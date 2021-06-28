package boj_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] check;
	static int[]result;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		arr=new int[9];
		check=new int[7];
		result=new int[7];
		for(int i=0;i<9;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		comb(0,0);
		for(int i=0;i<7;i++)
		{
			System.out.println(result[i]);
		}
	}
	static void comb(int cnt,int start)
	{
		if(cnt==7)
		{
			int sum=0;
			for(int i=0;i<7;i++)
			{
				sum+=check[i];
			}
			if(sum==100)
			{
				for(int i=0;i<7;i++)
				{
					result[i]=check[i];
				}
				return;
			}
			return;
		}
		for(int i=start;i<9;i++)
		{
			check[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}
}
