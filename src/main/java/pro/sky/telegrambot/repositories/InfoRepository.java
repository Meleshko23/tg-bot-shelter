package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.telegrambot.model.Info;

public interface InfoRepository extends JpaRepository<Info,Long> {

    Info findInfoByName(String name);
}
