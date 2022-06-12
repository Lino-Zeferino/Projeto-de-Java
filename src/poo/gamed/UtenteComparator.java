package poo.gamed;

import java.util.Comparator;
/**
 * classe <code>UtenteComparator</code> responsavel por fazer a manipulacao da comparacao dos atributos de dois Utentes.
 * esta  implementa a Interface Serializable.
 * @see Serializable
 * @author Lino_Zeferino
 * @version 1.0
 * @since 1.0
 */
public class UtenteComparator implements Comparator<Utente>  {
/**
 * <code>compare</code> Metodo  responsavel por fazer a comparacao entre dois utentes, tendo em conta os seus nome.
 * caso der diferente vai chamar a funcao compareId, para verificar de acordo os seus id's
 * @param o1
 * @param o2
 * @return 
 */
	@Override
	public int compare(Utente o1, Utente o2) {
		// TODO Auto-generated method stub
		 int compareValue = o1.getName().compareTo(o2.getName());
		 // se os utentes tem o mesmo nome compare os ID
		 // � o valor do ID que vai fixar a ordem
		 if (compareValue  == 0)
		 {
			 compareValue  = compareId( o1.getId(),  o2.getId()) ;
		 }
		return compareValue ;
	}
/**
 * <code>compareId</code> Metodo  responsavel por fazer a comparacao entre dois utentes, tendo em conta os seus id
 * @param id1
 * @param id2
 * @return 
 */
        public int compareId(int id1, int id2)
	{
		if (id1 == id2)
            return 0;
        else if (id1 > id2)
            return 1;
        else
            return -1;
	}

}
