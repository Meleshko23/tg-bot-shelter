package pro.sky.telegrambot.constant;

public enum Keyboard {

    START("/start"),
    CAT("CAT"),
    DOG("DOG"),
    info_shelter_cat("info_shelter_cat"),
    work_time_and_address_cat("work_time_and_address_cat"),
    shelter_rules_cat("shelter_rules_cat"),
    leave_request_cat("leave_request_cat"),
    call_volunteer_cat("call_volunteer_cat"),

    info_shelter_dog("info_shelter_dog"),
    work_time_and_address_dog("work_time_and_address_dog"),
    shelter_rules_dog("shelter_rules_dog"),
    leave_request_dog("leave_request_dog"),
    call_volunteer_dog("call_volunteer_dog"),

    ONE_DOG("ONE_DOG"),
    TWO_DOG("TWO_DOG"),
    THREE_DOG("THREE_DOG"),
    FOUR_DOG("FOUR_DOG"),

    ONE_CAT("ONE_CAT"),
    TWO_CAT("TWO_CAT"),
    THREE_CAT("THREE_CAT"),
    FOUR_CAT("FOUR_CAT");

    private String command;

    Keyboard(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
