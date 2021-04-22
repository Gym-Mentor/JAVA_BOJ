package boj_15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,H,max=4;
	static boolean[][] ladder;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		ladder=new boolean[H+1][N+1];
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			int Y=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			ladder[Y][X]=true;
		}
		
		if(check())
		{
			System.out.println("0");
			return ;
		}
		comb(0,0,0); //cnt , y, x, 사다리개수
		
		if(max==4)
			System.out.println("-1");
		else
			System.out.println(max);
	}
	// 조합 생성
	static void comb(int cnt,int num,int sum)
	{
		if(cnt==3)
		{
			if(max>sum)
			if(check())
				max=sum;
			return;
		}
		for(int i=num;i<H*(N-1);i++)
		{
			int Y=i/(N-1)+1;
			int X=i%(N-1)+1;
			if(!(ladder[Y][X-1]||ladder[Y][X+1]||ladder[Y][X]))
			{
				ladder[Y][X]=true;
				comb(cnt+1,i+1,sum+1);
				ladder[Y][X]=false;
			}
			
			comb(cnt+1,i+1,sum);
			
		}
	}
	
	//사다리 체크
	static boolean check()
	{
		for(int i=1;i<=N;i++)
		{
			int X=i;
			for(int j=1;j<=H;j++)
			{
				if(ladder[j][X])
				{
					X++;
				}
				else if(ladder[j][X-1])
				{
					X--;
				}
			}
			if(X!=i)return false;
		}
		return true;
	}
}