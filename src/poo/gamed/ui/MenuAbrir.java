package poo.gamed.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import poo.gamed.MediatecaOffice;
import poo.gamed.exception.UserRegistrationFailedException;
import poo.gamed.exception.WorkRegistrationFailedException;
/**
 *<code>MenuAbrir</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a um utente
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuAbrir extends Menu {

	Scanner input = new Scanner(System.in);  // Create a Scanner object
        /**
         *  Metodo construtor da classe MenuAbrir que permite instanciar a mesma com passagem de Parametro
         * @param subMenu
         * @param office 
         */
	public MenuAbrir(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.ABRIR, subMenu, office);
		// TODO Auto-generated constructor stub
	}
	

	
@Override
public void executarOpcao(int opcao) {
	
	
}

/**
 * Metodo que faz a manipulacao de todas as opcaoes relacionado ao menu abrir arquivo 
 */
// implement the abstract method that is defined inside the Menu class
@Override
public void executarOpcao() 
{
	// TODO Auto-generated method stub
	while(true)
	{
		this.displayMenu();
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
				input.nextLine(); // important (read/erase the undesirable data before asking for new one)
				//message for user
				System.out.println(Message.openFile());
				//Enter and set the current file for the application
				this.getOffice().setFicheiro(input.nextLine());
			try {
				this.getOffice().abrirFicheiro(this.getOffice().getFicheiro());
					System.out.println("Ficheiro importado com sucesso");
			} catch (FileNotFoundException e) {
				System.out.println(e.getClass().getSimpleName());
			} catch (ClassNotFoundException e) {
				// Do nothing
				
			} catch (IOException e) {
				// Do nothing
				
			}
				
				break;
			case 2:
				// Human readable file (don't set the filename)
				input.nextLine(); // important (read/erase the undesirable data before asking for new one)
				System.out.println(Message.openFile());
			try {
				this.getOffice().leituraFicheiroTexto(input.nextLine());
				System.out.println("Ficheiro importado com sucesso");
			}  catch (FileNotFoundException e) {
				System.out.println(e.getClass().getSimpleName());
			}catch (IOException e) {
				// TODO Auto-generated catch block
				
			} catch (UserRegistrationFailedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (WorkRegistrationFailedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
				
				break;
			default:
				System.out.println(Message.invalidOption()); 
				
		}
		
	
	}
}


}