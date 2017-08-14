package com.mycompany.journal;

public class ChatLogger {

    public ChatLogger(String first_name, String last_name, String user_id,
            String message, String replayedMessage, String messageType, String date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_id = user_id;
        this.message = message;
        this.messageType = messageType;
        this.replayedMessage = replayedMessage;
        this.date = date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getMessage() {
        return message;
    }

    public String getReplayedMessage() {
        return replayedMessage;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        String res = user_id + " *** " + first_name + " *** " + last_name
                + " *** " + messageType + " *** " + date + "\n\t" + message
                + "\n\t" + replayedMessage;
        return res;
    }

    private final String first_name;
    private final String last_name;
    private final String user_id;
    private final String message;
    private final String messageType;
    private final String replayedMessage;
    private final String date;
}
