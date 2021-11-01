/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 25666
 */

import java.math.BigInteger;
import java.util.*;

public class RSA {
    
    private int tamPrimo;
    private BigInteger n, p, q, fi, e, d;

    
     public RSA(int tamPrimo) {
        this.tamPrimo = tamPrimo;
        generaPrimos();             
        generaClaves();             
    }

    public RSA(BigInteger p,BigInteger q,int tamPrimo) {
        this.tamPrimo=tamPrimo;
        this.p=p;
        this.q=q;
        generaClaves();
    }

    private void generaPrimos(){
        p = new BigInteger(tamPrimo, 100, new Random());
        do q = new BigInteger(tamPrimo, 100, new Random());
            while(q.compareTo(p)==0);
    }

    private void generaClaves(){
        n = p.multiply(q);
        fi = p.subtract(BigInteger.valueOf(1));
        fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
        do e = new BigInteger(3 * tamPrimo, new Random());
        while((e.compareTo(fi) != -1) || (e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
        d = e.modInverse(fi);
    }

    public BigInteger[] cifrar(String mensaje){
        
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for(i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for(i=0; i<bigdigitos.length; i++)
            encriptado[i] = bigdigitos[i].modPow(e,n);

        return(encriptado);
        
    }

    public String descifrar(BigInteger[] encriptado) {
        BigInteger[] desencriptado = new BigInteger[encriptado.length];

        for(int i=0; i<desencriptado.length; i++)
            desencriptado[i] = encriptado[i].modPow(d,n);

        char[] charArray = new char[desencriptado.length];

        for(int i=0; i<charArray.length; i++)
            charArray[i] = (char) (desencriptado[i].intValue());

        return(new String(charArray));
    }

    public BigInteger getP() {return(p);}
    public BigInteger getQ() {return(q);}
    public BigInteger getPhi() {return(fi);}
    public BigInteger getN() {return(n);}
    public BigInteger getE() {return(e);}
    public BigInteger getD() {return(d);}
    
}
