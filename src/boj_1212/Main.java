package boj_1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String num=br.readLine();
		StringBuilder answer=new StringBuilder("");
		int size=num.length();
		for(int i=0;i<size;i++) {
			int now=num.charAt(i)-'0';
			StringBuilder temp=new StringBuilder("");
			while(now>0)
			{
				temp.insert(0,now%2);
				now/=2;
			}
				if(temp.length()==1)
				{
					temp.insert(0,"00");
				}
				else if(temp.length()==2)
				{
					temp.insert(0,"0");
				}
				else if(temp.length()==0)
				{
					temp.append("000");
				}
			answer.append(temp.toString());
		}
		if(answer.toString().equals("000"))
			{
			System.out.println("0");
				return;
			}
		while(true)
		{
			if(answer.charAt(0)=='0')
			{
				answer=answer.deleteCharAt(0);
			}
			else
				break;
		}
		System.out.println(answer.toString());
	}

}
