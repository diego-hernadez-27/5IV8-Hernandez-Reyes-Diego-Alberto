/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DES;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author 25666
 */
public class CifradoDES {
    
    public String Cifrado(String Cadena, String Clave) {

        String CadenaFinal = "";
        String TipoCifrado = "DES";
        SecretKeySpec obj = new SecretKeySpec(Clave.getBytes(), TipoCifrado);
        Cipher cifrador;
        try {
            cifrador = Cipher.getInstance(TipoCifrado);
            cifrador.init(Cipher.ENCRYPT_MODE, obj);
            byte[] bytcif = cifrador.doFinal(Cadena.getBytes());
            CadenaFinal = new BASE64Encoder().encode(bytcif);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
        return CadenaFinal;
    }

    public String Descifrar(String CadenaCifrada, String Clave) {
        String CadenaFinal = "";
        String TipoCifrado = "DES";
        SecretKeySpec obj = new SecretKeySpec(Clave.getBytes(), TipoCifrado);
        Cipher cifrador;
        try {
            cifrador = Cipher.getInstance(TipoCifrado);
            cifrador.init(Cipher.DECRYPT_MODE, obj);
            byte[] cifr = new BASE64Decoder().decodeBuffer(CadenaCifrada);
            byte[] bytdes = cifrador.doFinal(cifr);
            CadenaFinal = new String(bytdes);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return CadenaFinal;
    }
    
}
