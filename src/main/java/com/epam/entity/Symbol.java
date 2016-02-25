package com.epam.entity;

/**
 * Created by Munar on 25.02.2016.
 */
public class Symbol extends AbstractChar{
    int wordNumber;
    public Symbol(int number, char value) {
        super(value);
        this.wordNumber = number;
    }

    @Override
    public char getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(char value) {
        super.setValue(value);
    }

    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }
}
