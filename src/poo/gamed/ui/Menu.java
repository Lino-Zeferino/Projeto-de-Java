package poo.gamed.ui;

import poo.gamed.MediatecaOffice;
/**
 *<code>Menu</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado que sera implementado em outras classe menus
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public abstract class Menu {
	
	private String title = "";
	
	private String[] subMenu;
	
	private MediatecaOffice office;
	
	/**
         * Metodo construtor da classe Menu que permite instanciar a mesma com passagem de Parametro
         * @param title
         * @param subMenu
         * @param office 
         */
	
	public Menu(String title, String[] subMenu, MediatecaOffice office)
	{
		this.title = title;
		this.subMenu = subMenu;
		this.office = office;
		
	}
/**
 * Metodo que pega e retorna o title da obra
 * @return title
 */
	public String getTitle() {
		return title;
	}
/**
 * Metodo que permite a pegar um valor por parametro e atribui o seu valor ao a tributo title 
 * @param title 
 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
         * Metodo que retorna o tamanho do Menu
         * @return length
         */
	public int menuSize()
	{
		return subMenu.length;
	}
	/**
         * Metodo que imprime uma sequencia de numero de 1 até onde termina a quantidade opcoes no menu
         */
	public void displayMenu()
	{
		System.out.println(title);
		for (int i = 0; i < menuSize(); i++)
			System.out.println((i + 1) + " - " + subMenu[i]); 
		System.out.println(LabelMenu.EXIT);
	}
	
	/**
         * Metodo abstrato quesra obrigatorio a sua implementacao em todas as classe que o estenderem desta classe
         * @param opcao 
         */
	//executarOpcao 
	public abstract void executarOpcao(int opcao);
        /**
         * Metodo abstrato que será obrigatório a sua implementacao em todas as classe que o estenderem desta classe
         */
	public abstract void executarOpcao();
/**
 * Metodo que pega e retorna o office
 * @return office
 */
	public MediatecaOffice getOffice() {
		return office;
	}
/**
 * Metodo que permite a pegar um valor por parametro e atribui o seu valor ao a tributo office 
 * @param office 
 */
	public void setOffice(MediatecaOffice office) {
		this.office = office;
	}
	

}
