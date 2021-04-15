package boj_17298;
//오큰수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[],result[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		
		arr=new int[N];
		result=new int[N];
		Arrays.fill(result, -1);
		Stack<pair> s=new Stack<>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		// for문 한번으로 문제 해결
		for(int i=0;i<N;i++)
		{
			//배열입력받기
			arr[i]=Integer.parseInt(st.nextToken());
			
			//스택이 비어있으면 넣기
			if(s.empty())
			{
				s.add(new pair(arr[i],i));
				continue;
			}
		
			//입력받은 수보다 스택의 제일 위의 수가 작으면 오큰수로 result 배열에 저장
			while(!s.empty()&&s.peek().value<arr[i])
			result[s.pop().idx]=arr[i];
			
			//입력받은 수를 스택에 저장
			s.add(new pair(arr[i],i));
		}
		
		// Sysout으로 출력할경우 시간초과
		for(int i=0;i<N;i++)
		{
			sb.append(result[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static class pair
	{
		int value;
		int idx;
		public pair(int value, int idx) {
			super();
			this.value = value;
			this.idx = idx;
		}
		
	}
}
