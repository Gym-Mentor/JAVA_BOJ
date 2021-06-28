package boj_2567;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean arr[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		arr=new boolean[101][101];
		N=Integer.parseInt(br.readLine());
		int result=0;
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			for(int row=Y;row<Y+10;row++)
			{
				for(int col=X;col<X+10;col++)
				{
					arr[row][col]=true;
				}
			}
		}
		for(int i=99;i>=0;i--)
		{
			for(int j=99;j>=0;j--)
			{
				if(arr[i][j+1]==false&&arr[i][j]==true)
				{
					result++;
				}
			}
		}
		for(int i=99;i>=0;i--)
		{
			for(int j=99;j>=0;j--)
			{
				if(arr[j+1][i]==false&&arr[j][i]==true)
				{
					result++;
				}
			}
		}
		System.out.println(result*2);
	}

}
