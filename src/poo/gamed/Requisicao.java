package poo.gamed;

import java.io.Serializable;

 /**
 * classe <code>Requisicao</code> responsavel por reunir todos os atributos que é necessario para fazer uma requisicao 
 * como: workId, userId, borrowDate e dateOfReturn.
 * esta  implementa a Interface Serializable.
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class Requisicao implements Serializable
{


        /**
	 * 
	 */
	private static final long serialVersionUID = -7621574083865354914L;
private String workId;
private int userId;
private String borrowDate;
private String dateOfReturn;


    /**
         * Metodo construtor sem parametro responsavel por istanciar esta classe sem passar os seus devidos valores
         *
         */
public Requisicao()
{

}
/**
 *  Metodo construtor da classe Requisicao com parametro responsavel por istanciar a classe com passagem dos seus devidos valores
 * @param workId
 * @param userId
 * @param borrowDate
 * @param returnDate 
 */
public Requisicao(String workId, int userId, String borrowDate, String returnDate)
{
this.workId = workId;
this.userId = userId;
this.borrowDate = borrowDate;
this.dateOfReturn = returnDate;
}




    /**
         * metodo ispetor que permite o retorno do valor do atriuto workId
         * @return workId
         */
public String getWorkId() {
return workId;
}
 /**
         * Metoto ispector que permite a passagem do valor do atributo  para o workId
         * @param workId 
         */
public void setWorkId(String workId) {
this.workId = workId;
}
    /**
         * metodo ispetor que permite o retorno do valor do atriuto userId
         * @return userId
         */
public int getUserId() {
return userId;
}
 /**
         * Metoto ispector que permite a passagem do valor do atributo  para o userId
         * @param userId 
         */
public void setUserId(int userId) {
this.userId = userId;
}
    /**
         * metodo ispetor que permite o retorno do valor do atriuto borrowDate
         * @return borrowDate
         */
public String getBorrowDate() {
return borrowDate;
}
 /**
         * Metoto ispector que permite a passagem do valor do atributo  para o borrowDate
         * @param borrowDate 
         */
public void setBorrowDate(String borrowDate) {
this.borrowDate = borrowDate;
}
    /**
         * metodo ispetor que permite o retorno do valor do atriuto dateOfReturn
         * @return dateOfReturn
         */
    public String getDateOfReturn() {
        return dateOfReturn;
    }
 /**
         * Metoto ispector que permite a passagem do valor do atributo  para o dateOfReturn
         * @param dateOfReturn 
         */
    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }






}