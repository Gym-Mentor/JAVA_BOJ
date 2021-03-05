package boj_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N,MAX_NUM,result=0;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		dfs("",0);		
		bw.write(sb.toString());
		bw.flush();
		
	}
	private static void dfs(String s, int cnt) {
		if (cnt == N) { // 현재 숫자가 N이되면 결과에 넣기
			sb.append(s+'\n');
			return;
		}
		for(int i=1; i<=9; i++) {
			if(!isPrime(Integer.parseInt(s+i))) { // 현재 숫자가 소수이면 계속 진행
				dfs(s+i,cnt+1);
			}
		}
	}
	static boolean isPrime(int num)
	{
		if(num==1)return true;
		for(int i=2;i<=Math.sqrt(num);i++) // 소수의 특성상 자기자신의 제곱근까지만 체크하면 됨
		{
			if(num%i==0) // 소수가 아닐경우
			{
				return true;
			}
		}
		return false;
	}
}


//에라토스테네스의 체로 소수 구하기  -> 메모리 초과

//for(int i=2; i*i<=N; i++){
//	// prime[i]가 소수라면
//    if(!prime[i]){
//    	// prime[j] 소수가 아닌 표시
//    	for(int j=i*i; j<=N; j+=i) prime[j] = true;                
//    }        
//}    


