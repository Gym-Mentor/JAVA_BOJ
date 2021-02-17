package boj_1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char arr[][];
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		arr=new char[N][N];
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<N;j++)
			{
				arr[i][j]=str.charAt(j);
			}
		}
		System.out.println(divide(0,0,N));
		
		
	}
	static boolean check1(int Y,int X,int size)
	{
		for(int i=Y;i<Y+size;i++)
		{
			for(int j=X;j<X+size;j++)
			{
				if(arr[i][j]=='0')return false;
			}
		}
		return true;
	}
	static boolean check0(int Y,int X,int size)
	{
		for(int i=Y;i<Y+size;i++)
		{
			for(int j=X;j<X+size;j++)
			{
				if(arr[i][j]=='1')return false;
			}
		}
		return true;
	}
	static String divide(int Y,int X,int size)
	{
		String str="";

		if(check1(Y,X,size))
			str="1";
		else if(check0(Y,X,size))
			str="0";
		else
		{
			str="(";
			str+=divide(Y,X,size/2);
			str+=divide(Y,X+size/2,size/2);
			str+=divide(Y+size/2,X,size/2);
			str+=divide(Y+size/2,X+size/2,size/2);
			str+=")";
		}
		return str;
	}
}
