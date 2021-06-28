package boj_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[],N,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		long low=1,high=0,result=0;
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
			high=Math.max(high, arr[i]);
		}
		
		Arrays.sort(arr);
		
		while(low<=high) // 이분탐색
		{
			long mid=(low+high)/2; // 좌표의 제일 작은값과 큰값을 더해서 나눈값 = 중간값
			if(check(mid)) // 현재 중간값보다 좌표사이의 거리 최소값이 큰 경우 // 1 2 4 8 9   mid=5  ->  mid=2  ->  mid=3
			{
				if(result<mid)
				{
					result=mid;
					low=mid+1;
				}
			}
			else
				high=mid-1;
		}
		System.out.println(result);
		
	}
	
	static boolean check(long dist) // 입력받은 거리와 좌표사이의 거리를 비교
	{
		int cnt=1;
		long pre=arr[0]; // 시작 좌표
		for(int i=1;i<N;i++)
		{
			if(arr[i]-pre>=dist) // 거리 비교
			{
				cnt++;
				pre=arr[i];
			}
		}
		if(cnt>=C)return true; // 거리에 C개이상으로 공유기를 설치 할수 있을 때 -> 현재 두 공유기 사이의 거리를 늘려야함
		else return false;
	}
}
