package pro.sky.telegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.service.VolunteerService;

import java.util.Collection;

@RestController
@RequestMapping("volunteer")
public class VolunteerController {

    private VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @Operation(
            summary = "Добавление волонтера в базу данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "волонтер добавлен",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Volunteer.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если волонтер уже находится в базе данных"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "новый волонтер",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Volunteer.class)
                            )
                    }
            )
    )
    @PostMapping()
    public ResponseEntity<Volunteer> addVolunteer(@RequestBody Volunteer volunteer){
        Volunteer addVolunteer = volunteerService.addVolunteer(volunteer);
        return ResponseEntity.ok(addVolunteer);
    }

    @Operation(
            summary = "Вывести список волонтеров",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "список волонтеров выведен",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Volunteer.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если волонтеров нет"
                    )
            }
    )
    @GetMapping("all_volunteer")
    public ResponseEntity<Collection<Volunteer>> getAllVolunteer(){
        return ResponseEntity.ok(volunteerService.getAllVolunteer());
    }

}
