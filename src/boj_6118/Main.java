package boj_6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		adj=new ArrayList[N+1];
		
		for(int i=0;i<=N;i++)
		{
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			adj[num1].add(num2);
			adj[num2].add(num1);
		}
		dijkstra(1);
	}

	static void dijkstra(int v)
	{
		int[] dist=new int[N+1];
		boolean[] visited=new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> q =new LinkedList<>();
		dist[v]=0;
		visited[v]=true;
		q.offer(v);
		
		while(!q.isEmpty())
		{
			int idx=q.poll();
			for(int i=0;i<adj[idx].size();i++) {
				int next=adj[idx].get(i);
				if(!visited[next]&&dist[next]>dist[idx]+1)
				{
					dist[next]=dist[idx]+1;
					q.offer(next);
					visited[next]=true;
				}
			}
		}
		
		int max=-1;
		int maxPos=-1;
		int maxNum=-1;
		
		for(int i=1;i<=N;i++)
		{
			if(max<dist[i])
			{
				max=dist[i];
				maxPos=i;	
				maxNum=1;
			}
			else if(max==dist[i])
			{
				maxNum++;
			}
		}
		System.out.println(maxPos+" "+max+" "+maxNum);
	}
}
