package boj_17129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,Y,X;
	static boolean arr[][];
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int[][] goal;
	public static void main(String[] args) throws IOException{
		
		///////////////////////선언 및 생성//////////////////
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new boolean[N][M]; // 0과 1을 받는 배열이자 visited 체크하는 배열
		goal=new int[3][2]; // 3,4,5(식당)를 입력받는 배열
		
		
		/////////////////////////지도 입력받기 ////////////////////////
		int cnt=0;
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<M;j++)
			{
				int num=str.charAt(j)-'0';
				
				if(num==0) // 빈 복도일 때
				{
					arr[i][j]=false;
				}
				else if(num==1) // 벽일 때
				{
					arr[i][j]=true;
				}
				else if(num==2) // 현재 식구의 위치
				{
					arr[i][j]=false;
					Y=i;
					X=j;
				}
				else // 식당의 위치를 배열에 저장
				{
					arr[i][j]=false;
					goal[cnt][0]=i;
					goal[cnt++][1]=j;
				}
			}
		}
		BFS(Y,X);
	
		
	}
	static void BFS(int y, int x)
	{
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {y,x,0});
		arr[y][x]=true;
	
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int dist=q.peek()[2];
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&arr[nextY][nextX]==false)
				{
					
					///////////////////////////////////////////////////
					//////////////다음 방문할 좌표가 식당인지 체크/////////////
					for(int j=0;j<3;j++)
					{
						if(nextY==goal[j][0]&&nextX==goal[j][1])
						{
							int result=dist+1; // 처음위치와 떨어진 거리 구하기
							System.out.println("TAK");
							System.out.println(result);
							return;
						}
					}
					////////////////////////////////////////////////////
					
					if(arr[nextY][nextX]==false) // 다음에 방문할 좌표가 복도인 경우
					{
						q.offer(new int[] {nextY,nextX,dist+1});
						arr[nextY][nextX]=true; // 방문체크와 동시에 벽으로 바꾸기
					}
					
				}
				
			}
		}
		System.out.println("NIE");
		return;
	}
}
