package pro.sky.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.telegrambot.constant.TypeAnimal;
import pro.sky.telegrambot.controller.PetsController;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repositories.PetRepository;
import pro.sky.telegrambot.service.PetsService;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PetsController.class)
public class PetsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetRepository petRepository;

    @SpyBean
    private PetsService petsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addPetTest() throws Exception {
        final String name = "newName";
        final int age = 2;
        final long id = 1;

        JSONObject petObject = new JSONObject();
        petObject.put("id", id);
        petObject.put("name", name);
        petObject.put("age", age);

        Pet pet = new Pet();
        pet.setId(id);
        pet.setAge(age);
        pet.setName(name);

        when(petRepository.save(any(Pet.class))).thenReturn(pet);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pets")
                        .content(petObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void getAllPetsTest() throws Exception {
        final String name = "newName";
        final int age = 2;
        final long id = 1;
        final String breed = "ovcharka";
        final boolean healthRestrictions = false;


        final String name1 = "name1";
        final int age1 = 3;
        final long id1 = 2;
        final String breed1 = "ovcharka";
        final boolean healthRestrictions1 = false;
        Pet pet = new Pet(name, age, TypeAnimal.DOG, breed, healthRestrictions);
        Pet pet1 = new Pet(name1, age1, TypeAnimal.DOG, breed1, healthRestrictions1);

        JSONObject petObject = new JSONObject();
        petObject.put("name", name);
        petObject.put("age", age);

        when(petRepository.findAll()).thenReturn(List.of(pet, pet1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pets/all_pet")
                        .content(petObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findPetTest() throws Exception{
        final String name = "newName";
        final int age = 2;
        final long id = 1;

        JSONObject petObject = new JSONObject();
        petObject.put("id", id);
        petObject.put("name", name);
        petObject.put("age", age);

        Pet pet = new Pet();
        pet.setId(id);
        pet.setAge(age);
        pet.setName(name);

        when(petRepository.findById(id)).thenReturn(Optional.of(pet));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pets/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));
    }
}
