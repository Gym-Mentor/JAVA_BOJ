package boj_2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int arr[][];
	static int arr1[][];
	static int cr,cc;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		arr=new int[10][10];
		arr1=new int[10][10];
		for(int i=0;i<9;i++) {
			String str=br.readLine();
			for(int j=0;j<9;j++)
			{
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
			{
				arr1[i][j]=(i/3)*3;
				arr1[i][j]+=(j/3);
			}
		}
		fill();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	static boolean fill()
	{
		int r=0;
		int c=0;
		if(findEmpty())
		{
			return true;
		}
		r=cr;
		c=cc;
		for(int n=1;n<=9;n++)
		{
			if(isSafe(r,c,n))
			{
				arr[r][c]=n;
				if(fill())
				{
					return true;
				}
				arr[r][c]=0;
			}
			
		}
		return false;
	}
	static boolean isSafe(int Y,int X,int num)
	{
		if(!checkRow(Y,num)&&!checkCol(X,num)&&!checkSquare(Y,X,num))
		{
			return true;
		}
		return false;
	}
	private static boolean findEmpty() {
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(arr[i][j]==0)
				{
					cr=i;
					cc=j;
					return false;
				}
			}
		}
		return true;
	}
	static boolean checkRow(int Y,int num)
	{
		for(int i=0;i<9;i++)
		{
			if(arr[Y][i]==num)return true;
		}
		return false;
	}
	static boolean checkCol(int X,int num)
	{
		for(int i=0;i<9;i++)
		{
			if(arr[i][X]==num)return true;
		}
		return false;
	}
	static boolean checkSquare(int Y,int X,int num)
	{
		int startY=(arr1[Y][X]/3)*3;
		int startX=(arr1[Y][X]%3)*3;
		
		for(int i=startY;i<startY+3;i++)
		{
			for(int j=startX;j<startX+3;j++)
			{
				if(arr[i][j]==num)return true;
			}
		}
		return false;
	}
}
