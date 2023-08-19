package com.latam.alura.tienda.dao;
import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;


public class CategoriaDAO {
	
	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}
}

/*¿Cuál de las siguientes opciones permite actualizar los registros existentes 
 * en la base de datos?
 * 
 *	em.getTransaction().begin();
	em.persist(producto);
	producto.setDescripcion (“Teste 1”);
	em.getTransaction().commit();
	El método commit sincroniza los datos con la base de datos de forma definitiva.
	
	
	em.getTransaction().begin();
	em.persist(producto);
	producto.setDescripcion (“Teste 1”);
	em.flush();
	El método flush sincroniza los datos con la base de datos y permite realizar 
	un roll back en caso de errores.
 * 
 */


/*	em.getTransaction().begin();
	Producto producto = em.find(Producto.class, 1l);
	producto.setDescripcion(“Test 1”);
	em.flush();
	producto.setDescripcion(“Test 2”);
	em.merge(producto);
	producto.setDescripcion(“Test 3”);
	em.getTransaction().commit();
	em.close();
	
	La entidad producto se actualizará en la base de datos 
	con la descripción Teste 3.
 *  En el código anterior, merge acabó siendo indiferente, 
 *  pues la entidad ya estaba en estado Managed.
 */


/* ¿Cuál es la finalidad del método merge?
 * Traer los registros deseados con estado managed.
 * Pero en una diferente ubicación en memoria, por lo que 
 * tenemos que reasignar la variable que se encuentra como detached.
 */


/*	em.getTransaction().begin();
	Producto producto = em.find(Producto.class, 1l);
	producto.setDescripcion(“Teste 1”);
	em.flush();
	em.clear();
	em.remove(producto);
	em.getTransaction().commit();
	em.close();
	Alternativas:
	
	Una exception será lanzada al tentar remover la entidad producto.
	La entidad producto estaba en estado Detached al ser removida, 
	algo que JPA no permite.
 * 
 * 
 * https://caelum-online-public.s3.amazonaws.com/1954-persistencia-jpa-hibernate/img_aula4_a.JPG
 */