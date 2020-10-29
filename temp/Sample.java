import java.util.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Sample {
	public static void main(String[] args)throws Exception{

    String password = "tamemotoakihiro";

//Cipher：共通鍵による暗号化
    byte[] ByteSalt1 = getNextSalt();
		String StringSalt = Base64.getEncoder().encodeToString(ByteSalt1);

    System.out.println(StringSalt);
		//UQVZ9TXEa2qap1+YdrSG6A==

		//16バイト(16の数字)のByteSalt1を用いて初期化ベクトル(Initialization Vector)を作成する
    IvParameterSpec ivspec1 = new IvParameterSpec(ByteSalt1);

		//AES:SubBytes,ShiftRows,MixColumns,AddRoundKeyの流れで置換

		//SecretKeySpec:プロバイダに依存しない形式での秘密鍵の指定
		//バイト配列からSecretKeyを構築することができる。オブジェクト自身を鍵として使用可能
    SecretKeySpec sksSpec1 = new SecretKeySpec(ByteSalt1, "AES");

		//同じ鍵で管理するためにJavaのKeyStoreクラスを呼び出す
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

		//
		try(FileInputStream fis = new FileInputStream("sample")){
			ks.load(fis, password.toCharArray());
		}

		KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(password.toCharArray());
		KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(sksSpec1);
		ks.setEntry("secretKeyAlias",skEntry,protParam);

		try(FileOutputStream fos = new FileOutputStream("sample")){
			ks.store(fos, password.toCharArray());
		}



		ks.getEntry("secretKeyAlias",protParam);



		//AESアルゴリズムでCipherオブジェクトを生成
		//CBC
		//PKCS5PADDING：ClearTextのByte列が8Byteの長さになるように文字列をPadding(付加)する。
		//8Byte固定なのでうまく機能しないこともあるが、PKCS7#PaddingがPKCS5のスーパーセットなので、
		//特に問題ないはず。
    Cipher cipher1 = Cipher.getInstance("AES/CBC/PKCS5PADDING");

		//Cipherオブジェクトに秘密鍵を設定　ENCRYPT_MODEとして秘密鍵を初期化
		//init(int opmode, Certificate,AlgorithmParameterSpec)
		//Certificateクラス：身元証明の公開鍵などを扱う
		//AlgorithmParameterSpec：パラメータの仕様
		//秘密鍵,初期化ベクトル
    cipher1.init(Cipher.ENCRYPT_MODE,sksSpec1,ivspec1);

    byte[] bytePass = password.getBytes("UTF-8");

		//暗号化
    byte[] output1 = cipher1.doFinal(bytePass);

    String EncodedPass = Base64.getEncoder().encodeToString(output1);

    System.out.println(EncodedPass);
		//POaf5tT6Xp2fKIMXdVvqXA==
		//Stringでみる限りpaddingが抜けているように見える



//復号化
    byte[] ByteSalt2 = getNextSalt();
		String StringSalt1 = Base64.getEncoder().encodeToString(ByteSalt1);

		System.out.println(StringSalt1);
		//UQVZ9TXEa2qap1+YdrSG6A== StringSaltと同じ 24文字


    //IvParameterSpec ivspec2 = new IvParameterSpec(ByteSalt2);

		//AES:AddRoundKey,MixColumns,ShiftRows,SubBytesの流れで復号処理
		//16バイトで変換するのが主要？
    //SecretKeySpec sksSpec2 = new SecretKeySpec(ByteSalt2, "AES");
    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5PADDING");

		//Cipherオブジェクトに秘密鍵を設定　DECRYPT_MODEとして秘密鍵を初期化
    cipher2.init(Cipher.DECRYPT_MODE,sksSpec1,ivspec1);

		//ここでエラーが出る
		//BadPaddingException: Given final block not properly padded.
		//Such issues can arise if a bad key is used during decryption.
		//byteをそのまま入れても同じだった。
		byte[] b2 = Base64.getDecoder().decode(EncodedPass);
    byte[] output2 = cipher2.doFinal(b2);

		String DecodedPass = new String(output2, "UTF-8");
    System.out.println(DecodedPass);

  }

//Saltを生成するメソッド。ソルトは、ハッシュ化する前のパスワードの前後につける文字列
  private static byte[] getNextSalt() {
      SecureRandom random = new SecureRandom();
      byte[] salt = new byte[16];
      random.nextBytes(salt);
			//
      return salt;
  }

}
