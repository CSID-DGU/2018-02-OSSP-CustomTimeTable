import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Condition extends JFrame {
/*
 * 시간표 생성 조건
 */
	private JPanel contentPane;
	public CourseList list = null;
	public Vector<Time> timeStorage = new Vector<Time>();
	public int max_credit = 0;
	
	public JCheckBox checkBox;
	public JCheckBox chckbxTue;
	public JCheckBox chckbxWed;
	public JCheckBox chckbxThu;
	public JCheckBox chckbxFri;
	public JComboBox comboBox;
	public JComboBox creditCombo;

	
	public Condition(CourseList _list) {
		list = _list;
		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC2DD\uC0AC \uC2DC\uAC04"); //식사시간
		lblNewLabel.setBounds(40, 40, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uACF5\uAC15 \uC694\uC77C"); //공강 요일
		lblNewLabel_1.setBounds(40, 80, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uACF5 \uC218"); //전공수
		lblNewLabel_2.setBounds(40, 120, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uAD50\uC591 \uC218"); //교양수
		lblNewLabel_3.setBounds(40, 160, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC878\uC5C5 \uD559\uC810"); //졸업 학점
		lblNewLabel_4.setBounds(40, 200, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uD55C \uD559\uAE30 \uC774\uC218 \uD559\uC810"); //한학기 이수 학점
		lblNewLabel_5.setBounds(40, 240, 106, 15);
		contentPane.add(lblNewLabel_5);
		
		//식사시간
		String comboBox_arr[] = {"선택 안함","11시~12시","12시~1시","1시~2시"};
		comboBox = new JComboBox(comboBox_arr);
		comboBox.setToolTipText("");
		comboBox.setBounds(180, 40, 240, 21);
		contentPane.add(comboBox);
		
		//공강 요일
		checkBox = new JCheckBox("Mon");
		checkBox.setBounds(180, 75, 50, 20);
		contentPane.add(checkBox);
		
		chckbxTue = new JCheckBox("Tue");
		chckbxTue.setBounds(230, 75, 50, 20);
		contentPane.add(chckbxTue);
		
		chckbxWed = new JCheckBox("Wed");
		chckbxWed.setBounds(280, 75, 50, 20);
		contentPane.add(chckbxWed);
		
		chckbxThu = new JCheckBox("Thu");
		chckbxThu.setBounds(330, 75, 50, 20);
		contentPane.add(chckbxThu);
		
		chckbxFri = new JCheckBox("Fri");
		chckbxFri.setBounds(380, 75, 50, 20);
		contentPane.add(chckbxFri);
		
		//전공 수
		String comboBox_arr1[] = {"1개","2개","3개","4개","5개"};
		JComboBox comboBox_1 = new JComboBox(comboBox_arr1);
		comboBox_1.setBounds(180, 120, 240, 21);
		contentPane.add(comboBox_1);
		
		//교양 수
		String comboBox_arr2[] = {"1개","2개","3개","4개","5개"};
		JComboBox comboBox_2 = new JComboBox(comboBox_arr2);
		comboBox_2.setBounds(180, 160, 240, 21);
		contentPane.add(comboBox_2);
		
		//졸업학점
		JRadioButton radioButton = new JRadioButton("120");
		radioButton.setBounds(180, 200, 69, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("140");
		radioButton_1.setBounds(260, 200, 69, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("160");
		radioButton_2.setBounds(340, 200, 121, 23);
		contentPane.add(radioButton_2);
		
		String label_arr[] = {"선택 안함", "~12학점", "~15학점", "~18학점", "~21학점", "21학점 이상"};
		creditCombo = new JComboBox(label_arr);
		creditCombo.setBounds(180, 237, 240, 21);
		contentPane.add(creditCombo);
		
		JButton button = new JButton("\uC81C\uCD9C"); //제출 버튼
		button.addActionListener(new submitEvent(list, this)); //제출
		button.setBounds(233, 320, 97, 23);
		contentPane.add(button);
	}

}


class submitEvent implements ActionListener //제출 버튼 클릭시
{
	CourseList d_list = null;
	Condition c_list = null;
	
	public submitEvent(CourseList _list, Condition _clist)
	{
		d_list = _list;
		c_list = _clist;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(c_list.checkBox.isSelected()==true)
			c_list.timeStorage.add(new Time(0, 0, 27)); //월
		if(c_list.chckbxTue.isSelected()==true)
			c_list.timeStorage.add(new Time(1, 0, 27)); //화
		if(c_list.chckbxWed.isSelected()==true)
			c_list.timeStorage.add(new Time(2, 0, 27)); //수
		if(c_list.chckbxThu.isSelected()==true)
			c_list.timeStorage.add(new Time(3, 0, 27)); //목
		if(c_list.chckbxFri.isSelected()==true)
			c_list.timeStorage.add(new Time(4, 0, 27)); //금
		
		if(c_list.comboBox.getSelectedIndex()==1) {  //11시 ~ 12시 점심시간 확보(모든 요일)
			c_list.timeStorage.add(new Time(0, 6, 8));
			c_list.timeStorage.add(new Time(1, 6, 8));
			c_list.timeStorage.add(new Time(2, 6, 8));
			c_list.timeStorage.add(new Time(3, 6, 8));
			c_list.timeStorage.add(new Time(4, 6, 8));
		}
		else if(c_list.comboBox.getSelectedIndex()==2) {  //12시 ~ 1시 점심시간 확보(모든 요일)
			c_list.timeStorage.add(new Time(0, 8, 10));
			c_list.timeStorage.add(new Time(1, 8, 10));
			c_list.timeStorage.add(new Time(2, 8, 10));
			c_list.timeStorage.add(new Time(3, 8, 10));
			c_list.timeStorage.add(new Time(4, 8, 10));
		}
		else if(c_list.comboBox.getSelectedIndex()==3) {  //1시 ~ 2시 점심시간 확보(모든 요일)
			c_list.timeStorage.add(new Time(0, 10, 12));
			c_list.timeStorage.add(new Time(1, 10, 12));
			c_list.timeStorage.add(new Time(2, 10, 12));
			c_list.timeStorage.add(new Time(3, 10, 12));
			c_list.timeStorage.add(new Time(4, 10, 12));
		}
		
		//�ִ� ���� ����
		if(c_list.creditCombo.getSelectedIndex()==1) {
			c_list.max_credit = 12;
		}
		else if(c_list.creditCombo.getSelectedIndex()==2) {
			c_list.max_credit = 15;
		}
		else if(c_list.creditCombo.getSelectedIndex()==3) {
			c_list.max_credit = 18;
		}
		else if(c_list.creditCombo.getSelectedIndex()==4) {
			c_list.max_credit = 21;
		}
		else if(c_list.creditCombo.getSelectedIndex()==5) {
			c_list.max_credit = 24;
		}
			
		
		d_list.blank.timeStorage = c_list.timeStorage; //공강시간 넘겨주기
		d_list.blank.max_credit = c_list.max_credit; //최대 수강 학점 넘겨주기
		
		
		c_list.dispose();
	}
	
}