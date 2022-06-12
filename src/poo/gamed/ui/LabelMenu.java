package poo.gamed.ui;

/**
 * classe responsavel por reunir todos os titulos do Menu
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
// Titles for All Menu
public  interface LabelMenu {
	
	
	// Label Menu Main
	String TITLO_INTERFACE_PRINCIPAL = "Menu Principal";
	String ABRIR = "Abrir";
	String GUARDAR = "Guardar";
	String MENU_GESTAO_UTENTES = "Menu de Gestao de Utentes";
	String MENU_GESTAO_OBRAS = "Menu de Gestao de Obras";
	String MENU_GESTAO_REQUISOES = "Menu de Gestao de Requisicoes";
	
	String[] MAIN_MENU_OPTIONS = {ABRIR,
			
			GUARDAR, MENU_GESTAO_UTENTES, MENU_GESTAO_OBRAS, MENU_GESTAO_REQUISOES};
	// Label Menu ABRIR
	
	String ABRIR_FICHEIRO = "Ficheiro associado a aplicacao";
	String IMPORTAR_FICHEIRO = "Importar ficheiro texto";
	String[] ABRIR_MENU_OPTIONS = {ABRIR_FICHEIRO, IMPORTAR_FICHEIRO};
	// Label Menu GUARDAR
	String GUARDAR_FICHEIRO_ACTUAL = "Guardar dados no ficheiro actual";
	String GUARDAR_FICHEIRO_NOVO  = "Guardar dados em um novo ficheiro";
	String[] GUARDAR_MENU_OPTIONS = {GUARDAR_FICHEIRO_ACTUAL, GUARDAR_FICHEIRO_NOVO};
	// Label Menu MENU_GESTAO_OBRAS
	String REGISTAR_OBRA = "Registar Obra";
	String MOSTRAR_OBRA = "Mostrar obra";
	String MOSTRAR_OBRAS = "Mostrar Obras";
	String EFECTUAR_PESQUISAS = "Efectuar Pesquisas";
	String[] OBRAS_MENU_OPTIONS = {REGISTAR_OBRA,MOSTRAR_OBRA,MOSTRAR_OBRAS,EFECTUAR_PESQUISAS};
	
	// Label Menu REGISTAR_OBRA
	String CATEGORIA_OBRA = "Categoria da obra";
	String TIPO_OBRA ="Tipo da obra";
	String[] Registar_OBRA_MENU_OPTIONS = {CATEGORIA_OBRA, TIPO_OBRA};
	String[] CATEGORIA_OBRA_MENU_OPTIONS = {"obras de referencia", "obras de ficcao", 
			"obras tecnicas e cientificas"};
	String[] TIPO_OBRA_MENU_OPTIONS = {"Livro", "DVD"};
	// Label Menu  MENU_GESTAO_UTENTES 
	String REGISTAR_UTENTE = "Registar utente";
	String MOSTRAR_UTENTE = "Mostrar utente";
	String MOSTRAR_UTENTES = "Mostrar utentes";
        String PAGAR_MULTA= "pagar multa";
	String[] UTENTES_MENU_OPTIONS = {REGISTAR_UTENTE ,MOSTRAR_UTENTE,MOSTRAR_UTENTES,PAGAR_MULTA};
	// Label Menu  MENU_GESTAO_REQUISOES
	
	String REQUISITAR_OBRA = "Requisitar Obra";
	String DEVOLVER_OBRA = "Devolver Obra";
	String[]REQUISICAO_MENU_OPTIONS = {REQUISITAR_OBRA ,DEVOLVER_OBRA};
	// Label for All Main Menu and others Menu
	String EXIT = "0 - SAIR";

}
