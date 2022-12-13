package pro.sky.telegrambot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repositories.PetRepository;
import pro.sky.telegrambot.repositories.VolunteerRepository;
import pro.sky.telegrambot.service.PetsService;
import pro.sky.telegrambot.service.VolunteerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VolunteerServiceTest {
    @InjectMocks
    private VolunteerService volunteerService;

    @Mock
    private VolunteerRepository volunteerRepository;

    private Volunteer volunteer1;
    private Volunteer volunteer2;
    private Volunteer volunteer3;

    private List<Volunteer> volunteerList = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        volunteerService = new VolunteerService(volunteerRepository);
        volunteer1 = new Volunteer(1, 23467, "name");
        volunteer2 = new Volunteer(2, 2342435, "name1");
        volunteer3 = new Volunteer(3, 243542, "name2");
        volunteerList.add(volunteer1);
        volunteerList.add(volunteer2);
        volunteerList.add(volunteer3);
    }

    @Test
    public void addVolunteerTest(){
        Assertions.assertEquals(volunteer1, volunteerService.addVolunteer(volunteer1));
    }

    @Test
    public void getAllVolunteerTest(){
        Mockito.when(volunteerRepository.findAll()).thenReturn(volunteerList);
        Assertions.assertEquals(volunteerList, volunteerService.getAllVolunteer());
    }
}
