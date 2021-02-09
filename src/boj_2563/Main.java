package boj_2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean arr[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		arr=new boolean[100][100];
		int result=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int x=Integer.parseInt(st.nextToken()); 
		int y=Integer.parseInt(st.nextToken()); 
		fill(y,x);
		}
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(arr[i][j])
				{
					result++;
				}
			}
		}
		System.out.println(result);
		
	}
	static void fill(int y,int x)
	{
		for(int i=y;i<y+10;i++)
		{
			for(int j=x;j<x+10;j++)
			{
				arr[i][j]=true;
			}
		}
	}

}
