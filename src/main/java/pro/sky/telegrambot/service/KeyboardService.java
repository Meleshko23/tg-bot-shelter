package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.constant.Icon;
import pro.sky.telegrambot.constant.Keyboard;

@Service
public class KeyboardService {

    @Autowired
    private TelegramBot telegramBot;

    /**
     * Метод отправляет пользователю сообщение с клавиатурой под сообщением
     * @param chatId идентификатор чата для отправки сообщения
     * @param messageText текст сообщения
     * @param inlineKeyboardMarkup клавиатура по сообщением
     */
    public void responseOnCommand(long chatId,
                                  String messageText,
                                  InlineKeyboardMarkup inlineKeyboardMarkup ) {

        SendMessage sendMess = new SendMessage(chatId, messageText);
        sendMess.replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMess);
    }

    /**
     * Метод для вызова волонтера собачьего приюта
     * @param chatId
     */
    public void responseOnCommandCallVolunteerDog(long chatId) {
        //
    }

    /**
     * Метод для вызова волонтера кошачьего приюта
     * @param chatId
     */
    public void responseOnCommandCallVolunteerCat(long chatId) {
//        ForceReply forceReply = new ForceReply();
//        //forceReply.selective(true);
//
//        SendMessage sendMess = new SendMessage(chatId, "Введите ваше имя:");
//        sendMess.rep
//        telegramBot.execute(sendMess);
    }

    /**
     * Метод создает InlineKeyboardMarkup клавиатуру (в каждой строке одна кнопка)
     * @param buttonsTexts текст на кнопках
     * @param buttonsCallback идентификаторы кнопок
     * @return инлайн клавитура для сообщения
     */
    public InlineKeyboardMarkup prepareKeyboard(String[] buttonsTexts, Keyboard[] buttonsCallback) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        InlineKeyboardButton[] buttons = new InlineKeyboardButton[buttonsTexts.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new InlineKeyboardButton(buttonsTexts[i]);
            buttons[i].callbackData(buttonsCallback[i].getCommand());
            markupInline.addRow(buttons[i]);
        }
        return markupInline;
    }
}
