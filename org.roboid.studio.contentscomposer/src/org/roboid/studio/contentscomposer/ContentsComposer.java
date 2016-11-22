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

package org.roboid.studio.contentscomposer;

import java.io.File;
import java.io.FileInputStream;
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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.editparts.PaletteEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.widgets.Composite;
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
import org.roboid.robot.DeviceAdapter;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.actions.CloneMcAction;
import org.roboid.studio.contentscomposer.actions.CloneMccAction;
import org.roboid.studio.contentscomposer.actions.CopyBlockAction;
import org.roboid.studio.contentscomposer.actions.CutBlockAction;
import org.roboid.studio.contentscomposer.actions.EditScriptAction;
import org.roboid.studio.contentscomposer.actions.PasteBlockAction;
import org.roboid.studio.contentscomposer.commands.AddSystemComponentCommand;
import org.roboid.studio.contentscomposer.commands.DeleteSystemComponentCommand;
import org.roboid.studio.contentscomposer.commands.ModifyComponentEnabledCommand;
import org.roboid.studio.contentscomposer.commands.ModifyComponentIdCommand;
import org.roboid.studio.contentscomposer.editparts.ContentsComposerEditPartFactory;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineEditor;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ContentsComposer extends GraphicalEditorWithPalette implements IClipEditor
{
	private MotionContent contentsClip; // 다이어그램(콘텐츠)
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
			if(part == ContentsComposer.this)
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
			if(part == ContentsComposer.this)
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
			if(activePart == ContentsComposer.this) return;
			
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
			super.notifyChanged(notification);
		}
	};

	public ContentsComposer()
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
	
	// 액션을 생성한다.
	@SuppressWarnings("unchecked")
	@Override
	protected void createActions()
	{
		super.createActions();
		
		ActionRegistry registry = getActionRegistry();
		
		IAction action = new CutBlockAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new CopyBlockAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new PasteBlockAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		// 모션 클립 복사본 만들기
		action = new CloneMcAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		// 콘텐츠 클립 복사본 만들기
		action = new CloneMccAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		// 스크립트 편집
		action = new EditScriptAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		// 노드 정렬
		action = new AlignmentAction((IWorkbenchPart)this, PositionConstants.CENTER);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new AlignmentAction((IWorkbenchPart)this, PositionConstants.MIDDLE);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
	}
	
	@Override
	protected void createGraphicalViewer(Composite parent)
	{
		MotionContent clip = readContentsClip();
		setContentsClip(clip);
		
		super.createGraphicalViewer(parent);
	}

	@Override
	protected void configureGraphicalViewer()
	{
		super.configureGraphicalViewer();
		
		final GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new ContentsComposerEditPartFactory());
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		
		// Zoom In/Out 액션을 등록한다.
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		
		// 마우스 우클릭 팝업 메뉴를 등록한다.
		ContentsComposerContextMenuProvider contextMenu = new ContentsComposerContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(contextMenu);
		getSite().registerContextMenu(contextMenu, viewer);
		
		// Create motion clips by drag-and-drop
		// Export motion clip by darg-and-drop
		viewer.addDropTargetListener(new ImportDropListener(viewer, FileTransfer.getInstance()));
		viewer.addDragSourceListener(new ExportDragListener(viewer, FileTransfer.getInstance()));
		
		PaletteEditPart palette = (PaletteEditPart)getPaletteViewer().getRootEditPart().getContents();
		palette.getFigure().setBackgroundColor(ColorConstants.white);
	}
	
	// 파일에 적힌 로봇 이름과 현재 로봇 모델의 로봇 이름을 비교하고 변경할지 묻는다. 
//	private boolean validateAndChangeRobotName()
//	{
//		if(!diagram.getTargetRobotID().equalsIgnoreCase(robot.getName() + " " + robot.getVersion()))
//		{
//			StringBuilder sb = new StringBuilder();
//			sb.append("This content was composed for ");
//			sb.append(diagram.getTargetRobotID());
//			sb.append(", but the current robot is ");
//			sb.append(robot.getName());
//			sb.append(". Do you want to apply this content to ");
//			sb.append(robot.getName());
//			sb.append("?");
//			if(MessageDialog.openQuestion(null, "Model Mismatch!", sb.toString()))
//			{
//				diagram.setTargetRobotID(robot.getName() + " " + robot.getVersion());
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	// 뷰를 초기화한다.
	@Override
	protected void initializeGraphicalViewer()
	{
		if(contentsClip == null) return;
		
		// 로봇 이름이 달라서 변경한 경우 파일로 저장한다.
//		if(validateAndChangeRobotName())
//			doSave(new NullProgressMonitor());
		
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(contentsClip);
		
		RobotManager.setDeviceListener(getRobot(), new DeviceAdapter());
		contentsClip.getResource().eAdapters().add(activityAdapter);
	}
	
	public void updateContentsComposer(MotionContent clip)
	{
		initializeGraphicalViewer();
	}

	@Override
	public IClip getContent()
	{
		return getContentsClip();
	}

	@Override
	public Robot getRobot()
	{
		if(getContentsClip() != null)
			return getContentsClip().getRobot();
		return null;
	}

	@Override
	public Activity getActivity()
	{
		if(getContentsClip() != null)
			return getContentsClip().getActivity();
		return null;
	}

	private MotionContent readContentsClip()
	{
		IFile f = ((IFileEditorInput)getEditorInput()).getFile();
		setPartName(f.getName());
		
		File file = f.getLocation().toFile();
		MotionContent clip = readContentsClip(file);
		
		if(clip == null) // old version
		{
			Robot robot = RobotManager.getProjectRobot(file);
			if(robot == null) robot = RobotManager.getDefaultRobot();
			URI uri = URI.createFileURI(file.getAbsolutePath());
			
			clip = readOldContentsClip(file, uri, robot);
			if(clip == null)
			{
				clip = createContentsClipWithResource(robot, uri);
				clip.getActivity().init(robot);
			}
			else
				layoutNestedMotionClip(clip);
		}
		
		if(clip != null) clip.validate();
		return clip;
	}
	
	public static MotionContent readContentsClip(File file)
	{
		if(file == null) return null;
		URI uri = URI.createFileURI(file.getAbsolutePath());
		return readContentsClip(uri);
	}
	
	public static MotionContent readContentsClip(URI uri)
	{
		if(uri == null) return null;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EList<EObject> objects = resource.getContents();

			Robot robot = (Robot)objects.get(0);
			Activity activity = (Activity)objects.get(1);
			MotionContent clip = (MotionContent)objects.get(2);
			
			robot.createDeviceMemory();
			activity.init(robot);
			clip.setRobot(robot);
			clip.setActivity(activity);
			layoutNestedMotionClip(clip);
			return clip;
		}
		catch (RuntimeException e)
		{
//			e.printStackTrace();
		}
		return null;
	}
	
	private static MotionContent readOldContentsClip(File file, URI uri, Robot robot)
	{
		System.out.println("The old version of contents clip file was detected.");
		
		try
		{
			// read a contents clip file by serialization
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
			try
			{
				MotionContent newClip = createContentsClipWithResourceWithoutRoot(robot, uri);
				if(newClip == null) return null;
			
				// according to its version
				double version = 0;
				Object obj = ois.readObject();
				if(obj instanceof Double)
					version = ((Double)obj).doubleValue();
				
				if(version < 1.2)
				{
					kr.roboid.motioncomposer.model.MotionDiagram oldClip = (kr.roboid.motioncomposer.model.MotionDiagram)obj; // 콘텐츠 클립 내용
					oldClip.toVersion1_4(newClip, robot);
					newClip.setVersion("1.0.0");
				}
				else if(version < 1.4) // 1.2 버전
				{
					org.roboid.studio.contentscomposer.model.MotionDiagram oldClip = (org.roboid.studio.contentscomposer.model.MotionDiagram)ois.readObject();
					oldClip.toVersion1_4(newClip, robot);
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
	
	public static void layoutNestedMotionClip(MotionContent clip)
	{
		for(BlockElement block : clip.getBlocks())
		{
			block.setParent(clip);
			if(block instanceof MotionClipBlock)
			{
				MotionClip motionClip = ((MotionClipBlock)block).getMotionClip();
				TimelineEditor.layoutMotionClip(motionClip);
			}
			else if(block instanceof MotionContentBlock)
			{
				MotionContent contentsClip = ((MotionContentBlock)block).getContent();
				layoutNestedMotionClip(contentsClip);
			}
		}
	}
	
	public static MotionContent importContentsClip(File file, Robot robot) throws ContentsClipException
	{
		if(file == null || robot == null) return null;
		
		try
		{
			URI uri = URI.createFileURI(file.getAbsolutePath());
			MotionContent clip = importContentsClip(uri);
			if(clip == null) clip = importOldContentsClip(file, uri);
		
			if(clip != null)
			{
				int code = MotionContent.INSERT_SUCCESS;
				if(robot.equalsContents(clip.getRobot()))
					code = clip.updateReference(robot);
				else
					code = clip.adaptTo(robot);
				
				switch(code)
				{
				case MotionContent.INSERT_INVALID_CLIENT_ROBOT:
				case MotionContent.INSERT_INVALID_REFERENCE_ROBOT:
				case MotionContent.INSERT_DIFFERENT_ROBOT:
				case MotionContent.INSERT_INVALID_LOGIC_BLOCK:
				case MotionContent.INSERT_INVALID_SCRIPT:
					throw new ContentsClipException(code);
				case MotionContent.INSERT_PARTIAL:
					layoutNestedMotionClip(clip);
					throw new ContentsClipException(code, clip);
				}
				layoutNestedMotionClip(clip);
			}
			return clip;
		}
		catch (ContentsClipException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private static MotionContent importContentsClip(URI uri)
	{
		if(uri == null) return null;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			EList<EObject> objects = resource.getContents();
			MotionContent clip = (MotionContent)objects.get(2);
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
	private static MotionContent importOldContentsClip(File file, URI uri)
	{
		if(file == null || uri == null) return null;
		
		try
		{
			Robot robot = RobotManager.getProjectRobot(file);
			if(robot == null) robot = RobotManager.getDefaultRobot();
			return readOldContentsClip(file, uri, robot);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static MotionContent createContentsClip(Robot robot)
	{
		MotionContent clip = createContentsClipWithoutRoot(robot);
		if(clip != null)
		{
			RootBlock root = ContentsComposerFactory.eINSTANCE.createRootBlock();
			clip.addChild(root);
		}
		return clip;
	}
	
	private static MotionContent createContentsClipWithoutRoot(Robot robot)
	{
		MotionContent clip = ContentsComposerFactory.eINSTANCE.createMotionContent();
		Activity activity = ActivityFactory.eINSTANCE.createActivity(robot);
		clip.setRobot(robot);
		clip.setActivity(activity);
		clip.setVersion(MotionContent.VERSION);
		return clip;
	}
	
	private static MotionContent createContentsClipWithResource(Robot robot, URI uri)
	{
		if(uri == null) return null;
		
		MotionContent clip = createContentsClipWithResourceWithoutRoot(robot, uri);
		if(clip != null)
		{
			RootBlock root = ContentsComposerFactory.eINSTANCE.createRootBlock();
			clip.addChild(root);
		}
		return clip;
	}
	
	private static MotionContent createContentsClipWithResourceWithoutRoot(Robot robot, URI uri)
	{
		if(uri == null) return null;
		
		MotionContent clip = createContentsClipWithoutRoot(robot);
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
		if(contentsClip == null) return;
		saveMotionContent(contentsClip, monitor);
		getCommandStack().markSaveLocation();
	}
	
	public boolean isSaveAsAllowed()
	{
		return true;
	}

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
	
	protected void doSaveAs(URI uri, IEditorInput editorInput)
	{
		if(contentsClip == null) return;
		
		((EObject)contentsClip).eResource().setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		EditorActionBarContributor actionBarContributor = (EditorActionBarContributor)getEditorSite().getActionBarContributor();
		IStatusLineManager statusLineManager = actionBarContributor.getActionBars().getStatusLineManager();
		IProgressMonitor progressMonitor = statusLineManager != null ? statusLineManager.getProgressMonitor() : new NullProgressMonitor();
		doSave(progressMonitor);
	}
	
	public static void saveMotionContent(final MotionContent content, IProgressMonitor monitor)
	{
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		
		content.setVersion(MotionContent.VERSION);
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
		{
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
			{
				try
				{
					ResourceSet resourceSet = new ResourceSetImpl();
					URI uri = ((EObject)content).eResource().getURI();
					Resource resource = resourceSet.createResource(uri);
					
					resource.getContents().add((EObject)content.getRobot());
					resource.getContents().add((EObject)content.getActivity());
					resource.getContents().add((EObject)content);
					resource.save(saveOptions);
				}
				catch (Exception e)
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
	
	public static boolean exportContentsClip(File file, Robot robot, Activity activity, MotionContent contentsClip)
	{
		if(file == null || robot == null || activity == null || contentsClip == null) return false;
		
		try
		{
			URI uri = URI.createFileURI(file.getAbsolutePath());
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(uri);
			
			resource.getContents().add((EObject)robot);
			resource.getContents().add((EObject)activity);
			resource.getContents().add((EObject)contentsClip);
			contentsClip.setVersion(MotionContent.VERSION);
			
			final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			
			resource.save(saveOptions);
			return true;
		}
		catch (Exception e)
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
	
	public MotionContent getContentsClip()
	{
		return contentsClip;
	}
	
	public void setContentsClip(MotionContent content)
	{
		this.contentsClip = content;
	}
	
	// 팔레트 크기를 얻는다.
	@Override
	protected int getInitialPaletteSize()
	{
		return 145;
	}

	/**
	 * Activate robot by attaching sensor listeners
	 * @param robot
	 */
	// 디바이스에 리스너를 단다.
//	private void activate(Robot robot)
//	{
//		for(int i = 0; i < robot.getRoboids().size(); i ++)
//		{
//			List<Device> devices = robot.getRoboids().get(i).getDevices();
//			for(int j = 0; j < devices.size(); j ++)
//			{
//				devices.get(j).addDeviceListener(new DeviceAdapter());
//			}
//		}
//	}
	
	// 팔레트를 만든다.
	@Override
	protected PaletteRoot getPaletteRoot()
	{
		PaletteRoot root = new PaletteRoot();
		
		PaletteGroup group = new PaletteGroup("Selection Tool");
		ToolEntry select = new PanningSelectionToolEntry();
		group.add(select);
		root.setDefaultEntry(select);
		
		group.add(new MarqueeToolEntry());
		group.add(new ExportClipToolEntry());
		
		group.add(new PaletteSeparator());
//		group.add(new CreationToolEntry("Action clip", "Create new motion clip",
//				new SimpleFactory(kr.roboid.motioncomposer.model.MotionClip.class),
//				Activator.getImageDescriptor("icons/film.png"),
//				Activator.getImageDescriptor("icons/film.png")));
//		group.add(new CreationToolEntry("Behaviour", "Create new behaviour",
//				new SimpleFactory(org.roboid.studio.contentscomposer.model.ContentClip.class),
//				Activator.getImageDescriptor("icons/movie16.png"),
//				Activator.getImageDescriptor("icons/movie16.png")));

//		group.add(new CreationToolEntry("Clone.mc", "Place clone of motion clip",
//				new SimpleFactory(org.roboid.studio.contentscomposer.model.CloneClip.class),
//				Activator.getImageDescriptor("icons/camera2.png"),
//				Activator.getImageDescriptor("icons/camera2.png")));
//		group.add(new CreationToolEntry("Clone.mcc", "Place clone of contents clip",
//				new SimpleFactory(org.roboid.studio.contentscomposer.model.CloneContent.class),
//				Activator.getImageDescriptor("icons/movie_view.png"),
//				Activator.getImageDescriptor("icons/movie_view.png")));
		group.add(new CreationToolEntry("Wait clip", "Create a wait clip block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getWaitClipBlock()),
				Activator.getImageDescriptor("icons/stopwatch.png"),
				Activator.getImageDescriptor("icons/stopwatch.png")));
		
		group.add(new PaletteSeparator());
		group.add(new CreationToolEntry("Join", "Create a join block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getAdderBlock()),
				Activator.getImageDescriptor("icons/add16.png"),
				Activator.getImageDescriptor("icons/add16.png")));
//		group.add(new CreationToolEntry("Fork", "Create a fork block",
//				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getForkBlock()),
//				Activator.getImageDescriptor("icons/fork16.png"),
//				Activator.getImageDescriptor("icons/fork16.png")));
//		group.add(new CreationToolEntry("Merge", "Create a merge block",
//				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getMergeBlock()),
//				Activator.getImageDescriptor("icons/merge16.png"),
//				Activator.getImageDescriptor("icons/merge16.png")));
		group.add(new CreationToolEntry("Stop", "Create a stop block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getTerminatorBlock()),
				Activator.getImageDescriptor("icons/finish16.png"),
				Activator.getImageDescriptor("icons/finish16.png")));
		group.add(new PaletteSeparator());
		group.add(new CreationToolEntry("Counter", "Create a counter block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getLoopBlock()),
				Activator.getImageDescriptor("icons/refresh.png"),
				Activator.getImageDescriptor("icons/refresh.png")));
		group.add(new CreationToolEntry("Dice", "Create a dice block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getDiceBlock()),
				Activator.getImageDescriptor("icons/die.png"),
				Activator.getImageDescriptor("icons/die.png")));
		group.add(new PaletteSeparator());
//		group.add(new CreationToolEntry("Trigger", "Create a trigger block",
//				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getTriggerBlock()),
//				Activator.getImageDescriptor("icons/exit.png"),
//				Activator.getImageDescriptor("icons/exit.png")));
		group.add(new CreationToolEntry("Branch", "Create a branch block",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getBranchBlock()),
				Activator.getImageDescriptor("icons/branch_element.png"),
				Activator.getImageDescriptor("icons/branch_element.png")));
		group.add(new PaletteSeparator());
		group.add(new ConnectionCreationToolEntry("Connection", "Connect blocks",
				new SimpleEFactory(ContentsComposerPackage.eINSTANCE.getAssociation()),
				Activator.getImageDescriptor("icons/connection16.gif"),
				Activator.getImageDescriptor("icons/connection16.gif")));
		
		root.add(group);
		return root;
	}
	
	public static int snap(int value)
	{
		return MotionContent.GRID * Math.round((float)value / MotionContent.GRID);
	}
	
	private class SimpleEFactory implements CreationFactory
	{
		private EClass type;

		public SimpleEFactory(EClass aClass)
		{
			type = aClass;
		}

		public Object getNewObject()
		{
			try
			{
				return ContentsComposerFactory.eINSTANCE.create(type);
			}
			catch (Exception e)
			{
				return null;
			}
		}

		public Object getObjectType()
		{
			return type;
		}
	}
}
