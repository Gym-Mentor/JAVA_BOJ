package boj_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static boolean apple[][];
	static boolean snake[][];
	static int[][] move;
	static int dy[]= {0,1,0,-1};
	static int dx[]= {1,0,-1,0};
	static int dir;
	static int cnt=0;
	static Deque<int []> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		
		apple=new boolean[N][N]; // 사과의 위치 저장
		snake=new boolean[N][N];
		dir=0; // 초기 방향은 오른쪽

		/////////////////////사과의 위치 받기////////////////////////
		for(int i=0;i<K;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken())-1;
			int num2=Integer.parseInt(st.nextToken())-1;
			
			apple[num1][num2]=true; 
		}
		///////////////////////////////////////////////////////////
		
		
		///////////////////// 뱀의 방향 받기 /////////////////////////
		L=Integer.parseInt(br.readLine());
		move=new int[L][2];
		for(int i=0;i<L;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			char num2=st.nextToken().charAt(0);
			move[i][0]=num1;
			move[i][1]=num2;
		}
		/////////////////////////////////////////////////////////
		
		q.add(new int[] {0,0}); // 큐의 마지막에 뱀 넣기
		snake[0][0]=true;
		
		
		//////////////////////////뱀 움직이기 시뮬레이션 ///////////////////
		int idx=0;
		while(true)
		{
			if(idx<L&&move[idx][0]==cnt)
			{
				if(move[idx][1]=='D') //오른쪽으로 방향 회전
				{
					dir=(dir+1)%4;
				}
				else // 왼쪽으로 방향 회전
				{
					dir=(dir-1+4)%4;
				}
				idx++;
			}
			cnt++; // 초 증가
			//현재 뱀의 위치에 이동할 방향을 넣어 좌표 받기
			int nextY=q.peekLast()[0]+dy[dir]; 
			int nextX=q.peekLast()[1]+dx[dir];
			
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N)
			{
				if(snake[nextY][nextX]) // 뱀이 자기자신에게 부딪힐 경우
				{
					break;
				}
				else
				{
					if(apple[nextY][nextX]) // 사과를 먹을 경우
					{
						apple[nextY][nextX]=false;
					}
					else
					{
						snake[q.peek()[0]][q.peek()[1]]=false;
						q.poll();
					}
					q.add(new int[] {nextY,nextX});
					snake[nextY][nextX]=true;
				}
			}
			else
			{
				break;
			}
		}
		System.out.println(cnt);
	}

}
