
package Validacoes;
/**
 *
 * @author LINO ZEFERINO
 */
public class validar {
    
    public static boolean validarIdade(int idade){
        if(Character.isDigit(idade) == true){
            if(idade >= 18){ 
                return true;
            }
            else{ 
                return false;
            }            
        }
        else{
            System.out.println("O dado introduzido não é um número...");
        }
        return false;
    }
}
