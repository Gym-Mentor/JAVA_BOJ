package boj_2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,d,k,c;
	static int arr[];
	static int visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		visited=new int[d+1];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		int count=0;
		for(int i=0;i<k;i++)
		{
			if(visited[arr[i]]==0)count++;
			visited[arr[i]]++;
			
		}
		int max=0;
		if(visited[c]==0)count++;
		visited[c]++;
		for(int i=0;i<N;i++)
		{
			if(visited[arr[i]]>0) {
				visited[arr[i]]--;
				if(visited[arr[i]]==0)
					count--;
			}
			
			if(visited[arr[(i+k)%N]]==0)
			{
				count++;
			}
			visited[arr[(i+k)%N]]++;
			
			if(visited[c]==0) 
			{
				count++;
			}
			max=Math.max(max, count);
		}
		
		System.out.println(max);
	}

}
