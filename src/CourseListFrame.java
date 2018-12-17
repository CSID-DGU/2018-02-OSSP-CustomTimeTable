import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
//엑셀에서 가져온 수업정보를 보여주고 관리하는 클래스

public class CourseListFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mframe = null;
	Course crs= new Course(); 
	JList list = new JList();

	public CourseListFrame(MainFrame mframe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*************************************************************/
		

		//list형태로 출력
		list.setBounds(21, 20, 592, 341);
		contentPane.add(list);
		
		list.setListData(mframe.Clist.crsStorage);
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(390, 382, 93, 23);
		contentPane.add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
				mframe.Ttable.tableShift.removeAll();
				mframe.Clist.cal = new CalCourse(mframe.Clist.crsStorage);
				mframe.Clist.cal.CreateInstanceList(mframe.Clist.blank);
				
				mframe.Ttable.addCard(mframe);
				
				mframe.Ttable.setVisible(true);
				dispose();
		
			}
		});
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {//더블클릭 하여 update 화면을 띄운다

		            // Double-click detected
		            int index = list.locationToIndex(evt.getPoint());//해당하는 list의 index저장
		            crs = mframe.Clist.crsStorage.elementAt(index);//index에 해당하는 course 객체를 저장
		          
		            Update up = new Update(crs);
		            
					up.setVisible(true);//더블 클릭시 Update 화면으로 이동
					up.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							up.setVisible(false);
							up.dispose();
						}
					});
		            
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            int index = list.locationToIndex(evt.getPoint());
		        }
		    }
		});
		/*************************************************************/
	
		
		/*************************************************************/
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(172, 382, 93, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(21, 20, 592, 341);
		contentPane.add(scrollPane);
		
		
		
		/*************************************************************/
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
	
				int selec;
					try
					{
						if(list.isSelectionEmpty())
							throw new Exception();
					}
					catch(Exception _e)
					{
						System.out.println("선택된 컴포넌트가 없습니다.");
						return;
					}
					selec = list.getSelectedIndex();
					mframe.Clist.crsStorage.remove(selec);
					list.setVisible(false);
					list.setVisible(true);
				}
		});
		
		/*************************************************************/
	/*
		JButton btnCon = new JButton("Condition");
		btnCon.setBounds(200,400 , 93, 23);
		contentPane.add(btnCon);
	
		btnCon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Blank blank = new Blank(mframe.Clist);
				
				blank.setVisible(true);
				blank.addWindowListener(new WindowAdapter() {
					public void windowColsing(WindowEvent e) {
					blank.setVisible(false);
					blank.dispose();
				}
			});
			}
		});
		*/
	}	
}
	


	
