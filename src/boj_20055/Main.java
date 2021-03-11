package boj_20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,cnt=0,result=0,idx=0;
	static int arr[][]; // 컨베이어 벨트 내구도 배열
	static boolean visited[]; // 현재 컨베이어 벨트에 로봇이 있는지 체크하는 배열
	public static void main(String[] args) throws IOException{
		
		//생성 및 입력 받기
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[2][N];
		visited=new boolean[N];
		
		st =new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			arr[0][i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++)
		{
			arr[1][N-1-i]=Integer.parseInt(st.nextToken());
		}
		while(cnt<K) { // 내구도가 0인 칸의 개수가 K 이상이 될 때까지 반복
			result++;
			
			//벨트 한 칸 회전한다.
			int temp1=arr[1][0];
			int temp2=arr[0][N-1];
			for(int i=N-2;i>=0;i--)
			{
				//벨트 내구도 이동
				arr[0][i+1]=arr[0][i];
				visited[i+1]=visited[i];
				visited[i]=false;
				arr[1][N-2-i]=arr[1][N-1-i];

			}
			// 벨트 회전
			arr[0][0]=temp1;
			arr[1][N-1]=temp2;
			// 내리는 곳의 로봇 없애기
			visited[N-1]=false;
			
			// 각 로봇 한칸씩 앞으로 이동하기
			for(int i=N-2;i>=0;i--) {
				if(arr[0][i+1]>0 && visited[i]&&!visited[i+1]) {				
				visited[i+1]=true;
				visited[i]=false;
				arr[0][i+1]--;
				if(arr[0][i+1]<=0)cnt++;
				}
				
			}
			
			//올라가는 칸에 로봇 올리기
			if(arr[0][0]>0&&!visited[0]) 
			{
				arr[0][0]--;
				visited[0]=true;
				if(arr[0][0]<=0)cnt++;	
			}
			
			if(cnt>=K)
			{
				break;
			}
		}
		System.out.println(result);
	}

}
