package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import com.pengrad.telegrambot.model.botcommandscope.BotCommandScopeDefault;
import com.pengrad.telegrambot.request.SetMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TelegramBotConfiguration {

    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        ///////////////////////////////////
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "Запуск бота"));
        listOfCommands.add(new BotCommand("/help", "Помощь в работе с ботом"));

        try {
            bot.execute(new SetMyCommands(
                    new BotCommand("/start", "Запуск бота"),
                    new BotCommand("/help", "Помощь в работе с ботом")
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ///////////////////////////
        //bot.execute(new DeleteMyCommands());
        return bot;
    }

}
