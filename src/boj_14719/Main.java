package boj_14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H,W;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		arr=new int[W];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		int result=0;
		for(int i=1;i<W-1;i++)
		{
			left=right=0;
			for(int j=0;j<i;j++)
			{
				left=Math.max(arr[j], left);
			}
			for(int j=i+1;j<W;j++)
			{
				right=Math.max(arr[j], right);
			}
			
			if(arr[i]<left&&arr[i]<right)
			{
				result+=Math.min(left, right)-arr[i];
			}
		}
		System.out.println(result);
	}

}
