package boj_1592;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M,L,arr[],result=-1;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=0;
		}
		arr[0]=1;
		int num=0;
		while(true)
		{
			result++;
			if(arr[num]==M)
				break;
			if(arr[num]%2==0) //반시계방향
			{
				num=num-L;
				if(num<0)
				{
					num+=N;
				}
				arr[num]++;
			}
			else
			{
				num=(num+L)%N;
				arr[num]++;
			}
		}
		System.out.println(result);
	}

}
