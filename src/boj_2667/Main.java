package boj_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

		static int N,result=0;
		static char arr[][];
		static int[] dy= {1,-1,0,0};
		static int[] dx= {0,0,1,-1};
		static ArrayList<Integer> list=new ArrayList<>();
		public static void main(String[] args) throws IOException{
			
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			N=Integer.parseInt(br.readLine());
			arr=new char[N][N];
			for(int i=0;i<N;i++)
			{
				String str=br.readLine();
				arr[i]=str.toCharArray();
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(arr[i][j]=='1')
					{
						result++;
						list.add(bfs(i,j));					
					}
				}
			}
			Collections.sort(list);
			System.out.println(result);
			for(int num:list)
			{
				System.out.println(num);
			}
		}
		static int bfs(int Y,int X)
		{
			int cnt=1;
			Queue<int[]> q=new LinkedList<>();
			q.offer(new int[] {Y,X});
			arr[Y][X]=0;
			while(!q.isEmpty())
			{
				int nowY=q.peek()[0];
				int nowX=q.peek()[1];
				q.poll();
				for(int i=0;i<4;i++)
				{
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&arr[nextY][nextX]=='1')
					{
						arr[nextY][nextX]=0;
						q.offer(new int[] {nextY,nextX});
						cnt++;
						
					}
				}
			}
			return cnt;
		}
}
