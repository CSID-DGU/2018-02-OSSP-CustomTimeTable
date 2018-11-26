import java.awt.EventQueue;

public class MainApp {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//커밋확인22
	
}