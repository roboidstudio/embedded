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
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.ScriptEngine;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.console.MessageConsoleStream;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.downloader.Downloader;
import org.roboid.studio.contentscomposer.player.Player;
import org.roboid.studio.processing.ProcessingFactory;
import org.roboid.ui.console.ConsoleFactory;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class Contributor extends ActionBarContributor
{
	private IEditorPart editor; // Ȱ��ȭ�� ������
	private Action playAction; // �÷���
	private Action recordAction; // ����
	private Action downloadAction;
//	private ScriptEngine engine;
//	private FlashViewer flash;
	
	public Contributor()
	{
		// �÷��� �׼ǰ� ���� �׼��� �����Ѵ�.
		createActions();
	}

	// Ȱ��ȭ�� �����͸� �����Ѵ�.
	@Override
	public void setActiveEditor(IEditorPart editor)
	{
		this.editor = editor;
		super.setActiveEditor(editor);
	}
	
	// �÷��� �׼ǰ� ���� �׼��� �����Ѵ�.
	private void createActions()
	{
		// �÷��� �׼�
		playAction = new Action()
		{
			public void run()
			{
				//�κ��̵� �Ŵ��� �� Ȱ��ȭ �Ѵ�.
				try
				{
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.roboid.studio.roboidmanager.views.manager");
				} catch (PartInitException e)
				{
					e.printStackTrace();
				}
				// ���̾�׷��� ��´�.
				MotionContent content = ((ContentsComposer)editor).getContentsClip();
				if(content == null) return;
				
				// ��� �������� ������ �˻��Ѵ�.
				if(!content.validate())
				{
					MessageDialog.openError(null, "Logic validation error", "Can't play this content");
					return;
				}
				
				// ����� ȭ�� ����
				PlayerDialog dialog = new PlayerDialog(editor.getSite().getShell(), content);
				Shell parentShell = editor.getSite().getShell();
				
				Shell diagShell = null;
				if(content.isMinimized())
				{
					parentShell.setMinimized(true);
					diagShell = dialog.open(true);
				}
				else
					diagShell = dialog.open(false);
				
				// ��ũ��Ʈ ������ ����� ���� �����Ѵ�.
				// ���� �������  ������ ���� ���Ǹ� �����մϴ�.
				ScriptEngine engine = content.createScriptEngine();
				engine.put("browser", new RoboidBrowserFactory(diagShell));
				engine.put("flash", new FlashFactory(diagShell));
				MessageConsoleStream console = ConsoleFactory.getInstance();
				console.setActivateOnWrite(true);
				engine.put("console", console);
				engine.put("diagram", content);
				ProcessingFactory processing = new ProcessingFactory(engine);
				engine.put("processing", processing);
				
				// ����⿡ �������� �ε��Ѵ�.
				Player player = new Player(content);
				
				// ��� ����
				player.play();
				Display display = parentShell.getDisplay(); 
				while(!diagShell.isDisposed())
				{
					if(!display.readAndDispatch()) display.sleep();
					// �÷��̰� ������ â�� �ݴ´�.
					if(!player.isPlaying()) dialog.close();
				}

				// dispose
				processing.close();
				parentShell.setMinimized(false);
				player.stop();
			}
		};
		
		playAction.setText("Play"); // ǥ���� ���ڿ�
		playAction.setToolTipText("Play Contents Clip"); // ������ ǥ���� ���ڿ�
		ImageDescriptor descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "bullet_triangle_green.png"); //"movie_play.png");
		playAction.setImageDescriptor(descriptor); // ���ٿ� ǥ���� ������

	    // ���� �׼�
		recordAction = new Action()
		{
			public void run()
			{
				Runtime r = Runtime.getRuntime();
				try
				{
					// ������ ��θ� ���Ѵ�.
					URL installLocation = Activator.getDefault().getBundle().getEntry("/");
					try 
					{
						// �������� ��θ� �� �����Ѵ�.
						URL local = FileLocator.toFileURL(installLocation);
						String resourceRoot = new File(local.getPath()).getAbsolutePath() + "/sndrec32.exe";
						r.exec(resourceRoot);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}catch(Exception e)
				{
					System.out.println("Error executing robot driver");
				}
			}
		};
		
		recordAction.setText("Record"); // ǥ���� ���ڿ�
		recordAction.setToolTipText("Record Voice"); // ������ ǥ���� ���ڿ�
	    descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "microphone1.png");
	    recordAction.setImageDescriptor(descriptor); // ���ٿ� ǥ���� ������
	    
	 // �ٿ�ε� �׼�
		downloadAction = new Action()
		{
			public void run()
			{
				if(editor instanceof ContentsComposer)
				{
					MotionContent content = ((ContentsComposer)editor).getContentsClip();
					if(content == null) return;
					
					Robot robot = content.getRobot();
					if(robot == null) return;
					
					List<Roboid> roboids = robot.getRoboids();
					if(roboids == null) return;
					if(roboids.size() <= 0) return;
					
					Roboid roboid = roboids.get(0);
					if(roboid == null) return;
					
					Downloader downloader = Downloader.get(roboid.getId());
					if(downloader == null) return;
					
					downloader.run(content);
				}
			}
		};
		
		downloadAction.setText("Download"); // ǥ���� ���ڿ�
		downloadAction.setToolTipText("Download Contents Clip"); // ������ ǥ���� ���ڿ�
	    descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "download.png");
	    downloadAction.setImageDescriptor(descriptor); // ���ٿ� ǥ���� ������
	}
	
	/**
	 * Create actions managed by this contributor.
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	// Undo, Reo, Delete, Zoom In/Out, Alignment �׼��� �����.
	protected void buildActions() 
	{
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
		addRetargetAction(new DeleteRetargetAction());
		
		IWorkbenchWindow window = getPage().getWorkbenchWindow();
		addRetargetAction((RetargetAction)ActionFactory.CUT.create(window));
		addRetargetAction((RetargetAction)ActionFactory.COPY.create(window));
		addRetargetAction((RetargetAction)ActionFactory.PASTE.create(window));
		addRetargetAction((RetargetAction)ActionFactory.SELECT_ALL.create(window));
		
		addRetargetAction(new ZoomInRetargetAction());
		addRetargetAction(new ZoomOutRetargetAction());
		
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
	}

	/**
	 * Add actions to the given toolbar.
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	// ���ٸ� �����Ѵ�.
	public void contributeToToolBar(IToolBarManager toolBarManager) 
	{
		// Undo, Redo, Delete�� ���ٿ� �߰�
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		
		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(ActionFactory.CUT.getId()));
		toolBarManager.add(getAction(ActionFactory.COPY.getId()));
		toolBarManager.add(getAction(ActionFactory.PASTE.getId()));
		
		// Zoom In/Out�� ���ٿ� �߰�
		toolBarManager.add(new Separator());
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

		// Alignment�� ���ٿ� �߰�
		toolBarManager.add(new Separator());
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ALIGN_CENTER));
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ALIGN_MIDDLE));
		
		// �÷��� �׼ǰ� ���� �׼��� ���ٿ� �߰�
		toolBarManager.add(new Separator());
		toolBarManager.add(recordAction);		
		toolBarManager.add(new Separator());
		toolBarManager.add(playAction);
		toolBarManager.add(downloadAction);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
	 */
	protected void declareGlobalActionKeys()
	{
		// currently none
	}
}
