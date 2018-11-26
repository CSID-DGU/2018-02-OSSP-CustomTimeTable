import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//시간표 생성전 선택할 조건을 구현
	private JPanel contentPane;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public Condition() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC2DD\uC0AC \uC2DC\uAC04");
		lblNewLabel.setBounds(40, 40, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uACF5\uAC15 \uC694\uC77C");
		lblNewLabel_1.setBounds(40, 80, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uACF5 \uC218");
		lblNewLabel_2.setBounds(40, 120, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uAD50\uC591 \uC218");
		lblNewLabel_3.setBounds(40, 160, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC878\uC5C5 \uD559\uC810");
		lblNewLabel_4.setBounds(40, 200, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uD55C \uD559\uAE30 \uC774\uC218 \uD559\uC810");
		lblNewLabel_5.setBounds(40, 240, 106, 15);
		contentPane.add(lblNewLabel_5);
		
		String comboBox_arr[] = {"11시~12시","12시~1시","1시~2시"};
		JComboBox comboBox = new JComboBox(comboBox_arr);
		comboBox.setToolTipText("");
		comboBox.setBounds(180, 40, 240, 21);
		contentPane.add(comboBox);
		
		JCheckBox chckbxTue = new JCheckBox("Tue");
		chckbxTue.setBounds(230, 75, 50, 20);
		contentPane.add(chckbxTue);
		
		JCheckBox chckbxWed = new JCheckBox("Wed");
		chckbxWed.setBounds(280, 75, 50, 20);
		contentPane.add(chckbxWed);
		
		JCheckBox chckbxThu = new JCheckBox("Thu");
		chckbxThu.setBounds(330, 75, 50, 20);
		contentPane.add(chckbxThu);
		
		JCheckBox chckbxFri = new JCheckBox("Fri");
		chckbxFri.setBounds(380, 75, 50, 20);
		contentPane.add(chckbxFri);
		
		String comboBox_arr1[] = {"1개","2개","3개","4개","5개"};
		JComboBox comboBox_1 = new JComboBox(comboBox_arr1);
		comboBox_1.setBounds(180, 120, 240, 21);
		contentPane.add(comboBox_1);
		
		String comboBox_arr2[] = {"1개","2개","3개","4개","5개"};
		JComboBox comboBox_2 = new JComboBox(comboBox_arr2);
		comboBox_2.setBounds(180, 160, 240, 21);
		contentPane.add(comboBox_2);
		
		JRadioButton radioButton = new JRadioButton("120");
		radioButton.setBounds(180, 200, 69, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("140");
		radioButton_1.setBounds(260, 200, 69, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("160");
		radioButton_2.setBounds(340, 200, 121, 23);
		contentPane.add(radioButton_2);
		
		JCheckBox checkBox = new JCheckBox("Mon");
		checkBox.setBounds(180, 75, 50, 20);
		contentPane.add(checkBox);
		
		JButton button = new JButton("\uC81C\uCD9C");
		/*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first first_page = new first();				
				first_page.setVisible(true);
				dispose();
			}
		});*/
		
		button.setBounds(233, 320, 97, 23);
		contentPane.add(button);
		
		JTextField textField = new JTextField();
		textField.setBounds(180, 237, 240, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	
	}

}
