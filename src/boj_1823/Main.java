package boj_1823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N,DP[][],arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		DP=new int[N+1][N+1];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(solve(0,N));
		
	}
	static int solve(int i,int j)
	{
		if(i==j)return 0; // N-1개 반복 후 종료
		if(DP[i][j]>0)return DP[i][j];
		
		int k=N-j+i+1; // 현재 몇 번째인지 담는 변수
		int ret=Math.max(solve(i+1,j)+arr[i]*k,solve(i,j-1)+arr[j-1]*k); // 왼쪽수확, 오른쪽 수확중 더 큰 것 선택
		return DP[i][j]=ret;
		
	}
}
