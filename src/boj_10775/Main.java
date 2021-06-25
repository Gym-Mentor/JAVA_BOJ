package boj_10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int G,P,ans=0;
	static int parents[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		G=Integer.parseInt(br.readLine());
		P=Integer.parseInt(br.readLine());
		
		parents=new int[G+1];
		
		for(int i=0;i<=G;i++)
		{
			parents[i]=i;
		}
		
		for(int i=0;i<P;i++)
		{
			int num=Integer.parseInt(br.readLine());
			
			int parent=findSet(num);
			
			if(parent==0)
				break;
			
			ans++;
			union(parent,parent-1);
			
		}
		System.out.println(ans);
	}

	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static void union(int num1,int num2)
	{
		int P1=findSet(num1);
		int P2=findSet(num2);
		
		if(P1!=P2)
		{
			parents[P1]=P2;
		}
	}
}
