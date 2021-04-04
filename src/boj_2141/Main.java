package boj_2141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 우체국
public class Main {
	static int N,minIdx;
	static long A[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		A=new long[N][2];
		long human=0;
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			A[i][0]=Integer.parseInt(st.nextToken());
			A[i][1]=Integer.parseInt(st.nextToken());
			human+=A[i][1];
		}
		
		Arrays.sort(A,new Comparator<long[]>()
		{

			@Override
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				 if(o1[0] < o2[0]) {
	                    return -1;
	                }
	                else if(o1[0] == o2[0]) {
	                    if(o1[1]< o2[1]) {
	                        return -1;
	                    }
	                }
	                return 1;
			}
		});
		
		long people=0;
		for(long[] a : A)
		{
			people+=a[1];
			if(people >= (human + 1) / 2) {
                System.out.println(a[0]);
                return;
            }
		}
	}

}
