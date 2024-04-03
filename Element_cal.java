package Cal_string;

public class Element_cal {
	
String el_str = null;
Integer el_num = null;
Boolean flag_str = false;
	
	
	Element_cal(String input_str) throws MyException{
		String prepare_str = prepare_line(input_str);
		//System.out.println("Подготовленная строка " + str);
		el_num = test_str(prepare_str);
		el_str = check_line(prepare_str);
	}//
public String prepare_line(String input_str) {
		String str = "";
		Boolean flag_quotes = false;
		Boolean flag_end = false;
		String quotes = "\"";
		char[] mass_c = input_str.toCharArray();
		for(char c: mass_c) {
			String s = new String(new char[]{c});
			if(s.equals(" ") && flag_quotes == false) {
				continue;
			}//
			if(s.equals(quotes) && flag_quotes == false) {
				//System.out.println("Найдены первый кавычки " + str);
				flag_quotes = true;
				continue;
			}//
			if(s.equals(quotes) && flag_quotes == true) {
				//System.out.println("Найдены вторый кавычки " + str);
				flag_quotes = false;
				flag_str = true;
				break;
			}//
			str = str + s;
		}//
		return str;
}//
public Integer test_str(String str) throws MyException{
	if(flag_str == true) return this.el_num;
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
	if(flag_str == false) return this.el_str;
	if(this.el_num != null) return this.el_str;
	String result = null;
	result = input_str;
	//System.out.println("Строка без кавычек  " + input_str);
	if(result.length() > 10)throw new MyException();
	return result;
}//

public String vernut_el_str() {
	String result; 
	
	
	result = el_str;//.replace("\"", "");
	
	return result;
}//
}
