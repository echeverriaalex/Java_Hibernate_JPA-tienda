package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

/*
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
*/

import javax.persistence.EntityManager;
import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaId(1l);
		
		System.out.println(producto.getNombre());

		//List<Producto> productos = productoDAO.consultarTodo();
		//List<Producto> productos = productoDAO.consultaNombre("Samsung S23 ULTRA");
		List<Producto> productos = productoDAO.consultaCategoria("Celulares");
		productos.forEach(produc-> System.out.println(produc.getDescripcion()));
		
		BigDecimal precio= productoDAO.consultaPrecioNombre("Samsung S23 ULTRA");
		System.out.println(precio);
		
		/*
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);		
		celulares.setNombre("Softwares");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);		
		em.remove(celulares);
		em.flush();
		*/
		
		
		
	}
	
	private static void registrarProducto() {
		
		Categoria celulares = new Categoria("Celulares");		
		Producto celular = new Producto("Samsung S23 ULTRA", "el mas caro de los Samsungs", new BigDecimal("2000"), celulares);

		// esto es la conexion
		EntityManager em = JPAUtils.getEntityManager();
		
		/*¿Cuándo debemos iniciar y comitar una transacción al persistir una unidad?
		 * Al realizar operaciones de escrita en la base de datos, como insert, 
		 * update y delete.Operaciones de escrita exigen el uso de transacciones.
		 */
		
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		
		//em.persist(celulares);
		productoDAO.guardar(celular);
		
		//celulares.setNombre("Llibros");
		
		em.getTransaction().commit();
		em.close();
	}

}
