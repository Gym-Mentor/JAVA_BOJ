package boj_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,sharkY,sharkX,sharkSize=2,size=0,result=0,cnt=0,minY,minX,init=21,dist=401;
	static int[][] arr;
	static boolean visited[][];
	static int[] dy= {-1,0,0,1};
	static int[] dx= {0,-1,1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==9)
				{
					sharkY=i;
					sharkX=j;
				}
			}
		}
		while(true)
		{
			init();
			bfs(sharkY,sharkX);
			if(minY!=init)
			{
				result+=dist;
				sharkY=minY;
				sharkX=minX;
				size++;
				if(size==sharkSize)
				{
					sharkSize++;
					size=0;
				}
			}
			else
			{
				break;
			}
			
		}
		
		System.out.println(result);
		
	}
	static void init()	
	{
		for(boolean rows[]:visited)
		{
			Arrays.fill(rows, false);
		}
		dist=401;
		minY=init;
		minX=init;
	}
	static void bfs(int Y,int X)
	{
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {Y,X,0});
		visited[Y][X]=true;
		arr[Y][X]=0;
		ArrayList<int[]> list=new ArrayList<>();
		while(!q.isEmpty())
		{
			//현재 탐색할 좌표
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int distance=q.peek()[2];
			q.poll();
			//4방위  탐색
			for(int i=0;i<4;i++)
			{
				// 다음에 탐색할 좌표
				
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX]&&arr[nextY][nextX]<=sharkSize) // 범위 내에 있을 때
				{
					
					if(arr[nextY][nextX]<sharkSize&&arr[nextY][nextX]!=0) // 먹을 수 있는 물고기를 발견하면 먹는다.
					{
						list.add(new int[] {nextY,nextX,distance+1});
						
					}
					visited[nextY][nextX]=true;
					q.offer(new int[] {nextY,nextX,distance+1});
				}		
			}
		}
		if(list.size()>0) {
			for(int j=0;j<list.size();j++) {
				if(dist>list.get(j)[2])
				{
					dist=list.get(j)[2];
					minY=list.get(j)[0];
					minX=list.get(j)[1];
				}
				else if(dist==list.get(j)[2]) {
				if(minY>list.get(j)[0])
				{
					minY=list.get(j)[0];
					minX=list.get(j)[1];
				}
				else if(minY==list.get(j)[0])
				{
					if(minX>list.get(j)[1])
					{
						minX=list.get(j)[1];
					}
				}
				}
			}
		}
	}
	
	static class pair{ // 좌표를 저장하기 위한 객체
		int first;
		int second;
		pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}
}
