package boj_3980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,result;
	static int[][] player;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		while(T-->0)
		{
			result=0;
			player=new int[11][11];
			
			for(int i=0;i<11;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=0;j<11;j++)
				{
					player[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0,0);
			System.out.println(result);
		}

	}

	static void dfs(int cnt,int sum,int flag)
	{
		if(cnt==11)
		{
			result=Math.max(result,sum);
			return;
		}
		
		for(int i=0;i<11;i++)
		{
			if(player[cnt][i]!=0&&(flag&(1<<i))!=(1<<i))
			{
				dfs(cnt+1,sum+player[cnt][i],flag|(1<<i));
			}
		}
	}
}
