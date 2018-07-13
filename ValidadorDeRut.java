
package verificador.de.rut;

import java.util.Scanner;

/**
 *
 * @author roman
 * @version 1.0
 */
public class ValidadorDeRut {

    int suma = 0;
    int resto;
    int resultado;
    int multiplicacion;
    String digitoVerificador;
    String capVerificador;
    String res;
    int[] numfijos = {3, 2, 7, 6, 5, 4, 3, 2};

    public ValidadorDeRut() {
        this.suma = 0;
    }

    public void verificarRut(){
        Scanner sc1 = new Scanner(System.in);
        
        System.out.println("#####  Verificador de rut #######");
        System.out.println("");
        System.out.println("Ingrese su rut [Formato: 12345678-9]");
        String rut = sc1.nextLine();
        
        if(rut.length() != 10){
            System.out.println("Formato de su rut invalido!");
        }else{
            for(int i =0; i < numfijos.length; i++)
            {
               multiplicacion = Integer.parseInt(rut.substring(i,i+1)) * numfijos[i];
               
               suma += multiplicacion;
            }
            
            resto = suma % 11;
            
            resultado = (11-resto);
            
            switch (resultado) {
                case 11:
                    digitoVerificador ="0";
                    if(digitoVerificador != capVerificador){
                        System.out.println("El digito verificador ingresado es invalido, su digito verificador es = "+digitoVerificador);
                    }else{
                        System.out.println("Digito verificador valido");
                    }   
                    break;
                case 10:
                    digitoVerificador = "k";
                    if(digitoVerificador != capVerificador){
                        System.out.println("El digito verificador ingresado es invalido, su digito verificador es ="+digitoVerificador);
                    }else{
                        System.out.println("Digito verificador valido");
                    }   
                    break;
                default:
                    capVerificador = rut.substring(10);
                    
                    res= Integer.toString(resultado);
                    
                    System.out.println(res);
                    
                    if(res != capVerificador){
                        
                        System.out.println("El digito verificador ingresado es invalido, su digito verificador es ="+res);
                    }else{
                        System.out.println("Digito verificador valido");
                    }     
                    break;
            }

        }
    }
}
