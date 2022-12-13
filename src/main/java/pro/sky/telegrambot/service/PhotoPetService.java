package pro.sky.telegrambot.service;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.PhotoPet;
import pro.sky.telegrambot.repositories.PhotoPetRepository;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class PhotoPetService {

    @Value("photo_pet")
    private String coversDir;

    private PetsService petsService;
    private PhotoPetRepository photoPetRepository;

    public PhotoPetService(PetsService petsService, PhotoPetRepository photoPetRepository) {
        this.petsService = petsService;
        this.photoPetRepository = photoPetRepository;
    }

    public void uploadPhotoPet(Long petId, MultipartFile file) throws IOException {
        Pet pet = petsService.findPet(petId);

        Path filePath = Path.of(coversDir, petId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        PhotoPet photoPet = findPhotoPet(petId);
        photoPetRepository.save(photoPet);
        photoPet.setPet(pet);
        photoPet.setFilePath(filePath.toString());
        photoPet.setFileSize(file.getSize());
        photoPet.setMediaType(file.getContentType());

        photoPetRepository.save(photoPet);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public PhotoPet findPhotoPet(Long petId) {
        return photoPetRepository.findPhotoPetByPetId(petId).orElse(new PhotoPet());
    }

    private byte[] generateImageData(Path filePath) throws IOException {
        try (InputStream is = Files.newInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage image = ImageIO.read(bis);

            int height = image.getHeight() / (image.getWidth() / 100);
            BufferedImage preview = new BufferedImage(100, height, image.getType());
            Graphics2D graphics = preview.createGraphics();
            graphics.drawImage(image, 0, 0, 100, height, null);
            graphics.dispose();
            ImageIO.write(preview, getExtension(filePath.getFileName().toString()), baos);
            return baos.toByteArray();
        }

    }

}
