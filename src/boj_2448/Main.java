package boj_2448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N;
	static char arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new char[N][N*2];
		
		for(char[] rows:arr)
		{
			Arrays.fill(rows, ' ');
		}
		
		//N-1로 width를 줘야 행의 제일 왼쪽 인덱스 0부터 찍힘
		recursive(0,N-1,N);
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N*2;j++)
			{
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void recursive(int h,int w,int n)
	{
		if(n==3)
		{
			//첫 째줄
			arr[h][w]='*';
			
			//두 째줄
			arr[h+1][w-1]='*';
			arr[h+1][w+1]='*';
			
			//세 째줄
			arr[h+2][w-2]='*';
			arr[h+2][w-1]='*';
			arr[h+2][w]='*';
			arr[h+2][w+1]='*';
			arr[h+2][w+2]='*';
			return;
		}
		// 하나의 삼각형은 총 3개의 삼각형으로 분해됨
		// 각 삼각형의 젤 위의 좌표로 재귀호출
		recursive(h,w,n/2);
		recursive(h+n/2,w-n/2,n/2);
		recursive(h+n/2,w+n/2,n/2);
		
	}
}