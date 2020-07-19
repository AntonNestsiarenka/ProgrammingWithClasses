package com.company.textmodel;

public class Word {

    /* Класс реализует слово. */

    private String word;

    public Word()
    {
        word = "";
    }

    public Word(String word)
    {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}