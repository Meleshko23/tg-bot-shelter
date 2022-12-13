package pro.sky.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class PhotoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoPet photoPet = (PhotoPet) o;
        return fileSize == photoPet.fileSize && id.equals(photoPet.id) && filePath.equals(photoPet.filePath) && mediaType.equals(photoPet.mediaType);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (int) (fileSize ^ (fileSize >>> 32));
        result = 31 * result + (mediaType != null ? mediaType.hashCode() : 0);
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        return result;
    }
}
