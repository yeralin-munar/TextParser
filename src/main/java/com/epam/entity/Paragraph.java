package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Munar on 25.02.2016.
 */
public class Paragraph {
    private List<Sentence> value = new ArrayList<Sentence>();

    Paragraph(String value){
        paragraphParser(value);
    }

    public void paragraphParser(String value){
        String[] sentences = value.split("(?<=([….!?]{1,3}))");
        for (String sentence:sentences) {
            this.value.add(new Sentence(sentence));
        }
    }

    public String getParagraph(){
        StringBuilder paragraph = new StringBuilder();
        for (Sentence sentence: this.value) {
            paragraph.append(sentence.getSentence()+"\n");
        }
        return paragraph.toString();
    }

}
