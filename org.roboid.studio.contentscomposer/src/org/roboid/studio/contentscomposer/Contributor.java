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
	private IEditorPart editor; // 활성화된 에디터
	private Action playAction; // 플레이
	private Action recordAction; // 녹음
	private Action downloadAction;
//	private ScriptEngine engine;
//	private FlashViewer flash;
	
	public Contributor()
	{
		// 플레이 액션과 녹음 액션을 생성한다.
		createActions();
	}

	// 활성화된 에디터를 설정한다.
	@Override
	public void setActiveEditor(IEditorPart editor)
	{
		this.editor = editor;
		super.setActiveEditor(editor);
	}
	
	// 플레이 액션과 녹음 액션을 생성한다.
	private void createActions()
	{
		// 플레이 액션
		playAction = new Action()
		{
			public void run()
			{
				//로보이드 매니저 뷰어를 활성화 한다.
				try
				{
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.roboid.studio.roboidmanager.views.manager");
				} catch (PartInitException e)
				{
					e.printStackTrace();
				}
				// 다이어그램을 얻는다.
				MotionContent content = ((ContentsComposer)editor).getContentsClip();
				if(content == null) return;
				
				// 대상 콘텐츠의 로직을 검사한다.
				if(!content.validate())
				{
					MessageDialog.openError(null, "Logic validation error", "Can't play this content");
					return;
				}
				
				// 재생기 화면 오픈
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
				
				// 스크립트 엔진은 실행시 마다 생성한다.
				// 이전 실행시의  설정된 변수 정의를 무시합니다.
				ScriptEngine engine = content.createScriptEngine();
				engine.put("browser", new RoboidBrowserFactory(diagShell));
				engine.put("flash", new FlashFactory(diagShell));
				MessageConsoleStream console = ConsoleFactory.getInstance();
				console.setActivateOnWrite(true);
				engine.put("console", console);
				engine.put("diagram", content);
				ProcessingFactory processing = new ProcessingFactory(engine);
				engine.put("processing", processing);
				
				// 재생기에 콘텐츠를 로드한다.
				Player player = new Player(content);
				
				// 재생 시작
				player.play();
				Display display = parentShell.getDisplay(); 
				while(!diagShell.isDisposed())
				{
					if(!display.readAndDispatch()) display.sleep();
					// 플레이가 끝나면 창을 닫는다.
					if(!player.isPlaying()) dialog.close();
				}

				// dispose
				processing.close();
				parentShell.setMinimized(false);
				player.stop();
			}
		};
		
		playAction.setText("Play"); // 표시할 문자열
		playAction.setToolTipText("Play Contents Clip"); // 툴팁에 표시할 문자열
		ImageDescriptor descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "bullet_triangle_green.png"); //"movie_play.png");
		playAction.setImageDescriptor(descriptor); // 툴바에 표시할 아이콘

	    // 녹음 액션
		recordAction = new Action()
		{
			public void run()
			{
				Runtime r = Runtime.getRuntime();
				try
				{
					// 번들의 경로를 구한다.
					URL installLocation = Activator.getDefault().getBundle().getEntry("/");
					try 
					{
						// 녹음기의 경로를 얻어서 실행한다.
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
		
		recordAction.setText("Record"); // 표시할 문자열
		recordAction.setToolTipText("Record Voice"); // 툴팁에 표시할 문자열
	    descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "microphone1.png");
	    recordAction.setImageDescriptor(descriptor); // 툴바에 표시할 아이콘
	    
	 // 다운로드 액션
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
		
		downloadAction.setText("Download"); // 표시할 문자열
		downloadAction.setToolTipText("Download Contents Clip"); // 툴팁에 표시할 문자열
	    descriptor = ImageDescriptor.createFromFile(ContentsComposer.class, "download.png");
	    downloadAction.setImageDescriptor(descriptor); // 툴바에 표시할 아이콘
	}
	
	/**
	 * Create actions managed by this contributor.
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	// Undo, Reo, Delete, Zoom In/Out, Alignment 액션을 만든다.
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
	// 툴바를 생성한다.
	public void contributeToToolBar(IToolBarManager toolBarManager) 
	{
		// Undo, Redo, Delete를 툴바에 추가
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		
		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(ActionFactory.CUT.getId()));
		toolBarManager.add(getAction(ActionFactory.COPY.getId()));
		toolBarManager.add(getAction(ActionFactory.PASTE.getId()));
		
		// Zoom In/Out을 툴바에 추가
		toolBarManager.add(new Separator());
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

		// Alignment를 툴바에 추가
		toolBarManager.add(new Separator());
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ALIGN_CENTER));
		toolBarManager.add(getActionRegistry().getAction(GEFActionConstants.ALIGN_MIDDLE));
		
		// 플레이 액션과 녹음 액션을 툴바에 추가
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
