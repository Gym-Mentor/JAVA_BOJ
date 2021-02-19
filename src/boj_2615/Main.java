package boj_2615;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int arr[][],temp=1,resultY=-1,resultX=-1,result=0;
	static boolean[][] visited;
	static int[][] dirY= {{-1,1},{0,0},{-1,1},{-1,1}}; //상하 좌우
	static int[][] dirX= {{0,0},{-1,1},{-1,1},{1,-1}}; //상하 좌우
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		arr=new int[19][19];
		visited=new boolean[19][19];
		for(int i=0;i<19;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<19;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0;j<19;j++)
		{
			for(int i=0;i<19;i++)
			{
				if(arr[i][j]!=0)
				for(int k=0;k<4;k++)
				{
					temp=1;
					for(boolean[] row: visited)
						Arrays.fill(row, false);
					DFS(i,j,arr[i][j],k);
					if(temp==5)
					{
						if(arr[i][j]==1)
							result=1;
						else
							result=2;
						resultY=i+1;
						resultX=j+1;
						break;
					}
				}
				if(result!=0)break;
			}
			if(result!=0)break;
		}
		System.out.println(result);
		if(result!=0)
		System.out.println(resultY+" "+resultX);
	}
	
	static void DFS(int Y,int X,int flag,int idx)
	{
		visited[Y][X]=true;
		for(int i=0;i<2;i++)
		{
			int nextY=Y+dirY[idx][i];
			int nextX=X+dirX[idx][i];
			if(0<=nextY&&nextY<19&&0<=nextX&&nextX<19)
			{
				if(!visited[nextY][nextX]&&arr[nextY][nextX]==flag)
				{
					temp++;
					DFS(nextY,nextX,flag,idx);
				}
			}
		}
	}
}
