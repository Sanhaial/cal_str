package Cal_string;

import java.util.Scanner;

public class Start {

	public static void main(String args[]) throws MyException {
		Scanner scan = new Scanner(System.in);
		System.out.println("������� �����");
		String str = scan.nextLine();
		
		Calculator objCalculator = new Calculator();
		String res = objCalculator.ver_res(str);
		System.out.println("��������� ��������������� ��������� " + res);
		//System.out.println("��������� ��������������� ��������� " + res);
	}//
}
