package work.y_omasa.test;

import java.math.BigInteger;
import java.security.MessageDigest;

import static work.y_omasa.test.DataChecker.checkMailAddress;

public class User {
    private String userId;  //ユーザID
    private String pwdHash; //パスワードハッシュ
    private String email;   //メールアドレス

    public String toString(){
        String s;
        s = userId+":"+pwdHash+":"+email;
        return s;        
    }

    //指定された文字列が正しいパスワードか確認
    public boolean isPwdValid(String pwd){
        MessageDigest digest = null;
        try {
            //渡された文字列からハッシュを生成 
			digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(pwd.getBytes("utf8"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //生成されたハッシュ値を文字列に変換
        String entered = String.format("%032x", new BigInteger(1, digest.digest()));
        //生成されたハッシュ値と保存した値を比較
        return entered.equals(pwdHash);
    }

    // getter setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InputCheckException{
        this.email = checkMailAddress(email);
    }
}