package boj_10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h, p, q, t;

	static int dy[] = { 1, 1, -1, -1 };
	static int dx[] = { 1, -1, -1, 1 };
	static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken()); // X
		q = Integer.parseInt(st.nextToken()); // Y
		t = Integer.parseInt(br.readLine());

		if(((q+t)/h)%2==0)//오른쪽으로 진행중
		{
			q=(q+t)%h;
		}
		else
		{
			q=h-(q+t)%h;
		}
		
		if(((p+t)/w)%2==0)//오른쪽으로 진행중
		{
			p=(p+t)%w;
		}
		else
		{
			p=w-(p+t)%w;
		}
		
		
		System.out.println(p + " " + q);
	}
}
