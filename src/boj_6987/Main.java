package boj_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 월드컵
public class Main {

	static int[] win;
	static int[] draw;
	static int[] lose;
	static int myTeam[]= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int yourTeam[]= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static boolean check;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		win=new int[6];
		draw=new int[6];
		lose=new int[6];
		
		for(int tc=0;tc<4;tc++)
		{
			check=false;
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<6;i++)
			{
				win[i]=Integer.parseInt(st.nextToken());
				draw[i]=Integer.parseInt(st.nextToken());
				lose[i]=Integer.parseInt(st.nextToken());
			}
			dfs(0);
			if(check)
			{
				System.out.print("1 ");
			}
			else
			{
				System.out.print("0 ");
			}
		}
		
	}
	static void dfs(int cnt)
	{
		if(cnt==15)
		{
			check=true;
			return;
		}
		int t1=myTeam[cnt];
		int t2=yourTeam[cnt];
		
		if(win[t1]>0&&lose[t2]>0) // t1이 이기고 t2가 질 때
		{
			win[t1]--;
			lose[t2]--;
			dfs(cnt+1); // 재귀호출
			// 백트래킹
			win[t1]++;
			lose[t2]++;
		}
		if(draw[t1]>0&&draw[t2]>0) // t1과 t2가 비길 때
		{
			draw[t1]--;
			draw[t2]--;
			dfs(cnt+1);
			draw[t1]++;
			draw[t2]++;
		}
		if(lose[t1]>0&&win[t2]>0) // t1이 지고 t2가 이길 때
		{
			lose[t1]--;
			win[t2]--;
			dfs(cnt+1);
			lose[t1]++;
			win[t2]++;
		}
	}
}
