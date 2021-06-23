package boj_20053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,T,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N=Integer.parseInt(br.readLine());
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				int num=Integer.parseInt(st.nextToken());
				min=Math.min(min,num);
				max=Math.max(max,num);
			}
			System.out.println(min+" "+max);
		}
	}

}
