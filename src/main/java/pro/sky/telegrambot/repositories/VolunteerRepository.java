package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {
}
