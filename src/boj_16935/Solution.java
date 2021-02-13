package boj_16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N,M,R;
	static int arr[][];

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
	
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int tmp=0;
		st=new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			int cmd=Integer.parseInt(st.nextToken());
			if(cmd==1)
			{
				one();
			}
			else if(cmd==2)
			{
				two();
			}
			else if(cmd==3)
			{
				
				three();
				
			}
			else if(cmd==4)
			{
				four();
				
			}
			else if(cmd==5)
			{
				five();
			}
			else if(cmd==6)
			{
				six();
			}	
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{

				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
	static void one()	
	{
		int temp[]=new int[arr[0].length];
		
		for(int i=0;i<arr.length/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
	}
	static void two()	
	{
		int temp[][]=new int[arr.length][arr[0].length];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i][j]=arr[i][j];
				arr[i][j]=arr[i][arr[0].length-j-1];
				arr[i][arr[0].length-j-1]=temp[i][j];
			}
		}
	}
	
	static void three()
	{
		int temp[][]=new int[arr[0].length][arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				temp[j][arr.length-i-1]=arr[i][j];
			}
		}
		arr=temp;
	}
	static void four()
	{
		int temp[][]=new int[arr[0].length][arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				temp[arr[0].length-j-1][i]=arr[i][j];
			}
		}
		arr=temp;
	}
	static void five()
	{
		int temp[][]=new int[arr.length][arr[0].length];
		
		//1에 4대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i][j]=arr[i+arr.length/2][j];
			}
		}
		//2에 1대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i][j+arr[0].length/2]=arr[i][j];
			}
		}
		//3에 2대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i+arr.length/2][j+arr[0].length/2]=arr[i][j+arr[0].length/2];
			}
		}
		//4에 3대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i+arr.length/2][j]=arr[i+arr.length/2][j+arr[0].length/2];
			}
		}
		arr=temp;
	}
	static void six()
	{
		int temp[][]=new int[arr.length][arr[0].length];
		
		//1에 4대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i][j]=arr[i][j+arr[0].length/2];
			}
		}
		//2에 1대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i+arr.length/2][j]=arr[i][j];
			}
		}
		//3에 2대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i][j+arr[0].length/2]=arr[i+arr.length/2][j+arr[0].length/2];
			}
		}
		//4에 3대입
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr[0].length/2;j++)
			{
				temp[i+arr.length/2][j+arr[0].length/2]=arr[i+arr.length/2][j];
			}
		}
		arr=temp;
	}
}
