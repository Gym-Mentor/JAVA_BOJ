package boj_7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int T,N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			comb(0,1,1,1,"1");
			System.out.println();
		}
	}

	static void comb(int sum,int sign, int num, int n, String str)
	{
		if(n==N)
		{
			sum+=(num*sign);
			if(sum==0)
			{
				System.out.println(str);
			}
			return;
		}
		else
		{
			comb(sum,sign,num*10+(n+1),n+1,str+' '+(n+1));
			comb(sum+(sign*num),1,(n+1),n+1,str+'+'+(n+1));
			comb(sum+(sign*num),-1,(n+1),n+1,str+'-'+(n+1));
		}
	}
}
