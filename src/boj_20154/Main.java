package boj_20154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num[]= {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		int sum=0;
		String str= br.readLine();
		for(int i=0;i<str.length();i++)
		{
			char c= str.charAt(i);
			sum+=num[c-'A'];
		}
		
		if(sum%2==0)
		{
			System.out.println("You're the winner?");
		}
		else
		{
			System.out.println("I'm a winner!");
		}
	}

}
