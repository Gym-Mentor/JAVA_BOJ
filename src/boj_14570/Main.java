package boj_14570;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int[][] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		tree=new int[N+1][2];
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			tree[i][0]=num1;
			tree[i][1]=num1;
		}
		
		int pos=1;
		while(true)
		{
			if(tree[pos][0]==-1&&tree[pos][1]==-1)break;
			else if(tree[pos][0]==-1)
			{
				pos=tree[pos][1];
			}
			else if(tree[pos][1]==-1)
			{
				pos=tree[pos][0];
			}
			else if(K%2==0)
			{
				pos=tree[pos][1];
				K=K/2;
			}
			else
			{
				pos=tree[pos][0];
				K=K/2+1;
			}
			
		}
		System.out.println(pos);
	}

}
