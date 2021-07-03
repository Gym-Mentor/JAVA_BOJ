package boj_14600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K,N,now=1;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		N=(int) Math.pow(2, K);
		arr=new int[N][N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		
		arr[y-1][x-1]=-1;
		if(K==1)
		{
			fill(0,0);
			for(int i=1;i>=0;i--)
			{
				for(int j=0;j<2;j++)
				{
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		else
		{
			int firstY=((y-1)/2)*2;
			int firstX=((x-1)/2)*2;
			fill(firstY,firstX);
			fill(1,1);
			fill(0,0);
			fill(0,2);
			fill(2,0);
			fill(2,2);
			for(int i=3;i>=0;i--)
			{
				for(int j=0;j<4;j++)
				{
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}
	static void fill(int y,int x)
	{

		int count=0;
		// 채울 수 있는 타일인지 판정
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(arr[y+i][j+x]>0)
				{
					count++;
				}
			}
		}
		if(count>1)return;
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(arr[y+i][j+x]==0)
				{
					arr[y+i][j+x]=now;
				}
			}
		}
		now++;
	}
}
