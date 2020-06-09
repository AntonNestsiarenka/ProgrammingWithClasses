package com.company.textmodel;

public enum TypeOfSentence {

    NARRATIVE ('.', "Narrativ"),
    QUESTION ('?', "Question"),
    EXCLAMATION ('!', "Exclamation");

    private char sentenceEndSymbol;
    private String typeOfSentence;

    TypeOfSentence()
    {
        sentenceEndSymbol = '.';
        typeOfSentence = "Narrativ";
    }

    TypeOfSentence(char symbol, String typeOfSentence)
    {
        sentenceEndSymbol = symbol;
        this.typeOfSentence = typeOfSentence;
    }

    public char getSentenceEndSymbol() {
        return sentenceEndSymbol;
    }

    public String getTypeOfSentence() {
        return typeOfSentence;
    }

    @Override
    public String toString() {
        return String.valueOf(sentenceEndSymbol);
    }
}