package boj_9079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char board[][]=new char[3][3];
	static char temp[][]=new char[3][3];
	static int T,result,count;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			result=Integer.MAX_VALUE;
			for(int i=0;i<3;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++)
				{
					board[i][j]=st.nextToken().charAt(0);
				}
			}
			dfs(0,0);
			if(Integer.MAX_VALUE!=result)
				System.out.println(result);
			else
				System.out.println("-1");
		}
		
	}
	static void dfs(int cnt,int flag)
	{
		if(cnt==8)
		{
			if(check(flag))
			{
				result=Math.min(result, count);
			}
			return;
		}
		dfs(cnt+1,(flag<<1)|1);
		dfs(cnt+1,flag<<1);
	}
	
	static boolean check(int flag)
	{
		deepCopy();
		count=0;
		for(int i=0;i<8;i++)
		{
			if((flag&1<<i)!=0)
			{
				count++;
				reverse(i);
			}
		}
		char c=temp[0][0];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(c!=temp[i][j])return false;
			}
		}
		return true;
	}
	static void reverse(int idx)
	{
		if(idx<3) // 행 바꾸기
		{
			if(temp[idx][0]=='T')
				temp[idx][0]='H';
			else
				temp[idx][0]='T';
			
			if(temp[idx][1]=='T')
				temp[idx][1]='H';
			else
				temp[idx][1]='T';
			
			if(temp[idx][2]=='T')
				temp[idx][2]='H';
			else
				temp[idx][2]='T';
					
		}
		else if(idx<6) // 열 바꾸기
		{
			idx%=3;
			if(temp[0][idx]=='T')
				temp[0][idx]='H';
			else
				temp[0][idx]='T';
			
			if(temp[1][idx]=='T')
				temp[1][idx]='H';
			else
				temp[1][idx]='T';
			
			if(temp[2][idx]=='T')
				temp[2][idx]='H';
			else
				temp[2][idx]='T';
		}
		else // 대각선 바꾸기
		{
			if(idx%2==0)
			{
				if(temp[0][0]=='T')
					temp[0][0]='H';
				else
					temp[0][0]='T';
				
				if(temp[1][1]=='T')
					temp[1][1]='H';
				else
					temp[1][1]='T';
				
				if(temp[2][2]=='T')
					temp[2][2]='H';
				else
					temp[2][2]='T';
			}
			else
			{
				if(temp[0][2]=='T')
					temp[0][2]='H';
				else
					temp[0][2]='T';
				
				if(temp[1][1]=='T')
					temp[1][1]='H';
				else
					temp[1][1]='T';
				
				if(temp[2][0]=='T')
					temp[2][0]='H';
				else
					temp[2][0]='T';
			}
		}
	}
	static void deepCopy()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				temp[i][j]=board[i][j];
			}
		}
	}
}
