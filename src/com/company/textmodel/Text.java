package com.company.textmodel;

import java.util.ArrayList;

public class Text {

    private String heading;
    private ArrayList<Sentence> sentences;

    public Text()
    {
        heading = "";
        sentences = new ArrayList<Sentence>();
    }

    public Text(String heading, Sentence sentence)
    {
        this.heading = heading;
        sentences = new ArrayList<Sentence>();
        addSentenceToText(sentence);
    }

    public Text(String heading, ArrayList<Sentence> sentences)
    {
        this.heading = heading;
        this.sentences = new ArrayList<Sentence>();
        addSentencesToText(sentences);
    }

    public Text(String heading, Sentence...sentences)
    {
        this.heading = heading;
        this.sentences = new ArrayList<Sentence>();
        for (Sentence sentence : sentences)
        {
            addSentenceToText(sentence);
        }
    }

    public void addSentenceToText(Sentence sentence)
    {
        sentences.add(sentence);
    }

    public void addSentencesToText(ArrayList<Sentence> sentences)
    {
        this.sentences.addAll(sentences);
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void clearText()
    {
        sentences.clear();
    }

    public void printText()
    {
        // Вывод в консоль текста.
        System.out.println(toString());
    }

    @Override
    public String toString() {
        // Собирает предложения в текст.
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < sentences.size() - 1; i++)
        {
            text.append(sentences.get(i).toString());
            text.append(' ');
        }
        text.append(sentences.get(sentences.size() - 1).toString());
        return heading + "\n" + "\u2029" + text.toString();
    }
}