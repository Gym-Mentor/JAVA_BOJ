package boj_11562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n+1][n+1];
		
		//초기값 최대로
		for(int[] rows: arr)
		Arrays.fill(rows, 50000);
		
		//입력받기
		for(int i=0;i<m;i++)
		{
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int oneWay=Integer.parseInt(st.nextToken());
			
			if(oneWay==0) // 일방통행
			{
				arr[from][to]=0;
				arr[to][from]=1; // 일방통행이 안될 때 양방향으로 바꾸어주는 횟수 +1
			}
			else
			{
				arr[from][to]=0;
				arr[to][from]=0;
			}
		}
		
		// 자기자신 0으로 초기화
		for(int i=1;i<=n;i++)
		{
			arr[i][i]=0;
		}
		
		//플로이드와샬
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n;i++)
			{
				if(i==k)continue;
				for(int j=1;j<=n;j++)
				{
					if(i==j||k==j)continue;
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		//출력
		k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++)
		{
			st=new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			System.out.println(arr[num1][num2]);
		}
		
	}
	
}
