package boj_4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int[] parents,level;
	static int T,F;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		while(T-->0)
		{
			F=Integer.parseInt(br.readLine());
			parents=new int[F*2];
			level=new int[F*2];
			for(int i=0;i<F*2;i++)
			{
				parents[i]=i;
				level[i]=1;
			}
			HashMap<String,Integer> map=new HashMap<>();
			int index=0;
			for(int i=0;i<F;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				String a=st.nextToken();
				String b=st.nextToken();
			
				if(!map.containsKey(a))
				{
					map.put(a, index++);
				}
				
				if(!map.containsKey(b))
				{
					map.put(b, index++);
				}
				
				System.out.println(union(map.get(a),map.get(b)));
			}
			
		}
	}
	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static int union(int a,int b)
	{
		int num1=findSet(a);
		int num2=findSet(b);
		
		if(num1!=num2)
		{
			parents[num2]=num1;
			level[num1]+=level[num2];
		}
		
		return level[num1];
	}
}
