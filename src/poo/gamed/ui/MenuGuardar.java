package poo.gamed.ui;

import java.io.IOException;
import java.util.Scanner;

import poo.gamed.MediatecaOffice;
/**
 *<code>MenuGuardar</code> é a classe responsavel por fazer a manipulacao de todo o menu relacionado a guardar todo o estado atual do programa
 * @author Lino_Zeferino
 * @see Menu
 * @version 1.0
 * @since 1.0
 */
public class MenuGuardar extends Menu{
	Scanner input = new Scanner(System.in);
        /**
         * Metodo construtor da classe MenuGuardar que permite instanciar a mesma com passagem de Parametro
         * @param subMenu
         * @param office 
         */
	public MenuGuardar(String[] subMenu, MediatecaOffice office) {
		super(LabelMenu.GUARDAR, subMenu, office);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarOpcao(int opcao) {
		// TODO Auto-generated method stub
		
	}
/**
 * Metodo que faz a execucao do menu na parte do guardar 
 */
	@Override
	public void executarOpcao() {
		if (this.getOffice().checkFicheiro())
		{
			System.out.println(this.getOffice().getFicheiro());
			try {
				this.getOffice().guardarFicheiro();
				// for debug
				System.out.println("Dados guardados com sucesso");
			} catch (IOException e) {
				// for debug if file doesn't exist
				//System.out.println("dados n�o guardos guardados");
				//e.printStackTrace();
				
			}
		}
		else
		{
			//input.nextLine();
			System.out.println(Message.newSaveAs());
			//this.getOffice().setFicheiro(input.nextLine());
			try {
				this.getOffice().guardarFicheiro(input.nextLine());
				//for debug
				System.out.println("Dados guardados com sucesso");
			} catch (IOException e) {
				// for debug if file doesn't exist
				//System.out.println("dados n�o guardos guardados");
				//e.printStackTrace();
				
			}
		}
	}

	

}
