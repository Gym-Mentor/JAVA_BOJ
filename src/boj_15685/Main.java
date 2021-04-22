package boj_15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N,X,Y,cnt=0,d,g;
	static boolean board[][];
	static int dy[]= {0,-1,0,1};
	static int dx[]= {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		board=new boolean[101][101];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			X=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken()); // 시작방향
			g=Integer.parseInt(st.nextToken()); // 세대
			board[Y][X]=true;
			Y+=dy[d];
			X+=dx[d];
			board[Y][X]=true;
			ArrayList<Integer> list=new ArrayList<>();
			list.add((d+1)%4);
			solve(list,0);
		}
		count();
		System.out.println(cnt);
	}

	static void solve(ArrayList<Integer> list, int cnt)
	{
		//목표세대에 도착하면 종료
		if(cnt==g)
		{
			return;
		}
		int size=list.size()-1;
		for(int i=size;i>=0;i--)
		{
			int idx=list.get(i);
			Y+=dy[idx];
			X+=dx[idx];
			board[Y][X]=true;
			list.add((idx+1)%4);
		}
		solve(list,cnt+1);
	}
	static void count()
	{
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(board[i][j]&&board[i+1][j]&&board[i][j+1]&&board[i+1][j+1])cnt++;
			}
		}
	}
}
