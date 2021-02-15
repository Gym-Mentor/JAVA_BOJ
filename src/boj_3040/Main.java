package boj_3040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr,result;
	static int first=0;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		arr=new int[9];
		result=new int[7];
		for(int i=0;i<9;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		perm(0,0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static void perm(int cnt,int flag)
	{
		if(cnt==7)
		{
			int num=0;
			for(int i=0;i<7;i++)
			{
				num+=result[i];
			}
			if(num==100&&first==0)
			{
				first++;
				for(int i=0;i<7;i++)
				{
					sb.append(result[i]+"\n");
				}
			}
			return;
		}	
		for(int i=0;i<9;i++)
		{
			if((flag&1<<i)!=0)
			{
				continue;
			}
			result[cnt]=arr[i];
			perm(cnt+1,flag|1<<i);
		}
	}
}
