
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 25666
 */
public class Validaciones {
    
    public static boolean  validarNumeros(String cadena, String campo){
        boolean bandera;
        if (!cadena.matches("[0-9]")){
            JOptionPane.showMessageDialog(null, "El dato ingresado en " + campo + " no es un número");
            bandera = false;
        }else{
            bandera = true;
        }
        return bandera;
    }    
    
    public static boolean estaVacio(String cadena, String campo){
        boolean bandera;
        if (cadena.isEmpty()){
            JOptionPane.showMessageDialog(null, "El dato ingresado en " + campo + " esta vacio");
            bandera = false;
        }else{
            bandera = true;
        }
        return bandera;
    } 
    
    public static boolean Tama(String cadena, String campo){
        boolean bandera;
        if (cadena.length() != 3){
            JOptionPane.showMessageDialog(null, "El dato ingresado en " + campo + " no tiene 3 digitos");
            bandera = false;
        }else{
            bandera = true;
        }
        return bandera;
    } 
    
    public static boolean esPrimo(String cadena, String campo){
        boolean bandera = true;
        int numero = Integer.parseInt(cadena);
        if(numero<2){
            bandera = false;
        }else {
            for(int x=2; x*x<=numero; x++)
            {
                if( numero%x==0 ) {
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "El dato ingresado en " + campo + " no es numero primo");
                    break;
                }
            }
        }
        return bandera;
    } 
    
}
