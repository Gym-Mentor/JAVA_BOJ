package boj_10163;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[101][101];
		
		for(int tc=1;tc<=N;tc++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			int Y=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			int row=Integer.parseInt(st.nextToken());
			int col=Integer.parseInt(st.nextToken());
			
			for(int i=Y;i<Y+row;i++)
			{
				for(int j=X;j<X+col;j++)
				{
					arr[i][j]=tc;
				}
			}
		}
		
		for(int tc=1;tc<=N;tc++)
		{
			int result=0;
			for(int i=0;i<101;i++)
			{
				for(int j=0;j<101;j++)
				{
					if(tc==arr[i][j])
						result++;
				}
			}
			System.out.println(result);
		}
		
	}

}
