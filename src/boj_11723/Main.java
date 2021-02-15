package boj_11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int set=0;
		M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			int num=0;
			if(!(str.equals("all")||str.equals("empty")))
			num=Integer.parseInt(st.nextToken());
			
			if(str.equals("add"))
			{
				set=set|1<<num;
			}
			else if(str.equals("remove"))
			{	
				int temp=1<<num;
				temp=~temp;
				set=set&temp;
			}
			else if(str.equals("check"))
			{
				if((set&1<<num)!=0)
				{
					sb.append("1\n");
				}
				else
				{
					sb.append("0\n");
				}
			}
			else if(str.equals("toggle"))
			{
				if((set&1<<num)!=0)
				{
					int temp=1<<num;
					temp=~temp;
					set=set&temp;
				}
				else
				{
					set=set|1<<num;
				}
			}
			else if(str.equals("all"))
			{
				set=Integer.MAX_VALUE>>10;
			}
			else if(str.equals("empty"))
			{
				set=0;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
