package pro.sky.telegrambot.model;

import pro.sky.telegrambot.constant.StatusTrialPeriod;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity (name = "dog_owners")
public class DogOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String name;
    private String mail;
    private String phone;
    private LocalDate startTrialPeriod;
    private LocalDate endTrialPeriod;
    private StatusTrialPeriod statusTrial;

    // У одного владельца один питомец. Это под вопросом. Обсуждаем)))
    @OneToOne
    private Pet pet;

   // @JsonIgnore
    @OneToMany(mappedBy = "dogOwner")
    private List<KeepingPet> keepingPetList;

    public DogOwner(String name, String mail, String phone, Long chatId, Long id) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.chatId = chatId;
        this.id = id;
    }

    public DogOwner() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DogOwner{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", chatId=" + chatId +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogOwner petOwner = (DogOwner) o;
        return Objects.equals(name, petOwner.name) && Objects.equals(mail, petOwner.mail) && Objects.equals(phone, petOwner.phone) && Objects.equals(chatId, petOwner.chatId) && Objects.equals(id, petOwner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, phone, chatId, id);
    }
}
