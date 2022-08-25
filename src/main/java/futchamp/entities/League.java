package futchamp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import futchamp.configuration.Auditable;

@Entity
public class League extends Auditable implements Serializable {

    /** Serie de la clase */
    private static final long serialVersionUID = 1L;

    /** Identificador de registro */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de la liga */
    @Column(length = 100, unique = true)
    private String name;

    /** Tipo de deporte realizado */
    @Column(length = 70)
    private String sport;

    /** Fecha de creación de la liga */
    private LocalDate founded;

    /** Imagen de la liga */
    private String picture;



    public League() {
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
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

