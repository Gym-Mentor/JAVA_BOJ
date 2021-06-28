package boj_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] m;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int idx = 0;
		m=new int[2][2];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) {
					m[idx][0] = i;
					m[idx++][1] = j;
				} else if (num != 0) {
					q.offer(new int[] { i, j, num });
				}
			}
		}
		System.out.println(solve(R, C, T));
	}

	static int solve(int R,int C,int T)
	{
		int result=0;
		for(int tc=1;tc<=T;tc++)
		{
			int size=q.size();
			int[][] arr=new int[R][C];
			// 미세먼지 확산
			for(int i=0;i<size;i++)
			{
				int nowY=q.peek()[0];
				int nowX=q.peek()[1];
				int quantity=q.peek()[2];
				q.poll();
				arr[nowY][nowX]+=quantity;
				//  4방위로 미세먼지 확산
			}
			for(int i=0;i<R;i++)
			{
				for(int j=0;j<C;j++)
				{
					if(arr[i][j]!=0) 
					{
						int qt=arr[i][j];
						int count=0;
						for(int k=0;k<4;k++)
						{
							int nextY=i+dy[k];
							int nextX=j+dx[k];
							
							if(0<=nextY&&nextY<R&&0<=nextX&&nextX<C)
							{
								//위쪽의 공기청정기로가면
								if(nextY==m[0][0]&&nextX==m[0][1])
								{
									continue;
								}
								else if(nextY==m[1][0]&&nextX==m[1][1])
								{
									continue;
								}
								q.offer(new int[] {nextY,nextX,qt/5});
								count++;
							}
						}
					// 원래위치의 미세먼지 나누기
						if(i==m[0][0]&&j==m[0][1])
						{
							continue;
						}
						else if(i==m[1][0]&&j==m[1][1])
						{
							continue;
						}
						q.offer(new int[] {i,j,qt-(count*(qt/5))});
					}
				}
			}
			
			//공기청정기 가동
			size=q.size();
			// 미세먼지 확산
			for(int i=0;i<size;i++)
			{
				int nowY=q.peek()[0];
				int nowX=q.peek()[1];
				int quantity=q.peek()[2];
				
				//반시계방향
				if(nowY==0)
				{
					if(nowX==0)
					{
						nowY+=1;
					}
					else
					{
						nowX-=1;
					}
				}
				//반시계방향
				else if(nowY==m[0][0])
				{
					if(nowX==C-1)
					{
						nowY-=1;
					}
					else
					{
						nowX+=1;
					}
				}
				//시계방향
				else if(nowY==m[1][0])
				{
					if(nowX==C-1)
					{
						nowY+=1;
					}
					else
					{
						nowX+=1;
					}
				}
				//시계방향
				else if(nowY==R-1)
				{
					if(nowX==0)
					{
						nowY-=1;
					}
					else
					{
						nowX-=1;
					}
				}
				else if(nowX==0&&nowY<m[0][0])
				{
					nowY+=1;
				}
				else if(nowX==C-1&&nowY<m[0][0])
				{
					nowY-=1;
				}
				else if(nowX==0&&nowY>m[1][0])
				{
					nowY-=1;
				}
				else if(nowX==C-1&&nowY>m[1][0])
				{
					nowY+=1;
				}
				q.poll();
				int nextY=nowY;
				int nextX=nowX;
				if(nextY==m[1][0]&&nextX==m[1][1]||nextY==m[0][0]&&nextX==m[0][1])continue;
				q.offer(new int[] {nextY,nextX,quantity});
			}
		}
		
		while(!q.isEmpty()) {
			result+=q.poll()[2];
		}
		
	return result;
	}
}
