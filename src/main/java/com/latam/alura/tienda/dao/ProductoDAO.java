package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDAO {
	
	private EntityManager em;
	
	public ProductoDAO(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);		
	}
	
	public void actualizar(Producto producto) {
        this.em.merge(producto);
    }

    public void remover(Producto producto) {
    	producto = this.em.merge(producto);
        this.em.remove(producto);
    }
    
    public Producto consultaId(Long id) {
    	return em.find(Producto.class, id);
    }
    
    public List<Producto> consultaNombre(String nombre) {
    	String jpql = "select p from Producto as p where p.nombre =:nombre";
    	return em.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }
    
    public List<Producto> consultaCategoria(String categoria) {
    	String jpql = "select p from Producto as p where p.categoria.nombre =:categoria";
    	return em.createQuery(jpql, Producto.class).setParameter("categoria", categoria).getResultList();
    }
    
    public BigDecimal consultaPrecioNombre(String nombre) {
    	String jpql = "select p.precio from Producto as p where p.nombre =:nombre";
    	return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }
    
    public List<Producto> consultarTodo(){
    	String jpql = "select p from Producto as p";
    	return em.createQuery(jpql, Producto.class).getResultList();
    }

}
