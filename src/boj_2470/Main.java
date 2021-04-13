package boj_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start=0;
		int end=N-1;
		
		int gap=Integer.MAX_VALUE;
		int ans1=0;
		int ans2=0;
		
		int temp;
		int sum;
		
		// start가 end보다 작을 때
		while(start<end)
		{
			sum=arr[start]+arr[end]; // 양쪽끝을 더함
			temp=Math.abs(sum); // 절대값을 취함
			
			// 현재 갭보다 작으면 갱신
			if(temp<gap)
			{
				gap=temp;
				ans1=arr[start];
				ans2=arr[end];
			}
			//현재 양수이면 오른쪽끝을 당김
			if(sum>0)
			{
				end--;
			}
			//현재 음수이면 왼쪽끝을 당김
			else
			{
				start++;
			}
		}
		
		System.out.println(ans1+" "+ans2);
	}
}
