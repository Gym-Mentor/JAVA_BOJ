package boj_19238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,result;
	static int arr[][];
	static boolean visited[][];
	static ArrayList<Integer[]> client;
	static int[] driver;
	static int dy[]= {1,0,0,-1};
	static int dx[]= {0,-1,1,0};
	public static void main(String[] args) throws IOException{
		//////////////////선언 및 생성
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken()); // 활동할 영역의 지도 크기
		M=Integer.parseInt(st.nextToken()); // 승객의 수
		result=Integer.parseInt(st.nextToken()); // 연료
		
		arr=new int[N][N]; // 활동할 영역의 지도
		client=new ArrayList<>(); // 승객,목적지 좌표 리스트
		driver=new int[2]; // 처음 택시기사의 좌표
		visited=new boolean[N][N]; // 방문체크
		
		//활동할 영역 입력 받기
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 택시기사 좌표 입력받기
		st=new StringTokenizer(br.readLine());		
		driver[0]=Integer.parseInt(st.nextToken())-1;
		driver[1]=Integer.parseInt(st.nextToken())-1;
		
		//승객과 목적지 좌표 입력받기
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			client.add(new Integer[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
			arr[client.get(i)[0]][client.get(i)[1]]=-1; // 승객의 좌표 표시
		}

		
		getClient(driver[0],driver[1],0);
		System.out.println(result);
		
	}
	
	static void getClient(int Y, int X,int num)
	{
		if(client.size()==0)return;
		if(arr[Y][X]==-1)
		{	arr[Y][X]=0;
			getDest(Y,X,0);
			return;
		}
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {Y,X,num});
		
		ArrayList<Integer[]> list=new ArrayList<>();
		
		for(boolean[] rows: visited)
			Arrays.fill(rows, false);
		
		visited[Y][X]=true;
		
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
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&arr[nextY][nextX]!=1&&!visited[nextY][nextX])
				{
					if(arr[nextY][nextX]==0)
					{
						q.offer(new int[] {nextY,nextX,dist+1});
						visited[nextY][nextX]=true;
					}
					else //승객인 경우 리스트에 넣는다.
					{
						if(list.size()==0) //리스트가 비었으면 무조건 넣는다.
						{
							list.add(new Integer[] {nextY,nextX,dist+1});
						}
						else
						{
							if(list.get(0)[2]>=dist+1) // 리스트에 들어있는 값과 거리가 작거나 같을 때만 넣는다.
							{
								list.add(new Integer[] {nextY,nextX,dist+1});
							}
							else // 리스트에 들어있는 값보다 거리가 크면 종료한다.
							{
								q.clear();
								break;
							}
						}
						q.offer(new int[] {nextY,nextX,dist+1});
						visited[nextY][nextX]=true;
					}
				}
				
			}
		}
		// 가장 가까운 승객 구하기
					int nextY=0;
					int nextX=0;
					int nextdist=Integer.MAX_VALUE;
					for(int i=0;i<list.size();i++) {
						if(nextdist>list.get(i)[2])
						{
							nextY=list.get(i)[0];
							nextX=list.get(i)[1];
							nextdist=list.get(i)[2];
						}
						else if(nextdist==list.get(i)[2])
						{
							if(nextY>list.get(i)[0])
							{
								nextY=list.get(i)[0];
								nextX=list.get(i)[1];
							}					
							else if(nextY==list.get(i)[0])
							{
								if(nextX>list.get(i)[1])
								{
									nextX=list.get(i)[1];
								}
							}
						}
					}
					
					// 다음 목적지로 가는 메서드 호출
					if(nextdist!=Integer.MAX_VALUE)
					{
						result-=nextdist;
						if(result<0)
						{
							result=-1;
							return;
						}
						arr[nextY][nextX]=0;
						getDest(nextY,nextX,0);
						return;
					}		
		result=-1;
	}
	
	static void getDest(int Y,int X,int num)
	{
		// 현재 출발지의 목적지 찾기
		int destY=0;
		int destX=0;
		for(int i=0;i<client.size();i++) 
		{
			if(client.get(i)[0]==Y&&client.get(i)[1]==X)
			{
				destY=client.get(i)[2];
				destX=client.get(i)[3];
				client.remove(i);
				break;
			}
		}

		// 초기화 부분
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {Y,X,num});
		
		for(boolean[] rows: visited)
			Arrays.fill(rows, false);
		
		visited[Y][X]=true;
		
		// 사방위 탐색
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
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&arr[nextY][nextX]!=1&&!visited[nextY][nextX])
				{
					//목적지를 찾았을 때
					if(nextY==destY&&nextX==destX)						
					{	
						result-=(dist+1);
						if(result<0) // 연료가 떨어졌을 경우
						{
							result=-1;
							return;
						}
						else // 연료가 충분한 경우
						{
							result=result+(dist+1)*2;
							getClient(nextY,nextX,0);
							return;
						}
					}
					q.offer(new int[] {nextY,nextX,dist+1});
					visited[nextY][nextX]=true;
				}
				
			}
			
		}
		result=-1;
	}
}
