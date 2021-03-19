package boj_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int result=0;
	static int arr[][];
	static boolean visited[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M]; // 현재 빙산 배열
		visited=new boolean[N][M]; // 방문 체크
		result=0; // 빙산이 녹는 시간(년)
		
		/////////////////////////빙산 배열 입력 받기 /////////////////////
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine()," ");	
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//////////////////////// 빙산을 녹이는 과정 /////////////////////////
		while(true) {
			
			int count=0; // 현재 빙산 덩어리 카운트
			
			////////////////////////bfs를 돌면서 현재 빙산의 수 체크 ///////////////
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(arr[i][j]>0&&!visited[i][j])
					{
						count++;
						bfs(i,j); // bfs가 끝나면 빙산을 녹인다.
					}
				}
			}
			
			if(count>1) // 현재 빙산이 2조각 이상일 때
			{
				System.out.println(result);
				return;
			}
			else if(count==0) // 빙산이 다 녹을 때까지 덩어리로 나누어지지 않을 때
			{
				System.out.println("0");
				return;
			}
			
			for(boolean[] row : visited) // 방문 배열 초기화
			{
				Arrays.fill(row, false);
			}
			result++;
		}
	}
	
	static void bfs(int Y, int X)
	{
		// bfs를 위한 생성 및 선언
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {Y,X}	);
		visited[Y][X]=true;
		
		// 얼음을 녹이기 위한 리스트
		ArrayList<int[]> list=new ArrayList<>();
		list.add(new int[] {Y,X,iceBerg(Y,X)});
		
		// 너비우선 탐색
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
				{
					if(arr[nextY][nextX]>0&&!visited[nextY][nextX])
					{
						q.offer(new int[] {nextY,nextX});
						visited[nextY][nextX]=true;
						
						// 리스트에 현재 빙산의 정보 넣기
						list.add(new int[] {nextY,nextX,iceBerg(nextY,nextX)});
					}
				}
			}
		}
		
		for(int i=0;i<list.size();i++) // 빙산의 수 만큼 반복
		{
			int nowY=list.get(i)[0];
			int nowX=list.get(i)[1];
			int minus=list.get(i)[2];
			
			arr[nowY][nowX]-=minus; // 빙산 녹이기
			
			if(arr[nowY][nowX]<0)
				arr[nowY][nowX]=0;
		}
	}
	
	static int iceBerg(int Y, int X) // 녹는 빙산의 양 구하는 메소드
	{
		
		// 현재위치의 사방위를 탐색하여 0이 몇개 있는지 리턴
		int count=0;
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
			{
				if(arr[nextY][nextX]==0)
				{
					count++;
				}
			}
		}
		return count;
	}
	
}
