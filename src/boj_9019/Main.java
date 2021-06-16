package boj_9019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 21주차 DSLR
public class Main {

	static int T;
	static int now, goal;
	static boolean check,chk[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			chk = new boolean[10000];
			
			check=false;
			StringTokenizer st= new StringTokenizer(br.readLine());
			now=Integer.parseInt(st.nextToken());
			goal=Integer.parseInt(st.nextToken());
			chk[now] = true;
			
			bfs();
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void bfs()
	{
		Queue<Pair> q=new LinkedList<>();
		q.offer(new Pair(now,""));
		
		while(!q.isEmpty())
		{
			int num=q.peek().num;
			String str=q.poll().str;
			if(num==goal)
			{
				sb.append(str+"\n");
				return;
			}
			int temp=num;
			temp*=2;
			//D일 떄 *2
			if(temp>9999)
			{
				temp=temp%10000;
			}
			if(!chk[temp])
			{
				q.offer(new Pair(temp,str+"D"));
				chk[temp]=true;
			}
			temp=num-1;
			if(temp==0)
				temp=9999;
			if(!chk[temp])
			{
				q.offer(new Pair(temp,str+"S"));
				chk[temp]=true;
			}
			
			temp=(num%1000);
			temp=temp*10+(num/1000);
			if(!chk[temp])
			{
				q.offer(new Pair(temp,str+"L"));
				chk[temp]=true;
			}
			temp=num/10;
			temp=(num%10)*1000+temp;
			if(!chk[temp])
			{
				q.offer(new Pair(temp,str+"R"));
				chk[temp]=true;
			}
		}
	}
	static class Pair{
		int num;
		String str;
		public Pair(int num, String str) {
			super();
			this.num = num;
			this.str = str;
		}
	}
}
