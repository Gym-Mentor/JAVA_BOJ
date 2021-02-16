package boj_2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,min=Integer.MAX_VALUE;
	static pair input[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		input=new pair[N];
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());

			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());

			input[i]=new pair(num1,num2);
		}
		subset(0,1,0,0);
		System.out.println(min);
	}
	static void subset(int cnt,int S, int B,int check)
	{
		if(cnt==N)
		{
			if(check>0)
			min=Math.min(min, Math.abs(S-B));
			return ;
		}
		subset(cnt+1,S*input[cnt].first,B+input[cnt].second,check+1);
		subset(cnt+1,S,B,check);
		
	}

}
class pair
{
	int first;
	int second;
	pair(int first,int second)
	{
		this.first=first;
		this.second=second;
	}
}