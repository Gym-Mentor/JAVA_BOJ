package boj_9421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static int N;
	static boolean prime[]=new boolean[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		eratosthenes();
		solve();
		
	}

	static void eratosthenes()
	{
		prime[0]=prime[1]=true;
		for(int i=2;i<=1000000;i++)
		{
			if(prime[i])continue;
			for(int j=i*2;j<=1000000;j+=i)
			{
				prime[j]=true;
			}
		}
	}
	static void solve()
	{
		for(int i=3;i<=N;i++)
		{
			if(prime[i])continue;
			Set<Integer> set =new HashSet<Integer>();
			String s=String.valueOf(i);
			boolean success =false;
			while(true)
			{
				int sum=0;
				for(int j=0;j<s.length();j++) {
					sum+=Math.pow(s.charAt(j)-'0', 2);
				}
				if(sum==1)
				{
					success=true;
					break;
				}
				if(set.contains(sum))
				{
					break;
				}
				else
				{
					set.add(sum);
					s=String.valueOf(sum);
				}
			}
			if(success)
			{
				System.out.println(i);
			}
		}
	}
}
