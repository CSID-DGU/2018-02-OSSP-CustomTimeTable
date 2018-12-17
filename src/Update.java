import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;

public class Update extends JFrame {

	private JPanel contentPane;

	public Update(Course crs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox  enCheck= new JCheckBox("필수");
		enCheck.setBounds(18, 17, 201, 37);
		contentPane.add(enCheck);
		
		JCheckBox basicCheck = new JCheckBox("기본");
		basicCheck.setBounds(18, 106, 201, 37);
		contentPane.add(basicCheck);
		System.out.println(crs);
		
		JButton save = new JButton("저장");
		save.setBounds(283, 62, 153, 37);
		contentPane.add(save);
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enCheck.isSelected()==true) crs.prior = 50;//필수를 선택 했을때 50 값
				if(basicCheck.isSelected()==true) crs.prior = 0;//기본일때 0으로 저장
				dispose();
			}
		});
		
	}
}
