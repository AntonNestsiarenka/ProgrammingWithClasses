package com.company.textmodel;

import java.util.ArrayList;

public class Sentence {

    /* Класс реализует предложение из набора слов. */

    private TypeOfSentence typeOfSentence;
    private ArrayList<Word> wordsOfSentence = new ArrayList<>();

    public Sentence()
    {
        typeOfSentence = TypeOfSentence.NARRATIVE;
    }

    public Sentence(TypeOfSentence typeOfSentence, Word...words)
    {
        this.typeOfSentence = typeOfSentence;
        for (Word word : words)
        {
            addWordToSentence(word);
        }
    }

    public Sentence(TypeOfSentence typeOfSentence, ArrayList<Word> words)
    {
        this.typeOfSentence = typeOfSentence;
        addWordToSentence(words);
    }

    public void addWordToSentence(Word word)
    {
        // Добавляет слово в список слов.
        wordsOfSentence.add(word);
    }

    public void addWordToSentence(ArrayList<Word> words)
    {
        // Добавляет в текущий список слов заданный список слов (расширяет предложение).
        wordsOfSentence.addAll(words);
    }

    public void addWordToSentence(Word...words)
    {
        // Добавляет в текущий список слов заданный массив слов (расширяет предложение).
        for (Word word : words)
        {
            addWordToSentence(word);
        }
    }

    public TypeOfSentence getTypeOfSentence() {
        return typeOfSentence;
    }

    public ArrayList<Word> getWordsOfSentence() {
        return wordsOfSentence;
    }

    public void setTypeOfSentence(TypeOfSentence typeOfSentence) {
        this.typeOfSentence = typeOfSentence;
    }

    public void setWordsOfSentence(ArrayList<Word> wordsOfSentence) {
        // Устанавливает предложению новый список слов.
        this.wordsOfSentence = wordsOfSentence;
    }

    public void clearSentence()
    {
        // Удаляет все слова из предложения.
        wordsOfSentence.clear();
    }

    public void printSentence()
    {
        // Вывод предложения в консоль.
        System.out.print(toString());
    }

    @Override
    public String toString() {
        // Собирает предложение в строку.
        StringBuilder sentence = new StringBuilder();
        if (!wordsOfSentence.isEmpty())
        {
            for (int i = 0; i < wordsOfSentence.size() - 1; i++)
            {
                sentence.append(wordsOfSentence.get(i).toString());
                sentence.append(' ');
            }
            sentence.append(wordsOfSentence.get(wordsOfSentence.size() - 1).toString());
            sentence.append(typeOfSentence.toString());
        }
        return sentence.toString();
    }
}