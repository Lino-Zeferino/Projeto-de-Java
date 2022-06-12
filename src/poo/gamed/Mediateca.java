package poo.gamed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import poo.gamed.exception.FineErrorException;

import poo.gamed.exception.UserRegistrationFailedException;
import poo.gamed.exception.WorkNotBorrowedByUserException;
import poo.gamed.exception.WorkRegistrationFailedException;
import poo.gamed.exception.NoSuchWorkException;
import poo.gamed.exception.RuleFailedException;
import poo.gamed.exception.NoSuchUserException;
import poo.gamed.ui.LabelMenu;

/**
 * <code>Medtiateca>/code> classe responsavel por reunir todos os elementos que uma Mediateca contem, como:
 * Obras que podem ser livros ou Dvds e todos os usuários e todos os pedidos
 *
 * * @author Lino_Zeferino
 */
public class Mediateca implements Serializable {

    private static final long serialVersionUID = 4436730676853423012L;

    /**
     * Metodo construtor sem parametro responsavel por istanciar esta classe sem
     * passar os seus devidos valores
     *
     */
    public Mediateca() {
    }

    private int obraNumber = 1;
    private int utenteID = 1;

    // Formatacao da data: dia/mes/ano
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // classe que nos dá a instancia de uma data do calendario
    private Calendar cal = Calendar.getInstance();

 /*Livros
      Estrutura de dados para armazenar todos os livros:
      chave = ID do trabalho
      valor = informações do livro (autor, título...)
      */
    private Map<String, Livro> livros = new TreeMap<String, Livro>();

  /*DVD
      Estrutura de dados para armazenar todos os DVDs:
      chave = ID do trabalho
      valor = informações do DVD (autor, título...)
      */
    private Map<String, DVD> dvds = new TreeMap<String, DVD>();

    /**
     *  Estrutura de dados para armazenar todos as obras: 
     * chave = ID do trabalho
     * valor = livro e DVD
     * 
     * */
    private Map<String, Object> obras = new TreeMap<String, Object>();


    /**
     * Utentes
     * Estrutura de dados para armazenar todos os Usuarios
     * chave= id do usuario
    **/
    private Map<Integer, Utente> utentes = new TreeMap<Integer, Utente>();

   /**
    * Requisitos
    * Estrutura de dados para armazenar o empréstimo dos usuários (obter livro ou DVD da biblioteca):
    *  key = dados do empréstimo (ID do usuário, ID do trabalho, data de devolução)
    *  valor = ID do usuário
    * */
    private Map<Requisicao, Integer> requisicoes = new HashMap<Requisicao, Integer>();

   /**
    * classe reponsavel por ler dados de um arquivo de teste 
    * por intermedio de entrada do nome do arquivo
    * @param ficheiro
    * @throws FileNotFoundException
    * @throws IOException
    * @throws UserRegistrationFailedException
    * @throws WorkRegistrationFailedException 
    */
    public void leituraFicheiroTexto(String ficheiro) throws FileNotFoundException, IOException, UserRegistrationFailedException, WorkRegistrationFailedException {
        //Regular expression pattern to match USER, Livro and DVD.
        Pattern patternUtente = Pattern.compile("USER");
        Pattern patternLivro = Pattern.compile("Livro");
        Pattern patternDVD = Pattern.compile("DVD");
        BufferedReader dados = new BufferedReader(new FileReader(ficheiro));

        String l; // cada linha do ficheiro

        while ((l = dados.readLine()) != null) {

            /*separ os dados da linha tendo em conta o formato do ficheiro
             * 
             * 	DVD:t�tulo:realizador:pre�o:categoria:n�meroDNDAC:exemplares
             Livro:t�tulo:autor:pre�o:categoria:ISBN:exemplares
             USER:nome:email
             * */
            String[] l_split = l.split(":");

            //verifica o pattern 
            if (patternUtente.matcher(l_split[0]).matches()) {
                // um utente:
                guardarUtente(l_split, 1);

            } else if (patternLivro.matcher(l_split[0]).matches()) {
                // um livro
                guardarObra(l_split, 1);
            } else if (patternDVD.matcher(l_split[0]).matches()) {
                // um DVD
                guardarObra(l_split, 2);
            } else {
                // Fazer nada:  arquivo mal formatado
            }

        }

        dados.close(); // fechar o ficheiro depois de ter lido os dados

    }

  /**
   * Metodo responsavel por guardar todos os dados de um utente
   * @param l_split
   * @param op
   * @throws UserRegistrationFailedException 
   */
    public void guardarUtente(String[] l_split, int op) throws UserRegistrationFailedException {
		// create a user

        Utente utente = null;
        if (op == 1) {
            // Dados do arquivo TEXT
            utente = new Utente(utenteID, l_split[1], l_split[2]);
        } else if (op == 2) {
            //Dados para serialização de objetos
            utente = new Utente(utenteID, l_split[1], l_split[2], "ACTIVO");
        }
        if (utente == null) {
            throw new UserRegistrationFailedException();
        }
        utentes.put(utenteID, utente);
        utenteID++;
    }
/**
 * * por padrão, o TreeMap organiza os dados dendo em conta as chaves
 *
 * so que a gente quer organizar os dados tento em conta os valores
 * para tal temos que utilizar uma Interface comparável e tambem o Comparador
 * isso porque pede-se que ao mostrar como devemos denando-los
 * lexicograficamente pelo nome
 * @param <K>
 * @param <V>
 * @param map
 * @return 
 */
  
    public <K, V extends Comparable<V>> Map<K, Utente>
            valueSort(final Map<K, Utente> map) {
        Comparator<K> valueComparator = new Comparator<K>() {

            public int compare(K k1, K k2) {

                int comp = map.get(k1).getName().compareTo(map.get(k2).getName());

                if (comp == 0) {
                    return 1;
                } else {
                    return comp;
                }
            }
        };

        Map<K, Utente> sorted = new TreeMap<K, Utente>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
/**
 * Metodo responsavel por pegar todos os utentes e depois retorna-os
 * @return utente
 */
    public Collection<Utente> getAllUtentes() {
	//antes de retornar todos os usuários classificam os dados dentro do TreeMap utentes
         // por valor (ordem alfabética)
        Map<Integer, Utente> sortedMap = valueSort(utentes);

        return sortedMap.values();

    }
/**
 * Metodo responsavel por pegar um utente de acordo o seu Id
 * @param id
 * @return
 * @throws NoSuchUserException 
 */
    public Utente getUtenteById(int id) throws NoSuchUserException {
        Utente utente = utentes.get(id);

        if (utente == null) {
            throw new NoSuchUserException();
        }
        return utente;

    }

   /**
    * Metodo responsavel por guardar uma obra
    * @param l_split
    * @param type
    * @throws WorkRegistrationFailedException 
    */
    public void guardarObra(String[] l_split, int type) throws WorkRegistrationFailedException {
        DVD dvd = null;
        Livro livro = null;
        // criacao do formato do id da obra: XXXX/AAAA
        String obraId = String.format("%04d", obraNumber) + "/" + cal.get(Calendar.YEAR);
        if (type == 1) {
			// if BOOK

            livro = new Livro(l_split[0], l_split[1], l_split[2], Float.parseFloat(l_split[3]), l_split[4], l_split[5], Integer.parseInt(l_split[6]),
                    obraId);
            obras.put(obraId, livro);
            livros.put(obraId, livro);

        } else if (type == 2) {
            // if DVD
            dvd = new DVD(l_split[0], l_split[1], l_split[2], Float.parseFloat(l_split[3]), l_split[4], l_split[5], Integer.parseInt(l_split[6]),
                    obraId);
            obras.put(obraId, dvd);
            dvds.put(obraId, dvd);

        } else {
            //fazer Nada
        }
        if (livro == null && dvd == null) {
            throw new WorkRegistrationFailedException();
        }

        obraNumber++;
    }

   /**
    * Metodo que pega todos os livros e os retorna
    * @return livros.values()
    */
    public Collection<Livro> getAllLivros() {

        return livros.values();

    }

   /**
    * Metodo que pega todas as obras, livos e dvds e as retorna
    * @return obras.values()
    */
    public Collection<Object> getAllWork() {

        return obras.values();

    }
/**
 * metodo  que pega uma obra de acordo o seu id e a retorna
 * @param id
 * @return obra
 * @throws NoSuchWorkException 
 */
    public Object getWorkById(String id) throws NoSuchWorkException {

        Object obra = obras.get(id);

        if (obra == null) {

            throw new NoSuchWorkException();
        }
        return obra;

    }
/**
 * Metodo que pega um livro de acordo o seu id e o retorna
 * @param id
 * @return livro
 * @throws NoSuchWorkException 
 */
    public Livro getLivroById(String id) throws NoSuchWorkException {
        Livro livro = livros.get(id);
        if (livro == null) {
            throw new NoSuchWorkException();
        }
        return livro;

    }
/**
 * Metodo  responsavel por pegar todos os dvds e os retorna
 * @return dvds.values()
 */
    public Collection<DVD> getAllDVD() {

        return dvds.values();

    }
/**
 * Metodo reponsavel por pegar um dev por id e o retorna
 * @param id
 * @return dvd
 * @throws NoSuchWorkException 
 */
    public DVD getDVDById(String id) throws NoSuchWorkException {
        DVD dvd = dvds.get(id);
        if (dvd == null) {
            throw new NoSuchWorkException();
        }
        return dvd;

    }

    /**
     * Metodo responsavel por Tratar a requisicao de obra( livros e DVDs)
     * 
     * @param workId
     * @param userId
     * @return isAdd
     * @throws RuleFailedException
     * @throws NoSuchUserException
     * @throws NoSuchWorkException 
     */
    public boolean addRequest(String workId, int userId) throws RuleFailedException, NoSuchUserException, NoSuchWorkException {
       /**
        * entrada: id de trabalho, id de usuário
          * saída :
          * true: o livro está disponível (solicitação aceita)
          * false: livro não disponível (veja regra 3 no enunciado)
          *
          * */
        boolean isAdd = true;
        if (checkRulesUser(workId, userId) && checkRulesWork(workId)) {
            if (workAvailable(workId)) {

                String borrowDate = (dateFormat.format(cal.getTime()));
                cal.setTime(cal.getTime());
                // O utilizador tem 5 dias para fazer a devolu��o do material emprestado
                cal.add(Calendar.DAY_OF_MONTH, 5);
                String dateToLend = (dateFormat.format(cal.getTime()));
                Requisicao request = new Requisicao(workId, userId, borrowDate, dateToLend);
                requisicoes.put(request, userId);

                // -1 available : -1 na quantidade de livros disponivel
                setAvailableWork(workId, -1);
                // set the default date
                cal.setTime(cal.getTime());
                cal.add(Calendar.DAY_OF_MONTH, -5);

            } else {
                isAdd = false;
            }
        }

        return isAdd;

    }
    /**
     * Metodo responsavel por tratar da multa de um utente
     */
    Manipulacao man = new Manipulacao();
     public boolean pagarMulta(int userId) throws NoSuchUserException, FineErrorException
		{
			boolean estado = true;
                       Utente utente =  getUtenteById(userId);

                        if(utente.equals("null")){
                            estado = false;
                        }

			//Verificar se o Utente esta realmente suspenso 
                    // casso esteja pedi para pagara o valor da multa
                        else if( getUtenteById(userId).getStatus().equalsIgnoreCase("SUSPENSO")){
			    man.fineAmount();// vai pedir para digitar o valor da multa
                           double multa = new Scanner(System.in).nextDouble();
                           if(multa >= 10000){
                               getUtenteById(userId).setStatus("ACTIVO");
                           }else{   
                               estado = false;
				        throw new FineErrorException();                  
			}
                   } else{
                        estado = false;
                   }
				
		return estado;	
		}
/**
 * Metod que aumenta o numero de exemplar de uma determinada oubra tendo enconta o seu id
 * @param workId
 * @param number
 * @throws NoSuchWorkException 
 */
    // Ver se a obra � um livro or um DVD (fun��o Auxiliar)
    public void setAvailableWork(String workId, int number) throws NoSuchWorkException {
        if (getWorkById(workId) instanceof Livro) {
            ((Livro) getWorkById(workId)).setAvailable(((Livro) getWorkById(workId)).getAvailable() + number);
        }
        if (getWorkById(workId) instanceof DVD) {
            ((DVD) getWorkById(workId)).setAvailable(((DVD) getWorkById(workId)).getAvailable() + number);
        }
    }
    
    /**
     * Metodo que verificar se a obra que esta a ser devolvida foi emprestada pelo o utente 
     * output:
     * 		WorkNotBorrowedByUserException se a obra nao foi emprestada pelo o usuario
     * 		requisicao data se a obra foi emprestada pelo usuario
     * @param workId
     * @param userId
     * @return request
     * @throws WorkNotBorrowedByUserException 
     */
    public Requisicao borrowedWorkById(String workId, int userId) throws WorkNotBorrowedByUserException {
        Requisicao request = null;
        for (Map.Entry<Requisicao, Integer> entry : requisicoes.entrySet()) {
            if (entry.getKey().getUserId() == userId) {
                if (entry.getKey().getWorkId().equals(workId)) {
                    request = entry.getKey();
                    break;
                } else {
                    // Obra a ser devolvida nao foi emprestada pelo o usuario entrado
                    throw new WorkNotBorrowedByUserException();
                }

            }
        }
        return request;
    }
/**
 * Metodo responsavel por retornar a tada de entregade uma obra requisitada
 * @param workId
 * @param userId
 * @return borrowedWorkById(workId, userId).getDateOfReturn()
 * @throws WorkNotBorrowedByUserException 
 */
    public String workReturnDay(String workId, int userId) throws WorkNotBorrowedByUserException {
        return borrowedWorkById(workId, userId).getDateOfReturn();
    }
/**
 * Metodo reponsavel por devolver uma determinada obra na mediateca
 * @param workId
 * @param userId
 * @throws NoSuchUserException
 * @throws WorkNotBorrowedByUserException
 * @throws NoSuchWorkException 
 */

    public void giveBackWork(String workId, int userId) throws NoSuchUserException, WorkNotBorrowedByUserException, NoSuchWorkException {
        // get today's date
        String returnDate = (dateFormat.format(cal.getTime()));

        // throw Exception if user didn't borrow the work
        Requisicao request = borrowedWorkById(workId, userId);
        // check return date
        if (request.getUserId() == userId && request.getWorkId().equals(workId)) {
            if (request.getDateOfReturn().compareTo(returnDate) < 0) {
                getUtenteById(userId).setStatus("SUSPENSO");
            }
        }
        // +1 available
        setAvailableWork(workId, +1);
        requisicoes.remove(request);

    }
    /**
     * Metodo responsavel por returnar o numero de obras ja requisitado por um utente
     * @param userId
     * @return number
     */

  
    public int numberOfRequest(int userId) {
        int number = 0;
        for (Map.Entry< Requisicao, Integer> entry : requisicoes.entrySet()) {

            if (entry.getKey().getUserId() == userId) {
                number++;

            }
        }
        return number;
    }
/**
 * Metodo que verifica se um determinado utente ja fez o emprestimo de uma determinada obra
 * @param workId
 * @param userId
 * @return borrowed
 */
    public boolean workBorrowed(String workId, int userId) {
        boolean borrowed = false;
        for (Map.Entry<Requisicao, Integer> entry : requisicoes.entrySet()) {

            if (entry.getKey().getUserId() == userId && entry.getKey().getWorkId().equals(workId)) {
                borrowed = true;

            }
        }
        return borrowed;
    }
    /**
     * Metodo responsavel por verificar as resgras a ter em consideracao no ato da requisicao de uma obra em funao do utente
     *  1.Noo pode requisitar duas vezes a mesma obra
     *  2.Nao pode requisitar obras um utente que esteja suspenso;
     *  4.Nao pode ter mais que n obras requisitadas em cada momento 
     * (valor base: 3);
     * @param workId
     * @param userId
     * @return true
     * @throws RuleFailedException
     * @throws NoSuchUserException 
     */


    public boolean checkRulesUser(String workId, int userId) throws RuleFailedException, NoSuchUserException {
        if (workBorrowed(workId, userId) || numberOfRequest(userId) > 3 || getUtenteById(userId).getStatus() == "SUSPENSO") {
            throw new RuleFailedException();
        }

        return true;
    }
/**
 * Metodo responsavel por verificar as resgras a ter em consideracao no ato da requisicao de uma obra em funao da Obra
 * 5.Nao pode requisitar obras de referencia
 * 6.Nao pode requisitar obras com um preço superior a Kz. 10.000,00;
 * @param workId
 * @return true
 * @throws RuleFailedException
 * @throws NoSuchWorkException 
 */
   
    public boolean checkRulesWork(String workId) throws RuleFailedException, NoSuchWorkException {
        if (getWorkById(workId) instanceof Livro) {
            if (((Livro) getWorkById(workId)).getCategory().equals(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS[0])
                    || ((Livro) getWorkById(workId)).getPrice() > 10000) {
                throw new RuleFailedException();
            }
        }

        if (getWorkById(workId) instanceof DVD) {
            if (((DVD) getWorkById(workId)).getCategory().equals(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS[0]) || ((DVD) getWorkById(workId)).getPrice() > 10000) {
                throw new RuleFailedException();
            }
        }
        return true;

    }
/**
 * Metodo responsavel por verificar se ainda exite exeplar de uma determinada obra
 * @param id
 * @return isAvailable
 * @throws NoSuchWorkException 
 */
    // 3.Nao pode requisitar obras cujos exemplares tenham sido ja todos requisitados
    public boolean workAvailable(String id) throws NoSuchWorkException {
        boolean isAvailable = true;
        if (getWorkById(id) instanceof Livro) {
            if (((Livro) getWorkById(id)).getAvailable() == 0) {
                isAvailable = false;
            }
        }

        if (getWorkById(id) instanceof DVD) {
            if (((DVD) getWorkById(id)).getAvailable() == 0) {
                isAvailable = false;
            }
        }

        return isAvailable;
    }

}
