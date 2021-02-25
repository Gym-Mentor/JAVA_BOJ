package boj_14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++)
		{			
			long num1=0;
			long num2=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");			
			int num=Integer.parseInt(st.nextToken());
			for(int i=0;i<num;i++)
			{
				num1+=Math.pow(1000, Integer.parseInt(st.nextToken()));
			}
			
			st=new StringTokenizer(br.readLine()," ");		
			num=Integer.parseInt(st.nextToken());
			for(int i=0;i<num;i++)
			{
				num2+=Math.pow(1000, Integer.parseInt(st.nextToken()));
			}
			if(num1>num2)
			{
				System.out.println("A");
			}
			else if(num1<num2)
			{
				System.out.println("B");
			}
			else
			{
				System.out.println("D");
			}
		}
	}
}
