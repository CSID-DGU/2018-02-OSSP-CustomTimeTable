import java.util.Iterator;
import java.util.Vector;
/*
 * 강의 정보를 저장
 */
interface Week 
{
	int MON=0, TUE=1, WED=2, THU=3, FRI=4, SAT=5, SUN=6;
}

public class Course 
{        
	public int num;
	public String name;  
	public int credit; 
	public int prior;   
	public String professor;
	public Vector<Time> timeStorage = new Vector<Time>();
	public int max_credit = 0;
	
	public Course()	{} //매개변수 없는 생성자
	
	public Course(int _num, String _name, int _prior, int _credit, Vector<Time> _time, String _prof) { //매개변수 있는 생성자
		num = _num; //0
		name = _name; //강의 이름   
		prior = _prior; //중요도(초기 값 : 0)  
		credit = _credit; //학점
		timeStorage = _time; //강의 시간
		professor = _prof; //교수 이름
	}
	
	public String toString() 
	{
		String str = name; //강의 이름 추가
		for(int i = name.length(); i<11; ++i) 
			str +="　";
		str += professor; //교수님 이름 추가
		for(int i = professor.length(); i<6; ++i)
			str +="　";
		str += credit+"점"; //학점 추가
		for(int i = String.valueOf(credit).length(); i<3; ++i)
			str +="　";
		if(prior == 0)
		{
			str += "기본"; //중요도 추가
		}
		else if(prior == 50)
		{
			str += "필수";
		}
		for(int i = String.valueOf(prior).length(); i<3; ++i)
			str +="　";
		
		//공강 추가
		Iterator itr = timeStorage.iterator(); 
		while(itr.hasNext())
		{
			Time t = (Time)itr.next();
			str +=t.toString()+" "; //0(월요일)~4(금요일)
		}
		
		return str; //반환
	}
	
	public void setNum(int _n)
	{
		num = _n;
	}
}

class Time 
{   
	public int wDay; //수업 요일    
	private int sHour; //시작 시간
	private int sMin; //시작 분
	private int eHour; //끝 시간
	private int eMin; //끝 분
	
	public int sIndex; //시작 인덱스
	public int eIndex; //끝 인덱스
	
	public Time(int _w, int _sT, int _eT) //생성자
	{
		wDay = _w; //수업 요일(0:월, 4:금)    
		sHour = _sT/2+8; //수업 시작 시간(교시->시간으로 변경)
	 	sMin = (_sT%2)*30; //수업 시작 분
		eHour = _eT/2+8; //수업 끝 시간
		eMin = (_eT%2)*30; //수업 끝 분
		
		sIndex = (wDay*28)+((sHour-8)*2)+1; //시간 기준으로 시작 인덱스 위치 계산(출력 위치 셀)
		eIndex = (wDay*28)+((eHour-8)*2)+1; //시간 기준으로 끝 인덱스 위치 계산
		
		if(sMin!=0) //정각에 시작인 수업이 아니면(30분에 시작이면)
			++sIndex; //시작 인덱스 한 칸 뒤로
		if(eMin!=0) //정각에 끝나는 수업이 아니면(30분에 끝나면)
			++eIndex; //끝 인덱스 한 칸 뒤로
	}
	
	public String toString()
	{
		String str;
		switch(wDay)
		{
		case Week.MON:
			str = "월 ";
			break;
		case Week.TUE:
			str = "화 ";
			break;
		case Week.WED:
			str = "수 ";
			break;
		case Week.THU:
			str = "목 ";
			break;
		case Week.FRI:
			str = "금 ";
			break;
		default:
			return null;
		}
		str += sHour+"시 "+sMin+"분 ~ "+eHour+"시 "+eMin+"분";
		return str;
	}
}