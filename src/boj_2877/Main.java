package boj_2877;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int K=Integer.parseInt(br.readLine());
		K++;
		String str="";
		while(K>1)
		{
			if(K%2==1)
			{
				str="7"+str;
			}
			else
			{
				str="4"+str;
			}
			K/=2;
		}
		System.out.println(str);
	}

}
