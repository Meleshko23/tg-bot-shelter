package pro.sky.telegrambot.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.repositories.PhotoPetRepository;
import pro.sky.telegrambot.service.PhotoPetService;

import java.io.IOException;

@RestController
@RequestMapping("photo_pet")
public class PhotoPetController {

    private PhotoPetService photoPetService;
    private PhotoPetRepository photoPetRepository;

    public PhotoPetController(PhotoPetService photoPetService, PhotoPetRepository photoPetRepository) {
        this.photoPetService = photoPetService;
        this.photoPetRepository = photoPetRepository;
    }

    @PostMapping(value = "{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @RequestParam MultipartFile photoPet) throws IOException {
        if (photoPet.getSize() > 1024 * 300){
            return ResponseEntity.badRequest().body("File is too big.");
        }
        photoPetService.uploadPhotoPet(id, photoPet);
        return ResponseEntity.ok().build();
    }
}
