package boj_2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int R,C,N,total,count,minC,maxC,downNum;
	static char[][] arr;
	static int[] downArr;
	static boolean[][] visited;
	static boolean[][] isDown;
	static int[]dy= {1,-1,0,0};
	static int[]dx= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		for(int i=0;i<R;i++)
		{
			arr[i]=br.readLine().toCharArray();
			for(int j=0;j<C;j++)
			if(arr[i][j]=='x')total++;
		}
		
		N=Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			int num=Integer.parseInt(st.nextToken());
			// 부수기
			if(i%2==0) // 왼쪽에서 부수기
				boom(R-num,-1,0);
			else // 오른쪽에서 부수기
				boom(R-num,1,C-1);
			
			// 모든 미네랄 검사
			visited=new boolean[R][C];
			count=0;
			for(int col=C-1;col>=0;col--)
			{
				if(!visited[R-1][col]&&arr[R-1][col]=='x')
				{
					dfs(R-1,col);
				}
			}
			
			//밑으로 내리기
			if(count!=total)
			{
				minC=Integer.MAX_VALUE;
				maxC=0;
				downArr=new int[C];
				downNum=Integer.MAX_VALUE;
				isDown=new boolean[R][C];
				boolean escape=false;
				for(int row=R-2;row>=0;row--)
				{
					for(int col=0;col<C;col++)
					{
						if(!visited[row][col]&&arr[row][col]=='x')
						{
							getMinMax(row,col);
							escape=true;
							break;
						}
					}
					if(escape)break;
				}
				getDownNum(minC,maxC);
				down();
			}
		}
		print();
	}
	static void boom(int Y,int left,int idx)
	{
		
		for(int i=0;i<C;i++)
		{
			if(arr[Y][idx-i*left]=='x')
			{
				arr[Y][idx-i*left]='.';
				total--;
				return;
			}
		}
	}
	
	static void dfs(int Y, int X)
	{
		count++;
		visited[Y][X]=true;
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			if(0<=nextY&&nextY<R&&0<=nextX&&nextX<C&&!visited[nextY][nextX]&&arr[nextY][nextX]=='x')
			{
				dfs(nextY,nextX);
			}
		}
	}
	static void getMinMax(int Y,int X)
	{
		//내려야할 범위 저장
		if(minC>X)
		{
			minC=X;
		}
		if(maxC<X)
		{
			maxC=X;
		}
		downArr[X]=Math.max(downArr[X], Y);
		visited[Y][X]=true;
		isDown[Y][X]=true;
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			if(0<=nextY&&nextY<R&&0<=nextX&&nextX<C&&!visited[nextY][nextX]&&arr[nextY][nextX]=='x')
			{
				getMinMax(nextY,nextX);
			}
		}
	}
	static void getDownNum(int start, int end)
	{
		for(int i=start;i<=end;i++)
		{
			for(int j=0;j<R-1;j++)
			{
				if(isDown[j][i])
				{
					for(int k=j+1;k<R;k++)
					{
						if((!isDown[k][i]&&arr[k][i]=='x'))
						{
							downNum=Math.min(downNum, k-1-j);
						}
						else if(k==R-1)
						{
							downNum=Math.min(downNum, k-j);
						}
					}
				}
					
			}
		}
	}
	static void down()
	{
		for(int i=minC;i<=maxC;i++)
		{
			for(int j=downArr[i];j>=0;j--)
			{
				if(isDown[j][i])
				{
					arr[j+downNum][i]=arr[j][i];
					arr[j][i]='.';
				}
			}
		}
	}
	static void print()
	{
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}