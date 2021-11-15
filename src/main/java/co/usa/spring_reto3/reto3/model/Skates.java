package co.usa.spring_reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "skate")
public class Skates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties({ "skates" })
    private Category category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "skates")
    @JsonIgnoreProperties({ "skates" })
    public List<Messages> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "skates")
    @JsonIgnoreProperties({ "skate" })
    public List<Reservations> reservations;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
