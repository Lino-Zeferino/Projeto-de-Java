package poo.gamed;

import java.io.Serializable;
/**
 * classe <code>Obra</code> responsavel por reunir todos os atributos que um Obra deve ter como Id, title, type e outros.
 * esta  implementa a Interface Serializable.
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class Obra implements Serializable	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7950293822245952195L;
	// formato XXXX/AAAA 
	// XXXX de 0001 até 9999 e AAAA (ano)
	// add automatically
	private String id;
	private int numberOfCopy;
	private String title;
	private float price;
	private String category;
	private String type;
	private int available;
	    /**
         * Metodo construtor sem parametro responsavel por istanciar esta classe sem passar os seus devidos valores
         *
         */
	public Obra()
	{}
        /**
         * Metodo construtor da classe Obra com parametro responsavel por istanciar a classe com passagem dos seus devidos valores
         * @param id
         * @param exemplares
         * @param title
         * @param price
         * @param category
         * @param type 
         */
	public Obra(String id, int exemplares, String title, float price, String category, String type)
	{
		this.id = id;
		this.numberOfCopy = exemplares;
		this.title = title;
		this.price = price;
		this.category = category;
		this.type = type;
		this.available = exemplares;
		
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto id
         * @return id
         */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto numberOfCopy
         * @return numberOfCopy
         */
	public int getNumberOfCopy() {
		return numberOfCopy;
	}
	public void setNumberOfCopy(int numberOfCopy) {
		this.numberOfCopy = numberOfCopy;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto title
         * @return title
         */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto price
         * @return price
         */
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	/**
         * metodo ispetor que permite o retorno do valor do atriuto category
         * @return category
         */
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto type
         * @return type
         */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto available
         * @return available
         */
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
           /**
         * metodo que permite imprimir os valor guardado nos atributod da classe Obra
         * @return toString()
         */
        
	public String toString() {
		return getId() + " - " + getType() + 
		  " - " + getTitle() + " - " + 
		 getCategory() + " - " + getNumberOfCopy() + " - " + getAvailable() + " - " + 
		 getPrice() ;
	}
}
