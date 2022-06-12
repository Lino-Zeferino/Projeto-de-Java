package poo.gamed.ui;



import java.util.Scanner;

import poo.gamed.MediatecaOffice;
import poo.gamed.exception.NoSuchUserException;
import poo.gamed.exception.NoSuchWorkException;
import poo.gamed.exception.RuleFailedException;
import poo.gamed.exception.WorkNotBorrowedByUserException;
/**
 *<code>MenuRequisicao</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a requisicao de uma obra
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuRequisicao extends Menu {
/**
 *  Metodo construtor da classe MenuRequisicao que permite instanciar a mesma com passagem de Parametro
 * @param subMenu
 * @param office 
 */
	public MenuRequisicao(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.MENU_GESTAO_REQUISOES, subMenu, office);
		
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}
	Scanner input = new Scanner(System.in);
        /**
 * Metodo que faz a manipulacao de todas as opcaoes relacionado ao menu de requisicao de uma obra
 */
	@Override
	public void executarOpcao() 
	{
		
		while(true)
		{
		this.displayMenu();
		
		String workId;
		int userId;
		//input.nextLine(); 
		System.out.println(Message.selectAnOption());
		int option = input.nextInt(); 
		
		if (option == 0)
		{
			return; // BACK TO main menu
		}
		
		switch (option)
		{
		
			case 1:
				//input.nextLine(); // important (read/erase the undesirable data before asking for new one)
				//message for user
				System.out.println(Message.requestUserId());
				//user ID
				userId = input.nextInt();
				//user ID
				System.out.println(Message.requestWorkId());
				input.nextLine();
				workId = input.nextLine();
			
				try {
					// if true request accepted
					if(this.getOffice().addRequest(workId, userId))
					{
						System.out.println("Requisição aceite");
						System.out.println(this.getOffice().workReturnDay());
						// Mostrar a data de devolu��o
						/*
						try {
								System.out.println(this.getOffice().showReturnDate(workId, userId));
							} catch (WorkNotBorrowedByUserException e) {
								// TODO Auto-generated catch block
								//must never happen
							}*/
						
					}
					else
					{
						// requisi��o n�o aceite por falta de exemplares
						System.out.println(Message.requestReturnNotificationPreference());
					}
				} catch (RuleFailedException e) {
					System.out.println(e.getClass().getSimpleName());
				} catch (NoSuchUserException e) {
					System.out.println(e.getClass().getSimpleName());
				} catch (NoSuchWorkException e) {
					System.out.println(e.getClass().getSimpleName());
				}
				break;
			case 2:
				System.out.println(Message.requestUserId());
				//user ID
				userId = input.nextInt();
				//user ID
				System.out.println(Message.requestWorkId());
				input.nextLine();
				workId = input.nextLine();
			try {
				this.getOffice().returnRequest(workId, userId);
				System.out.println("Devolução aceite");
			} catch (NoSuchUserException e) {
				System.out.println(e.getClass().getSimpleName());
			} catch (WorkNotBorrowedByUserException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getClass().getSimpleName());
			} catch (NoSuchWorkException e) {
				System.out.println(e.getClass().getSimpleName());
				
			}
				
				break;
			default:
				System.out.println(Message.invalidOption()); 
				
		}
		
	}

	
	
	}

}
