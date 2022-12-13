package pro.sky.telegrambot.constant;

import com.vdurmont.emoji.EmojiParser;

public enum Icon {
    DOG_Icon(":dog:"),
    CAT_Icon(":smiley_cat:");

    private String value;

    Icon(String value) {
        this.value = value;
    }

    public String get() {
        return EmojiParser.parseToUnicode(value);
    }
}

