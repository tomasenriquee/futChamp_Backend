package futchamp.entities;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordinator extends Person implements Serializable {

    /**
     * Version de clase
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
     * Estudios realizados por el coordinador
     */
    @Column(length = 150)
    private String education;

    /**
     * Ocupacion o función del coordinador
     */
    @Column(length = 200)
    private String employment;

    /**
     * Habilidades del coordinador
     */
    private String skill;

    public Coordinator() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}

