import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
 
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
 
public class PasswordUtil {
 
    /** �p�X���[�h�����S�ɂ��邽�߂̃A���S���Y�� */
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    /** �X�g���b�`���O�� */
    private static final int ITERATION_COUNT = 10000;
    /** ��������錮�̒��� */
    private static final int KEY_LENGTH = 256;
 
    /**
     *�@�����̃p�X���[�h�ƃ\���g������S�ȃp�X���[�h�𐶐����A�ԋp���܂�
     *
     * @param password �����̃p�X���[�h
     * @param salt �\���g
     * @return ���S�ȃp�X���[�h
     */
    public static String getSafetyPassword(String password, String salt) {
 
        char[] passCharAry = password.toCharArray();
        byte[] hashedSalt = getHashedSalt(salt);
 
        PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, ITERATION_COUNT, KEY_LENGTH);
 
        SecretKeyFactory skf;
        try {
            skf = SecretKeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
 
        SecretKey secretKey;
        try {
            secretKey = skf.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        byte[] passByteAry = secretKey.getEncoded();
 
        // �������ꂽ�o�C�g�z���16�i���̕�����ɕϊ�
        StringBuilder sb = new StringBuilder(64);
        for (byte b : passByteAry) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
 
    /**
     * �\���g���n�b�V�������ĕԋp���܂�
     * ���n�b�V���A���S���Y����SHA-256���g�p
     *
     * @param salt �\���g
     * @return �n�b�V�������ꂽ�o�C�g�z��̃\���g
     */
    private static byte[] getHashedSalt(String salt) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        messageDigest.update(salt.getBytes());
        return messageDigest.digest();
    }
}