package boj_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static char[][] s;
	static int[] check;
	static int K,result=0;
	static int arr[]= {1,2,4,8};
	public static void main(String[] args) throws IOException{
		
		////////////////////선언 및 생성///////////////////////
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		s= new char[4][8];
		for(int i=0;i<4;i++)
		{	
			String str=br.readLine();
			for(int j=0;j<8;j++)
			{
				s[i][j]=str.charAt(j);
			}
		}
		K=Integer.parseInt(br.readLine());		
		
		for(int i=0;i<K;i++)
		{	check=new int[4];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken())-1;
			int num2=Integer.parseInt(st.nextToken());
			check[num1]=num2;
			moveleft(num1-1,num2*-1); // 오른쪽으로 진행
			moveright(num1+1,num2*-1); // 왼쪽으로 진행
			rotate();
		}
		for(int i=0;i<4;i++)
		{
			if(s[i][0]=='1')
			{
				result+=arr[i];
			}
		}
		System.out.println(result);
	}
	static void moveright(int num1, int num2)
	{
		if(num1==4) return;


		if(s[num1][6]!=s[num1-1][2])
		{	check[num1]=num2;
		moveright(num1+1,num2==1?-1:1);
		}
	
	}
	static void moveleft(int num1, int num2)
	{
		if(num1==-1) return;		

		// 조건을 만족하면 재귀호출
		if(s[num1][2]!=s[num1+1][6])
		{
			check[num1]=num2;
			moveleft(num1-1,num2==1?-1:1);
		}		
	}
	static void rotate()
	{
		for (int i =0 ; i <= 3; i++) { 
			if (check[i] == -1) { // 반시계 방향으로 회전 할 때
				char first = s[i][0];
				for (int j = 1; j < 8; j++) { // 한칸씩 바꾸기
					s[i][j - 1] = s[i][j];
				}
				s[i][7] = first;
			} 
			else if (check[i] == 1) { // 시계 방향으로 회전 할 때
				char last = s[i][7];
				for (int j = 6; j >= 0; j--) { // 한칸씩 바꾸기
					s[i][j + 1] = s[i][j];
				}
				s[i][0] = last;
			}
		}
	}
}
