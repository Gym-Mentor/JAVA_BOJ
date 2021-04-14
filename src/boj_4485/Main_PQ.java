package boj_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_PQ {

	static int N,arr[][],tc=1,DP[][];
	static boolean visited[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			arr=new int[N][N];
			DP=new int[N][N];
			visited=new boolean[N][N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					DP[i][j]=Integer.MAX_VALUE;
				}
			}
			System.out.println("Problem "+tc+": "+solve());
			tc++;
		}while(true);
	}
	static int solve()
	{
		PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		pq.offer(new int[] {0,0,arr[0][0]});
		visited[0][0]=true;
		
		while(!pq.isEmpty())
		{
			int Y=pq.peek()[0];
			int X=pq.peek()[1];
			int dist=pq.peek()[2];
			pq.poll();
			if(Y==N-1&&X==N-1)
			{
				return dist;
			}
			for(int i=0;i<4;i++)
			{
				int nextY=Y+dy[i];
				int nextX=X+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX])
				{
					pq.offer(new int[] {nextY,nextX,arr[nextY][nextX]+dist});
					visited[nextY][nextX]=true;
				}
			}
		}
		return 0;
	}
}
