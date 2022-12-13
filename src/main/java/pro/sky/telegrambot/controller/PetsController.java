package pro.sky.telegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.service.PetsService;

import java.util.Collection;

@RestController
@RequestMapping("pets")
public class PetsController {
    private PetsService petsService;

    public PetsController(PetsService petsService) {
        this.petsService = petsService;
    }

    @Operation(
            summary = "Добавление питомца в приют",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "питомец добавлен",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Pet.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если питомец уже находится в приюте"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "новый питомец",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Pet.class)
                            )
                    }
            )
    )
    @PostMapping()
    public ResponseEntity<Pet> addPet(@Parameter( name = "питомец") @RequestBody Pet pet){
        Pet addPet = petsService.addPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(addPet);
    }

    @Operation(
            summary = "Поиск питомца по базе данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "питомец найден",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Pet.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если питомца нет"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "имеющийся питомец",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Pet.class)
                            )
                    }
            )
    )
    @GetMapping("{id}")
    public ResponseEntity<Pet> findPet(@PathVariable Long id){
        Pet pet = petsService.findPet(id);
        return ResponseEntity.ok(pet);
    }
    @Operation(
            summary = "Вывести список питомцев",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "список питомцев выведен",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Pet.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если питомцев нет"
                    )
            }
    )
    @GetMapping("all_pet")
    public ResponseEntity<Collection<Pet>> getAllPet(){
        return ResponseEntity.ok(petsService.getAllPet());
    }

}
