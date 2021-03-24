package boj_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		int DP[][]=new int[31][31];
		int i,j,k;
		for (i = 1; i < 31; i++) DP[1][i] = i;
	    for (i = 2; i < 31; i++) {
	        for (j = i; j < 31; j++) {
	            for (k = j-1; k >= i-1; k--) DP[i][j] += DP[i-1][k];
	        }
	    }
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			System.out.println(DP[N][M]);
		}
	}

}
