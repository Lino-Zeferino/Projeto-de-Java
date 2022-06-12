package poo.gamed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import poo.gamed.exception.NoSuchUserException;
import poo.gamed.exception.NoSuchWorkException;
import poo.gamed.exception.RuleFailedException;
import poo.gamed.exception.UserRegistrationFailedException;
import poo.gamed.exception.WorkNotBorrowedByUserException;
import poo.gamed.exception.WorkRegistrationFailedException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import poo.gamed.exception.FineErrorException;

/**
 * <code>MediatecaOffice</code> classe responsavel por reunir todos os metodos
 * que relacionam as funcionalidade do programa com ficheiros
 *
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class MediatecaOffice {

    private String ficheiro = new String();

    private Manipulacao manip = new Manipulacao();

    /**
     * Metodo responsavel por guardar dodos os dados do sistema em um ficheiro
     * ja existente
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void guardarFicheiro() throws FileNotFoundException, IOException {
        ObjectOutputStream dados = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(this.ficheiro)));
        dados.writeObject(manip);
        dados.close();

    }

    /**
     * Metodo responsavel por guardar dodos os dados do sistema em um ficheiro
     *
     * @param ficheiro
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void guardarFicheiro(String ficheiro) throws FileNotFoundException, IOException {
        ObjectOutputStream dados = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(ficheiro)));
        dados.writeObject(manip);
        dados.close();

        this.ficheiro = ficheiro;

    }

    /**
     * Metodo responsavel por Abrir um ficheiro e regarregar todos os dados para
     * o programa
     *
     * @param _ficheiro
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void abrirFicheiro(String _ficheiro) throws FileNotFoundException,
            IOException, ClassNotFoundException {
        ObjectInputStream data = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(_ficheiro)));

        manip = new Manipulacao();
        manip = (Manipulacao) data.readObject();
        data.close();

        this.ficheiro = _ficheiro;
    }

    /**
     * Metodo res+pnsavel por Abrir um ficheiro de texto e regarregar no
     * programa corrente
     *
     * @param ficheiro
     * @throws FileNotFoundException
     * @throws IOException
     * @throws UserRegistrationFailedException
     * @throws WorkRegistrationFailedException
     */
    public void leituraFicheiroTexto(String ficheiro) throws FileNotFoundException, IOException, UserRegistrationFailedException, WorkRegistrationFailedException {

        manip.leituraFicheiroTexto(ficheiro);

    }

    /**
     * Metodo responsavel por pegar um ficheiro e fazer o seu retorno
     *
     * @return ficheiro
     */
    public String getFicheiro() {
        return ficheiro;
    }

    /**
     * Metodo responsavel por fazer a passagem do valor do aributo ficheiro
     *
     * @param ficheiro
     */
    public void setFicheiro(String ficheiro) {
        this.ficheiro = ficheiro;
    }

    /**
     * metodo responsavel por fazer o retorno se o ficheiro esta ou não vazio
     *
     * @return !ficheiro.isEmpty()
     */
    public boolean checkFicheiro() {
        return !ficheiro.isEmpty();
    }

    /**
     * Metodo que adiciona um utente no Programa que posterior mente pode ou noa
     * ser guardado no sistem(Arquivo)
     * @param name
     * @param eMail
     * @throws UserRegistrationFailedException
     */
    public void addUtente(String name, String eMail) throws UserRegistrationFailedException {
        String[] data = {"USER", name, eMail};
        manip.guardarUtente(data, 2);

    }

    /**
     * Metodo ue faz o retorno de uma lista de todos os Utentes do Programa
     *
     * @return allUtentes
     */
    public ArrayList<String> showAllUtentes() {
        ArrayList<String> allUtentes = new ArrayList<String>();

        for (Utente utente : manip.getAllUtentes()) {
            allUtentes.add(utente.toString());
        }

        return allUtentes;
    }

    /**
     * metodo que lista um deterinado utente de a cordo o seu id
     *
     * @param id
     * @return manip.getUtenteById(id).toString()
     * @throws NoSuchUserException
     */
    public String showUtenteById(int id) throws NoSuchUserException {

        return manip.getUtenteById(id).toString();
    }

    /**
     * Metodo que adiciona uma deterninada obra no programa
     *
     * @param type
     * @param title
     * @param name
     * @param price
     * @param category
     * @param coparateNumber
     * @param exemplares
     * @throws WorkRegistrationFailedException
     */
    public void addObra(String type, String title, String name, float price, String category, String coparateNumber, int exemplares) throws WorkRegistrationFailedException {
        String[] data = {type, title, name, Float.toString(price), category, coparateNumber, Integer.toString(exemplares)};
        if (type.equals("Livro")) {
            manip.guardarObra(data, 1);
        } else if (type.equals("DVD")) {
            manip.guardarObra(data, 2);
        }

    }

    /**
     * Metodo que lista todas as Obras do Programa
     * @return allObras
     */
    public ArrayList<String> showAllObras() {
        ArrayList<String> allObras = new ArrayList<String>();

        for (Livro obra : manip.getAllLivros()) {
            allObras.add(obra.toString());
        }
        for (DVD obra : manip.getAllDVD()) {
            allObras.add(obra.toString());
        }
        Object ob;

        return allObras;
    }
    /*
     public ArrayList<String> showAllObras()
     {
     ArrayList<String> allObras = new ArrayList<String>();
		
     for(Object obra : mediateca.getAllWork())
     allObras.add(obra.toString());
		

     return allObras;
     }*/

    /*
     public String showLivroById(String id) throws  NoSuchWorkException
     {
		
	
     return mediateca.getLivroById(id).toString();
     }
     public String showDVDById(String id) throws  NoSuchWorkException
     {
	 
     return mediateca.getDVDById(id).toString();
     }*/
    /**
     * Metodo que lista uma de terminada obra de acordo ao seu id
     *
     * @param id
     * @return manip
     * @throws NoSuchWorkException
     */
    public String showObraById(String id) throws NoSuchWorkException {
        manip.setLivroToNull();
        manip.setDVDToNull();
        manip.setObraById(id);
        if (manip.getLivroById() != null) {
            return manip.getLivroById().toString();
        } else {
            return manip.getDvdById().toString();
        }

    }

    /*
     public String showObraById(String id) throws  NoSuchWorkException
     {
		
		
     return mediateca.getWorkById(id).toString();
     }*/
    /**
     * Metodo que faz uma pesquise de obra,de acordo o Autor, Realizzdor ou
     * titulo da obra
     *
     * @param word
     * @return allObras
     */
    public ArrayList<String> showWorksBySearch(String word) {
        ArrayList<String> allObras = new ArrayList<String>();
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        String sequence = null;
        for (Livro obra : manip.getAllLivros()) {
            sequence = obra.getAuthor() + obra.getTitle();
            matcher = pattern.matcher(sequence);
            if (matcher.find()) {
                allObras.add(obra.toString());

            }
        }

        for (DVD obra : manip.getAllDVD()) {
            sequence = obra.getRealizador() + obra.getTitle();
            matcher = pattern.matcher(sequence);
            if (matcher.find()) {
                allObras.add(obra.toString());

            }
        }

        /*
         for(Object obra : mediateca.getAllWork())
         {
			
         if (obra instanceof Livro)
         {
         sequence = ((Livro) obra).getAuthor() + ((Livro) obra).getTitle();
         matcher = pattern.matcher(sequence);
         if(matcher.find()) 
         {
         allObras.add(obra.toString());
			       
         }
	       
	        
         }
         if (obra instanceof DVD)
         {
         sequence = ((DVD) obra).getRealizador() + ((DVD) obra).getTitle();
         matcher = pattern.matcher(sequence);
         if(matcher.find()) 
         {
         allObras.add(obra.toString());
			        
         }
	       
	        
         }
	    	
         }*/
        return allObras;
    }

    /**
     * Metodo que faz a requisicao de uma obra
     *
     * @param workId
     * @param userId
     * @return manip.addRequest(workId, userId)
     * @throws RuleFailedException
     * @throws NoSuchUserException
     * @throws NoSuchWorkException
     */
    public boolean addRequest(String workId, int userId) throws RuleFailedException, NoSuchUserException, NoSuchWorkException {
        /*
         * true : Ask user if user want to know return date
         * false: show return date
         * 	
         * 
         * */

		//return mediateca.addRequest(workId, userId);
        return manip.addRequest(workId, userId);

    }
    /**
     * Metodo que faz a pagamento de uma multa
     * @param userId
     * @return manip.pagarMulta(userId)
     * @throws NoSuchUserException
     * @throws FineErrorException 
     */
          public boolean pagarMulta(int userId) throws NoSuchUserException, FineErrorException
		{
                    return manip.pagarMulta(userId);
                }

    /**
     * Metodo que retorna a data da devolucao de uma obra
     *
     * @return getReturnDate()
     */
    public String workReturnDay() {

        return "Data de devolucao: " + manip.getReturnDate();
    }
    /*
     public String showReturnDate(String workId, int userId) throws WorkNotBorrowedByUserException
     {
     return Message.workReturnDay(mediateca.workReturnDay(workId, userId));
     }*/

    /**
     * Metodo que retorna a data em que o utente fez a devolucao da obra
     *
     * @param workId
     * @param userId
     * @throws NoSuchUserException
     * @throws WorkNotBorrowedByUserException
     * @throws NoSuchWorkException
     */
    public void returnRequest(String workId, int userId) throws NoSuchUserException, WorkNotBorrowedByUserException, NoSuchWorkException {
        //mediateca.giveBackWork(workId, userId);
        manip.returnRequest(workId, userId);
    }
}
