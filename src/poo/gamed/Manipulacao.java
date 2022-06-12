package poo.gamed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;
import poo.gamed.exception.FineErrorException;

import poo.gamed.exception.NoSuchUserException;
import poo.gamed.exception.NoSuchWorkException;
import poo.gamed.exception.RuleFailedException;
import poo.gamed.exception.UserRegistrationFailedException;
import poo.gamed.exception.WorkNotBorrowedByUserException;
import poo.gamed.exception.WorkRegistrationFailedException;
import poo.gamed.ui.LabelMenu;


/**
 * classe <code>Manipulacao</code> Responsavel por conter todos os metodos principais 
 * para a manipulacao das possiveis operacoes da Mediateca
 * @see Serializable
 * @author Lino_Zeferino
 */

public class Manipulacao implements Serializable

{

	private static final long serialVersionUID = 6322618632943474458L;
	 /**
         * Metodo construtor sem parametro responsavel por istanciar esta classe sem passar valores
         *
         */
	public Manipulacao()
	{
	}
	
	private int obraNumber = 1;
	private int utenteID = 1;
	
	// Format da data: dia/mes/ano
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	// pega a instancia de uma calandario
	private Calendar cal = Calendar.getInstance();
	
	private ArrayList<Utente> utentes = new ArrayList<Utente>();
	private ArrayList<Livro> livros= new ArrayList<Livro>();
	private ArrayList<DVD> dvds= new ArrayList<DVD>();
	private ArrayList<Requisicao> requests= new ArrayList<Requisicao>();
	private Livro livroById = null;
	private DVD dvdById = null;
	private String returnDate;
	
	
	
	/**
         * Metodo  que faz a leitura de um arquivo de texto
         * @param ficheiro
         * @throws FileNotFoundException
         * @throws IOException
         * @throws UserRegistrationFailedException
         * @throws WorkRegistrationFailedException 
         */
	public void leituraFicheiroTexto(String ficheiro) throws FileNotFoundException, IOException, UserRegistrationFailedException, WorkRegistrationFailedException
	{
		//Regular expression pattern to match USER, Livro and DVD.
		Pattern patternUtente = Pattern.compile("USER");
		Pattern patternLivro = Pattern.compile("Livro");
		Pattern patternDVD = Pattern.compile("DVD");
		 BufferedReader dados = new BufferedReader(new FileReader(ficheiro));

		    String l; // cada linha do ficheiro

		    while ((l = dados.readLine()) != null) 
		    {
		    	
		    	 /*separ os dados da linha tendo em conta o formato do ficheiro
		    	  * 
		    	  * 	DVD:t�tulo:realizador:pre�o:categoria:n�meroDNDAC:exemplares
						Livro:t�tulo:autor:pre�o:categoria:ISBN:exemplares
						USER:nome:email
		    	  * */
		      String[] l_split = l.split(":");
		      
		      //check the pattern 
		      if (patternUtente.matcher(l_split[0]).matches())
		      {
		    	  // � um utente:
		    	  guardarUtente(l_split, 1);
		    	  
		      }
		      else if (patternLivro.matcher(l_split[0]).matches())
		      {
		    	 // � um livro
		    	  guardarObra(l_split,1);
		      }
		      else if (patternDVD.matcher(l_split[0]).matches())
		      {
		    	  // � um DVD
		    	  guardarObra(l_split,2);
		      }
		      else
		      {
		    	  // DO nothing:  bad file format
		      }
		      
		    }
		    
		    dados.close(); // fechar o ficheiro depois de ter lido os dados

	}
	
	/**
         * Metodo que guarda um determinado utente em Uma lista de Utentes
         * @param l_split
         * @param op
         * @throws UserRegistrationFailedException 
         */
	public void guardarUtente(String[] l_split, int op) throws UserRegistrationFailedException
	{
		// create a user
		Utente utente = null;
		if(op == 1)
		{
			// Data from TEXT file
			utente = new Utente(utenteID,l_split[1], l_split[2]);
		}
		else if (op == 2)
		{
			// Data for Object Serialization
			utente = new Utente(utenteID,l_split[1], l_split[2], "ACTIVO");
		}
		if (utente == null)
		{
			throw new UserRegistrationFailedException();
		}
		utentes.add(utente);
		utenteID++;
	}
	/**
         * Metodo que guarda uma determinada obra(Livro ou dvs)
         * @param l_split
         * @param type
         * @throws WorkRegistrationFailedException 
         */
	//guardar DVD ou livro  = meter o dvd na lista de dvds ou livro na lista de livros
	public void guardarObra(String[] l_split, int type) throws WorkRegistrationFailedException
	{
		DVD dvd = null;
		Livro livro = null;
		// create id format: XXXX/AAAA
		String obraId = String.format("%04d", obraNumber ) + "/" + cal.get(Calendar.YEAR);
		if(type ==1)
		{
			// if BOOK
			
			livro = new Livro(l_split[0],l_split[1],l_split[2],Float.parseFloat(l_split[3]), l_split[4], l_split[5],Integer.parseInt(l_split[6]),
					 obraId);
			livros.add(livro);
			
		}
		else if (type ==2)
		{
			// if DVD
			dvd = new DVD(l_split[0],l_split[1],l_split[2],Float.parseFloat(l_split[3]), l_split[4], l_split[5],Integer.parseInt(l_split[6]),
					 obraId);
			
			dvds.add(dvd);
			
			
			
		}
		else
		{
			//Do nothing
		}
		if (livro==null && dvd==null)
		{
			throw new WorkRegistrationFailedException();
		}
		
		obraNumber++;
	}
	/**
         * * Manipulacao auxiliares:
	 * recuperar livro com ajuda de id
         * @param id 
         */
	
	public void setLivroById(String id) 
	{
		
		for(Livro l: livros)
		{
			if(l.getId().equals(id))
			{
				livroById = l;
				break;
			}
		}
		
		
	}
	/**
         * Manipulacao auxiliares:
	 * recuperar  dvd  com ajuda de id
         * @param id 
         */
	
	public void setDVDById(String id) 
	{
		
		for(DVD d: dvds)
		{
			if(d.getId().equals(id))
			{
				dvdById = d;
				
				break;
			}
		}
		
	}
	/**
         * recuperar  uma obra com ajuda de id
         * @param id
         * @throws NoSuchWorkException 
         */
	public void setObraById(String id) throws NoSuchWorkException
	{
		setDVDById(id);
		setLivroById(id);
		if (livroById == null && dvdById == null)
		{
			throw new NoSuchWorkException();
		}
		
	}
        /**
         *  Manipulacao auxiliares:
	 * recuperar  utente com ajuda de id
         * @param userId
         * @return user
         * @throws NoSuchUserException 
         */
	
	public Utente getUtenteById(int  userId) throws NoSuchUserException 
	{
		Utente user = null;
		
		for(Utente s: utentes)
		{
			if(s.getId() == userId)
			{
				user = s;
				// Encontramos o que estavamos a procurar, deixa-se a loop
				// para evitar mais procuras
				break;
			}
		}
		if (user == null)
		{
			throw new NoSuchUserException();
		}
		return user;
		
	}
	/**
         * Metodo que pega todos os dvds da lista e os retorna
         * @return dvds
         */

	public ArrayList<DVD> getAllDVD()
	{
		
		return dvds;
		
	}
	
	/**
         * Metodo que pega todos os livros da lista e os retorna
         * @return livros
         */

	public ArrayList<Livro> getAllLivros()
	{
		
		return livros;
		
	}
        /**
         * Recuperar todos os utentes:
	 * 	aqui vamos organizar a saida em ordem 
         * @return utentes
         */

	public ArrayList<Utente> getAllUtentes()
	{
		//Sorting using sort method of Collections class
		// Collection.sort(Object_To_Sort, Comparator)
		Collections.sort(utentes,new UtenteComparator());
		return  utentes;	
		
	}

	
/**
 * Metodo que Validar uma requisicao:
 * aceitar ou n�o uma requisicao
 * @param workId
 * @param userId
 * @return isAdd
 * @throws RuleFailedException
 * @throws NoSuchUserException
 * @throws NoSuchWorkException 
 */
	
	public boolean addRequest(String workId,int userId) throws RuleFailedException, NoSuchUserException, NoSuchWorkException 
	{
		/* input: work id, user id
		 * output : 
		 * 		true:  Book is Available (request accepted)
		 * 		false: book not available (veja regra 3 no enunciado)
		 * 
		 * */
		boolean isAdd = true;	// todos os requisitos estao conforme
		if (checkRulesUser(workId, userId) && checkRulesWork(workId))
		{
			if(workAvailable(workId))
			{
				
				String borrowDate = (dateFormat.format(cal.getTime()));
				cal.setTime(cal.getTime());
				// O utilizador tem 5 dias para fazer a devolucao do material emprestado
				cal.add(Calendar.DAY_OF_MONTH, 5);
				returnDate = (dateFormat.format(cal.getTime()));
				Requisicao request = new Requisicao(workId, userId, borrowDate, returnDate);
				requests.add(request);
				
				// -1 available : -1 na quantidade de livros disponivel
				setAvailableWork(workId, -1);
				// set the default date
				cal.setTime(cal.getTime());
				cal.add(Calendar.DAY_OF_MONTH, -5);
				
			}
			else
			{
				//Request denied (causa:todos os exemplares da obra ja foram requisitados)
				isAdd = false; 
			}
		}
		
		
		// true: request accepted or if True
		// false : Request denied (cause:todos os exemplares da obra ja foram requisitados)
		return isAdd;
		
	}
	/**
         * Metodo que trada a devolucao de uma obra
         * @param workId
         * @param userId
         * @throws NoSuchUserException
         * @throws WorkNotBorrowedByUserException
         * @throws NoSuchWorkException 
         */
	
		public void returnRequest(String workId,int userId) throws NoSuchUserException, WorkNotBorrowedByUserException, NoSuchWorkException
		{
			// data em que o utente esta a fazer a devolucao
			// para saber se o utente respeitou a data de devolucao (data data no momento da requisicao)
			String returnDate = (dateFormat.format(cal.getTime()));
			
			// Verificar se o livro a ser devolvido foi requisitado pelo o utente
			Requisicao request = checkWorkRequest(workId,userId);
			// verificar se  o utente ultrapassou a data limite de devolu��o
			// se sim meter mudar o estatuto do utente (meter SUSPENSO)
			
			if(request.getDateOfReturn().compareTo(returnDate)<0)
			{
				getUtenteById(userId).setStatus("SUSPENSO");
			}
				
			
			// +1 available
			setAvailableWork(workId, +1);
			requests.remove(request);
			
			
		}
                /**
                 * Metodo responsavel por fazer a manipulacao da funcao pagar multa
                 * @param userId
                 * @return estado
                 * @throws NoSuchUserException
                 * @throws FineErrorException 
                 */
             public boolean pagarMulta(int userId) throws NoSuchUserException, FineErrorException
		{
			boolean estado = true; 
                    Utente utente =  getUtenteById(userId);

                        if(utente.equals("null")){
                            estado = false;
                        }
                        else if( getUtenteById(userId).getStatus().equalsIgnoreCase("SUSPENSO")){
			    fineAmount();// vai pedir para digitar o valor da multa
                           double multa = new Scanner(System.in).nextDouble();
                           if(multa >= 10000){
                               getUtenteById(userId).setStatus("ACTIVO");
                           }else{   
                               estado = false;
				        throw new FineErrorException();                  
			}
                   } else{
                        estado = false;
                             // utente ja esta ativo

                   }
				
		return estado;	
		}
                
                /**
                 * Metodo Auxiliares usados para tratar a parte da requisicao
                 *  Recuperar todas as requisicoes
                 * @return request
                 */
	
	
	public ArrayList<Requisicao> getAllRequest()
	{
		
		return requests;
		
	}
	/**
         * Metodo que pega todas as requisicoes feitas por um utente
         * @param userId
         * @return 
         */
	
	public ArrayList<Requisicao> allUserRequest(int userId)
	{
		ArrayList<Requisicao> allUserRequest = new ArrayList<Requisicao>();
		for(Requisicao request: requests)
		{
			if (request.getUserId() == userId)
			{
				allUserRequest.add(request);
			}
		}
		
		return allUserRequest;
	}
	
	/**
         * metodo que verifica se o utente tem a mesma obra
	 * requisitada duas vezes
         * @param workId
         * @param userId
         * @return 
         */
	
	public boolean checkDuplicate(String workId, int userId)
	{
		boolean isDuplicate = false;
		
		for(Requisicao request: allUserRequest(userId))
		{
			if (request.getWorkId().equals(workId))
			{
				isDuplicate = true;
				
			}
			
		}
		
		return isDuplicate;
	}
        /**
         * Metodo que pega o numero de requisicao de um utente
         * @param userId
         * @return size()
         */
	
	public int  numberOfRequest(int userId)
	{
		return allUserRequest(userId).size();
	}
	/**
         * Metodo que verificar se a obra a devolver foi requisitada pelo usuario
         * @param workId
         * @param userId
         * @return _request
         * @throws WorkNotBorrowedByUserException 
         */
	
	public Requisicao checkWorkRequest(String workId, int userId) throws WorkNotBorrowedByUserException
	{
		Requisicao _request = null;
		
		for(Requisicao request: allUserRequest(userId))
		{
			if (request.getWorkId().equals(workId))
			{
				_request = request;
				
			}
			
		}
		if(_request == null)
		{
			// Obra a ser devolvida n�o foi emprestada pelo o usuario entrado
			throw new WorkNotBorrowedByUserException();
		}
		
		return _request;
	}
	
	
	/**
         *  Metodo que Verifica�ao das regras de requisicao
	 * 
	 *  1.Nao pode requisitar duas vezes a mesma obra
	 *  2.Nao pode requisitar obras um utente que esteja suspenso;
	 *  4.Nao pode ter mais que n obras requisitadas em cada momento 
	 * (valor base: 3);
         * @param workId
         * @param userId
         * @return true
         * @throws RuleFailedException
         * @throws NoSuchUserException 
         */
	
	public boolean checkRulesUser(String workId, int userId) throws RuleFailedException, NoSuchUserException 
	{
		if (checkDuplicate(workId, userId) || numberOfRequest(userId)>3 || getUtenteById(userId).getStatus()=="SUSPENSO")
		{
				throw new RuleFailedException();
		}
		
		return true; // Usuario respeitou as regras
	}
        /**
         * Metodo que erificar se o livro ou o DVD respeita as regras impostas
	 * 5.Nao pode requisitar obras de referencia
	 * 6.Nao pode requisitar obras com um pre�o superior a Kz. 10.000,00;
         * @param workId
         * @return true
         * @throws RuleFailedException
         * @throws NoSuchWorkException 
         */
	
	public boolean checkRulesWork(String workId) throws RuleFailedException,  NoSuchWorkException
	{

			// verifica nos livros primeiros
			// se nao existir nos livros verificar nos DVDs
			// se nenhuma Exception é lançada o livro pode ser requisitado
		setLivroToNull();
		setDVDToNull();
		setObraById(workId);
		if (livroById!=null && dvdById==null )
		{
			if(livroById.getCategory().equals(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS[0]) || livroById.getPrice()>10000)
			{
				
				throw new RuleFailedException();
			}
		}
		
		if (dvdById != null  && livroById==null)
		{
			 if(dvdById.getCategory().equals(LabelMenu.CATEGORIA_OBRA_MENU_OPTIONS[0]) ||dvdById.getPrice()>10000)
			{
				
				throw new RuleFailedException();
			}
		}
		return true; // (Livro ou DVD pode ser requisitado)
		
		
	}
        /**
         * Metodo que verifica se os exemplar de uma determinada obra ja foi toda requisitada
         * @param workId
         * @return isAvailable
         * @throws NoSuchWorkException 
         */
	
	// 3.N�o pode requisitar obras cujos exemplares tenham sido todos requisitados
		public boolean workAvailable(String workId) throws NoSuchWorkException
		{
			boolean isAvailable = true; 
			setLivroToNull();
			setDVDToNull();
			setObraById(workId);
			if (livroById!=null && dvdById==null )
			{
				if(livroById.getAvailable()==0)
				{
					
					isAvailable = false;
				}
			}
			
			if (dvdById !=null  && livroById==null)
			{
				if(dvdById.getAvailable()==0)
				{
					
					isAvailable = false;
				}
			}
			
			
			return isAvailable;
		}
		
		/**
                 * Metodo que Reduzir o numero de obras disponiveis depois de uma requisicao
		 * Aumentar o numero de obras disponiveis depois de uma devolucao
                 * @param workId
                 * @param number
                 * @throws NoSuchWorkException 
                 */
		public void setAvailableWork(String workId, int number) throws NoSuchWorkException
		{
			Object obj =  whichObject(workId);
			setLivroToNull();
			setDVDToNull();
			setObraById(workId);
			if (obj  instanceof Livro )
			{
				livroById.setAvailable(livroById.getAvailable() + number);
			}
			if (obj  instanceof DVD )
			{
				dvdById.setAvailable(dvdById.getAvailable() + number);
			}
			
		}
                /**
                 * metodo que permete saber qual dos materias esta a ser requisitado
		 * (Livro ou DVD), 
                 */
		public Object whichObject(String workId)
		{
			Object obj = null;
			for(Livro l: livros)
			{
				if (l.getId().equals(workId))
				{
					obj = l;
					
				}
				
			}
			for(DVD d: dvds)
			{
				if (d.getId().equals(workId))
				{
					obj = d;
					
				}
				
			}
			return obj;
		}
    /**
         * metodo ispetor que permite o retorno do valor do atriuto livroById
         * @return livroById
         */
		public Livro getLivroById() {
			return livroById;
		}
         /**
         * metodo ispetor que permite o retorno do valor do atriuto dvdById
         * @return dvdById
         */
		public DVD getDvdById() {
			return dvdById;
		}
		  /**
    * metodo ispetor que permite  instaciar o atributo livroById com valor Null
    */
		public void  setLivroToNull() {
			livroById = null;
		}
   /**
    * metodo ispetor que permite  instaciar o atributo dvvById com valor Null
    */
		public void setDVDToNull() {
			 dvdById = null;
		}
         /**
         * metodo ispetor que permite o retorno do valor do atriuto returnDate
         * @return returnDate
         */
		public String getReturnDate()
		{
			return returnDate;
		}
                //Metodos auxiliar do pagar multa
	 
        /**
         * Metodo que pede para informar o valor da multa
         * @return sms
         */
         public String fineAmount(){
            String sms = "Digite o valor da Multa (Multa >= 10.000kz):";
            return sms;
        }
       
}
