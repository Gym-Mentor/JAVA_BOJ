package boj_15686;

// 치킨 디펜스 2021 02 17
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


	static int N, M,result=Integer.MAX_VALUE;
	static List<pair>house;
	static List<pair>chicken;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house=new ArrayList<>();
		chicken=new ArrayList<>();
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				int c=Integer.parseInt(st.nextToken());
				if(c==1)
				{
					house.add(new pair(i,j));
				}
				else if(c==2)
				{
					chicken.add(new pair(i,j));
				}
			}
		}
		visited=new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(result);
	}

	static void dfs(int idx,int selected)
	{
		if(selected==M)
		{
			int temp=0;
			for(int i=0;i<house.size();i++) 
			{
				int dist=Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) 
				{
					if(visited[j])
						dist=Math.min(dist, Math.abs(house.get(i).first-chicken.get(j).first)+Math.abs(house.get(i).second-chicken.get(j).second));
				}
				temp+=dist;
			}
			result=Math.min(result,temp);
			return;
		}
		if(idx==chicken.size())
		{
			return;
		}
		visited[idx]=true;
		dfs(idx+1,selected+1);
		visited[idx]=false;
		dfs(idx+1,selected);
	}
	static class pair {
		int first;
		int second;

		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
