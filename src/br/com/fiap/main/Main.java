package br.com.fiap.main;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.dao.JpaUtil;
import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.dao.impl.ClientesDAOImpl;
import br.com.fiap.dao.impl.PedidosDAOImpl;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class Main {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getInstance().createEntityManager();
		ClientesDAO clienteDAO = new ClientesDAOImpl(em);
		PedidosDAO pedidoDAO = new PedidosDAOImpl(em);
		
		Clientes c1 = new Clientes();
		c1.setNome("Mateus Santos");
		c1.setEmail("mateus.artur@hotmail.com");
		
		Clientes c2 = new Clientes();
		c2.setNome("George Santos");
		c2.setEmail("georarturvieirasantos@gmail.com");

		Pedidos p1 = new Pedidos();
		p1.setDescricao("Notebook");
		p1.setValor(5000.0);
		p1.setData(Calendar.getInstance());
		
		Pedidos p2 = new Pedidos();
		p2.setDescricao("Mouse");
		p2.setValor(150.0);
		p2.setData(Calendar.getInstance());

		Pedidos p3 = new Pedidos();
		p3.setDescricao("Teclado");
		p3.setValor(350.0);
		p3.setData(Calendar.getInstance());

		Pedidos p4 = new Pedidos();
		p4.setDescricao("Monitor");
		p4.setValor(1500.0);
		p4.setData(Calendar.getInstance());
		
		c1.adicionarPedidos(p1);
		c1.adicionarPedidos(p2);
		c2.adicionarPedidos(p3);
		c2.adicionarPedidos(p4);
		clienteDAO.adicionar(c1);
		clienteDAO.adicionar(c2);
				
		List<Clientes>clientes = clienteDAO.listar();
		clientes.stream().forEach(System.out::println);
		List<Pedidos>pedidos = pedidoDAO.listar();
		pedidos.stream().forEach(System.out::println);
		
		
	}

}
