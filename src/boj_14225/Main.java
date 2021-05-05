package boj_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[];
	static Set<Integer> set=new HashSet<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		int result=1;
		while(true)
		{
			if(set.contains(result))
			{
				result++;
			}
			else
			{
				break;
			}
		}
		System.out.println(result);
	}

	static void dfs(int cnt,int sum)
	{
		if(cnt==N)
		{
			set.add(sum);
		}
		else
		{
			dfs(cnt+1,sum+arr[cnt]);
			dfs(cnt+1,sum);
		}
		
	}
}
