package com.constanzooficial.integracao.util;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class UtilAES {

    private static final UtilAES INSTANCE = new UtilAES();
    private SecretKey defaultKey;

    private UtilAES() {
        byte[] y = {63, 64, 102, 7};
        byte[] u = {-10, 6, 1, -84};
        byte[] r = {-92, 20, -104, -115};
        byte[] i = {46, -46, -38, 111};
        byte[] k = new byte[16];
        System.arraycopy(y, 0, k, 0, 4);
        System.arraycopy(u, 0, k, 4, 4);
        System.arraycopy(r, 0, k, 8, 4);
        System.arraycopy(i, 0, k, 12, 4);
        this.defaultKey = keyFromByteArray(k);
    }

    public static UtilAES getInstance() {
        return INSTANCE;
    }

    public SecretKey generateKey() throws NoSuchAlgorithmException {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey aesKey = kgen.generateKey();
        this.defaultKey = aesKey;
        return aesKey;
    }

    public SecretKey keyFromByteArray(byte[] array) {

        return new SecretKeySpec(array, "AES");
    }

    /*
    public static byte[] encrypt(String str, SecretKey sKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {

        // Encrypt cipher
        Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, sKey);

        // Encrypt
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher)) {
            cipherOutputStream.write(str.getBytes());
            cipherOutputStream.flush();
        }
        byte[] encryptedBytes = outputStream.toByteArray();

        return encryptedBytes;
    }
     */
    public String encrypt(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, defaultKey);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    /*
    public static String decrypt(byte[] encryptedBytes, SecretKey sKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException {

        // Decrypt cipher
        Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(sKey.getEncoded());
        decryptCipher.init(Cipher.DECRYPT_MODE, sKey, ivParameterSpec);

        // Decrypt
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inStream = new ByteArrayInputStream(encryptedBytes);
        CipherInputStream cipherInputStream = new CipherInputStream(inStream, decryptCipher);
        byte[] buf = new byte[1024];
        int bytesRead;
        while ((bytesRead = cipherInputStream.read(buf)) >= 0) {
            outputStream.write(buf, 0, bytesRead);
        }
        String decryptedString = new String(outputStream.toByteArray());

        return decryptedString;
    }
     */
    public String decrypt(String encryptedData) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, defaultKey);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    /*
    public SecretKey getDefaultKey() {
        return defaultKey;
    }
     */
}
