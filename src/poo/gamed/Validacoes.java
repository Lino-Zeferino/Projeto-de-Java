
package poo.gamed;

/**
 *
 * @author Lino_Zeferino
 */
public class Validacoes {

        public Validacoes() {
        }
        public boolean validarEmail(String email){
         if(email.matches("\\w+@\\w+\\.\\w{2,3}")){
              return true;   
             }
             return false;
        }  
      
}
