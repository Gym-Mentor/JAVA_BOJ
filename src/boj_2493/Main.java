package boj_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
		//////////////////선언 및 생성////////////////////
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		Stack<pair> s =new Stack<pair>();
		String temp[]=bf.readLine().split(" ");
		int n;
		for(int i=0;i<N;i++)
		{
			n=Integer.parseInt(temp[i]);
			while(!s.empty())
			{
				if(n>s.peek().second) {
					s.pop();
				}
				else
				{
					System.out.print(s.peek().first+" ");
					s.push(new pair(i+1,n));
					break;
				}
			}
			if(s.empty())
			{
				System.out.print("0 ");
				s.push(new pair(i+1,n));
			}
			
		}
		
		bf.close();
		
	}
	static class pair{
		int first;
		int second;
		pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}

}
