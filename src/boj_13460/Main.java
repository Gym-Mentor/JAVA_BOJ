package boj_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,result=0,redY,redX,blueY,blueX;
	static char[][] arr;
	static int[]dy= {1,-1,0,0};
	static int[]dx= {0,0,1,-1};
	static boolean visited[][][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new char[N][M];
		visited=new boolean[N][M][N][M];
		for(int i=0;i<N;i++)
		{
			arr[i]=br.readLine().toCharArray();
			for(int j=0;j<M;j++)
			{
				if(arr[i][j]=='R')
				{
					redY=i;
					redX=j;
				}
				else if(arr[i][j]=='B')
				{
					blueY=i;
					blueX=j;
				}
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs()
	{
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {redY,redX,blueY,blueX,0});
		visited[redY][redX][blueY][blueX]=true;
		
		while(!q.isEmpty())
		{
			
			redY=q.peek()[0];
			redX=q.peek()[1];
			blueY=q.peek()[2];
			blueX=q.peek()[3];
			int dist=q.peek()[4];
			q.poll();
			
			if(dist>=10)return -1;
			for(int i=0;i<4;i++)
			{
				//빨간 구슬을 이동시킨다.
				int RY=redY+dy[i];
				int RX=redX+dx[i];
				boolean checkB=false,checkR=false;
				while(0<=RY&&RY<N&&0<=RX&&RX<M)
				{
					if(arr[RY][RX]=='O')
					{
						checkR=true;
					}
					if(arr[RY][RX]!='#')
					{
						RY+=dy[i];
						RX+=dx[i];
					}
					else
					{
						RY-=dy[i];
						RX-=dx[i];
						break;
					}
				}
				//파란 구슬 이동시키기
				int BY=blueY+dy[i];
				int BX=blueX+dx[i];
				while(0<=BY&&BY<N&&0<=BX&&BX<M)
				{
					if(arr[BY][BX]=='O')
					{
						checkB=true;
					}
					if(arr[BY][BX]!='#')
					{
						BY+=dy[i];
						BX+=dx[i];
					}
					else
					{
						BY-=dy[i];
						BX-=dx[i];
						break;
					}
				}
				
				if(RY==BY&&RX==BX)
				{
					if(i==0)// 아래쪽 방향
					{
						if(redY<blueY)
						{
							RY-=1;
						}
						else
						{
							BY-=1;
						}
					}
					else if(i==1)// 위쪽 방향
					{
						if(redY<blueY)
						{
							BY+=1;
						}
						else
						{
							RY+=1;
						}
					}
					else if(i==2)// 오른쪽 방향
					{
						if(redX<blueX)
						{
							RX-=1;
						}
						else
						{
							BX-=1;
						}
					}
					else if(i==3)// 왼쪽 방향
					{
						if(redX<blueX)
						{
							BX+=1;
						}
						else
						{
							RX+=1;
						}
					}					
				}
				
				if(checkR&&!checkB)
				{
					return dist+1;
				}
				else if(!checkR&&!checkB&&!visited[RY][RX][BY][BX])
				{
					q.offer(new int[] {RY,RX,BY,BX,dist+1});
					visited[RY][RX][BY][BX]=true;
				}
			}
			
		}
		
		
		return -1;
	}
}
