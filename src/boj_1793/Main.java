package boj_1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		
		BigInteger DP[]=new BigInteger [251];
		
		DP[0]=BigInteger.ONE;
		DP[1]=BigInteger.ONE;
		DP[2]=BigInteger.valueOf(3);
		for(int i=3;i<=250;i++)
		{
			DP[i]=DP[i-1].add(DP[i-2].multiply(BigInteger.valueOf(2)));
		}
		String N=br.readLine();
		do {
		System.out.println(DP[Integer.parseInt(N)]);
		}while((N=br.readLine())!=null);
	}
}
