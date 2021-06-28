package boj_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int result;
	static char[][] arr;
	static int cArr[];
	static boolean[][] visited,check;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		arr=new char[5][5];
		visited=new boolean[5][5];
		check=new boolean[5][5];
		cArr=new int[7];
		result=0;
		for(int i=0;i<5;i++)
		{
			arr[i]=br.readLine().toCharArray();
		}
		comb(0,0);
		System.out.println(result);
	}
	static void comb(int cnt,int start)
	{
		if(cnt==7)
		{
			for(boolean[] rows:visited)
			Arrays.fill(rows, false);
			for(boolean[] rows:check)
			Arrays.fill(rows, false);
			for(int i=0;i<7;i++)
			{
				check[cArr[i]/5][cArr[i]%5]=true;
			}
			
			bfs(cArr[0]/5,cArr[0]%5);
			
			return;
		}
		for(int i=start;i<25;i++)
		{
			cArr[cnt]=i;
			comb(cnt+1,i+1);
		}
	}
	static void bfs(int Y,int X)
	{
		Queue<int[]> q =new LinkedList<>();
		visited[Y][X]=true;
		q.offer(new int[] {Y,X});
		int S=0;
		if(arr[Y][X]=='S')S++;
		int count=1;
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<5&&0<=nextX&&nextX<5&&!visited[nextY][nextX]&&check[nextY][nextX])
				{
					if(arr[nextY][nextX]=='S')
						S++;
					visited[nextY][nextX]=true;
					count++;
					q.offer(new int[] {nextY,nextX});
				}
			}
		}
		if(count==7)
		{
			if(S>=4)
			{
				result++;
			}
		}
	}
}
