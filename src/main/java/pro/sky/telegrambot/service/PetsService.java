package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repositories.PetRepository;

import java.util.Collection;

@Service
public class PetsService {

    private PetRepository petRepository;

    public PetsService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Метод добавляет питомца в базу данных.
     *
     * @param pet
     * @return Pet
     */
    public Pet addPet(Pet pet){
        return petRepository.save(pet);
    }

    /**
     * Метод находит питомца по id
     *
     * @param id
     * @return Pet
     */
    public Pet findPet(Long id){
        return petRepository.findById(id).orElse(null);
    }

    /**
     * Метод выводит весь список питомцев
     *
     * @return Collection
     */
    public Collection<Pet> getAllPet(){
        return petRepository.findAll();
    }
}
