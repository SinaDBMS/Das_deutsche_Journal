package com.mycompany.journal;

import java.util.HashMap;
import java.util.Map;

public class MessageProcess {

    public MessageProcess() {
        dictionary = new HashMap<>();
        String[] hallo = {"Hallo!!!!, wie geht's dir??",
            "Danke dass du an mich gedacht hast!!",
            "Hallo ich heiße Butt :-), und dir??"};
        String[] deutschland = {"Deutschland ist einen schönen Land zu leben!",
            "Wusstest du dass viele Leute nach Deautschland fliegen!", "Lebst du da?"};
        String[] sina = {"Ach ihmmm!!!, ich mag ihm sehr gern!",
            "Er ist alles zu mir", "Sina ist sowohl mein vater als auch meine Mutter!",
            "Der Typ ist mein Vorbild!", "Eines Tages möchte ich wie er werden!!!"};
        String[] du = {"Ich bin ein Bot, Der Butt!! :-)", "Ich besitze auch ein Butt!",
            "Ich hab viel zu viel über mich gesagt, jetzt du bist daran! ;-)"};
        dictionary.put("hallo", hallo);
        dictionary.put("deutschland", deutschland);
        dictionary.put("sina", sina);
        dictionary.put("du", du);
    }

    public String stringProcess(String message, String name) {
        message = message.toLowerCase();
        String replay;
        String[] tmp;
//        if (message.contains("hallo") || message.contains("deutschland")
//                || message.contains("sina") || message.contains("du")) {
        if (dictionary.containsKey(message)) {
            tmp = dictionary.get(message);
            replay = tmp[(int) (tmp.length * Math.random())];
            if (name.equalsIgnoreCase("mil")) {
                replay += ", Amoo Milad :-))))";
            } else {
                name += ", " + replay;
                replay = name;
            }
        } else {
            replay = "Zurzeit bin ich dumm, sogar sehr dumm. Ich kann nur auf die folge"
                    + "nden Wörter reagieren:\n\t1.hallo\n\t2.deuts"
                    + "chland\n\t3.sina\n\t4.du";
        }
        return replay;
    }

    public void logChat(ChatLogger logger) {
        System.out.println(logger);
    }

    private final Map<String, String[]> dictionary;

}
