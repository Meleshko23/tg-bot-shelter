package pro.sky.telegrambot.constant;

public enum Keyboard {

    START("/start"),
    CAT("CAT"),
    DOG("DOG"),
    ONE_DOG("ONE_DOG"),
    TWO_DOG("TWO_DOG"),
    THREE_DOG("THREE_DOG"),
    FOUR_DOG("FOUR_DOG"),

    ONE_CAT("ONE_CAT"),
    TWO_CAT("TWO_CAT"),
    THREE_CAT("THREE_CAT"),
    FOUR_CAT("FOUR_CAT"),

    info_shelter_dog("info_shelter_dog"),
    work_time_and_address_dog("work_time_and_address_dog"),
    shelter_rules_dog("shelter_rules_dog"),
    security_contacts_dog("security_contacts_dog"),
    safety_precautions_dog("safety_precautions_dog"),
    leave_request_dog("leave_request_dog"),
    call_volunteer_dog("call_volunteer_dog"),


    info_shelter_cat("info_shelter_cat"),
    work_time_and_address_cat("work_time_and_address_cat"),
    shelter_rules_cat("shelter_rules_cat"),
    security_contacts_cat("security_contacts_cat"),
    safety_precautions_cat("safety_precautions_cat"),
    leave_request_cat("leave_request_cat"),
    call_volunteer_cat("call_volunteer_cat"),

    DATING_RULES_DOG("dating_rules_dog"),
    DOCUMENTS_LIST_DOG ("documents_list_dog"),
    TRANSPORT_RECOMMENDATIONS_DOG ("transports_recommendations_dog"),
    HOME_IMPROVEMENT_PUPPY_DOG ("home_improvement_puppy_dog"),
    HOME_IMPROVEMENT_DOG ("home_improvement_dog"),
    HOME_IMPROVEMENT_DISABLED_DOG ("home_improvement_disabled_dog"),
    CYNOLOGIST_TIPS_DOG ("cynologist_tips_dog"),
    CYNOLOGISTS_LIST_DOG ("cynologist_list_dog"),
    BOUNCE_LIST_DOG ("bounce_list_dog"),

    DATING_RULES_CAT("dating_rules_cat"),
    DOCUMENTS_LIST_CAT ("documents_list_cat"),
    TRANSPORT_RECOMMENDATIONS_CAT ("transports_recommendations_cat"),
    HOME_IMPROVEMENT_PUPPY_CAT ("home_improvement_puppy_cat"),
    HOME_IMPROVEMENT_CAT ("home_improvement_cat"),
    HOME_IMPROVEMENT_DISABLED_CAT ("home_improvement_disabled_cat"),
    BOUNCE_LIST_CAT ("bounce_list_cat"),

    DAILY_REPORT_FORM_DOG("DAILY_REPORT_FORM_DOG"),
    SEND_REPORT_DOG("SEND_REPORT_DOG"),

    DAILY_REPORT_FORM_CAT("DAILY_REPORT_FORM_CAT"),
    SEND_REPORT_CAT("SEND_REPORT_CAT");
    private String command;

    Keyboard(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
