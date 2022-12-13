package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Info;
import pro.sky.telegrambot.repositories.InfoRepository;

/**
 * Класс отвечает за консультации с новым пользователем через методы приветствия,
 * предоставления полной информации о том, как предстоитподготовиться человеку ко встрече с новым членом семьи,
 * записать контактные данные пользователя, позвать волонтера.
 */
@Service
public class InfoPetsService {

    private InfoRepository infoRepository;

    public InfoPetsService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    /**
     * Метод выдает правила знакомства, до того как можно забрать собаку из приюта
     *
     * @return String
     */
    public String datingRules(String message){
        Info datingRules = infoRepository.findInfoByName(message);
        return datingRules.getDetails();
    }

    /**
     * Метод выдает список документов, необходимых для того, чтобы забрать питомца из приюта
     *
     * @return String
     */
    public String documentsList(String message){
        Info documentList = infoRepository.findInfoByName(message);
        return documentList.getDetails();
    }

    /**
     * Метод выдает список рекомендаций по транспортировке животного
     *
     * @return String
     */
    public String transportRecommendation(String message){
        Info transportRecommendation = infoRepository.findInfoByName(message);
        return transportRecommendation.getDetails();
    }

    /**
     * Метод выводит список рекомендаций по обустройству дома для щенка
     *
     * @return String
     */
    public String homeImprovementPuppyOrKitten(String message){
        Info homeImprovement = infoRepository.findInfoByName(message);
        return homeImprovement.getDetails();
    }

    /**
     * Метод выводит список рекомендаций по обустройству дома для взрослых собак.
     *
     * @return String
     */
    public String homeImprovementDogOrCat(String message){
        Info homeImprovement = infoRepository.findInfoByName(message);
        return homeImprovement.getDetails();
    }

    /**
     * Метод выводит список рекомендаций по обустройству дома для собаки с ограниченными возможностями.
     *
     * @return String
     */
    public String homeImprovementDisabledDog(String message){
        Info homeImprovement = infoRepository.findInfoByName(message);
        return homeImprovement.getDetails();
    }

    /**
     * Метод выдает список рекомендаций кинолога по первичному общению с питомцем.
     *
     * @return String
     */
    public String cynolistTips(String message){
        Info cynolistTips = infoRepository.findInfoByName(message);
        return cynolistTips.getDetails();
    }

    /**
     * Метод выдает информацию по проверенным кинологам, для дальнейшего обращения к ним.
     *
     * @return String
     */
    public String cynolistList(String message){
        Info cynolistList = infoRepository.findInfoByName(message);
        return cynolistList.getDetails();
    }

    /**
     * Метод выводит список почему могут отказать и не дать забрать собаку из приюта
     *
     * @return String
     */
    public String bounceList(String message){
        Info bounceList = infoRepository.findInfoByName(message);
        return bounceList.getDetails();
    }
}
