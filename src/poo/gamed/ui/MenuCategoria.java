package poo.gamed.ui;



import java.util.Scanner;

import poo.gamed.MediatecaOffice;
/**
 *<code>MenuCategoria</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a categoria de uma obra
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuCategoria extends Menu {
	
	private String category;
/**
 * Metodo construtor da classe MenuCategoria que permite instanciar a mesma com passagem de Parametro
 * @param subMenu
 * @param office 
 */
	public MenuCategoria(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.CATEGORIA_OBRA, subMenu, office);
		
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}

	Scanner input = new Scanner(System.in);
        /**
 * Metodo que faz a manipulacao de todas as opcaoes relacionado ao categoria da de uma obra
 */
	
	@Override
	public void executarOpcao() {
		this.displayMenu();
		//input.nextLine(); //
		System.out.println(Message.selectAnOption());
		int option = input.nextInt();
		category = LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS[option-1];
		
	}
/**
 * Metod ispector que pega o valor da variavel categoria e a retorna
 * @return category
 */
	public String getCategory() {
		return category;
	}
/**
 * Metodo ispector que recebe o valor e atribui a variavel categoria
 * @param category 
 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	

	

}
