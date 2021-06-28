package boj_2812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static char arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr= new char[N];
		arr=br.readLine().toCharArray();
		Deque<Character> dq= new ArrayDeque<>();
		
		for(int i=0;i<N;i++)
		{
			while(K>0&&!dq.isEmpty()&&dq.peekLast()<arr[i])
			{
				dq.pollLast();
				K--;
			}
			dq.offerLast(arr[i]);
			
		}
		
		int size=dq.size();
		for(int i=0;i<size-K;i++)
		System.out.print(dq.pollFirst());
	}

}
