package boj_13300;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,K,S,Y,result=0;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		arr=new int[2][7];
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
		st= new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
			if(arr[S][Y]==0)
			{
				result++;
			}
			arr[S][Y]++;
			if(arr[S][Y]>=K)				
			{
				arr[S][Y]=0;
			}

		}
		System.out.println(result);
	}
}
