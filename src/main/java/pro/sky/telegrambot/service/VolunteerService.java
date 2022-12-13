package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repositories.VolunteerRepository;

import java.util.Collection;

@Service
public class VolunteerService {

    private VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * Метод добавляет волонтера в базу данных.
     *
     * @param volunteer
     * @return Volunteer
     */
    public Volunteer addVolunteer(Volunteer volunteer){
        return volunteer;
    }

    /**
     * Метод выводит весь список волонтеров.
     *
     * @return Collection
     */
    public Collection<Volunteer> getAllVolunteer(){
        return volunteerRepository.findAll();
    }
}
