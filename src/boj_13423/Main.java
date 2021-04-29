package boj_13423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T,N;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int cnt=0;
			for(int i=1;i<N-1;i++)
			{
				int l=0;
				int r=N-1;
				while(l<r)
				{
					int lDist=arr[i]-arr[l];
					int rDist=arr[r]-arr[i];
					if(lDist==rDist)
					{
						cnt++;
						l++;
					}
					else if(lDist<rDist)
						r--;
					else
						l++;
				}
			}
			System.out.println(cnt);
		}
	}

}
