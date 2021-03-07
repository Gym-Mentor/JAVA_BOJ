package boj_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,min=1<<31-1,max=-(1<<31-1);
	static int arr[];
	static int input[];	
	static int op[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		op=new int[N-1];
		input=new int[4];
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++)
		{
			input[i]=Integer.parseInt(st.nextToken());
		}
		int idx=0;
		
		// 연산자 저장
		for(int i=0;i<4;i++)
		{
			while(input[i]-->0) // 1 0 1 0 -> 0 2 저장(더하기, 곱셈)
			{
				op[idx++]=i;
			}
		}
		
		perm(0,arr[0],0);
		System.out.println(max);
		System.out.println(min);
		
	}
	static void perm(int cnt,int num,int flag) // 순열
	{
		if(cnt==N-1) // 최대값 최소값 판별
		{
			if(max<num)
			{
				max=num;
			}
			if(min>num)
			{
				min=num;
			}
			return ;
		}
		for(int i=0;i<N-1;i++)
		{
			if((flag&(1<<i))!=1<<i) // 조건을 만족할 때
			{
				if(op[i]==0)// 더하기
				{
					perm(cnt+1,num+arr[cnt+1],flag|1<<i);
				}
				else if(op[i]==1)// 빼기
				{
					perm(cnt+1,num-arr[cnt+1],flag|1<<i);
				}
				else if(op[i]==2)// 곱하기
				{
					perm(cnt+1,num*arr[cnt+1],flag|1<<i);
				}
				else if(op[i]==3)// 나누기
				{
					perm(cnt+1,num/arr[cnt+1],flag|1<<i);
				}
			}
			
		}
	}

}
