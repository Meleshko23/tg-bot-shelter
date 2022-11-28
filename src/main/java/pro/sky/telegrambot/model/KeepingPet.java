package pro.sky.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class KeepingPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String infoPet;
    @OneToOne
    private PhotoPet photoPet;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PetOwner_id")
    private PetOwner petOwner;

    public KeepingPet(Long id, Long chatId, String infoPet, PhotoPet photoPet) {
        this.id = id;
        this.chatId = chatId;
        this.infoPet = infoPet;
        this.photoPet = photoPet;

    }

    public KeepingPet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getInfoPet() {
        return infoPet;
    }

    public void setInfoPet(String infoPet) {
        this.infoPet = infoPet;
    }

    public PhotoPet getPhotoPet() {
        return photoPet;
    }

    public void setPhotoPet(PhotoPet photoPet) {
        this.photoPet = photoPet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeepingPet that = (KeepingPet) o;
        return id.equals(that.id) && chatId.equals(that.chatId) && infoPet.equals(that.infoPet) && photoPet.equals(that.photoPet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, infoPet, photoPet);
    }

    @Override
    public String toString() {
        return "KeepingPet{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", infoPet='" + infoPet + '\'' +
                ", photoPet=" + photoPet +
                '}';
    }
}
