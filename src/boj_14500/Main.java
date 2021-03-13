package boj_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N,M,max=0;
	static int dy[]= {0,0,0,0, 0,1,2,3, 0,0,1,1, 0,1,2,2, 0,0,0,1, 0,0,1,2, 0,1,1,1  , 0,1,2,2 , 0,1,1,1, 0,0,1,2, 0,0,0,1, 0,1,1,2, 0,0,1,1, 0,0,1,1 , 0,1,1,2  , 0,1,1,1,  0,1,1,2, 0,1,1,2, 0,0,0,1    };
	static int dx[]= {0,1,2,3, 0,0,0,0, 0,1,0,1, 0,0,0,1, 0,1,2,0, 0,1,1,1, 0,0,-1,-2, 0,0,0,-1, 0,0,1,2, 0,1,0,0, 0,1,2,2, 0,0,1,1, 0,1,1,2, 0,1,0,-1, 0,0,-1,-1, 0,-1,0,1, 0,0,1,0, 0,0,-1,0, 0,1,2,1    };
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		////////////////////////처리 부분//////////////////////
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				int idx=0;
				for(int k=0;k<19;k++) // 총 19개의 모양
				{					
					int sum=0;
					for(int l=0;l<4;l++) // 4개의 정사각형의 합 구하기
					{
						int nextY=i+dy[idx];
						int nextX=j+dx[idx++];
						if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
						{
							sum+=arr[nextY][nextX];
						}
					}
					if(max<sum)
					{
						max=sum;
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
