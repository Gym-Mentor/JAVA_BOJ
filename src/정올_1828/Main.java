package 정올_1828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,result=0;
	static pair arr[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		arr=new pair[N];
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++	)
		{
			st=new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			arr[i]=new pair(num1,num2);
		}
		Arrays.sort(arr);
		int second=-270;
		for(int i=0;i<N;i++)
		{			
			if(second<arr[i].first)
			{
				second=arr[i].second;
				result++;
			}			
		}
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class pair implements Comparable<pair>
	{
		int first;
		int second;
		pair(int first, int second)
		{
			this.first=first;
			this.second=second;
		}
		public int compareTo(pair o)
		{
			int diff=this.second-o.second;
			if(diff!=0)return diff;
			else return this.first-o.first;
		}
	}
}
