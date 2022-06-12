package poo.gamed.ui;

import poo.gamed.MediatecaOffice;
/**
 * classe que contem o menu principal do programa
 * @author Lino_Zeferino
 * @see Menu
 *  @version 1.0
 * @since 1.0
 */
public class MenuPrincipal extends Menu {
    /**
     * Metodo construtor da classe MenuPrincipal que permite instanciar a mesma com passagem de Parametro
     * @param subMenu
     * @param office 
     */
	public MenuPrincipal(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.TITLO_INTERFACE_PRINCIPAL, subMenu, office);
		
	}
	

	

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executarOpcao() {
		// TODO Auto-generated method stub
		
	}
	
	  

}
