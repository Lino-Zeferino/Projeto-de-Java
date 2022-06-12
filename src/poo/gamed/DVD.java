package poo.gamed;

import java.io.Serializable;

/**
 * classe <code>DVD</code> responsavel por reunir todos os atributos que um dvd deve ter como Realizador DNDAC e outros.
 * esta classe estende da classe Obra por ser uma Obra e implementa a Interface Serializable.
 * @see Obra
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class DVD extends Obra implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
// atributos particularizados da classe DVD
	private String realizador;
	private String DNDAC;
        
        /**
         * Metodo construtor se parametro responsavel por istanciar uma classe sem passar os seus devidos valores
         *
         * 
         */
	public DVD()
	{}
          /**
         * Metodo construtor da classe DVD com parametro responsavel por istanciar a classe com passagem dos seus devidos valores
         * @param  type, title, name, price, category,coparateNumber,exemplares,id
         * 
         */
	public DVD(String type, String title, String name, float price, String category,String coparateNumber,  int exemplares, String id) 
	{
		super(id, exemplares, title, price, category, type);
		this.realizador = name;
		this.DNDAC = coparateNumber;
	}
	
	/**
         * metodo ispetor que permite o retorno do valor do atriuto Realizador
         * @return realizador
         */
	public String getRealizador() {
		return realizador;
	}
        /**
         * Metoto ispector que permite a passagem do valor do atributo  para o realizador
         * @param realizador 
         */
	public void setRealizador(String realizador) {
		this.realizador = realizador;
	}
        /**
         * metodo ispetor que permite o retorno do valor do atriuto DNDAC
         * @return DNDAC
         */
	public String getDNDAC() {
		return DNDAC;
	}
           /**
         * Metoto ispector que permite a passagem do valor do atributo  para o dNDAC
         * @param dNDAC 
         */
	public void setDNDAC(String dNDAC) {
		DNDAC = dNDAC;
	}
          /**
         * metodo que permite imprimir os valor guardado nos atributod da classe DVD
         * @return toString()
         */
	public String toString() {
		return super.toString() + " - " + realizador + " - " + DNDAC;
	}

}
