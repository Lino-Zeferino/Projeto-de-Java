package poo.gamed;

import java.io.Serializable;
/**
 * classe <code>Utente</code> responsavel por reunir todos os atributos que um Obra deve ter como Id, name, email e outros.
 * esta  implementa a Interface Serializable.
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class Utente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String eMail;
	private String status="";
        
	  /**
         * Metodo construtor se parametro responsavel por istanciar uma classe sem passar os seus devidos valores
         *
         */
	public Utente()
	{}
        /**
         * Metodo construtor da classe Utente com parametro responsavel por istanciar a classe com passagem dos seus devidos valores com excepcao do id
         * @param name
         * @param eMail 
         */
	public Utente(String name, String eMail)
	{
		this.name = name;
		this.eMail = eMail;
	}
        /**
         * Metodo construtor da classe Utente com parametro responsavel por istanciar a classe com passagem dos seus devidos valores
         * @param id
         * @param name
         * @param email
         * @param status 
         */
	public Utente(int id, String name, String email, String status)
	{
                this.eMail = email;
          	this.name = name;
		this.id = id;
		this.status = status;
		
	}
        /**
         * Metodo construtor da classe Utente com parametro responsavel por istanciar a classe com passagem dos seus devidos valores com excepcao do status
         * @param id
         * @param name
         * @param eMail 
         */
	public Utente(int id, String name, String eMail)
	{
		this.name = name;
		this.eMail = eMail;
		this.id = id;
	}
           /**
         * Metoto ispector que permite a passagem do valor do atributo  para o id
         * @param id 
         */
	public void setId(int id) {
		this.id = id;
	}
          /**
         * metodo ispetor que permite o retorno do valor do atriuto id
         * @return id
         */
        public int getId() {
		return id;
	}
          
          /**
         * metodo ispetor que permite o retorno do valor do atriuto name
         * @return name
         */
	public String getName() {
		return name;
	}
         /**
         * Metoto ispector que permite a passagem do valor do atributo  para o name
         * @param name 
         */
	public void setName(String name) {
		this.name = name;
	}
          /**
         * metodo ispetor que permite o retorno do valor do atriuto eMail
         * @return eMail
         */
	public String geteMail() {
		return eMail;
	}
            /**
         * Metoto ispector que permite a passagem do valor do atributo  para o eMail
         * @param eMail 
         */
	public void seteMail(String email) {
           
              this.eMail = email;
	}
          /**
         * metodo ispetor que permite o retorno do valor do atriuto status
         * @return status
         */
	public String getStatus() {
		return status;
	}    /**
         * Metoto ispector que permite a passagem do valor do atributo  para o status
         * @param status 
         */
	public void setStatus(String status) {
		this.status = status;
	}
          /**
         * metodo que permite imprimir os valor guardado nos atributod da classe Utente
         * verificando o seu status
         * @return toString()
         */
	public String toString() {
		if(!status.isEmpty())
		{
			return id + " - " + name + " - " + eMail + " - " + status;
		}
		else
		{
			// there is no status in txt file
			return id + " - " + name + " - " + eMail ;
		}
	    
  }
	
	
	

}
