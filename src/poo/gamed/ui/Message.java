package poo.gamed.ui;
/**
 * <code>Message</code> classe que reuni todas as possiveis mensagens do que serao mostrado no programa
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public final class Message {
	
	
	/**
         * Metodo contrutor da classe Message responsagel por instanciar a mesma sem passagm de valor
         */
	private Message()
	{
		
	}
	
	/**
         * Metodo que imprime uma mensagem quando a opcao escolhida nao existe
         * @return sms
         */
	 public static final String invalidOption() {
             String sms = "Opção não existente: ";
		    return sms;
		  }
         /**
         * Metodo que imprime uma mensagem quando se pretende saber qual ficheiro se deve abrir
         * @return sms
         */
	  public static final String openFile() {
              String sms = "Ficheiro a abrir: ";
	    return sms;
	  }
	  
	  
	
	  
	  /**
           * Metodo que imprime uma mensagem quando se pretende abrir um ficheiro e nao existe um associado no sistema
	   * @return string Message save As.
	   */
	  public static final String newSaveAs() {
              String sms = "Não existe ficheiro associado. Entrar nome de ficheiro:";
	    return sms;
	  }
	  
	  
	// Message for Menu GESTAO UTENTES interaction
	    /**
         * Metodo que imprime uma mensagem de pedido do nome do utente
         * @return sms
         */
	  public static String requestUserName() {
               String sms = "Nome do utente: ";
	    return sms;
	  }
	     /**
         * Metodo que imprime uma mensagem de pedido do email do utente
         * @return sms
         */
	  public static String requestUserEMail()
	  { 
              String sms = "E-Mail do utente:";
		  return sms;
	  }
	     /**
         * Metodo que imprime uma mensagem quando o utente foi registrado sem erro
         * @return sms
         */
	  public static String userRegistrationSuccessful()
	  {
		  return "Utente registado com sucesso.";
	  }
	     /**
         * Metodo que imprime uma mensagem de pedido do identificador do utente
         * @return sms
         */
	  public static String requestUserId()
	  {
              String sms = "Identificador do utente:"; 
              return sms;
	  }
	
	  
	// Message for Menu GESTAO OBRAS interaction
	  
	     /**
         * Metodo que imprime uma mensagem de pedido do titulo da Obra
         * @return sms
         */
	public static String requestTitle()
	{
             String sms = "Titulo da Obra:";
            return sms;
	}
	      /**
         * Metodo que imprime uma mensagem de pedido do preço da Obra
         * @return sms
         */
	public static String requestPrice()
	{
            String sms = "Preço da obra:";
		return sms;
	}
	     /**
         * Metodo que imprime uma mensagem de pedido do numero de exemplar da Obra
         * @return sms
         */
	public static String requestNumCopies()
	{   String sms =  "Número de exemplares:";
		return sms;
	}
	     /**
         * Metodo que imprime uma mensagem quando a Obra foi registrada sem erro
         * @return sms
         */
	public static String WorkRegistrationSuccessful()
	{
            String sms = "Obra registada com sucesso.";
		return sms;
		
	}
	
	     /**
         * Metodo que imprime uma mensagem de pedido do identificador da Obra
         * @return sms
         */
	public static String requestWorkId()
	{
            String sms = "Identificador da obra:";
		return sms;
	}
	
	     /**
         * Metodo que imprime uma mensagem de pedido do terma que se precisa para pesquisar de uma Obra
         * @return sms
         */
	public static String requestSearchTerm()
	{
             String sms = "Entrar o termo a procurar:";
		return sms;
	}
             /**
         * Metodo que imprime uma mensagem quando a obra que se pretende requisitar já nao há exemplares da mesma
         * @return sms
         */
	public static String requestReturnNotificationPreference()
	{
            String sms = "Deseja ser notificado da data devolução?";
		return sms;

	}
	
	/*
	public static String workReturnDay(String date)
	{
		// Obs: We need put the return date
		
		// make some operations do find the work return day
		// the final output will be something like:
		// return "Data de devolucao da obra:" + date;
		//
		return "Data de devolucao: " + date;
	}*/
	
	
	     /**
         * Metodo que imprime uma mensagem de pedido do tipo de Obra
         * @return sms
         */
	public static final String requestType() {
            String sms = "Escolha o tipo da Obra: ";
	    return sms;
	}
             /**
         * Metodo que imprime uma mensagem de pedido do Autor da Obra
         * @return sms
         */
	public static final String requestAuthor() {
	   String sms = "Autor: "; 
            return sms;
	}
             /**
         * Metodo que imprime uma mensagem de pedido do Realizador da Obra
         * @return sms
         */
	public static final String requestProducer() {
            String sms = "Realizador: ";
	    return sms;
	}
             /**
         * Metodo que imprime uma mensagem de pedido do categoria da Obra
         * @return sms
         */
	public static final String requestCategory() {
            String sms = "Escolha a categoria da Obra: ";
	    return sms;
	}
             /**
         * Metodo que imprime uma mensagem de pedido do ISBN da Obra
         * @return sms
         */
	public static final String requestISBN() {
            String sms = "Entre o ISBN: ";
	    return sms;
	}
	public static final String requestDNDAC() {
            String sms = "Entre o DNDAC: ";
	    return sms;
	}
           /**
         * Metodo que imprime uma mensagem de escolha de opcao
         * @return sms
         */
	public static final String selectAnOption() {
            String sms = "Escolha uma opção: ";
	    return sms;
	}
      
	
	  /**
          * Metodo que impreme sms quando outente ja encontra-se ativo
          * @return sms
          */
         public static final String utenteActivo(){
             String sms = "O o Utente informado encontra-se ATIVO";
             return sms;
         }
          /**
         * Metodo que imprime quando a multa foi paga sem erro
         * @return sms
         */
        public static final String finePaidSuccessfully(){
            String sms = "Multa paga com sucesso";
            return sms;
        }
}
