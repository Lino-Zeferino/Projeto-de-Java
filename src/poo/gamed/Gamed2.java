package poo.gamed;
import java.util.Scanner;
import poo.gamed.exception.*;
import poo.gamed.ui.*;


import java.util.Scanner;

/**
 *<code>Gamed</code> é a classe principal do programa responsavel por rodar todo programa
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */

public class Gamed2 {

 static MediatecaOffice office = new MediatecaOffice();
	/**
         * <code>main</code> Metodo principal do programa onde ocorre a relacao ou o elo de ligaca entre as funcionalidade do programa 
         * @param args
         * @throws NoSuchUserException 
         */
	public static void main(String[] args) throws NoSuchUserException 
	{
		// TODO Auto-generated method stub
		
		
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		// Menu de Gestao de Obras:
		Menu testMenu = new MenuPrincipal (LabelMenu.MAIN_MENU_OPTIONS, office);
		//testMenu.displayMenu();
		Menu testObra = new MenuObra(LabelMenu.OBRAS_MENU_OPTIONS, office);
		Menu testUtente = new MenuUtente(LabelMenu.UTENTES_MENU_OPTIONS, office);
		Menu testRequisicao = new MenuRequisicao(LabelMenu.REQUISICAO_MENU_OPTIONS, office);
		//Menu testCategoria = new MenuCategoria(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS, office);
		//Menu testTipo = new MenuTipo(LabelMenu.TIPO_OBRA_MENU_OPTIONS, office);
		Menu testAbrir = new MenuAbrir(LabelMenu.ABRIR_MENU_OPTIONS, office);
		Menu testGuardar = new MenuGuardar(LabelMenu.GUARDAR_MENU_OPTIONS, office);
		
		
		while(true)
		{
			testMenu.displayMenu();
			System.out.println(Message.selectAnOption());

			int option =input.nextInt(); 
			
			
			
			if (option == 0)
			{
		
				return;
			}
			
			switch (option)
			{
			
				case 1:
					testAbrir.executarOpcao();
					break;
				case 2:
					testGuardar.executarOpcao();
					break;
				case 3:
					testUtente.executarOpcao();
					break;
				case 4:
					testObra.executarOpcao();
					break;
				case 5:
					testRequisicao.executarOpcao();
					break;
				default:
					System.out.println(Message.invalidOption()); 
			}
		}
		
		
	}

}
