package co.usa.spring_reto3.reto3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "messages")
public class Messages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMessage;
    private String messageText;

    // Relacion de uno a muchos para los mensajes con las patinetas
    @ManyToOne
    @JoinColumn(name = "skates")
    @JsonIgnoreProperties({ "messages" })
    public Skates skates;

    // Relacion de muchos a uno con los clientes
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({ "messages" })
    public Clients client;

    public Integer getId() {
        return this.idMessage;
    }

    public void setId(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Skates getSkates() {
        return this.skates;
    }

    public void setSkates(Skates skates) {
        this.skates = skates;
    }

    public Clients getClient() {
        return this.client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
