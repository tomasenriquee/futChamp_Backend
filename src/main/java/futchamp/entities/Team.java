package futchamp.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import futchamp.configuration.Auditable;

@Entity
public class Team extends Auditable implements Serializable {

	/**
	 * Serie de la clase
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador de registro
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del equipode futbol
	 */
	@Column(length = 150, unique = true)
	private String name;

	/**
	 * Fecha de creación del equipo
	 */
	private LocalDate founded;

	/**
	 * Imagen del equipo
	 */
	private String picture;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getFounded() {
		return founded;
	}

	public void setFounded(LocalDate founded) {
		this.founded = founded;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
