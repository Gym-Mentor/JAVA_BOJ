package boj_17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K;
	static int[][] A;
	static int[][] R;
	static int[] r,c,s;
	static int[] dy= {0,1,0,-1};
	static int[] dx= {1,0,-1,0};
	static int min=Integer.MAX_VALUE;
	static int order[];
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		A=new int[N][M];
		order= new int[K];
		r=new int[K];
		c=new int[K];
		s=new int[K];
		R=new int[N][M];
		isSelected= new boolean[K];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			r[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
			s[i]=Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(min);
	}
	
	static void perm(int cnt)
	{
		if(cnt==K)
		{
			getmin();
			return;
		}
		for(int i=0;i<K;i++)
		{
			if(isSelected[i])continue;
			order[cnt]=i;
			isSelected[i]=true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
	
	static void getmin()
	{
		for(int row=0;row<N;row++)
		{
			for(int col=0;col<M;col++)
			{
				R[row][col]=A[row][col];
			}
		}
		for(int i=0;i<K;i++)
		{
			for(int cnt=0;cnt<s[order[i]];cnt++) 
			{
				int y=r[order[i]]-s[order[i]]+cnt-1;
				int x=c[order[i]]-s[order[i]]+cnt-1;
				int minY=y;
				int minX=x;
				int maxY=r[order[i]]+s[order[i]]-cnt-1;
				int maxX=c[order[i]]+s[order[i]]-cnt-1;
				
				int nextY=y;
				int nextX=x;
				
				Queue<Integer> q=new LinkedList<>();
				
				q.offer(R[y][x]);
				
				for(int j=0;j<4;j++)
				{
					nextY=nextY+dy[j];
					nextX=nextX+dx[j];
					
					while(minY<=nextY&&nextY<=maxY&&minX<=nextX&&nextX<=maxX)
					{
						q.offer(R[nextY][nextX]);
						R[nextY][nextX]=q.poll();
						
						nextY=nextY+dy[j];
						nextX=nextX+dx[j];
					}
					nextY=nextY-dy[j];
					nextX=nextX-dx[j];
				}
			}

		}
		for(int i=0;i<N;i++)
		{
			int temp=0;
			for(int j=0;j<M;j++)
			{
				temp+=R[i][j];
			}
			min=Math.min(min, temp);
		}
		
	}
}
