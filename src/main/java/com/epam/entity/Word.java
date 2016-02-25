package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munar on 25.02.2016.
 */
public class Word {
    private List<Letter> value = new ArrayList<Letter>();

    public Word(String value) {
        if (value != null) {
            for (char letter : value.toCharArray()) {
                this.value.add(new Letter(letter));
            }
        }
    }

    public void setValue(String value) {
        for (char letter: value.toCharArray()) {
            this.value.add(new Letter(letter));
        }
    }

    public String getValue() {
        if (this.value == null) return null;
        StringBuilder text = new StringBuilder();
        for (Letter letter:value) {
            text.append(letter.getValue());
        }
        return text.toString();
    }
}
