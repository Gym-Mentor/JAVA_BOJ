package boj_14595;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int parents[];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Pair> pq=new PriorityQueue<>();

		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		// 자신의 부모(자기가 속한 가장 작은 벽의 숫자) 저장할 배열 생성
		parents=new int[N+1];
		make();
		
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			pq.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		int right=0;
		int a; // 입력받을 가장 왼쪽 방
		int b; // 입력받을 가장 오른쪽 방
		while(!pq.isEmpty())
		{
			Pair pair=pq.poll();
			a=pair.first;
			b=pair.second;
			// 현재까지 부순 가장 큰 숫자의 벽보다 지금 부술 가장 작은 숫자의 벽이 작으면 현재까지 부순 가장 큰 숫자부터 탐색 (중복 탐색을 방지)
			if(a<right)
			{
				a=right;
			}
			// 부모 갱신
			for(int i=a;i<=b;i++)
			{
				union(a,i);
			}
			
			// 현재까지 부순 벽 중에 가장 큰 숫자의 벽 저장
			if(b>right)
			{
				right=b;
			}
		}
		
		// 방의 숫자 세기
		int count=0;
		for(int i=1;i<=N;i++)
		{
			if(i==parents[i])count++;
		}
		
		System.out.println(count);
	}
	
	static void make()
	{
		for(int i=0;i<=N;i++)
		{
			parents[i]=i;
		}
	}
	static int findSet(int a)
	{
		if(a==parents[a])return a;
		return parents[a]=findSet(parents[a]);
	}
	static void union(int a, int b)
	{
		a=findSet(a);
		b=findSet(b);
		
		if(a!=b)
		{
			parents[b]=a;
		}
	}
	// 부술 벽을 담을 클래스
	static class Pair implements Comparable<Pair>{ // 오름차순 정렬
		int first;
		int second;
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(Pair o) {
			if(this.first>o.first)
			{
				return 1;
			}
			else if(this.first<o.first)
			{
				return -1;
			}
			else
			{
				if(this.second<o.second)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
		}
	}
}
