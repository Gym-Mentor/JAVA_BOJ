package boj_2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X,Y,result=0,K;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		
		K=Integer.parseInt(br.readLine());
		int total=X*2+Y*2;
		arr=new int[K];
		
		for(int i=0;i<K;i++)
		{
			st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			
			if(num1==1)
			{
				arr[i]=num2;
			}
			else if(num1==4)
			{
				arr[i]=num2+X;
			}
			else if(num1==2)
			{
				arr[i]=(X-num2)+X+Y;
			}
			else if(num1==3)
			{
				arr[i]=(Y-num2)+X*2+Y;
			}
		}
		st= new StringTokenizer(br.readLine());
		int nowIdx=Integer.parseInt(st.nextToken());
		int nowX=Integer.parseInt(st.nextToken());
		
		int num;
		if(nowIdx==1)
		{
			num=nowX;
		}
		else if(nowIdx==4)
		{
			num=nowX+X;
		}
		else if(nowIdx==2)
		{
			num=(X-nowX)+X+Y;
		}
		else
		{
			num=(Y-nowX)+2*X+Y;
		}
		
		for(int i=0;i<K;i++)
		{
			int temp=Math.abs(arr[i]-num);
			result+=total-temp>temp?temp:total-temp;
		}
		System.out.println(result);
	}
	

}
