package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "MyBotCat_Example_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "7179446592:AAGCAIV4FmYrCTFTR87f0nJDxVcw5rnnfaY"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step1btn"));
        }
        if (getCallbackQueryButtonKey().equals("step1btn")) {
            addUserGlory(20);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT);
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!\n Выбирай свою награду:",
                    Map.of("Взять сосиску! +20 славы", "step2btn",
                            "Взять рыбку! +20 славы", "step2btn",
                            "Скинуть банку с огурцами! +20 славы", "step2btn"));
        }
        if (getCallbackQueryButtonKey().equals("step2btn")) {
            addUserGlory(20);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взлом робота-пылесоса", "step3btn"));
        }
        if (getCallbackQueryButtonKey().equals("step3btn")) {
            addUserGlory(30);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT);
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!\n Выбирай свою награду:",
                    Map.of("Отправить робопылесос за едой! +30 славы", "step4btn",
                            "Проехаться на робопылесосе! +30 славы", "step4btn",
                            "Убежать от робопылесоса! +30 славы", "step4btn"));
        }
        if (getCallbackQueryButtonKey().equals("step4btn")) {
            addUserGlory(30);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Надеть и включить GoPro!", "step5btn"));
        }
        if (getCallbackQueryButtonKey().equals("step5btn")) {
            addUserGlory(40);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT);
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!\n Выбирай свою награду:",
                    Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "step6btn",
                            "С GoPro нападать на других котов из засады! +40 славы", "step6btn",
                            "С GoPro нападать на собак из засады! +40 славы", "step6btn"));
        }
        if (getCallbackQueryButtonKey().equals("step6btn")) {
            addUserGlory(40);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взлом пароля", "step7btn"));
        }
        if (getCallbackQueryButtonKey().equals("step7btn")) {
            addUserGlory(50);
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT);
            sendTextMessageAsync("У тебя теперь накоплено " + getUserGlory() + " очков славы!",
                    Map.of("Выйти во двор", "step8btn"));
        }
        if (getCallbackQueryButtonKey().equals("step8btn")) {
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendImageMessageAsync("C:\\Users\\Семья\\Desktop\\Olga\\IdeaProjects\\TelegramBot\\final_pic.jpg");
            sendTextMessageAsync(FINAL_TEXT, Map.of("ДА", "step9btn", "НЕТ", "step10btn"));
        }
        if (getCallbackQueryButtonKey().equals("step9btn")) {
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendTextMessageAsync("Нажми на /start");
        }
        if (getCallbackQueryButtonKey().equals("step10btn")) {
            Message message = getLastSentMessage();
            editTextMessageAsync(message.getMessageId(), message.getText());
            sendTextMessageAsync("С тобой было весело! До встречи!!!!");
        }
        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Твой прогресс: " + getUserGlory());
        }
    }
}
