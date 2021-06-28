package boj_16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,R,goal;
	static int[][] A;
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());

		goal=Math.min(N, M)/2;
		A=new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R;i++)
		{
			rotate(0);
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	static void rotate(int cnt)
	{
		if(goal==cnt)return;
		
		int y=0+cnt;
		int x=0+cnt;
		
		int minY=0+cnt;
		int minX=0+cnt;
		
		int maxY=N-cnt;
		int maxX=M-cnt;
		int nextY=y;
		int nextX=x;
		Queue<Integer> q=new LinkedList<>();
		q.offer(A[y][x]);
		for(int i=0;i<4;i++)
		{
			nextY=nextY+dy[i];
			nextX=nextX+dx[i];
			
			while(minY<=nextY&&nextY<maxY&&minX<=nextX&&nextX<maxX)
			{
				q.offer(A[nextY][nextX]);
				A[nextY][nextX]=q.poll();
				
				nextY=nextY+dy[i];
				nextX=nextX+dx[i];
			}
			nextY=nextY-dy[i];
			nextX=nextX-dx[i];
		}
		rotate(cnt+1);
	}

}
