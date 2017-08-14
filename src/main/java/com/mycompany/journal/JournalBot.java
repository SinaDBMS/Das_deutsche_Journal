package com.mycompany.journal;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class JournalBot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "425426086:AAFtPbcx_YNjAzZgdudQyQ5yuQ48x2g6O6A";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Chat chat = update.getMessage().getChat();
        ChatLogger logger;
        String f_name = chat.getFirstName();
        String l_name = chat.getLastName();
        String user_name = chat.getUserName();
        String current_date = Calendar.getInstance().getTime().toString();

        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                String txt = update.getMessage().getText();
                String replayMessage;
                MessageProcess mp = new MessageProcess();
                replayMessage = mp.stringProcess(txt, f_name);

                SendMessage message = new SendMessage(
                        update.getMessage().getChatId(), replayMessage);
                logger = new ChatLogger(f_name, l_name, user_name, txt,
                        replayMessage, "Text", current_date);
                sendMessage(message);
                mp.logChat(logger);
            } catch (TelegramApiException ex) {
                Logger.getLogger(JournalBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Das_deutsche_Journal_bot";
    }

}
