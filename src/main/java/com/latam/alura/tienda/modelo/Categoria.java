package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* // esto era antes
public enum Categoria {
	
	SOFTWARES, // id 1
	LIBROS, // id 2
	CELULARES // id 3

}
*/

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	public Categoria() {
		
	}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nCategoria: " + this.getNombre();
	}
}
