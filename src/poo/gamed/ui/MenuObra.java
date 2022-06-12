package poo.gamed.ui;

import java.util.Scanner;

import poo.gamed.MediatecaOffice;
import poo.gamed.exception.NoSuchWorkException;
import poo.gamed.exception.WorkRegistrationFailedException;
/**
 *<code>MenuObra</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a uma obra
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuObra extends Menu {

	/**
         * Metodo construtor da classe MenuObra que permite instanciar a mesma com passagem de Parametro
         * @param subMenu
         * @param office 
         */
	public MenuObra(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.MENU_GESTAO_OBRAS, subMenu, office);
		/*
		 * 
		 * the menu will display after the instantiation because inside the Menu class
		 * in his construct we call displayMenu function
		 * 
		 * */
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}
	Scanner input = new Scanner(System.in);
        /**
 * Metodo que faz a manipulacao de todas as opcaoes relacionado ao menu Obra
 */
	@Override
	public void executarOpcao() 
	{
		String name = null, coparateNumber = null, title, category, type;
		float price;
		int numberCopies;
		// TODO Auto-generated method stub
		while(true)
		{
			this.displayMenu();
			//input.nextLine(); //
			System.out.println(Message.selectAnOption());
			int option = input.nextInt(); 
			
			if (option == 0)
			{
				// for debug
				//System.out.println("Saindo do Menu Utente");
				return;
			}
			
			switch (option)
			{
			
				case 1:
					//Registar Obra
					input.nextLine(); // important (read/erase the undesirable data before asking for new one)
					//message for user
					System.out.println(Message.requestTitle());
					title = input.nextLine();
					System.out.println(Message.requestPrice());
					price = input.nextFloat();
					System.out.println(Message.requestNumCopies());
					numberCopies = input.nextInt();
					System.out.println(Message.requestCategory());
					
					// call Menu Category,  3 options for category
					MenuCategoria categoryMenu = new MenuCategoria(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS, this.getOffice());
					categoryMenu.executarOpcao();
					category = categoryMenu.getCategory();
					
					// call Menu Type,  2 options for book
					System.out.println(Message.requestType());
					MenuTipo typeMenu = new MenuTipo(LabelMenu.TIPO_OBRA_MENU_OPTIONS, this.getOffice());
					typeMenu.executarOpcao();
					type = typeMenu.getType();
					
					if (type.equals("Livro"))
					{
						input.nextLine();
						System.out.println(Message.requestAuthor());
						name = input.nextLine();
						System.out.println(Message.requestISBN());
						coparateNumber = input.nextLine();
					}
					else if (type.equals("DVD"))
					{
						input.nextLine();
						System.out.println(Message.requestProducer());
						name = input.nextLine();
						System.out.println(Message.requestDNDAC());
						coparateNumber = input.nextLine();
					}
					else
					{
						
					}
					
				try {
					this.getOffice().addObra(type, title, name, price, category, 
							coparateNumber, numberCopies);
					System.out.println(Message.WorkRegistrationSuccessful());
				} catch (WorkRegistrationFailedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getClass().getSimpleName());
				}
					
					break;
				case 2:
					 
					//Mostrar Obra
					input.nextLine();
					System.out.println(Message.requestWorkId());
					String id = input.nextLine();
					System.out.println("Obra:");      
				try {
					System.out.println(this.getOffice().showObraById(id));
				} catch (NoSuchWorkException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getClass().getSimpleName());
				} 
					
					break;
				case 3:
					//Mostrar Obras
					System.out.println("Obras:"); 
			    	 for (String s: this.getOffice().showAllObras()) {           
			    		    System.out.println(s); 
			    		}
			    	 
					
					break;
				case 4:
					//Efectuar Pesquisas
					input.nextLine();
					System.out.println(Message.requestSearchTerm());
					String word = input.nextLine();
					System.out.println("Obras encontradas:"); 
			    	 for (String s: this.getOffice().showWorksBySearch(word)) {           
			    		    System.out.println(s); 
			    		}
			    	 
					
					break;
				default:
					System.out.println(Message.invalidOption()); 
					
			}
			
		
		}

	
	
	}	 
	
	
	
	
	 
}
