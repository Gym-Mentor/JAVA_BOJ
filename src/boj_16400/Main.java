package boj_16400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean prime[]=new boolean[40001];
	static int DP[];
	static final int DIV=123456789;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		eratosthenes();
		N=Integer.parseInt(br.readLine());
		ArrayList<Integer> primeList =new ArrayList<>();
		DP=new int[N+1];
		DP[0]=1;
		for(int i=0;i<=N;i++)
		{
			if(prime[i])
			primeList.add(i);
		}
		for(int i=0;i<primeList.size();i++) {
			int temp=primeList.get(i);
			for(int j=temp;j<=N;j++)
			{
				DP[j]=(DP[j]+DP[j-temp])%DIV;
			}
		}
		System.out.println(DP[N]);
		
	}
	static void eratosthenes()
	{
		Arrays.fill(prime,true);
		prime[0]=prime[1]=false;
		for(int i=2;i<prime.length;i++)
		{
			if(prime[i])
			{
				for(int j=i*i;j<prime.length;j+=i)
				{
						prime[j]=false;
				}
			}
		}
	}
}
