package futchamp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Person {

    /**
     * Nombre de la persona
     */
    @Column(length = 100)
    private String name;

    /**
     * Apellido de la persona
     */
    @Column(length = 100)
    private String surname;

    /**
     * Numero alfanumerico de documento nacional
     */
    @Column(length = 20, unique = true, nullable = false)
    private String dni;

    /**
     * Correo electronico
     */
    @Column(length = 100, unique = true)
    private String email;

    /**
     * Fecha de cumpleaños
     */
    private LocalDate birthday;

    /**
     * Genero de la persona
     */
    private Character gender;

    /**
     * Direccion
     */
    @Column(length = 150)
    private String address;

    /**
     * Número de telefono movil
     */
    @Column(length = 20, unique = true)
    private String mobile;

    /**
     * Foto de la persona
     */
    private String photo;

    /**
     * Fecha de creación del registro
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    /**
     * Fecha de ultima actualización del registro
     */
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated;

    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}


