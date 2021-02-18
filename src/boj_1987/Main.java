package boj_1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int R,C,max=Integer.MIN_VALUE;
	static char arr[][];
	static int[]dy= {0,0,1,-1};
	static int[]dx= {1,-1,0,0};
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][];
		visited=new boolean[26];
		for(int i=0;i<R;i++)
		{
			arr[i]=br.readLine().toCharArray();
		}

		visited[arr[0][0]-'A']=true;
		DFS(0,0,1);
		System.out.println(max);
	}
	
	static void DFS(int Y,int X,int cnt)
	{
		if(cnt>max)
			max=cnt;
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			if(0<=nextY&&nextY<R&&0<=nextX&&nextX<C)
			{					
				int num=arr[nextY][nextX]-'A';
					if(visited[num])continue;				
					visited[num]=true;
					DFS(nextY,nextX,cnt+1);
					visited[num]=false;
			}
		}
	}
}
