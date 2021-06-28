package boj_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K,max=0,idx=0,min=0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		arr=new int[6];
		for(int i=0;i<6;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			st.nextToken();
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<6;i++)
		{
			if(arr[i]*arr[(i+1)%6]>max)
			{
				max=arr[i]*arr[(i+1)%6];
				idx=i;
			}
		}
		min=arr[(idx+3)%6]*arr[(idx+4)%6];
		int result=(max-min)*K;
		System.out.println(result);
	}
}
