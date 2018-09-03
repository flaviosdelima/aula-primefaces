package br.com.rlsystem.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FornecedorDAO extends DAO {

	public void Salvar(Fornecedor fornecedor){
		EntityManager em = getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
		} catch(Exception ex){
			em.getTransaction().rollback();
		}
	}
	
	public Fornecedor Get(int idFornecedor){
		EntityManager em = getEntityManager();
		return em.find(Fornecedor.class, idFornecedor);
	}
	
	public void Update(Fornecedor fornecedor){
		EntityManager em = getEntityManager();
		
		try{
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			f.setNome(fornecedor.getNome());
			f.setEndereco(fornecedor.getEndereco());
			f.setObs(fornecedor.getObs());
			f.setTelefone(fornecedor.getTelefone());
			em.getTransaction().commit();
		} catch(Exception ex){
			em.getTransaction().rollback();
		}
	}
	
	public void Delete(Fornecedor fornecedor){
		EntityManager em = getEntityManager();
		
		try{
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			em.remove(f);
			em.getTransaction().commit();
		} catch(Exception ex){
			em.getTransaction().rollback();
		}
	}
	
	public List<Fornecedor> GetALL(){
		EntityManager em = getEntityManager();
		List<Fornecedor> lista = null;
		
		try{
			Query q = em.createQuery("select object(f) from Fornecedor as f");
			lista = q.getResultList();
		} catch(Exception ex){
			em.close();
		}
		
		return lista;
	}
}
