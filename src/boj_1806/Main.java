package boj_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,S;
	static int[] arr,sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1];
		sum=new int[N+1];
		st= new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++)
		{
			sum[i]=sum[i-1]+arr[i];
		}
		
		
		int result=Integer.MAX_VALUE;
		int first=0;
		int second=0;
		
		// 투 포인터 구현
		while(true)
		{
			// 현재 부분합이 S보다 크면
			if(sum[first]-sum[second]>=S)
			{
				// 현재 부분합보다 길이가 작으면
				if(result>first-second)
				{
					result=first-second;
				}
				//왼쪽인덱스를 당겨준다.
				second++;
			}
			//현재 부분합이 S보다 작으면 오른쪽인덱스를 늘려준다.
			else
			{
				first++;
			}
			//first가 끝에 도달했을 때
			if(first==N)
			{
				// 부분합이 S보다 작으면 종료
				if(sum[first]-sum[second]<S)
				{
					break;
				}
			}
		}
		if(result==Integer.MAX_VALUE)
			System.out.println("0");
		else
		System.out.println(result);
	}

}
