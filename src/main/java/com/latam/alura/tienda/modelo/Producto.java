package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.Local;

@Entity
@Table(name = "productos") // es el nombre de latabla
public class Producto {
	
	/*¿Cuál es la mejor definición de una entidad en JPA?
	 * Es una clase que hace el mapeamiento de una tabla del banco de datos.
	 * Una entidad JPA funciona como un espejo de una tabla en el banco de datos.
	 */
	
	
	/*¿Cuáles tipos de atributos podemos mapear sin la necesidad de 
	 * configuraciones adicionales vía anotaciones JPA?
	 * Los tipos primitivos, atributos del tipo String y algunas clases de Java, 
	 * como LocalDate y BigDecimal.
	 * Esos tipos pueden ser mapeados automáticamente, sin la necesidad de 
	 * configuraciones adicionales.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now();
	
	// @Enumerated(EnumType.STRING) // esto era antes cuando usaba contantes enums
	
	/*Aprendimos a utilizar la anotación @ManyToOne para indicar la cardinalidad de 
	 * una relación. Cual es la cardinalidad default asumida por JPA, en el caso de 
	 * un atributo que representa una relación y no tiene anotaciones?
	 * Es obligatorio agregar alguna anotación de cardinalidad en todos los atributos 
	 * que representan relaciones.
	 * PA no asume una cardinalidad default cuando no colocamos anotaciones.
	 * 
	 */
	
	@ManyToOne
	private Categoria categoria;
	
	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		this.setCategoria(categoria);
	}
	
	public Producto() {
		this.setNombre(null);
		this.setDescripcion(null);
		this.setPrecio(null);
		this.setCategoria(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nNombre: " + this.getNombre() + "\nDescripcion: " + this.getDescripcion();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
