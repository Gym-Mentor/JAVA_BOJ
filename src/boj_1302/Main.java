package boj_1302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static int N,max=0;
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		HashMap<String,Integer> hashMap=new HashMap<>();
		String s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine();
			if(hashMap.containsKey(s))
			{
				hashMap.put(s,hashMap.get(s)+1);
			}
			else
			{
				hashMap.put(s, 1);
			}
		}
		for(HashMap.Entry<String,Integer> h:hashMap.entrySet())
		{
			if(h.getValue()>max)
			{
				max=h.getValue();
				str=h.getKey();
			}
			else if(h.getValue()==max)
			{
				if(str.compareTo(h.getKey())>0) // str이 사전순으로 뒤에올때
				{
					str=h.getKey();
				}
			}
		}
		System.out.println(str);
	}
}
