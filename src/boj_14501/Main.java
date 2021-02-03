package boj_14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][]arr=new int[N][2];
		int[]DP=new int[N];
		int max=0;
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			if(arr[i][0]+i<=N)
			DP[i]=arr[i][1];
			max=Math.max(max, DP[i]);
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j][0]<=i-j&&i+arr[i][0]<=N)
				{
					DP[i]=Math.max(DP[i], arr[i][1]+DP[j]);
					max=Math.max(max,DP[i]);
				}
			}
		}
		System.out.println(max);
	}

}
