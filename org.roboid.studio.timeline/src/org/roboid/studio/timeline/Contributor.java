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
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.studio.timeline.downloader.Downloader;
import org.roboid.studio.timeline.player.Player;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class Contributor extends ActionBarContributor 
{
	TimelineEditor editor;
	private Action playAction;
	private Action recordAction;
	private Action downloadAction;

	public Contributor() 
	{
		createActions();
	}
	
	// 활성화된 에디터를 설정한다.
	@Override
	public void setActiveEditor(IEditorPart targetEditor)
	{
		this.editor = (TimelineEditor)targetEditor;
		super.setActiveEditor(targetEditor);
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
				
				MotionClip motionClip = editor.getMotionClip();
				if(motionClip == null) return;
				
				Player player = new Player(motionClip);
				
				TimelineRuler ruler = editor.getRuler();
				player.setRuler(ruler);

				TimelineGuide guide = new TimelineGuide();
				ruler.addGuide(guide);
				player.setGuide(guide);
				
				player.play();
				
				// 재생기 다이얼로그 창을 만든다.
				new PlayerDialog(editor.getSite().getShell()).open(false);
				
				// 재생기 다이얼로그가 닫히면 재생을 중지하고 가이드를 제거한다.
				player.stop();
				ruler.removeGuide(guide);
			}
		};
		
		playAction.setText("Play"); // 표시할 문자열
		playAction.setToolTipText("Play Motion Clip"); // 툴팁에 표시할 문자열
	    ImageDescriptor descriptor = ImageDescriptor.createFromFile(TimelineEditor.class, "bullet_triangle_blue.png"); //"film_play.png");
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
						r.exec(resourceRoot); // 녹음기 실행
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
	    descriptor = ImageDescriptor.createFromFile(TimelineEditor.class, "microphone1.png");
	    recordAction.setImageDescriptor(descriptor); // 툴바에 표시할 아이콘
	    
	    // 다운로드 액션
		downloadAction = new Action()
		{
			public void run()
			{
				MotionClip motionClip = editor.getMotionClip();
				if(motionClip == null) return;
				
				Robot robot = motionClip.getRobot();
				if(robot == null) return;
				
				List<Roboid> roboids = robot.getRoboids();
				if(roboids == null) return;
				if(roboids.size() <= 0) return;
				
				Roboid roboid = roboids.get(0);
				if(roboid == null) return;
				
				Downloader downloader = Downloader.get(roboid.getId());
				if(downloader == null) return;
				
				downloader.run(motionClip);
			}
		};
		
		downloadAction.setText("Download"); // 표시할 문자열
		downloadAction.setToolTipText("Download Motion Clip"); // 툴팁에 표시할 문자열
	    descriptor = ImageDescriptor.createFromFile(TimelineEditor.class, "download.png");
	    downloadAction.setImageDescriptor(descriptor); // 툴바에 표시할 아이콘
	}

	// Undo, Reo, Delete 액션을 만든다.
	protected void buildActions() 
	{
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
		addRetargetAction(new DeleteRetargetAction()); // 리타켓 가능한 삭제
		
		IWorkbenchWindow window = getPage().getWorkbenchWindow();
		addRetargetAction((RetargetAction)ActionFactory.CUT.create(window));
		addRetargetAction((RetargetAction)ActionFactory.COPY.create(window));
		addRetargetAction((RetargetAction)ActionFactory.PASTE.create(window));
		addRetargetAction((RetargetAction)ActionFactory.SELECT_ALL.create(window));
	}
	
	protected void declareGlobalActionKeys()
	{
	}
	
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

	    // 플레이 액션과 녹음 액션을 툴바에 추가
		toolBarManager.add(new Separator());
		toolBarManager.add(recordAction);		
		toolBarManager.add(new Separator());
		toolBarManager.add(playAction);
		toolBarManager.add(downloadAction);
	}
}
