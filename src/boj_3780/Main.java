package boj_3780;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,N;
	static int[] parents, level;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
			N=Integer.parseInt(br.readLine());
			parents=new int[N+1];
			level=new int[N+1];
			
			for(int i=0;i<=N;i++)
			{
				parents[i]=i;
				level[i]=0;
			}
			
			while(true)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				
				String cmd=st.nextToken();
				
				// 기업 I와 현재 I의 센터까지의 거리를 출력
				if(cmd.equals("E"))
				{
					int to=Integer.parseInt(st.nextToken());
					findSet(to);
					System.out.println(level[to]);
				}
				else if(cmd.equals("I")) // 센터I를 기업 J에 연결
				{
					union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				}
				else // 종료
				{
					break;
				}
			}
		}
		
	}
	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		else
		{
			int tmp=findSet(parents[a]);
			level[a]+=level[parents[a]];
			parents[a]=tmp;
			return tmp;
		}
			
	}
	
	static void union(int a,int b)
	{
		
		
		if(a!=b)
		{
			parents[a]=b;
			level[a]=(Math.abs(a-b)%1000);
		}
	}
}