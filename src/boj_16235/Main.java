package boj_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board,A;
	static int N,M,K,idx=0;
	static Deque<Tree> dq=new ArrayDeque<>();
	static Queue<Tree> dead=new LinkedList<>();
	static Queue<Tree> breed=new LinkedList<>();
	static int[] dy= {1,1,1,0,0,-1,-1,-1};
	static int[] dx= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		board=new int[N+1][N+1];
		A=new int[N+1][N+1];
		for(int[] rows: board)
		{
			Arrays.fill(rows, 5);
		}
		
		for(int i=1;i<=N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int Y=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			int age=Integer.parseInt(st.nextToken());
			
			dq.addFirst(new Tree(Y,X,age,idx++));
		}
		solve();
		System.out.println(dq.size());
	}
	static void solve()
	{
		for(int i=0;i<K;i++)
		{
			if(dq.isEmpty())return;
			spring();
			summer();
			fall();
			winter();
		}
	}
	static void spring()
	{
		int size=dq.size();
		Queue<Tree> q=new LinkedList<>();
		while(size-->0)
		{
			Tree tree=dq.poll();
			if(tree.age>board[tree.Y][tree.X]) // 나무죽이고 dead에 추가
			{
				dead.add(new Tree(tree.Y,tree.X,tree.age/2,idx));
			}
			else
			{
				board[tree.Y][tree.X]-=tree.age;
				dq.offerLast(new Tree(tree.Y,tree.X,tree.age+1,idx++));
				if((tree.age+1)%5==0)
				{
					breed.add(tree);
				}
			}
		}
	}
	static void summer()	
	{
		while(!dead.isEmpty())
		{
			Tree tree=dead.poll();
			board[tree.Y][tree.X]+=tree.age;
		}
	}
	static void fall()
	{
		while(!breed.isEmpty())
		{
			Tree tree=breed.poll();
			for(int i=0;i<8;i++)
			{
				int nextX=tree.X+dx[i];
				int nextY=tree.Y+dy[i];
				if(0<nextY&&nextY<=N&&0<nextX&&nextX<=N)
				{
					dq.offerFirst(new Tree(nextY,nextX,1,idx++));
				}
			}
		}
	}
	static void winter()
	{
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				board[i][j]+=A[i][j];
			}
		}
	}
	static class Tree implements Comparable<Tree>{
		int Y;
		int X;
		int age;
		int idx;
		public Tree(int y, int x, int age,int idx) {
			super();
			Y = y;
			X = x;
			this.age = age;
			this.idx=idx;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			if(this.age!=o.age)
			return this.age-o.age;
			else
				return o.idx-this.idx;
		}
		
	}
}
