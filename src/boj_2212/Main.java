package boj_2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K,arr[],dif[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		arr=new int[N];
		dif = new int[N-1];
		

		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		//거리를 배열에 넣고 정렬
		for(int i=0;i<N-1;i++)
		{
			dif[i]=arr[i+1]-arr[i];
		}
		Arrays.sort(dif);
		
		int ans=0;
		for(int i=0;i<N-K;i++) // N-K개만큼 연결을 해야함 -> 가장 짧은 거리부터 연결
		{
			ans+=dif[i];
		}
		
		System.out.println(ans);
	}

}
