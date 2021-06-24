package boj_1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,parents[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parents=new int[N+1];
		
		make();
		
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int flag=Integer.parseInt(st.nextToken());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			union(flag,num1,num2);
			
		}
	}
	

	static void make()	{
		for(int i=0;i<=N;i++)
		{
			parents[i]=i;
		}
	}
	
	static int findSet(int num1)
	{
		if(parents[num1]==num1)return num1;
		return parents[num1]=findSet(parents[num1]);
	}
	
	static boolean union(int flag,int num1,int num2)
	{
		int P1=findSet(num1);
		int P2=findSet(num2);
		
		if(flag==1) {
			if(P1==P2) {
				System.out.println("YES");
				return true;
			}
			else {
				System.out.println("NO");
				return false;
			}
		}
		else
		{
			if(P1==P2)return true;
			else 
			{
				parents[num2]=num1;
				return false;
			}
		}
	}
	
}
