package futchamp.entities;

import static futchamp.literals.Keys.FK_TEAM_PLAYER;
import static futchamp.literals.Keys.ID_TEAM;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	/**
	 * Relacion de N:1 desde Team
	 */
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.EAGER, cascade = { DETACH, MERGE, PERSIST, REFRESH })
	@JoinColumn(name = ID_TEAM, foreignKey = @ForeignKey(name = FK_TEAM_PLAYER), nullable = false)
	private Team team;

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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
