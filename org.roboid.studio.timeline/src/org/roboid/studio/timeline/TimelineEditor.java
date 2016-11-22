/*
 * Part of the ROBOID project
 * Copyright (C) 2016 Kwang-Hyun Park (akaii@kw.ac.kr) and Kyoung Jin Kim
 * https://github.com/roboidstudio/embedded
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
*/

package org.roboid.studio.timeline;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gef.ui.rulers.RulerComposite;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.FileEditorInput;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IClip;
import org.roboid.core.runtime.IClipEditor;
import org.roboid.core.runtime.RobotManager;
import org.roboid.robot.Channel;
import org.roboid.robot.Control;
import org.roboid.robot.DeviceAdapter;
import org.roboid.robot.IoMode;
import org.roboid.robot.Port;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.provider.NamedElementItemProvider;
import org.roboid.robot.provider.RobotItemProviderAdapterFactory;
import org.roboid.studio.timeline.actions.CopyControlPointAction;
import org.roboid.studio.timeline.actions.CutControlPointAction;
import org.roboid.studio.timeline.actions.PasteControlPointAction;
import org.roboid.studio.timeline.actions.SelectAllControlPointAction;
import org.roboid.studio.timeline.commands.AddSystemComponentCommand;
import org.roboid.studio.timeline.commands.DeleteSystemComponentCommand;
import org.roboid.studio.timeline.commands.ModifyComponentEnabledCommand;
import org.roboid.studio.timeline.commands.ModifyComponentIdCommand;
import org.roboid.studio.timeline.commands.ModifyPortModeCommand;
import org.roboid.studio.timeline.editparts.MotionClipEditPartFactory;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class TimelineEditor extends GraphicalEditor implements IClipEditor
{
//	private static final int TITLE_HEIGHT = 17; // height of channel title
	private static final int TITLE_WIDTH = 150; // width of channel title
	public static final Color COLOR_TITLE = new Color(null, 230, 230, 230);
	public static final Color COLOR_MAJOR_GRID = new Color(null, 220, 200, 240);
	public static final Color COLOR_MINOR_GRID = new Color(null, 245, 240, 255);
	
//	public static CommandStack commandStack;
	private ScrolledComposite compositeTitle;
	private TimelineRuler ruler = new TimelineRuler();
	private MotionClip motionClip;
	private IEditorPart currentEditor;
	private IWorkbenchPart activePart;
	private IPartListener partListener = new IPartListener()
	{
		@Override
		public void partOpened(IWorkbenchPart part)
		{
		}
		
		@Override
		public void partClosed(IWorkbenchPart part)
		{
			if(part == TimelineEditor.this)
			{
				if(!existContentEditor())
					ContentsManager.changeContent(null);
			}
		}
		
		@Override
		public void partActivated(IWorkbenchPart part)
		{
			activePart = part;
			
			if(part instanceof IEditorPart)
			{
				if(part == currentEditor) return;
				currentEditor = (IEditorPart)part;
				if(!(part instanceof IClipEditor))
					ContentsManager.notifyContentChanged(null);
			}
			if(part == TimelineEditor.this)
			{
				ContentsManager.changeContent(((IClipEditor)part).getContent());
			
				// 뷰를 활성화 한다.
				try
				{
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					page.showView("org.roboid.studio.roboidmanager.views.manager");
					page.showView("org.roboid.studio.portmanager.views.manager");
				} catch (PartInitException e)
				{
					e.printStackTrace();
				}
			}
		}

		@Override
		public void partDeactivated(IWorkbenchPart part)
		{
		}
		
		@Override
		public void partBroughtToTop(IWorkbenchPart part)
		{
		}
		
		boolean existContentEditor()
		{
			boolean existContentEditor = false;
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if(window != null)
			{
				IWorkbenchPage page = window.getActivePage();
				if(page != null)
				{
					IEditorReference[] references = page.getEditorReferences();
					if(references != null)
					{
						for(IEditorReference reference : references)
						{
							if(reference.getEditor(false) instanceof IClipEditor)
							{
								existContentEditor = true;
								break;
							}
						}
					}
				}
			}
			return existContentEditor;
		}
	};
	private EContentAdapter activityAdapter = new EContentAdapter()
	{
		@Override
		public void notifyChanged(org.eclipse.emf.common.notify.Notification notification)
		{
			if(activePart == TimelineEditor.this) return;
			
			int type = notification.getEventType();
			int featureId = notification.getFeatureID(ActivityPackage.class);
			
			if(notification.getNotifier() instanceof AbstractActivity)
			{
				switch(featureId)
				{
					case ActivityPackage.ABSTRACT_ACTIVITY__ID:
					{
						AbstractActivity activity = (AbstractActivity)notification.getNotifier();
						String oldId = (String)notification.getOldValue();
						String newId = (String)notification.getNewValue();
						getCommandStack().execute(new ModifyComponentIdCommand(activity, oldId, newId));
						break;
					}
					case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
					{
						AbstractActivity activity = (AbstractActivity)notification.getNotifier();
						boolean oldEnabled = (Boolean)notification.getOldValue();
						boolean newEnabled = (Boolean)notification.getNewValue();
						getCommandStack().execute(new ModifyComponentEnabledCommand(activity, oldEnabled, newEnabled));
						break;
					}
				}
			}
			else if(notification.getNotifier() instanceof Activity)
			{
				switch(featureId)
				{
					case ActivityPackage.ACTIVITY__SYSTEMS:
					{
						switch(type)
						{
							case Notification.ADD:
							{
								Activity activity = (Activity)notification.getNotifier();
								SystemActivity systemActivity = (SystemActivity)notification.getNewValue(); 
								getCommandStack().execute(new AddSystemComponentCommand(activity, systemActivity, activityAdapter));
								break;
							}
							case Notification.REMOVE:
							{
								Activity activity = (Activity)notification.getNotifier();
								SystemActivity systemActivity = (SystemActivity)notification.getOldValue();
								getCommandStack().execute(new DeleteSystemComponentCommand(activity, systemActivity, activityAdapter));
								break;
							}
							case Notification.REMOVE_MANY:
							{
								Activity activity = (Activity)notification.getNotifier();
								@SuppressWarnings("unchecked")
								List<SystemActivity> systemActivities = (List<SystemActivity>)notification.getOldValue();
								CompoundCommand command = new CompoundCommand();
								for(SystemActivity systemActivity : systemActivities)
									command.add(new DeleteSystemComponentCommand(activity, systemActivity, activityAdapter));
								getCommandStack().execute(command);
								break;
							}
						}
						break;
					}
				}
			}
			else if(notification.getNotifier() instanceof Port)
			{
				switch(featureId)
				{
					case RobotPackage.PORT__MODE:
					{
						Port port = (Port)notification.getNotifier();
						IoMode oldMode = (IoMode)notification.getOldValue();
						IoMode newMode = (IoMode)notification.getNewValue();
						getCommandStack().execute(new ModifyPortModeCommand(TimelineEditor.this, port, oldMode, newMode));
						break;
					}
				}
			}
			super.notifyChanged(notification);
		}
	};
	
	public TimelineEditor()
	{
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException
	{
		super.init(site, input);
		site.getPage().addPartListener(partListener);
	}

	@Override
	public void dispose()
	{
		getSite().getPage().removePartListener(partListener);
		getContent().getResource().eAdapters().remove(activityAdapter);
		super.dispose();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createActions()
	{
		super.createActions();
		
		ActionRegistry registry = getActionRegistry();
		
		IAction action = new CutControlPointAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new CopyControlPointAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new PasteControlPointAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SelectAllControlPointAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
	}
	
	@Override
	protected void createGraphicalViewer(Composite parent)
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.numColumns = 2;
		parent.setLayout(gridLayout);

		final Composite compositeLeft = new Composite(parent, SWT.NONE);
		compositeLeft.setBackground(ColorConstants.lightGray);
		GridLayout glLeft = new GridLayout();
		glLeft.marginWidth = 0;
		glLeft.marginHeight = 0;
		glLeft.horizontalSpacing = 0;
		glLeft.verticalSpacing = 1;
		compositeLeft.setLayout(glLeft);
		final GridData gdLeft = new GridData(SWT.FILL, SWT.FILL, false, true);
		gdLeft.widthHint = TITLE_WIDTH + 1;
		compositeLeft.setLayoutData(gdLeft);

		final Composite composite20ms = new Composite(compositeLeft, SWT.NONE);
		final GridLayout glTitle = new GridLayout();
		glTitle.marginWidth = 0;
		glTitle.marginHeight = 0;
		glTitle.marginTop = 2;
		glTitle.verticalSpacing = 0;
		composite20ms.setLayout(glTitle);
		composite20ms.setLayoutData(new GridData(TITLE_WIDTH, SWT.DEFAULT));
		composite20ms.setBackground(ColorConstants.white);

		Label x20msLabel = new Label(composite20ms, SWT.NONE);
		x20msLabel.setBackground(ColorConstants.white);
		x20msLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));
		x20msLabel.setText("   x 20 msec");

		compositeTitle = new ScrolledComposite(compositeLeft, SWT.NONE);
		compositeTitle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		compositeTitle.setBackground(ColorConstants.white);

		MotionClip clip = readMotionClip();
		setMotionClip(clip);
		createTitleArea(clip);
		
		// editor area
		final Composite compositeEditor = new Composite(parent, SWT.NONE);
		compositeEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeEditor.setLayout(new FillLayout());

		RulerComposite compositeRuler = new RulerComposite(compositeEditor, SWT.NONE);
		
		ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(compositeRuler);
		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();
		compositeRuler.setGraphicalViewer(viewer);
		compositeRuler.addControlListener(new ControlAdapter()
		{
			@Override
			public void controlResized(ControlEvent e)
			{
				RulerComposite ruler = (RulerComposite)e.widget;
				int height = ruler.getChildren()[1].getBounds().height - 1;
				((GridData)composite20ms.getLayoutData()).heightHint = height;
				compositeLeft.layout();
			}
		});
		
		final FigureCanvas fc = (FigureCanvas)viewer.getControl();
		fc.setBackground(ColorConstants.white);
		final ScrollBar sbv = fc.getVerticalBar();
//		final ScrollBar sbh = fc.getHorizontalBar();
		
		// scroll channel title area according to the vertical scroll bar
		sbv.addSelectionListener(new SelectionListener()
		{
			@Override
			public void widgetDefaultSelected(SelectionEvent e)
			{}

			@Override
			public void widgetSelected(SelectionEvent e)
			{
				compositeTitle.getContent().setLocation(0, -sbv.getSelection());
			}
		});
		fc.addControlListener(new ControlListener()
		{
			@Override
			public void controlMoved(ControlEvent e)
			{}

			@Override
			public void controlResized(ControlEvent e)
			{
				compositeTitle.getContent().setLocation(0, -sbv.getSelection());
			}});
//		fc.addMouseWheelListener(new MouseWheelListener()
//		{
//			@Override
//			public void mouseScrolled(MouseEvent e)
//			{	
//				sbh.setSelection(sbh.getSelection() - e.count * 20);
//				fc.scrollTo(sbh.getSelection(), 0);
//			}
//		});
	}
	
	private void createTitleArea(MotionClip clip)
	{
		for(org.eclipse.swt.widgets.Control control : compositeTitle.getChildren())
			control.dispose();
		
		final Canvas canvasTitle = new Canvas(compositeTitle, SWT.NONE);
		compositeTitle.setContent(canvasTitle);
		canvasTitle.setBackground(ColorConstants.lightGray);
		final GridLayout glChannels = new GridLayout();
		glChannels.marginWidth = 0;
		glChannels.marginHeight = 0;
		glChannels.horizontalSpacing = 0;
		glChannels.verticalSpacing = 1;
		canvasTitle.setLayout(glChannels);
		
		AdapterFactory factory = new RobotItemProviderAdapterFactory();
		final Robot robot = clip.getRobot();
		for(Control control : robot.getControls())
		{
			if(control.getChannels().size() <= 0) continue;
			
			ControlTitle controlTitle = new ControlTitle(canvasTitle, SWT.NONE, TITLE_WIDTH);
			controlTitle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			controlTitle.setTitle(control.getName());
			NamedElementItemProvider p = (NamedElementItemProvider)factory.adapt(control, IItemLabelProvider.class);
			Image image = (Image)ExtendedImageRegistry.getInstance().getImage(p.getIcon(control));
			controlTitle.setIcon(image);
			
			for(Channel channel : control.getChannels())
			{
				if(channel.isEnabled())
				{
					ChannelTitle channelTitle = new ChannelTitle(canvasTitle, SWT.NONE, TITLE_WIDTH);
					channelTitle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					channelTitle.setTitle(channel.getName());
					
					p = (NamedElementItemProvider)factory.adapt(channel, IItemLabelProvider.class);
					image = (Image)ExtendedImageRegistry.getInstance().getImage(p.getIcon(channel));
					channelTitle.setIcon(image);//ResourceManager.getPluginImage(Activator.getDefault(), findIcons(channel)));
				}
			}
		}
		
		Composite blank = new Composite(canvasTitle, SWT.NONE);
		blank.setLayoutData(new GridData(TITLE_WIDTH, 0));
		canvasTitle.setSize(canvasTitle.computeSize(TITLE_WIDTH, robot.getControls().size() == 0 ? 0 : SWT.DEFAULT));
	}
	
	public void updateTimelineEditor(MotionClip clip)
	{
		createTitleArea(clip);
		initializeGraphicalViewer();
	}
	
	@Override
	protected void configureGraphicalViewer() 
	{
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer = getGraphicalViewer();
		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		viewer.setRootEditPart(rootEditPart);		
		viewer.setEditPartFactory(new MotionClipEditPartFactory());
//		
//		// set unit 20 msec -> 50 pixels for 1 second
//		ruler.setUnit(RulerProvider.UNIT_PIXELS);
//		RulerProvider provider = new TimelineRulerProvider(ruler);
//
//		getGraphicalViewer().setProperty(RulerProvider.PROPERTY_HORIZONTAL_RULER, provider);
//		getGraphicalViewer().setProperty(RulerProvider.PROPERTY_RULER_VISIBILITY, true);
		
		viewer.addDropTargetListener(new ImportDropListener(viewer, FileTransfer.getInstance()));
	}
	
	// 뷰를 초기화한다.
	@Override
	protected void initializeGraphicalViewer()
	{
		if(motionClip == null) return;
		
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(motionClip);
		
		RobotManager.setDeviceListener(getRobot(), new DeviceAdapter());
		motionClip.getResource().eAdapters().add(activityAdapter);
		
		// set unit 20 msec -> 50 pixels for 1 second
		ruler.setUnit(RulerProvider.UNIT_PIXELS);
		RulerProvider provider = new TimelineRulerProvider(ruler);

		getGraphicalViewer().setProperty(RulerProvider.PROPERTY_HORIZONTAL_RULER, provider);
		getGraphicalViewer().setProperty(RulerProvider.PROPERTY_RULER_VISIBILITY, true);
	}

	@Override
	public IClip getContent()
	{
		return getMotionClip();
	}

	@Override
	public Robot getRobot()
	{
		if(getMotionClip() != null)
			return getMotionClip().getRobot();
		return null;
	}

	@Override
	public Activity getActivity()
	{
		if(getMotionClip() != null)
			return getMotionClip().getActivity();
		return null;
	}

	private MotionClip readMotionClip()
	{
		IFile f = ((IFileEditorInput)getEditorInput()).getFile();
		setPartName(f.getName());
		
		File file = f.getLocation().toFile();
		MotionClip clip = readMotionClip(file);
		
		if(clip == null) // old version
		{
			Robot robot = RobotManager.getProjectRobot(file);
			if(robot == null) robot = RobotManager.getDefaultRobot();
			URI uri = URI.createFileURI(file.getAbsolutePath());
			
			clip = readOldMotionClip(file, uri, robot);
			if(clip == null)
			{
				clip = createMotionClipWithResource(robot, uri);
				clip.getActivity().init(robot);
			}
			else
				layoutMotionClip(clip);
		}
		return clip;
	}
	
	public static MotionClip readMotionClip(File file)
	{
		if(file == null) return null;
		URI uri = URI.createFileURI(file.getAbsolutePath());
		return readMotionClip(uri);
	}
	
	public static MotionClip readMotionClip(URI uri)
	{
		if(uri == null) return null;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EList<EObject> objects = resource.getContents();
			
			Robot robot = (Robot)objects.get(0);
			Activity activity = (Activity)objects.get(1);
			MotionClip clip = (MotionClip)objects.get(2);
			
			robot.createDeviceMemory();
			activity.init(robot);
			clip.setRobot(robot);
			clip.setActivity(activity);
			layoutMotionClip(clip);
			return clip;
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private static MotionClip readOldMotionClip(File file, URI uri, Robot robot)
	{
		System.out.println("The old version of motion clip file was detected.");
		
		try
		{
			// read a motion clip file by serialization
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
			try
			{
				MotionClip newClip = createMotionClipWithResource(robot, uri);
				if(newClip == null) return null;
				
				// according to its version
				double version = 0;
				Object obj = ois.readObject();
				if(obj instanceof Double)
					version = ((Double)obj).doubleValue();
				
				if(version < 1.2)
				{
					kr.roboid.timeline.model.MotionClipModel oldClip = (kr.roboid.timeline.model.MotionClipModel)obj; // 모션 클립 내용
					oldClip.toVersion1_4(newClip);
					newClip.setVersion("1.0.0");
				}
				else if(version < 1.4) // version 1.2
				{
					org.roboid.studio.timeline.model.MotionClipModel oldClip = (org.roboid.studio.timeline.model.MotionClipModel)ois.readObject();
					oldClip.toVersion1_4(newClip);
					newClip.setVersion("1.3.0");
				}
				Activity activity = ActivityFactory.eINSTANCE.createActivity(robot);
				activity.init(robot);
				newClip.setActivity(activity);
				return newClip;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				ois.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void layoutMotionClip(MotionClip clip)
	{
		int y = 0, height;
		for(ControlTrack controlTrack : clip.getControls())
		{
			height = 0;
			for(ChannelTrack channelTrack : controlTrack.getChannels())
			{
				if(channelTrack.getChannel().isEnabled())
				{
					for(ControlPoint cp : channelTrack.getPoints())
					{
						cp.setParent(channelTrack);
						cp.setConstraint(new Rectangle(cp.getFrame(), MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
					}
					channelTrack.setParent(controlTrack);
					channelTrack.setConstraint(new Rectangle(0, height, clip.getFrameLimit(), MotionClip.CHANNEL_TRACK_HEIGHT));
					height += MotionClip.CHANNEL_TRACK_HEIGHT;
				}
			}
			controlTrack.setParent(clip);
			height += MotionClip.CONTROL_TRACK_TITLE_HEIGHT + 1;
			controlTrack.setConstraint(new Rectangle(0, y, clip.getFrameLimit(), height));
			y += height;
		}
	}
	
	public static MotionClip importMotionClip(File file, Robot robot) throws MotionClipException
	{
		if(file == null || robot == null) return null;
		
		try
		{
			URI uri = URI.createFileURI(file.getAbsolutePath());
			MotionClip clip = importMotionClip(uri);
			if(clip == null) clip = importOldMotionClip(file, uri);
			
			if(clip != null)
			{
				int code = MotionClip.INSERT_SUCCESS;
				if(robot.equalsContents(clip.getRobot()))
					code = clip.updateReference(robot);
				else
					code = clip.adaptTo(robot);
				
				switch(code)
				{
				case MotionClip.INSERT_INVALID_CLIENT_ROBOT:
				case MotionClip.INSERT_INVALID_REFERENCE_ROBOT:
				case MotionClip.INSERT_DIFFERENT_ROBOT:
					throw new MotionClipException(code);
				case MotionClip.INSERT_PARTIAL:
					layoutMotionClip(clip);
					throw new MotionClipException(code, clip);
				}
				layoutMotionClip(clip);
			}
			return clip;
		}
		catch (MotionClipException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static MotionClip importMotionClip(URI uri)
	{
		if(uri == null) return null;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EList<EObject> objects = resource.getContents();
			MotionClip clip = (MotionClip)objects.get(2); 
			clip.setRobot((Robot)objects.get(0));
			return clip;
		}
		catch (Exception e)
		{
//			e.printStackTrace();
		}
		return null;
	}
	
	// old version
	private static MotionClip importOldMotionClip(File file, URI uri)
	{
		if(file == null || uri == null) return null;
		
		try
		{
			Robot robot = RobotManager.getProjectRobot(file);
			if(robot == null) robot = RobotManager.getDefaultRobot();
			return readOldMotionClip(file, uri, robot);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static MotionClip createMotionClip(Robot robot)
	{
		MotionClip clip = TimelineFactory.eINSTANCE.createMotionClip();
		Activity activity = ActivityFactory.eINSTANCE.createActivity(robot);
		clip.setRobot(robot);
		clip.setActivity(activity);
		clip.setVersion(MotionClip.VERSION);
		clip.createControlTracks(robot);
		return clip;
	}
	
	private static MotionClip createMotionClipWithResource(Robot robot, URI uri)
	{
		if(uri == null) return null;
		
		MotionClip clip = createMotionClip(robot);
		Activity activity = clip.getActivity();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add((EObject)robot);
		resource.getContents().add((EObject)activity);
		resource.getContents().add((EObject)clip);
		return clip;
	}

	@Override
	public void doSave(IProgressMonitor monitor) 
	{
		if(motionClip == null) return;
		saveMotionClip(motionClip, monitor);
		getCommandStack().markSaveLocation();
	}
	
	@Override
	public boolean isSaveAsAllowed()
	{
		return true;
	}

	@Override
	public void doSaveAs()
	{
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.setOriginalFile(((IFileEditorInput)getEditorInput()).getFile());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if(path != null)
		{
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if(file != null)
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
		}
	}
	
	private void doSaveAs(URI uri, IEditorInput editorInput)
	{
		if(motionClip == null) return;
		
		((EObject)motionClip).eResource().setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		EditorActionBarContributor actionBarContributor = (EditorActionBarContributor)getEditorSite().getActionBarContributor();
		IStatusLineManager statusLineManager = actionBarContributor.getActionBars().getStatusLineManager();
		IProgressMonitor progressMonitor = statusLineManager != null ? statusLineManager.getProgressMonitor() : new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public static void saveMotionClip(final MotionClip motionClip, IProgressMonitor monitor)
	{
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		
		motionClip.setVersion(MotionClip.VERSION);
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
		{
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
			{
				try
				{
					ResourceSet resourceSet = new ResourceSetImpl();
					URI uri = ((EObject)motionClip).eResource().getURI();
					Resource resource = resourceSet.createResource(uri);
					
					resource.getContents().add((EObject)motionClip.getRobot());
					resource.getContents().add((EObject)motionClip.getActivity());
					resource.getContents().add((EObject)motionClip);
					resource.save(saveOptions);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};
		
		try
		{
			Shell shell = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
			new ProgressMonitorDialog(shell).run(true, false, operation);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean exportMotionClip(File file, Robot robot, Activity activity, MotionClip motionClip)
	{
		if(file == null || robot == null || activity == null || motionClip == null) return false;
		
		try
		{
			URI uri = URI.createFileURI(file.getAbsolutePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(uri);
			
			resource.getContents().add((EObject)robot);
			resource.getContents().add((EObject)activity);
			resource.getContents().add((EObject)motionClip);
			motionClip.setVersion(MotionClip.VERSION);
			
			final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			
			resource.save(saveOptions);
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean isDirty()
	{
		return getCommandStack().isDirty();
	}

	@Override
	public void commandStackChanged(EventObject event)
	{
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	public TimelineRuler getRuler()
	{
		return ruler;
	}
	
	public MotionClip getMotionClip()
	{
		return motionClip;
	}
	
	public void setMotionClip(MotionClip motionClip)
	{
		this.motionClip = motionClip;
	}
}
