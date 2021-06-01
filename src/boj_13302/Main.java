package boj_13302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,coupon=0;
	static int DP[][];
	static boolean check[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		DP=new int[N+1][N+1];
		check=new boolean[N+1];
		if(M>0) {
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
		{
			check[Integer.parseInt(st.nextToken())]=true;
		}
		}
		System.out.println(dfs(1,0,0));
	}
	
	static int dfs(int day, int coupon, int price)
	{
		if(N<day)
		{
			return price;
		}
		
		if(DP[day][coupon]>0) 
		{
			return DP[day][coupon]+price;
		}
		
		if(check[day])
		{
			return dfs(day+1,coupon,price);
		}
		
		int ans=Integer.MAX_VALUE;
		
		ans=Math.min(ans, dfs(day+1,coupon,price+10000));
		ans=Math.min(ans, dfs(day+3,coupon+1,price+25000));
		ans=Math.min(ans, dfs(day+5,coupon+2,price+37000));
		
		if(coupon>=3)
		{
			ans=Math.min(ans, dfs(day+1,coupon-3,price));
		}
		
		DP[day][coupon]=ans-price;
		return ans;
	}
}
