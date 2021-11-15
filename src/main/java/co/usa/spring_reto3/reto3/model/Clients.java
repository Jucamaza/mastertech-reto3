package co.usa.spring_reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idClient;
    private String email;
    private String name;
    private String password;
    private Integer age;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties({ "client" })
    private List<Messages> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties({ "client" })
    private List<Reservations> reservations;

    public Integer getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Messages> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Reservations> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
}
