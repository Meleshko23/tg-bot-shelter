package pro.sky.telegrambot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.telegrambot.constant.TypeAnimal;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repositories.PetRepository;
import pro.sky.telegrambot.service.PetsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PetsServiceTest {

    @InjectMocks
    private PetsService petsService;

    @Mock
    private PetRepository petRepository;

    private Pet pet1;
    private Pet pet2;
    private Pet pet3;

    private List<Pet> petList = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        petsService = new PetsService(petRepository);
        pet1 = new Pet("name", 3, TypeAnimal.DOG, "ovcharka", false);
        pet2 = new Pet("name1", 3, TypeAnimal.DOG, "ovcharka", false);
        pet3 = new Pet("name2", 3, TypeAnimal.DOG, "ovcharka", false);
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
    }

    @Test
    public void addPetTest(){
        Assertions.assertEquals(pet1, petsService.addPet(pet1));
    }

    @Test
    public void findPetTest(){
        Mockito.when(petRepository.findById(pet1.getId())).thenReturn(Optional.ofNullable(pet1));
        Assertions.assertEquals(pet1, petsService.findPet(pet1.getId()));
    }

    @Test
    public void getAllPetTest(){
        Mockito.when(petRepository.findAll()).thenReturn(petList);
        Assertions.assertEquals(petList, petsService.getAllPet());
    }
}
