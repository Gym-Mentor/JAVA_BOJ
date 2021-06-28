package boj_11559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char arr[][];
	static int result=0;
	static boolean isChanged=false;
	static boolean visited[][];
	static int[] dy= {-1,0,1,0};
	static int[] dx= {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		arr=new char[12][6];
		for(int i=0;i<12;i++)
		{
			String str=br.readLine();
			for(int j=0;j<6;j++)
			{
				arr[i][j]=str.charAt(j);
			}
		}
		
		while(true)
		{
			isChanged=false;
			for(int i=0;i<12;i++)
			{
				for(int j=0;j<6;j++)
				{
					visited=new boolean[12][6];
					bfs(i,j);
				}
			}
			if(isChanged)
			{
				result++;
			}
			else
			{
				break;
			}
			build();
		}
		System.out.println(result);
		
	}

	static void bfs(int Y,int X)
	{
		Queue<pair> q=new LinkedList<>();
		Queue<pair> savedQ=new LinkedList<>();
		q.offer(new pair(Y,X));
		savedQ.offer(new pair(Y,X));
		char c=arr[Y][X];
		int cnt=1;
		visited[Y][X]=true;
		if(c=='.')return;
		while(!q.isEmpty())
		{
			int nowY=q.peek().first;
			int nowX=q.peek().second;
			q.poll();
			
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<12&&0<=nextX&&nextX<6&&!visited[nextY][nextX])
				{
					if(arr[nextY][nextX]==c)
					{
						q.offer(new pair(nextY,nextX));
						savedQ.offer(new pair(nextY,nextX));
						visited[nextY][nextX]=true;
						cnt++;
					}
				}
			}
		}
		if(cnt>=4)
		{
			while(!savedQ.isEmpty())
			{
				
				int nowY=savedQ.peek().first;
				int nowX=savedQ.peek().second;
				savedQ.poll();
				
				
				
				arr[nowY][nowX]='.';
			}
			isChanged=true;
		}
		
	}
	static void build()
	{
		for(int i=0;i<6;i++)
		{
			Queue<Character> q =new LinkedList<>();
			for(int j=11;j>=0;j--)
			{
				if(arr[j][i]!='.')
				{
					q.offer(arr[j][i]);
				}

			}
			int cnt=11;
			while(!q.isEmpty())
			{
				arr[cnt--][i]=q.poll();
			}
			for(int j=cnt;j>=0;j--)
			{
				arr[j][i]='.';
			}
		}
	}
	static class pair
	{
		int first;
		int second;
		pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}
}
