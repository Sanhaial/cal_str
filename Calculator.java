package Cal_string;

import java.util.ArrayList;

public class Calculator {
	public Calculator() throws MyException{
		
	}//
public String ver_res(String input_str) throws MyException {
	//ArrayList<String> arr = operend(input_str);
			ArrayList<String> arr = null;
			//arr =  operend(input_str);
			arr =  check_quotes(input_str);
			//System.out.println("Массив элементов  " + arr.size());
			if (arr.size() == 0) throw new MyException();
			Element_cal objElement_cal = new Element_cal(arr.get(0));
			Element_cal objElement_ca2 = new Element_cal(arr.get(1));
			String res = arethmetic_action(objElement_cal, objElement_ca2, arr.get(2));
			res = "\"" + res + "\"";
			return res;
}//

	public  ArrayList<String> operend(String str){
		String str1 = "";
		String str2 = "";
		String operator = "";
		ArrayList<String> arr = new ArrayList<String>();
		int i=0;
		char[] mass_c = str.toCharArray();
		for(char c: mass_c) {
			String s = new String(new char[]{c});
			if(s.equals("-")) {
				str2 = str.substring(i+1);
				operator = "-";
				break;
			}
			if(s.equals("+")) {
				str2 = str.substring(i+1);
				operator = "+";
				break;
			}
			if(s.equals("/")) {
				str2 = str.substring(i+1);
				operator = "/";
				break;
			}
			if(s.equals("*")) {
				str2 = str.substring(i+1);
				operator = "*";
				break;
			}
			str1 = str1 + s;
			i++;
		}
		arr.add(str1); arr.add(str2); arr.add(operator); /*arr.add(type_numerals);*/
		return arr;
	}//
	public ArrayList<String> check_quotes(String input_str) {
		ArrayList<String> arr = new ArrayList<String>();
		String str1 = "";
		String str2 = "";
		String operator = "";
		Boolean flaf_line = false;
		char[] mass_c = input_str.toCharArray();
		int i=0;
		for(char c: mass_c) {
			String s = new String(new char[]{c});
			if(s.equals("\"")) {
				if(flaf_line == false) {
					flaf_line = true;
				} else {
					flaf_line = false;
				}//
				
				//System.out.println("Нашли кавычки сменили флаг   " + str1 + " Строка 2 " + flaf_line);
			}//
			if(s.equals("-") && flaf_line == false) {
				str2 = input_str.substring(i+1);
				operator = "-";
				break;
			}
			if(s.equals("+") && flaf_line == false) {
				str2 = input_str.substring(i+1);
				operator = "+";
				break;
			}
			if(s.equals("/") && flaf_line == false) {
				str2 = input_str.substring(i+1);
				operator = "/";
				break;
			}
			if(s.equals("*") && flaf_line == false) {
				str2 = input_str.substring(i+1);
				operator = "*";
				break;
			}
			str1 = str1 + s;
			i++;
		}
		arr.add(str1); arr.add(str2); arr.add(operator);
		return arr;
	}//

	public static String arethmetic_action(Element_cal elm1, Element_cal elm2,  String operator) throws MyException{
		String result_str = null;
		
		switch (operator) {
		case "-": 
		String str = elm1.vernut_el_str();
		String del_str = elm2.vernut_el_str();
		//System.out.println("Строка для вычитания   " + del_str);
		result_str = str.replaceAll(del_str, "");
		//System.out.println("Результат вычитания   " + result_str);
			break;
		case "+":
		String str1 = elm1.vernut_el_str();
		String str2 = elm2.vernut_el_str();
		result_str = str1 + str2;
		//System.out.println("Сложения   " + result_str);
		break;
		//return result_str;	
			//break;
		case "/": 
			String str_dl = elm1.vernut_el_str();
			int len = str_dl.length();
			Integer d = elm2.el_num;
			if(d == null) throw new MyException(); 
			int res = len / d;
			//System.out.println("Длинна строки " + len + " Делитель " + d + " Результат деления " + res);
			result_str = str_dl.substring(0, res);
			//System.out.println("Деление   " + result_str);
			break;
			//return result_str;
		case "*": 
			String str_um = elm1.vernut_el_str();
			Integer mnog = elm2.el_num;
			if(mnog == null) throw new MyException(); 
			int n = 0;
			result_str = "";
			for(int i=0;i<mnog;i++) {
				result_str = result_str + str_um;
				n++;
			}//
			//System.out.println("Умнажение   " + result_str + " Множетель " + n);
			break;
			//return result_str;

		default:  
			break;
		}//
		//System.out.println("Результат арифметического действия " + res);
		int len = result_str.length();
		//System.out.println("Длинна строки   " + len);
		if(len > 40) {
			result_str = result_str.substring(0, 40);
			result_str = result_str + "...";
		}//
		return result_str;
	}//

}
