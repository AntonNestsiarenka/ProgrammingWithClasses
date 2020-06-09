package com.company.textmodel;

public class Word {

    private String word;

    public Word()
    {
        word = new String("");
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
