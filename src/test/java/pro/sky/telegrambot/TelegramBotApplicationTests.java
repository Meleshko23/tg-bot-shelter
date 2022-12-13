package pro.sky.telegrambot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import pro.sky.telegrambot.constant.TypeAnimal;
import pro.sky.telegrambot.model.Pet;

import java.net.URI;

import static pro.sky.telegrambot.constant.TypeAnimal.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TelegramBotApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAddPet() {
		Pet pet = creatPetWith("PetName",5, DOG, "pudel",false);
		ResponseEntity<Pet> response = whenSendingCreatePetRequest(getUriBuilder().build().toUri(), pet);
		thenPetHasBeenCreated(response);

	}

	private void thenPetHasBeenCreated(ResponseEntity<Pet> response) {
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Assertions.assertThat(response.getBody()).isNotNull();
		Assertions.assertThat(response.getBody().getId()).isNotNull();
	}

	private Pet creatPetWith(String name, int age, TypeAnimal type, String breed, boolean healthRestriction) {
		return new Pet(name, age, type, breed, healthRestriction);
	}

	private ResponseEntity<Pet> whenSendingCreatePetRequest(URI uri, Pet pet) {
		return restTemplate.postForEntity(uri, pet, Pet.class);
	}

	private UriComponentsBuilder getUriBuilder() {
		return UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port(port)
				.path("/pets");
	}

}
