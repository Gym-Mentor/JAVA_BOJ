package boj_5875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int left=0,right=0;
		int idx=0;
		int result=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				{
					left++;
					idx++;
				}
			else
				{right++;
					idx--;
				}
			if(idx<=1)
			{
				left=0;
			}
			if(idx==-1)
			{
				result=right;
				break;
			}
		}

		if(idx>0)
		{
			result=left;
		}
		System.out.println(result);
	}

}
