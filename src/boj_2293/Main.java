package boj_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[],DP[];
	static int N,K,result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		DP=new int[10001];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		DP[0]=1;
		for(int i=0;i<N;i++)
			for(int j=arr[i];j<=K;j++)
				DP[j]+=DP[j-arr[i]];
		System.out.println(DP[K]);
	}

}
