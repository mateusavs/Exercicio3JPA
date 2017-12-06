package br.com.fiap.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	
	private  JpaUtil(){};
	
	public static EntityManagerFactory getInstance(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("Exercicio3JPA");
		}
		return factory;
	}
}