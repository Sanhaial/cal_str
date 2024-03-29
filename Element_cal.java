package Cal_string;

public class Element_cal {
	
String el_str = null;
Integer el_num = null;
	
	
	Element_cal(String input_str) throws MyException{
		el_num = test_str(input_str);
		el_str = check_line(input_str);
	}//
public Integer test_str(String str) throws MyException{
	if(this.el_str != null) return this.el_num;
	Integer operend = null;
	Boolean flag_parseInt = true;
	//System.out.println("строка для проверки " + str);
	try{
		operend = Integer.parseInt(str);
	}//try{
	catch(NumberFormatException nfe){
		//System.out.println("Невозможно преобразовать в цифры ");
		flag_parseInt = false;
	}//catch(NumberFormatException nfe){
	finally {
		//System.out.println("Оперенд равен " + operend);
		if(operend != null) {
		if(operend > 10) throw new MyException();
		}//
		return operend;
	}//
	}//
public String check_line(String input_str) throws MyException {
	if(this.el_num != null) return this.el_str;
	String result = null;
	char ch_test = '\"';
	int length = input_str.length();
	char carN = input_str.charAt(0);
	char carE = input_str.charAt(length - 1);
	if(carN != ch_test) return result; if(carE != ch_test) return result;
	result = input_str;
	//System.out.println("Первый символ строки " + carN + " последний символ " + carE);
	//System.out.println("Строка без кавычек  " + input_str);
	if(result.length() > 10)throw new MyException();
	return result;
}//
public String vernut_el_str() {
	String result; 
	
	
	result = el_str.replace("\"", "");
	
	return result;
}//
}
