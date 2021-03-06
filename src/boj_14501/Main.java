package boj_14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//////////////////////////선언 및 생성///////////////////////////
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][]arr=new int[N][2];  // 0 index : 상담을 완료하는데 걸리는 시간 / 1 index : 상담을 했을 때 받을 수 있는 금액
		int[]DP=new int[N]; //DP
		int max=0;
		
		////////////////////////입력 받기 //////////////////////////////
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken()); //상담을 완료하는데 걸리는 시간
			arr[i][1]=Integer.parseInt(st.nextToken()); //상담을 했을 때 받을 수 있는 금액
			
			if(arr[i][0]+i<=N) // 상담을 하고난 날짜가 N보다 작을 때
			DP[i]=arr[i][1]; // 비용을 넣는다.
			max=Math.max(max, DP[i]);
		}
		
		//DP 처리
		for(int i=0;i<N;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j][0]<=i-j&&i+arr[i][0]<=N) // j와 i가 상담을 할 수 있는 조건 일 때
				{
					DP[i]=Math.max(DP[i], arr[i][1]+DP[j]); //가장 큰 값을 DP에 저장
					max=Math.max(max,DP[i]);
				}
			}
		}
		System.out.println(max);
	}

}
