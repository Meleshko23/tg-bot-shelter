package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
