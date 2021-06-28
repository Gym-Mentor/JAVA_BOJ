package boj_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 5
14
1 2 2
1 3 3
1 4 1 **
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2 **
5 1 7
3 4 2
5 2 4
 */
public class Main {
	static int N,M,arr[][];
	public static void main(String[] args) throws IOException{
		//선언 및 생성
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		
		for(int[] rows:arr)
		Arrays.fill(rows,100001);
		// 도시간의 비용 배열에 저장
		for(int i=0;i<M;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			if(arr[node1][node2]==100001)
				arr[node1][node2]=value;
			else if(arr[node1][node2]>value) //시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다. -> 조건 추가
				arr[node1][node2]=value;
		}
		for(int i=1;i<=N;i++)
		{
			arr[i][i]=0;
		}
		
		// 플로이드 와샬 알고리즘
		for(int k=1;k<=N;k++)
		{
			for(int i=1;i<=N;i++)
			{
				if(i==k)continue;
				for(int j=1;j<=N;j++) 
				{
					if(i==j||k==j)continue;
					if(arr[i][j]>arr[i][k]+arr[k][j])
					{
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		// 출력
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(arr[i][j]!=100001)
					System.out.print(arr[i][j]+" ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

}
