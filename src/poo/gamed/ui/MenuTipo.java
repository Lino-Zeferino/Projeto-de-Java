package poo.gamed.ui;



import java.util.Scanner;

import poo.gamed.MediatecaOffice;
/**
 *<code>MenuTipo</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado ao tipo de obra
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuTipo extends Menu {

	private String type;
        /**
         * Metodo construtor da classe MenuTipo que permite instanciar a mesma com passagem de Parametro
         * @param subMenu
         * @param office 
         */
	public MenuTipo(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.TIPO_OBRA, subMenu, office);
		
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}

	Scanner input = new Scanner(System.in);
        /**
         * Metodo que faz a execucao do menu na parte do tipo de obra
         */
	@Override
	public void executarOpcao() {
		this.displayMenu();
		//input.nextLine(); //
		System.out.println(Message.selectAnOption());
		int option = input.nextInt();
		type =(LabelMenu.TIPO_OBRA_MENU_OPTIONS[option-1]);
		
		
	}
/**
 * Metodo que pega e retorna o typo de obra
 * @return type
 */
	public String getType() {
		return type;
	}
/**
 * Metodo que permite a pegar o tipo de obra por parametro e atribui o seu valor ao a tributo Type 
 * @param type 
 */
	public void setType(String type) {
		this.type = type;
	}

	

}
