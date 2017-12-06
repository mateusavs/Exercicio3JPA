package br.com.fiap.dao.impl;



import javax.persistence.EntityManager;

import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.entity.Clientes;

public class ClientesDAOImpl extends GenericDAOImpl<Clientes> implements ClientesDAO{

	public ClientesDAOImpl(EntityManager em) {
		super(em);
	}

}
