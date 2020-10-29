package tamework;

import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class PasswordUtil {


    //暗号化
    public static String getSafetyPassword(String password)
    throws Exception {

      byte[] ByteSalt = getNextSalt();
      IvParameterSpec ivspec = new IvParameterSpec(ByteSalt);
      SecretKeySpec sksSpec = new SecretKeySpec(ByteSalt, "AES");

      KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE,sksSpec,ivspec);

      byte[] bytePass = password.getBytes();

      byte[] output = cipher.doFinal(bytePass);

      String EncodedPass = Base64.getEncoder().encodeToString(output);
      return EncodedPass;
    }

    //暗号化されたパスワードを復号化する
    public static String getAuthPassword(String EncodedPass,String InputPass)
    throws Exception {


        byte[] ByteSalt = getNextSalt();
        IvParameterSpec ivspec = new IvParameterSpec(ByteSalt);

        SecretKeySpec sksSpec = new SecretKeySpec(ByteSalt, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,sksSpec,ivspec);

        byte[] output = cipher.doFinal(Base64.getDecoder().decode(EncodedPass));

        String DecodedPass = new String(output);
        System.out.println(DecodedPass);
        return DecodedPass;
    }

//Saltを生成するメソッド。ソルトは、ハッシュ化する前のパスワードの前後につける文字列
    private static byte[] getNextSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
