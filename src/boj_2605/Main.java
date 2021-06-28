package boj_2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		List<Integer> list=new LinkedList<>();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			int num=Integer.parseInt(st.nextToken());
			list.add(list.size()-num,i+1);
		}
		for(int i=0;i<N;i++)
		System.out.print(list.get(i)+" ");
	}

}
