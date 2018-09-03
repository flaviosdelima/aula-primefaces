package br.com.rlsystem.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContasPagarDAO extends DAO {

	public void Salvar(ContasPagar contas_pagar){
		EntityManager em = getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(contas_pagar);
			em.getTransaction().commit();
		} catch(Exception ex){
			em.getTransaction().rollback();
		}
	}
	
	public List<ContasPagar> GetALL(){
		EntityManager em = getEntityManager();
		List<ContasPagar> lista = null;
		
		try{
			Query q = em.createQuery("select object(c) from ContasPagar as c");
			lista = q.getResultList();
		} catch(Exception ex){
			em.close();
		}
		
		return lista;
	}
}
