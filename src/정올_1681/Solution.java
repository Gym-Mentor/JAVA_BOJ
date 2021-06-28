package 정올_1681;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
 
    static int N;
    static int[][] map;
    static boolean[] visit;
    
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        visit=new boolean[N];
        
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
        
        visit[0]=true;
        answer=Integer.MAX_VALUE;
        perm(0,1,0);
        System.out.println(answer);
        
    } 
    
    static void perm(int cur,int depth, int sum) {
        if(depth==N) {
            if(map[cur][0]==0)
                return;
            
            sum+=map[cur][0];
            
            answer=Math.min(answer, sum);
            
            return;
        }
        
        for(int i=1;i<N;i++) {
            if(visit[i]==false && map[cur][i]!=0 && sum+map[cur][i] < answer) {
                visit[i]=true;
                perm(i,depth+1,sum+map[cur][i]);
                visit[i]=false;
            }
        }
    }
}
 
