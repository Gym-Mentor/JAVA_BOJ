package boj_13397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int arr[];
	static int mid,left,right;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		solve();
		System.out.println(left);
	}
	
	static void solve()
	{
		left=0;
		right=50000000;
		while(left<right)
		{
			mid=(left+right)/2;
			
			// mid이하의 값들로 배열을 나눌 수 있을 때
			if(parameticSearch(mid))
			{
				right=mid;
			}
			else // mid이하의 값들로 배열을 나눌 수 없을 때
			{
				left=mid+1;
			}
		}
	}
	
	static boolean parameticSearch(int num)
	{
		int cnt=1; // 구간별로 나눈 횟수
		int min=Integer.MAX_VALUE;
		int max=0;
		int diff=0;
		for(int i=0;i<N;i++)
		{
			min=Math.min(min, arr[i]);
			max=Math.max(max, arr[i]);
			diff=max-min;
			if(diff>num)
			{
				min=arr[i];
				max=arr[i];
				diff=0;
				cnt++;
			}
		}
		// 현재 주어진 num으로 구간을 나눌 수 없을 때
		if(cnt>M)
			return false;
		
		//현재 주어진 num으로 구간을 나눌 수 있을 때
		return true;
	}

}
