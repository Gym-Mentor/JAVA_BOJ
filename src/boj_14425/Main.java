package boj_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++)
		{
			set.add(br.readLine());
		}
		
		int result=0;
		for(int i=0;i<M;i++)
		{
			if(set.contains(br.readLine()))
			{
				result++;
			}
		}
		System.out.println(result);
	}

}
