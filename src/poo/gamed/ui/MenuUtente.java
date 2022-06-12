package poo.gamed.ui;



import java.util.Scanner;
import poo.gamed.Manipulacao;

import poo.gamed.MediatecaOffice;
import poo.gamed.Validacoes;
import poo.gamed.exception.FineErrorException;
import poo.gamed.exception.NoSuchUserException;
import poo.gamed.exception.UserRegistrationFailedException;
/**
 *<code>MenuUtente</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a um utente
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuUtente extends Menu {
        Validacoes validar = new Validacoes();
	Scanner input = new Scanner(System.in);
        Manipulacao manipulacao = new Manipulacao(); 
        /**
         *  Metodo construtor da classe MenuUtente que permite instanciar a mesma com passagem de Parametro
         * @param subMenu
         * @param office 
         */
	public MenuUtente(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.MENU_GESTAO_UTENTES, subMenu, office);
		
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}
/**
 * Metodo que faz a manipulacao de todas as opcaoes relacionado ao menu utente
 */
	@Override
	public void executarOpcao() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			this.displayMenu();
			//input.nextLine(); //
			System.out.println(Message.selectAnOption());
			int option = input.nextInt(); 
			int idOfUser;
			if (option == 0)
			{
				// for debug
				//System.out.println("Saindo do Menu Utente");
				return;
			}
			
			switch (option)
			{
			
				case 1:
					input.nextLine(); // important (read/erase the undesirable data before asking for new one)
					//message for user
					System.out.println(Message.requestUserName());
					String userName = input.nextLine();
					System.out.println(Message.requestUserEMail());
					String userEMail = input.nextLine();
					boolean estado = (validar.validarEmail(userEMail));
				try {
                                    if(estado == false){
                                        System.out.println("Erro no fornmato do email exemplodeemailvalido@gamil.com ");
                                    }else{
					this.getOffice().addUtente(userName, userEMail);
					System.out.println(Message.userRegistrationSuccessful()); 
                                    }
				} catch (UserRegistrationFailedException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getClass().getSimpleName());
					//e.printStackTrace();
				}
					
					
					break;
				case 2:
					System.out.println(Message.requestUserId());
					int id = input.nextInt();
					System.out.println("Utente:");      
				try {
					System.out.println(this.getOffice().showUtenteById(id));
				} catch (NoSuchUserException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getClass().getSimpleName());
					//e.printStackTrace();
				} 
					
					break;
				case 3:
					System.out.println("Utentes:"); 
			    	 for (String s: this.getOffice().showAllUtentes()) {           
			    		    System.out.println(s); 
			    		}
			    	 
					
					break;
                                    case 4:
					System.out.println("Pagar Multa: "); 
                                        System.out.println("Informa o id do utente: ");
                                        idOfUser = input.nextInt();
                                        try{
                                             if(this.getOffice().pagarMulta(idOfUser)){
                                                 System.out.println(Message.finePaidSuccessfully());
                                             }else{
                                                 System.out.println( Message.utenteActivo()+ " Ou erro ao pagar muta");;
                                             }
			    		
                                        }catch(FineErrorException e){
                                            System.out.println(e.getClass().getSimpleName());
                                        }catch(NoSuchUserException a){
                                         System.out.println(a.getClass().getSimpleName());
                                        }
					
					break;
				default:
					System.out.println(Message.invalidOption()); 
					
			}
			
		
		}

	
	
	}	 

}
