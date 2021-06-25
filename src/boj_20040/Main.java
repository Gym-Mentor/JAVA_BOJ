package boj_20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,result=0;
	static int[] parents;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parents	=new int[N];
		for(int i=0;i<N;i++)
		{
			parents[i]=i;
		}
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			if(union(num1,num2))
			{
				return;
			}
		}
		System.out.println("0");
		
	}

	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a, int b)
	{
		result++;
		int num1=findSet(a);
		int num2=findSet(b);
		
		if(num1!=num2)
		{
			parents[num2]=num1;
		}
		else
		{
			System.out.println(result);
			return true;
		}
		return false;
	}
}
