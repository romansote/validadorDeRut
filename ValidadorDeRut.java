

package verificador.de.rut;

import java.util.Scanner;

/**
 *
 * @author roman
 * @version 1.0
 */
public class Persona {
    int suma;
    int resto;
    int resultado;
    int multiplicacion;
    int[] numfijos = {3, 2, 7, 6, 5, 4, 3, 2};
    String digitoVerificador;
    String capVerificador;
    String res;
    String rut;

    public Persona() {
        this.suma = 0;
    }

    public void verificarRut()
    {
        Scanner sc1 = new Scanner(System.in);
        
        System.out.println("#####  Verificador de rut #######");
        System.out.println("");
        System.out.println("Ingrese su rut [Formato: 12345678-9]");
        rut = sc1.nextLine();
        
        if(rut.length() != 10)
        {
            System.out.println("Formato de su rut invalido!");
        }
        else
        {
            for(int i =0; i < numfijos.length; i++)
            {
                multiplicacion = Integer.parseInt(rut.substring(i,i+1)) * numfijos[i];
                 
                suma += multiplicacion;
            }
            
            resto = suma % 11;
            
            resultado = (11-resto);
            
            if(resultado == 11)
            {
                digitoVerificador ="0";
                
                if(digitoVerificador.equals(capVerificador))
                {
                    System.out.println("El digito verificador ingresado es invalido, su digito verificador es ="+digitoVerificador);
                }else
                {
                    System.out.println("Digito verificador valido");
                }
            }else if(resultado == 10)
            {
                digitoVerificador = "k";
                
                if(!digitoVerificador.equals(capVerificador))
                {
                    System.out.println("El digito verificador ingresado es invalido, su digito verificador es ="+digitoVerificador);
                }else
                {
                    System.out.println("Digito verificador valido");
                }
                
            }else
            {
              capVerificador = rut.substring(9);
              
              res= Integer.toString(resultado);
              
              if(res.equals(capVerificador))
              {
                  System.out.println("Digito verificador valido");
              }else
              {

                  System.out.println("El digito verificador ingresado es invalido, su digito verificador es ="+res);
              }
                
            }
        }
    }
}
