package boj_14499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int x,y,N,M,K;
	static int board[][];
	static Dice dice=new Dice(0,0,0,0,0,0);
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		board=new int[N][M];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++)
		{
			int cmd=Integer.parseInt(st.nextToken());
			
			// 동쪽으로
			if(cmd==1)
			{
				if(x+1==M)continue;
				east();
				x++;
			}
			// 서쪽
			else if(cmd==2)
			{
				if(x-1==-1)continue;
				west();
				x--;
			}
			// 북쪽
			else if(cmd==3)
			{
				if(y-1==-1)continue;
				north();
				y--;
			}
			// 남쪽
			else if(cmd==4)
			{
				if(y+1==N)continue;
				south();
				y++;
			}
			
			// 수 복사
			if(board[y][x]==0)
			{
				board[y][x]=dice.bottom;
			}
			else
			{
				dice.bottom=board[y][x];
				board[y][x]=0;
			}
			//출력
			sb.append(dice.top).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void swap(int a,int b)
	{
		int temp=a;
		a=b;
		b=temp;
	}
	static void east()
	{
		int temp=dice.top;
		dice.top=dice.left;
		dice.left=dice.bottom;
		dice.bottom=dice.right;
		dice.right=temp;
	}
	static void west()
	{
		int temp=dice.top;
		dice.top=dice.right;
		dice.right=dice.bottom;
		dice.bottom=dice.left;
		dice.left=temp;
	}
	static void north()
	{
		int temp=dice.top;
		dice.top=dice.front;
		dice.front=dice.bottom;
		dice.bottom=dice.back;
		dice.back=temp;
	}
	static void south()
	{
		int temp=dice.top;
		dice.top=dice.back;
		dice.back=dice.bottom;
		dice.bottom=dice.front;
		dice.front=temp;
	}
	static class Dice{
		int top;
		int bottom;
		int left;
		int right;
		int front;
		int back;
		public Dice(int top, int bottom, int left, int right, int front, int back) {
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
			this.front = front;
			this.back = back;
		}
		
	}
}
