package boj_15486;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,max=0;
	static int DP[],cost[],earn[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		DP=new int[N+2];
		cost=new int[N+2];
		earn=new int[N+2];
		for(int i=1;i<=N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			cost[i]=Integer.parseInt(st.nextToken());
			earn[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, DP[i]);
			if(cost[i]+i<=N+1)
			{
				DP[i+cost[i]]=Math.max(max+earn[i], DP[i+cost[i]]);
			}
		}
		max=Math.max(max, DP[N+1]);
		System.out.println(max);
	}

}
