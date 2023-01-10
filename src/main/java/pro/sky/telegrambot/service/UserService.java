package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.exception.UserNotFoundException;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.repositories.UserRepository;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pro.sky.telegrambot.constant.MessageForSaveContacts.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private TelegramBot telegramBot;

    private String name = null;
    private String phone = null;
    private String mail = null;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Метод принимает и записывает контактные данные пользователя в базу данных
     */
    public void saveContactInfo(long chatId, String messageText, String userRequest) {
        if (messageText.equals(NAME)) {
            name = null;
            phone = null;
            mail = null;
            sendMessageReply(chatId, messageText);
        } else if (messageText.equals(PHONE)) {
            if (!validateAndSaveName(userRequest).isEmpty()) {
                name = userRequest;
                sendMessageReply(chatId, messageText);
            } else {
                sendMessageReply(chatId, NAME_AGAIN);
            }
        } else if (messageText.equals(MAIL)) {
            if (!validateAndSavePhone(userRequest).isEmpty()) {
                phone = userRequest;
                sendMessageReply(chatId, messageText);
            } else {
                sendMessageReply(chatId, PHONE_AGAIN);
            }
        } else if (messageText.equals(SAVE)) {
            if (!validateAndSaveEmail(userRequest).isEmpty()) {
                mail = userRequest;

                User user = new User();
                user.setChatId(chatId);
                user.setName(name);
                user.setPhone(phone);
                user.setMail(mail);
                saveUser(user);
                sendMessage(chatId, messageText);
            } else {
                sendMessageReply(chatId, MAIL_AGAIN);
            }

        }

    }

    private void sendMessageReply(long chatId, String messageText) {
        SendMessage sendMess = new SendMessage(chatId, messageText);
        sendMess.replyMarkup(new ForceReply());
        telegramBot.execute(sendMess);
    }

    private void sendMessage(long chatId, String messageText) {
        SendMessage sendMess = new SendMessage(chatId, messageText);
        telegramBot.execute(sendMess);
    }

    private String validateAndSaveName(String name) {
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я\\s]{2,30}");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return name;
        } else {
            return "";
        }
    }

    private String validateAndSavePhone(String phone) {
        String phoneOfNumber = phone.replaceAll("\\D", "");
        Pattern pattern = Pattern.compile("\\d{10,11}");
        Matcher matcher = pattern.matcher(phoneOfNumber);

        if (matcher.matches()) {
            return phoneOfNumber;
        } else {
            return "";
        }
    }

    private String validateAndSaveEmail(String email) {
//          Pattern pattern = Pattern.compile("\\w+([\\.-_]?\\w+)*@\\w+([\\.-_]?\\w+)*\\.\\w{2,4}");
//          Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}”);
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return email;
        } else {
            return "";
        }
    }


    public User findUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    /**
     * Метод возвращает все заявки, которые поступили через бота и записанные в таблицу user в бд.
     *
     * @return Collection
     */
    public Collection<User> getAllOrders() {
        return userRepository.findAll();
    }

    /**
     * Метод получает значение приюта, который выбрал User.
     *
     * @param chatId
     * @return String
     */
    public String findShelterByChatId(Long chatId) {
        return userRepository.findUserByChatId(chatId).getShelter();
    }

    /**
     * Метод получает заявки по значению поля shelter.
     *
     * @param shelter
     * @return Collection
     */
    public Collection<User> findUserByShelter(String shelter) {
        return userRepository.findUserByShelter(shelter);
    }


    /**
     * Находит User по chat id.
     *
     * @param chatId
     * @return User
     */
    public User findUserByChatId(Long chatId) {
        return userRepository.findUserByChatId(chatId);
    }
}
