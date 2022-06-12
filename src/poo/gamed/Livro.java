package poo.gamed;

import java.io.Serializable;
/**
 * classe <code>Livro</code> responsavel por reunir todos os atributos que um livro deve ter como Autor, ISBN e outros.
 * esta classe estende da classe Obra por ser uma Obra e implementa a Interface Serializable.
 * @see Obra
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class Livro extends Obra implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String author;
	// String com 10 caracter
	// para contar o numero de caracter usamos  o metodo String.length 
	
	private String ISBN;
           /**
         * Metodo construtor se parametro responsavel por istanciar uma classe sem passar os seus devidos valores
         *
         * 
         */
	public Livro()
	{}
        /**
         * Metodo construtor da classe Livro com parametro responsavel por istanciar a classe com passagem dos seus devidos valores
         * @param type
         * @param title
         * @param name
         * @param price
         * @param category
         * @param coparateNumber
         * @param exemplares
         * @param id 
         */
	public Livro(String type, String title, String name, float price, String category,String coparateNumber,  int exemplares, String id)
	{
		super(id, exemplares, title,price, category, type);
		this.author = name;
		this.ISBN = coparateNumber;
	
	}
	
	/**
         * metodo ispetor que permite o retorno do valor do atriuto author
         * @return author
         */
	public String getAuthor() {
		return author;
	}
           /**
         * Metoto ispector que permite a passagem do valor do atributo  para o author
         * @param author 
         */
	public void setAuthor(String author) {
		this.author = author;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto ISBN
         * @return ISBN
         */
	public String getISBN() {
		return ISBN;
	}
           /**
         * Metoto ispector que permite a passagem do valor do atributo  para o ISBN
         * @param ISBN 
         */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	   /**
         * metodo que permite imprimir os valor guardado nos atributod da classe Livro
         * @return toString()
         */
	public String toString() {
		return super.toString() + " - " + author + " - " + ISBN;
	}
}
