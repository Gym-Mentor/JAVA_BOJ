package boj_2661;
// 좋은수열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s=""; // 값을 출력하는 변수
	static boolean first=false; // 제일 작은 값을 찾았는지 체크하는 변수
	
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		
		dfs(""); // dfs 돌리기
		System.out.println(s);
	}

	static void dfs(String num)
	{
		//num의 길이가 N이면 종료
		if(num.length()==N)
		{
			if(!first) // 처음으로 찾은 값이면 가장 작은 값이기 때문에 결과에 넣고 가지치기
			{
				s=num;
				first=true;
			}
			return;
		}
		
		
		for(int i=1;i<=3;i++)
		{
			if(!first&&check(num+i)) // 가지치기와 좋은순열인지 체크
			{
				dfs(num+i);
			}
		}
		return;
	}
	
	static boolean check(String str) // 좋은 순열인지 체크
	{
		int idx=1; 
		//1부터 문자열의 절반길이만큼 비교
		while(idx<=str.length()/2)
		{
			String sub1=str.substring(str.length()-idx, str.length()); //  idx길이의 뒤의 문자열
			String sub2=str.substring(str.length()-2*idx, str.length()-idx); // idx 길이의 앞의 문자열
			if(sub1.equals(sub2))
				return false;
			idx++;
		}
		return true;
	}
}


//   12321232  // dfs를 반복하면서 유효한 값만 호출했기때문에
//        3 2  // 새로들어온 값인 2에대해서만 검사를 하면된다.
//      12 32
//    321 232
//  1232 1232

//  11660KB	 80ms
