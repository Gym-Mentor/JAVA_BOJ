package boj_1092; // 크레인

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N,M,result=0;
	static ArrayList<Integer> crane=new ArrayList<>();;
	static ArrayList<Integer> box=new ArrayList<>();;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//선언 및 생성
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());

		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
		{
			crane.add(Integer.parseInt(st.nextToken()));			
		}
		M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++)
		{
			box.add(Integer.parseInt(st.nextToken()));
		}

	
		//크레인이 옮길 수 있는 박스를 구하기 위해 정렬
		Collections.sort(crane,new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2)
			{
				return o2.compareTo(o1);
			}
		});
		Collections.sort(box,new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2)
			{
				return o2.compareTo(o1);
			}
		});
		//박스가 크레인보다 무거울 때 종료
		if(crane.get(0)<box.get(0))
		{
			System.out.println("-1");
			return;
		}
		
		//박스를 옮기는 처리 -> 모든 크레인이 최대로 옮길 수 있는 박스를 찾는다.
		while (box.size() != 0) { // 박스를 다 옮길 때 까지 반복
			int idx = 0; // 크레인 인덱스
			int temp = 0; // 박스 인덱스
			while (idx < N) { // 모든 박스를 탐색
				if (temp == box.size()) break; // 현재 크레인의 박스를 못찾음
				if (box.get(temp) <= crane.get(idx)) { // 박스를 옮길 수 있을 때
					box.remove(temp);
					idx++;
				} else if (box.get(temp) > crane.get(idx)) { // 박스를 못 옮길 때
					temp++;
				}
			}
			result++; // 모든 크레인 한번 반복 한 후 결과값 1증가
		}


		System.out.println(result);
	}
	
}
