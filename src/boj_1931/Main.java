package boj_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static pair arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new pair[N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			arr[i]=new pair(num1,num2);
		}
		Arrays.sort(arr);
		int first=0;
		int second=0;
		int cnt=0;
		for(int i=0;i<N;i++)
		{
			if(second<=arr[i].first)
			{
				cnt++;
				first=arr[i].first;
				second=arr[i].second;
			}
		}
		System.out.println(cnt);
	}
	
	
	static class pair implements Comparable<pair>
	{
		int first;
		int second;
		pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
		
		public int compareTo(pair o)
		{
			int diff=second-o.second;
			if(diff!=0)return diff;
			else return first-o.first;				
		}
	}
	
}
