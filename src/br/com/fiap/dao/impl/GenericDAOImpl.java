package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {
	
	private final Class<T> classe; 
	
	protected EntityManager em;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void adicionar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	

	@SuppressWarnings("unchecked") 
	
	@Override
	public List<T> listar() {
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}
	
	@Override
	public void remover(T entidade) {
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
	}
	
	@Override
	public T buscar(int id) {
		em.getTransaction().begin();
		T entidade = em.find(classe,id);
		em.getTransaction().commit();
		return entidade;
	}
}