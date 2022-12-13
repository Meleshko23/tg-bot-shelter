package pro.sky.telegrambot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Info;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.service.InfoService;

import java.util.Collection;

@RestController
@RequestMapping("info")
public class InfoController {

    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @Operation(
            summary = "Обновление информации в базе данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "информация обновлена",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Info.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если информации нет в базе данных"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "обновление информации",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = Info.class)
                            )
                    }
            )
    )
    @PutMapping
    public ResponseEntity<Info> editInfo(@RequestBody Info info) {
        Info editInfo = infoService.editInfo(info);
        return ResponseEntity.ok(editInfo);
    }

    @Operation(
            summary = "Вывести список информации",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "список информации выведен",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Info.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Если информации нет"
                    )
            }
    )
    @GetMapping("all_info")
    public ResponseEntity<Collection<Info>> getAllInfo() {
        return ResponseEntity.ok(infoService.getAllInfo());
    }
}
