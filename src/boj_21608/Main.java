package boj_21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int board[][]; // 앉을 자리 배열
	static int student[][]; // 좋아하는 학생 배열
	static int sit[][]; // 배치된 학생이 앉아있는 좌표 배열
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static int result=0;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		board=new int[N][N];
		student=new int[N*N][5];
		sit=new int[N*N][2];
		//좋아하는 학생 입력받기
		for(int i=0;i<N*N;i++)
		{
			 st= new StringTokenizer(br.readLine());
			 for(int j=0;j<5;j++)
			 {
				 student[i][j]=Integer.parseInt(st.nextToken());
			 }
		}
		
		solve();
		System.out.println(result);
	}

	static void solve()
	{
		for(int i=0;i<N*N;i++)
		{
			// 선생님이 i번쨰로 좋아하는 학생을 자리에 배치시키는 메서드
			checkSit(i);
		}
//		print();
		for(int i=0;i<N*N;i++)
		{
			result+=sum(i);
		}
	}
	
	static void print()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// 선생님이 i번쨰로 좋아하는 학생을 자리에 배치시키는 메서드
	static void checkSit(int idx)
	{
		int like=-1; // 좋아하는 학생수
		int empty=-1; // 비어있는 인접 칸
		int likeY=0; // 좋아하는 학생수가 제일 많은 Y좌표
		int likeX=0; // 좋아하는 학생수가 제일 많은 X좌표
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int nowEmpty=0;
				int nowLike=0;
				// 이미 자리 배치가 되었으면 생략
				if(board[i][j]!=0)
					continue;
				//(i,j)의 상하좌우에 비어있는 자리와 좋아하는 학생이 있는지 체크
				for(int k=0;k<4;k++)
				{
					int nextY=i+dy[k];
					int nextX=j+dx[k];
					
					if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N)
					{
						//비어있을 때
						if(board[nextY][nextX]==0)
						{
							nowEmpty++;
						}
						else
						{
							for(int l=1;l<5;l++)
							{
								// idx번째 학생이 좋아하는 학생
								int temp=student[idx][l];
								// idx번째 학생이 l번째로 좋아하는 학생이 상하좌우에 있는지 체크
								if(temp==board[nextY][nextX])
								{
									nowLike++;
									break;
								}
							}
						}
							
					}
				}
				if(nowLike>like) // 현재 좌석에서 좋아하는 친구가 더 많을 때
				{
					like=nowLike;
					empty=nowEmpty;
					likeY=i;
					likeX=j;
				}
				else if(nowLike==like) // 현재 좌석에서 좋아하는 친구의 숫자가 같을 때
				{
					// 비어있는 좌석의 수가 더 많을 때
					if(nowEmpty>empty)
					{
						empty=nowEmpty;
						likeY=i;
						likeX=j;
					}
				}
			}
		}
		
		// 가장 좋아하는 친구가 많은 자리에 배치
		board[likeY][likeX]=student[idx][0];
		sit[idx][0]=likeY;
		sit[idx][1]=likeX;
	}
	
	// 만족도 구하기
	static int sum(int idx)
	{
		int num=0;
		
		int nowY=sit[idx][0];
		int nowX=sit[idx][1];
		
		for(int i=0;i<4;i++)
		{
			int nextY=nowY+dy[i];
			int nextX=nowX+dx[i];
			
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N)
			{
				for(int j=1;j<5;j++)
				{
					if(board[nextY][nextX]==student[idx][j])
					{
						num++;
						break;
					}
				}
			}
		}
		if(num==0)return 0;
		return (int)Math.pow(10, num-1);
	}
}
