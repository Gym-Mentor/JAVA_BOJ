package boj_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,min=Integer.MAX_VALUE;
	static Node[] list;
	static boolean guess[],visited[],check[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		arr=new int[N+1];
		list=new Node[N+1];
		guess=new boolean[N+1];
		visited=new boolean[N+1];
		check=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++)
		{
			 st= new StringTokenizer(br.readLine());
			 int size=Integer.parseInt(st.nextToken());
			 for(int j=0;j<size;j++)
			 {
				 int num=Integer.parseInt(st.nextToken());
				 list[i]=new Node(num,list[i]);
			 }
		}
		comb(1);
		if(min==Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}
	static void bfs()
	{
		Arrays.fill(visited, false);
		Arrays.fill(check, false);
		Queue<Integer> tq=new LinkedList<>();
		Queue<Integer> fq=new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			if(guess[i]&&tq.isEmpty())
				{
					tq.offer(i);
					visited[i]=true;
					check[i]=true;
				}
			else if(!guess[i]&&fq.isEmpty())
				{
					fq.offer(i);
					visited[i]=true;
					check[i]=true;
				}
		}
		
		while(!tq.isEmpty())
		{
			int idx=tq.poll();
			if(list[idx]==null)continue;
			for(Node temp=list[idx];temp!=null;temp=temp.next)
			{
				if(guess[temp.to]&&!visited[temp.to])
				{
					visited[temp.to]=true;
					check[temp.to]=true;
					tq.add(temp.to);
				}
			}
			
		}
		while(!fq.isEmpty())
		{
			int idx=fq.poll();
			if(list[idx]==null)continue;
			for(Node temp=list[idx];temp!=null;temp=temp.next)
			{
				if(!guess[temp.to]&&!visited[temp.to])
				{
					visited[temp.to]=true;
					check[temp.to]=true;
					fq.add(temp.to);
				}
			}
		}
		
		for(int i=1;i<=N;i++)
		{
			if(!check[i])return;
		}
		int temp=0;
		int size=0;
		for(int i=1;i<=N;i++)
		{
			if(guess[i])
			{
				size++;
				temp+=arr[i];	
			}
			else
			{
				temp-=arr[i];
			}
		}
		if(size==0||size==N)return;
		if(Math.abs(temp)<min)
		{
			min=Math.abs(temp);
		}
	}
	static void comb(int cnt)
	{
		if(cnt==N+1)
		{
			bfs();
			return;
		}
		guess[cnt]=true;
		comb(cnt+1);
		guess[cnt]=false;
		comb(cnt+1);
	}
	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
}
