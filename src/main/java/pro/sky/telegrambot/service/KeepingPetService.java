package pro.sky.telegrambot.service;

import pro.sky.telegrambot.model.KeepingPet;
import pro.sky.telegrambot.model.PetOwner;
import pro.sky.telegrambot.model.PhotoPet;

import java.util.List;

/**
 * Сервис, описывающий методы по ведению питомца хозяевами
 */
public class KeepingPetService {

    /**
     * метод отправляет усыновителям форму ежедневного <b>отчета</b>
     *
     * @param
     * @return void
     */
    public void getFormDailyReport() {

    }

    /**
     * Метод отправляет ежедневный отчет усыновителя, включающиий  фото животоного, рацион, самочувствие, поведение. Отчет сохраняется в БД в таблице KeepingPet
     *
     *
     * @param chartId идентификатор чата, не может быть null
     * @param photo  объект, хранящий информацию с фотографией питомца. не null
     * @param message  сообщение, отправленное пользователем. Не null
     *
     * @return KeepingPet (объект инкапсулирующий отчет пользователя)
     */
    public KeepingPet sendReport(Long chartId, PhotoPet photo, String message) {
        // Если пользователь не отправил фото животного
        if (photo == null) {
            // попросить отправить фото животного
        }
        // Если пользователь не отправил текстовую информацию
        else if (message == null) {
            // попросить отправить текстовую информацию
        }

        return null;
    }

    /**
     * метод для волонтера, для отправки усыновителю предупреждения о том,
     * что отчет заполняется плохо
     */
    public void sendWarningByVolunteer() {

    }

    /**
     * метод определяет усыновителей , у которых по времени пройден испытательный срок
     *     метод запускается по графику каждый день
     *     Если усыновтели найдены, то отправить информацию волонтеру для проверки
     * @param allPetOwners - все усыновители
     * @return список усыновителей
     */
    public List<PetOwner> chechProbationaryPeriod(List<PetOwner> allPetOwners) {
        return null;
    }

    /**
     * метод направляет информацию волонтеру об усыновителях,
     *     у которых закончился испытательный срок
     */
    public void notifyVolunteerAboutOwnerEndedProbablyPeriod() {

    }

    /**
     *  метод поздравляет усыновителя с успешным окончанием испытательного срока
     */
    public void congratulateOwner() {

    }

    /**
     * метод сообщает усыновителю что ему назначены
     *     дополнительные дни исптытального срока в определенном количестве дней
     */
    public void reportAddProbationaryPeriod() {

    }

    /**
     * метод сообщает усыновителю что испытательный срок не пройдет
     *     дает инструкции по дальнейшим шагам
     */
    public void reportProbationaryPeriodNotPassed() {

    }

    /**
     * Метод зовет волонтера в чат
     */
    public void callVolunteer() {

    }

    /**
     * метод возвращает количество прошедших часов с момента отправки последнего отчета
     * @return количество часов
     */
    private int timeSinceLastReport () {
        return 0;
    }

    /**
     * метод запускается каждый час и проверяет, нет ли усыновителей,
     *     которые не отправили отчет в установленный срок
     *     если прошло 24 часа
     *         запустить метод отправки стандартного сообщения волонтером
     *         с напоминанием о необходимости отправки отчета
     *
     *         Если прошло более 48 часов,
     *         запустить метод, который отправляет запрос волонтеру для связи с усыновителем
     */
    public void checkTime() {

    }

}
