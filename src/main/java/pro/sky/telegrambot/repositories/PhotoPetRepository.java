package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.PhotoPet;

import java.util.Optional;

public interface PhotoPetRepository extends JpaRepository<PhotoPet, Long> {

    Optional<PhotoPet> findPhotoPetByPetId(Long petId);
}
