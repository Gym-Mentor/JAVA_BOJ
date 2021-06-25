package boj_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int parents[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		parents=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parents[i]=i;
		}
		
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				if(st.nextToken().equals("1"))
				{
					union(i,j);
				}
			}
		}
		
			StringTokenizer st= new StringTokenizer(br.readLine());
			int start=findSet(Integer.parseInt(st.nextToken()));
			for(int i=1;i<M;i++)
			{
				if(start!=findSet(Integer.parseInt(st.nextToken())))
				{
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		
	}

	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static void union(int a, int b)
	{
		int num1=findSet(a);
		int num2=findSet(b);
		
		if(num1!=num2)
		{
			if(num1<num2)
			{
				parents[num2]=num1;
			}
			else
			{
				parents[num1]=num2;
			}
		}
	}
}
