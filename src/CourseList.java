import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class CourseList {
	
	public Vector<Course> crsStorage = new Vector<Course>();	
	public CalCourse cal=null;
	public Course blank = new Course();
	//엑셀에서 가져온 시간표 정보들을 list 형태로 저장

	public CourseList()
	{
		
	}
	
	public void setCourse(String filePath) {
		Robot kb = null;
		String text = "";
		
		// 엑셀 읽기
		try {
			kb = new Robot();
		} catch (AWTException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		File file = new File(filePath);
		try {
			//키보드를 이용해서 자동으로 엑셀 전체를 복사
			Desktop.getDesktop().open(file);
			System.out.println("execute");
			kb.delay(2000);
		      // 메모장에 입력한 글자를 모두 선택한다.
		       kb.keyPress(KeyEvent.VK_CONTROL);
		       kb.keyPress(KeyEvent.VK_A);
		       kb.keyRelease(KeyEvent.VK_CONTROL);
		       kb.keyRelease(KeyEvent.VK_A);
		       System.out.println("모두 선택");

		      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
		       kb.delay(500);
		       kb.keyPress(KeyEvent.VK_CONTROL);
		       kb.keyPress(KeyEvent.VK_A);
		       kb.keyRelease(KeyEvent.VK_CONTROL);
		       kb.keyRelease(KeyEvent.VK_A);
		       System.out.println("모두 선택");

		      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
		       kb.delay(500);
		       
		       kb.keyPress(KeyEvent.VK_CONTROL);
		       kb.keyPress(KeyEvent.VK_C);
		       kb.keyRelease(KeyEvent.VK_CONTROL);
		       kb.keyRelease(KeyEvent.VK_C);
		       System.out.println("복사");

		      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
		       kb.delay(500);
		       
		       Transferable transfer = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

				if (transfer != null && transfer.isDataFlavorSupported(DataFlavor.stringFlavor)) 
				{ 
					text = (String)transfer.getTransferData(DataFlavor.stringFlavor);
				}
				if(text=="")
				{
					Desktop.getDesktop().open(file);
					kb.delay(2000);
				      // 메모장에 입력한 글자를 모두 선택한다.
				       kb.keyPress(KeyEvent.VK_CONTROL);
				       kb.keyPress(KeyEvent.VK_A);
				       kb.keyRelease(KeyEvent.VK_CONTROL);
				       kb.keyRelease(KeyEvent.VK_A);
				       System.out.println("모두 선택");

				      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
				       kb.delay(500);
				       kb.keyPress(KeyEvent.VK_CONTROL);
				       kb.keyPress(KeyEvent.VK_A);
				       kb.keyRelease(KeyEvent.VK_CONTROL);
				       kb.keyRelease(KeyEvent.VK_A);
				       System.out.println("모두 선택");

				      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
				       kb.delay(500);
				       
				       kb.keyPress(KeyEvent.VK_CONTROL);
				       kb.keyPress(KeyEvent.VK_C);
				       kb.keyRelease(KeyEvent.VK_CONTROL);
				       kb.keyRelease(KeyEvent.VK_C);
				       System.out.println("복사");

				      //현재 해당 쓰레드를 500ms 동안 sleep시킨다.
				       kb.delay(500);
				       
				       transfer = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

						if (transfer != null && transfer.isDataFlavorSupported(DataFlavor.stringFlavor)) 
						{ 
							text = (String)transfer.getTransferData(DataFlavor.stringFlavor);
						}
				}
		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (UnsupportedFlavorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String crs[] = text.split("\n");
		String element[][]= new String[crs.length][];
		for(int i = 1; i<crs.length; ++i)
		{
			element[i] = crs[i].split("\t");
			if(element[i].length<8||element[i][8]=="")
				continue;
			String time[] = element[i][8].split(",");
			String name = element[i][4];
			String professor = element[i][10];
			int credit = (int)Double.parseDouble(element[i][5]);
			int prio = 0;//Boolean.parseBoolean(element[i][2]);
			Vector<Time> timeStorage = new Vector<Time>();
			int before = 0;
			try
			{
			for(int j = 0; j<time.length; ++j)
			{
				String weekDay = time[j].substring(0, 1);
				double sNum = Double.parseDouble(time[j].substring(1, time[j].indexOf("-")));
				double eNum;
			
				if(time[j].contains("/"))
					eNum = Double.parseDouble(time[j].substring(time[j].indexOf("-")+1, time[j].indexOf("/")))+0.5;
				else
					eNum = Double.parseDouble(time[j].substring(time[j].indexOf("-")+1))+0.5;
				int week;
				switch(weekDay)
				{
				case "월":
					week = 0;
					break;
				case "화":
					week = 1;
					break;
				case "수":
					week = 2;
					break;
				case "목":
					week = 3;
					break;
				case "금":
					week = 4;
					break;
				/*case "토":
					week = 5;
					break;
				case "일":
					week = 6;
					break;*/
				default:
					week = before;
					break;
				}
				before = week;
				int sT= (int)sNum*2;
				int eT= (int)eNum*2;
				if(sNum%1!=0)++sT;
				if(eNum%1!=0)++eT;
				timeStorage.addElement(new Time(week, sT, eT));
				
			}
			}
			catch(Exception ex)
			{
				continue;
			}
			Course course = new Course(0, name,prio,credit, timeStorage, professor);
			//System.out.println(course);
			crsStorage.add(course);		
		}
	}
	
	
}

