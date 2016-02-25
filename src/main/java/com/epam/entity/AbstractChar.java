package com.epam.entity;

/**
 * Created by Munar on 25.02.2016.
 */
abstract class AbstractChar {
    private char value;

    public AbstractChar(char value) {
        this.value = value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
