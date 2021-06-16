package boj_20114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int len,H,W;
	static String[] str;
	static String answer="";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		len=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		
		str=new String[H];
		for(int i=0;i<H;i++)
		{
			str[i]=br.readLine();
		}
		
		for(int i=0;i<len;i++) // 하나의 글자
		{
			boolean check=true;
			
			for(int k=0;k<H;k++) // H만큼 반복
			{
				boolean innerCheck=true;
					for(int j=i*W;j<i*W+W;j++) // W만큼 반복
					{
						if(str[k].charAt(j)!='?')
						{
							answer+=str[k].charAt(j);
							check=false;
							innerCheck=false;
							break;
						}
					}
				if(!innerCheck)
				{
					break;
				}
			}
			if(check)
			{
				answer+='?';
			}
		}
		System.out.println(answer);
	}
	
}
