package boj_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int N;
	static Stack<Character> s =new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		while(N-->0)
		{
			s.clear();
			String str=br.readLine();
			for(int i=0;i<str.length();i++) {
				// 왼쪽 괄호일 경우 push
				if(str.charAt(i)=='(')
				{
					s.push('(');
				}
				else // 오른쪽 괄호인 경우 stack의 top이 (인지 )인지 체크한다.
				{
					if(s.size()>0&&s.peek()=='(') // 괄호쌍인경우 없앰
					{
						s.pop();
					}
					else // 괄호쌍이 아니면 ) 삽입
					{
						s.push(')');
					}
				}
			}
			
			if(s.size()>0)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
	}

}
