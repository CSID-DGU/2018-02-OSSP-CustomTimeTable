import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public CourseListFrame(MainFrame mframe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*************************************************************/
		

		//list형태로 출력
		JList list = new JList();
		list.setBounds(21, 20, 592, 341);
		contentPane.add(list);
		
		list.setListData(mframe.Clist.crsStorage);
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(404, 387, 93, 23);
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
		
		/*************************************************************/
	
		
		/*************************************************************/
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(198, 387, 93, 23);
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
				}
		});
		
		/*************************************************************/
	
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
	}	
}
	


	
