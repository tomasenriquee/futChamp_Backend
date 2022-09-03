package futchamp.entities;

import static futchamp.literals.Keys.FK_LEAGUE_TEAM;
import static futchamp.literals.Keys.ID_LEAGUE;
import static futchamp.literals.Keys.MAPPEDBY_TEAM;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	/** Categoria de futbol del equipo */
	private String category;

	/**
	 * Fecha de creación del equipo
	 */
	private LocalDate founded;

	/**
	 * Imagen del equipo
	 */
	private String picture;

	/**
	 * Relacion N:1 desde League
	 */
	@ManyToOne(targetEntity = League.class, fetch = FetchType.EAGER, cascade = { MERGE, DETACH, PERSIST, REFRESH })
	@JoinColumn(name = ID_LEAGUE, foreignKey = @ForeignKey(name = FK_LEAGUE_TEAM), nullable = false)
	private League league;

	/**
	 * Relacion de 1:N hacia Player
	 */
	@OneToMany(mappedBy = MAPPEDBY_TEAM, cascade = ALL, fetch = FetchType.LAZY, targetEntity = Player.class)
	private List<Player> players;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
}
