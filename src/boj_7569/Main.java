package boj_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class Main {

	static int M,N,H,result=0;
	static boolean check=false;
	//여섯방향 탐색
	static int dy[]= {1,-1,0,0,0,0};
	static int dx[]= {0,0,1,-1,0,0};
	static int dk[]= {0,0,0,0,1,-1};
	static int arr[][][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		arr=new int[N][M][H];
		for(int k=0;k<H;k++)
		{
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++)
				{
					arr[i][j][k]=Integer.parseInt(st.nextToken());									
				}
			}
		}	
				bfs();
			System.out.println(result);
		
	}
	static void bfs()
	{
		Queue<int[]> q=new LinkedList<>();
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				for(int k=0;k<H;k++) {
					if(arr[i][j][k]==1)
					{
						q.offer(new int[] {i,j,k,0});
					}
					else if(arr[i][j][k]==0) //여섯 방향이 -1이거나 막혔을 때 종료
					{
						int cnt=0;
						for(int idx=0;idx<6;idx++)
						{
							int nextY=i+dy[idx];
							int nextX=j+dx[idx];
							int nextK=k+dk[idx];
							
							// 방향이 -1이거나 막혔을 때 증가
							if(!(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&0<=nextK&&nextK<H)||arr[nextY][nextX][nextK]==-1)
							{
								cnt++;
							}
							//여섯방향이 막힌경우 종료
							if(cnt==6)
							{
								result=-1;
								check=true;
								return;
							}
						}
					}
				}
			}
		}
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int nowK=q.peek()[2];
			int dist=q.peek()[3]; // 날짜 계산
			if(result<dist)
			{
				result=dist;
			}
			q.poll();
			for(int idx=0;idx<6;idx++)
			{
				int nextY=nowY+dy[idx];
				int nextX=nowX+dx[idx];
				int nextK=nowK+dk[idx];
				if((0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&0<=nextK&&nextK<H)&&arr[nextY][nextX][nextK]==0)
				{
					arr[nextY][nextX][nextK]=1;
					q.offer(new int[] {nextY,nextX,nextK,dist+1});
				}
			}
		}
	}

}
