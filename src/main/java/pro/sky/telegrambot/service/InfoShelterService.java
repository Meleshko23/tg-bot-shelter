package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Info;
import pro.sky.telegrambot.repositories.InfoRepository;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class InfoShelterService {

    private InfoRepository infoRepository;

    public InfoShelterService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    /**
     * Метод выдает общую информацию о приюте
     * @param message
     * @return String
     */
    public String sendInfoShelter(String message) {
        Info infoShelter = infoRepository.findInfoByName(message);
        return infoShelter.getDetails();
    }


    //  Бот может выдать расписание работы приюта и адрес, схему проезда.

    /**
     * Метод передает информацию о графике, времени работы и адрес
     * @param message
     * @return String
     */
    public String sendWorkTimeAddressMap(String message) {
        Info workTime = infoRepository.findInfoByName(message);
        return workTime.getDetails();
    }

    //  Бот может выдать общие рекомендации о технике безопасности на территории приюта.

    /**
     * Метод выдает общие правила приюта
     * @param message
     * @return String
     */
    public String sendShelterRules(String message) {
        Info shelterRules = infoRepository.findInfoByName(message);
        return shelterRules.getDetails();
    }

    // Бот может выдать контакты охранны для выдачи пропуска

    /**
     * Метод выдает контакты охраны для выдачи пропуска
     * @param message
     * @return String
     */
    public String sendSecurityContacts(String message){
        Info securityContacts = infoRepository.findInfoByName(message);
        return securityContacts.getDetails();
    }

    // Бот может выдать технику безопасности при посещении приюта

    /**
     * Метод выдает технику безопасности при посещении приюта
     *
     * @param message
     * @return String
     */
    public String sendSafetyPrecautions(String message){
        Info safetyPrecautions = infoRepository.findInfoByName(message);
        return safetyPrecautions.getDetails();
    }

    //  Бот может принять и записать контактные данные для связи.

    /**
     * Метод принимает и записывает контактные данные пользователя в базу данных
     */
    public void saveContactInfo() {

        return;
    }

    //  Если бот не может ответить на вопросы клиента, то можно позвать волонтера.

    /**
     * Метод вызывает волонтера в чат
     */
    public void callVolunteer() {

        return;
    }


}
