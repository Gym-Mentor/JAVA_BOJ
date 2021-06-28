package boj_10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,normal=0,notNormal=0;
	static char arr[][];
	static boolean visited[][];
	static int dy[]= {0,0,1,-1};
	static int dx[]= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		////////////////////////////////선언 및 생성/////////////////////////////////
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));		
		N=Integer.parseInt(br.readLine());
		arr=new char[N][N];
		visited=new boolean[N][N];
		/////////////////////////////////입력//////////////////////////////
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<N;j++)
			{
				arr[i][j]=str.charAt(j);
			}
		}
		///////////////////////////////bfs 처리////////////////////////////
		for(int k=0;k<2;k++) // 첫 번째는 정상인  / 두 번째는 적록색맹
		{
			//visited 배열을 초기화
			for(boolean[] row:visited)
			Arrays.fill(row, false);
			
			// 각 좌표 bfs호출
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(k==0)
					bfsNormal(i,j);
					else
					bfs(i,j);
				}
			}
		}
		////////////////////////////////출력 처리///////////////////////////
		StringBuilder sb=new StringBuilder();
		sb.append(normal+" "+notNormal);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	//////////////////적록 색맹 아닌 사람//////////////////////
	static void bfsNormal(int Y,int X)
	{
		
		if(visited[Y][X]) return; //이미 방문 했다면 return
		Queue<pair> q=new LinkedList<>();
		q.offer(new pair(Y,X)); // 큐에 시작 위치 넣기
		visited[Y][X]=true;
		normal++;
		while(!q.isEmpty())
		{
			//현재 방문한 좌표
			int nowY=q.peek().first;
			int nowX=q.peek().second;
			q.poll();
			//현재 방문한 좌표의 색
			char c=arr[nowY][nowX];
			//사방위 탐색
			for(int i=0;i<4;i++)
			{
				
				//다음에 방문할 좌표
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				// 좌표의 범위 확인
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N)
				{
					//색이 같고 방문하지 않았을 때 방문
					if(c==arr[nextY][nextX]&&!visited[nextY][nextX])
					{
						visited[nextY][nextX]=true;
						q.offer(new pair(nextY,nextX));
					}
				}
			}
		}
	}
	//////////////////적록 색맹인 사람//////////////////////
	static void bfs(int Y,int X)
	{
		if(visited[Y][X]) return; //이미 방문 했다면 return
		Queue<pair> q=new LinkedList<>();
		q.offer(new pair(Y,X)); // 큐에 시작 위치 넣기
		visited[Y][X]=true;
		notNormal++;
		while(!q.isEmpty())
		{
			//현재 방문한 좌표
			int nowY=q.peek().first;
			int nowX=q.peek().second;
			
			q.poll();
			//현재 방문한 좌표의 색
			char c=arr[nowY][nowX];
			// 사방위 탐색
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				//다음에 검색할 좌표가 범위 안에 있는지 확인
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N)
				{
					//모든 조건을 검색
					if((c==arr[nextY][nextX]||c=='R'&&arr[nextY][nextX]=='G'||c=='G'&&arr[nextY][nextX]=='R')&&!visited[nextY][nextX])
					{
						//방문 체크
						visited[nextY][nextX]=true;
						//큐에 다음에 방문할 곳 넣기
						q.offer(new pair(nextY,nextX));
					}
				}
			}
		}
	}
	/////////////////////pair 클래스 //////////////////////
	static class pair{
		int first;
		int second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
