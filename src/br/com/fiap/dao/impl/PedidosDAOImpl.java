package br.com.fiap.dao.impl;


import javax.persistence.EntityManager;

import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.entity.Pedidos;

public class PedidosDAOImpl extends GenericDAOImpl<Pedidos> implements PedidosDAO {

	public PedidosDAOImpl(EntityManager em) {
		super(em);
	}
}
