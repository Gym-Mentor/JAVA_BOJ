package boj_1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		visited=new boolean[100000+1];
		
		System.out.println(minValue(N,K));
		
	}

	
	static class pair
	{
		int first;
		int second;
		pair(int first, int second)
		{
			this.first=first;
			this.second=second;
		}
	}
	
	static int minValue(int N, int K)
	{
		Queue<pair> q = new LinkedList<>();
		q.offer(new pair(N,0));
		
		while(!q.isEmpty())
		{
			int curLoc=q.peek().first;
			int curVal=q.peek().second;
			q.poll();
			
			if(curLoc==K)return curVal;
			if(curLoc+1<=100000&&!visited[curLoc+1])
			{
				q.offer(new pair(curLoc+1,curVal+1));
				visited[curLoc+1]=true;
			}
			if(curLoc-1>=0&&!visited[curLoc-1])
			{
				q.offer(new pair(curLoc-1,curVal+1));
				visited[curLoc-1]=true;
			}
			if(curLoc*2<=100000&&!visited[curLoc*2])
			{
				q.offer(new pair(curLoc*2,curVal+1));
				visited[curLoc*2]=true;
			}
		}
		return 0;
	}
}
