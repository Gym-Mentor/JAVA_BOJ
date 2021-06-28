package boj_2072;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,result=-1,temp=0;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dirY= {{-1,1},{0,0},{-1,1},{-1,1}}; //상하 좌우
	static int[][] dirX= {{0,0},{-1,1},{-1,1},{1,-1}}; //상하 좌우
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		arr=new int[19][19];
		visited=new boolean[19][19];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken())-1;
			int num2=Integer.parseInt(st.nextToken())-1;
			arr[num1][num2]=i%2==0?1:2; //1 일때 흑, 0 일때 백
			for(int j=0;j<4;j++)
			{
				///초기화
				temp=1;
				for(boolean[] row: visited)
					Arrays.fill(row, false);
				
				///상하 좌우 대각선 순으로 DFS 체크
				DFS(num1,num2,i%2==0?1:2,j);
				
				//오목이 완성되면 값 저장
				if(temp==5&&result==-1)
				{
					result=i+1;
				}
			}

		}
		StringBuilder sb=new StringBuilder();
		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
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
