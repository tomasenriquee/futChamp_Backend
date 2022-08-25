package futchamp.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player extends Person implements Serializable {

	/** Serie de la clase */
	@Serial
	private static final long serialVersionUID = 1L;

	/** Identificador de registro */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Posición del jugador */
	@Column(length = 150)
	private String position;

	/** Número de camiseta */
	@Column(nullable = false)
	private Byte dorsal;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Byte getDorsal() {
		return dorsal;
	}

	public void setDorsal(Byte dorsal) {
		this.dorsal = dorsal;
	}
}
