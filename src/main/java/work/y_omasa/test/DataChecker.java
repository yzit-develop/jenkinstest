package work.y_omasa.test;

import java.util.regex.*;

public class DataChecker {
    //メールアドレスの正当性確認を行うメソッド
	public static String checkMailAddress(String address) throws InputCheckException{
		//メールアドレスの正規表現
		String regularExpression 
				= "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern pattern = Pattern.compile(regularExpression);
		Matcher matcher = pattern.matcher(address);
		//パターンがマッチしたら引数をそのまま返す。
		if (matcher.find()) {
			return address;
		}
		//マッチしなかったので、例外をスロー
		throw new InputCheckException();
	}    
}