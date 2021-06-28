package boj_14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,L,cnt=0;
	static int board[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		
		board=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve();
		change();
		solve();
		// 가로 검사 두번
		System.out.println(cnt);
		
		
	}
	static void solve()
	{
		for(int i=0;i<N;i++)
		{
			if(check(i)) // 가능한 경우
			{
				cnt++;
			}
		}
	}
	static boolean build(int Y,int X, int num)
	{
		for(int i=X;i<X+L;i++)
		{
			if(visited[Y][i]||board[Y][i]!=num)
			{
				return false;
			}
		}
		return true;
	}
	static void building(int Y,int X)
	{
		for(int i=X;i<X+L;i++)
		{
			visited[Y][i]=true;
		}
	}
	static boolean check(int Y)
	{
		for(int i=0;i<N-1;i++)
		{
			if(board[Y][i]+1==board[Y][i+1]) // 현재 경사가 1낮을 때
			{
				if(i-L+1>=0) // 경사로를 둘 수 있는 조건일 때 
				{
					if(build(Y,i-L+1,board[Y][i])) // 경사로를 둘 수 있는 조건일 때
					{
						building(Y,i-L+1);
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else if(board[Y][i]-1==board[Y][i+1]) // 현재 경사가 1높을 때
			{
				if(i+L<N) // 경사로를 둘 수 있는 조건일 때 
				{
					if(build(Y,i+1,board[Y][i+1])) // 경사로를 둘 수 있는 조건일 때
					{
						building(Y,i+1);
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else if(board[Y][i]==board[Y][i+1]) // 같을 때
			{
				continue;
			}
			else // 2이상 경사차이가 날 때
			{
				return false;
			}
		}
		return true;
	}
	static void print()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void change()	
	{
		int temp[][]=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				temp[N-1-j][i]=board[i][j];
			}
		}
		board=temp;
		for(boolean[] rows: visited)
		{
			Arrays.fill(rows,false);
		}
	}
}
