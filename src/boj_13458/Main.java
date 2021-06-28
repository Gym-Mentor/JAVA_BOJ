package boj_13458;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		///////////////////입력/////////////////
		int A=sc.nextInt();
		int people[] = new int[A];
		for(int i=0;i<A;i++)
		{
			people[i]=sc.nextInt();
		}
		int B=sc.nextInt(),C=sc.nextInt();
		
		long result=0;
		
		/////////////////처리//////////////////
		for(int i=0;i<A;i++)
		{
			people[i]-=B;
			result++;
			if(people[i]<=0)continue;
			result+=people[i]/C;
			result=(people[i]%C==0)?result:result+1;
		}
		System.out.println(result);
		
	}
}
