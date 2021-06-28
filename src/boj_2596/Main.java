package boj_2596;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[8];
		str[0] = "000000";
		str[1] = "001111";
		str[2] = "010011";
		str[3] = "011100";
		str[4] = "100110";
		str[5] = "101001";
		str[6] = "110101";
		str[7] = "111010";
		char[] alphabet= {'A','B','C','D','E','F','G','H'};
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		char[] result = new char[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 8; j++) {
				int same=0;
				for (int k = 0; k < 6; k++) {
					if(str[j].charAt(k)==s.charAt(k+i*6))
					{
						same++;
					}
				}
				if(same==5||same==6)
				{
					result[i]=alphabet[j];
					break;
				}
				else if(j==7)
				{
					System.out.println(i+1);
					return;
				}
			}
		}
		for(char c:result)
		System.out.print(c);
	}

}
