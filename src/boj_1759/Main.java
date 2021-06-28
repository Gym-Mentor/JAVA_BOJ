package boj_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N,C;
	static char[] arr;
	static int[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		arr= new char[C];
		num= new int[C];
		for(int i=N;i<C;i++)
		{
			num[i]=1;
		}
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++)
		{
			arr[i]=st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		Arrays.sort(num);
		do 
		{
			String str="";
			int cnt1=0;
			int cnt2=0;
			for(int i=0;i<C;i++)
			{
				if(num[i]==0)
				{
					str+=arr[i];
					if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u')
					{
						cnt1++;
					}
					else
					{
						cnt2++;
					}
				}
			}
			if(cnt1>=1&&cnt2>=2)
			System.out.println(str);
			
		}while(NP());
		
	}
	static boolean NP()
	{
		int i=C-1;
		while(i>0&&num[i-1]>=num[i])
		{
			i--;
		}
		
		if(i==0)
		{
			return false;
		}
		int j=C-1;
		while(num[i-1]>=num[j])
		{
			j--;
		}
		
		swap(i-1,j);
		int k=C-1;
		
		while(i<k)
		{
			swap(i++,k--);
		}
		return true;
	}
	static void swap(int i, int j)
	{
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
}
