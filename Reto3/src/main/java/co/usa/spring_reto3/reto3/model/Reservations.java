package co.usa.spring_reto3.reto3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservations")
public class Reservations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idReservations;
    private Date startDate;
    private Date devolutionDate;
    private String status;
    private Integer score;

    // Relacion de uno a muchos para los mensajes con las patinetas
    @ManyToOne
    @JoinColumn(name = "skates")
    @JsonIgnoreProperties({ "reservations" })
    public Skates skates;

    // Relacion de uno a muchos para los mensajes con los clientes
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({ "reservations" })
    public Clients client;

    public Integer getIdReservations() {
        return this.idReservations;
    }

    public void setIdReservations(Integer idReservations) {
        this.idReservations = idReservations;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return this.devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Skates getSkate() {
        return this.skates;
    }

    public void setSkate(Skates skates) {
        this.skates = skates;
    }

    public Clients getClient() {
        return this.client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
