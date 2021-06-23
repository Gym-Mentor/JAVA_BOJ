package boj_20053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,T;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			N=Integer.parseInt(br.readLine());
			int[] nums=new int[N];
			int idx=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				nums[idx++]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			System.out.println(nums[0]+" "+nums[N-1]);
		}
	}

}
