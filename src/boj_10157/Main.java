package boj_10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static int K, idx = 0, r, c,Y=0,X=0;
	static int arr[][];


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		arr = new int[r][c];


		if (K > r * c) {
			System.out.println("0");
			return;
		}
		int nextY=0;
		int nextX=0;
		int num=2;
		arr[0][0]=1;
		while(K>1)
		{
			nextY=Y+dy[idx];
			nextX=X+dx[idx];
			if(0<=nextY&&nextY<r&&0<=nextX&&nextX<c&&arr[nextY][nextX]==0)
			{
				K--;
				arr[nextY][nextX]=num++;
				Y=nextY;
				X=nextX;
				continue;
			}
			idx=(idx+1)%4;
		}
		System.out.println((X+1) + " " + (Y+1));
	}
}
