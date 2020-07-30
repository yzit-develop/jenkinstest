package work.y_omasa.test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class App {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId("test001");

        String pwd = "1234";
        MessageDigest digest = null;
        try {
            //渡された文字列からハッシュを生成 
			digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(pwd.getBytes("utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成されたハッシュ値を文字列に変換
        String hashedPw = String.format("%032x", new BigInteger(1, digest.digest()));
        // userにパスワードハッシュを設定
        user.setPwdHash(String.valueOf(hashedPw));
        
        try {
            //メールアドレスを設定 書式チェックされる
            user.setEmail("test001@example.com");
        } catch (InputCheckException e) {
            e.printStackTrace();
        }

        System.out.println( user );

        if( user.isPwdValid("1234")){
            System.out.println("Password 1234 is valid");
        } else {
            System.out.println("Password 1234 is not valid");
        }
    }
}
