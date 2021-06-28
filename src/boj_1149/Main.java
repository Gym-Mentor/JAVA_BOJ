package boj_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[][];
	static int DP[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1][3];
		DP=new int[N+1][3];
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());

			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		DP[1][0]=arr[1][0];
		DP[1][1]=arr[1][1];
		DP[1][2]=arr[1][2];
		for(int i=2;i<=N;i++)
		{
			for(int j=0;j<3;j++)
			{
				DP[i][j]=Integer.MAX_VALUE;
				for(int k=0;k<3;k++)
				{
						if(j!=k)
						{
							DP[i][j]=Math.min(DP[i-1][k]+arr[i][j],DP[i][j]);
						}
				}
			}
		}
		int max=Math.min(DP[N][0], DP[N][1]);
		max=Math.min(max, DP[N][2]);
		System.out.println(max);
	}

}
