package com.company.Student;

public class Student {

    /* Класс описывает студента. */

    private String name;
    private String groupName;
    private int[] progress;

    public Student()
    {
        name = "";
        groupName = "";
        progress = new int[5];
    }

    public Student(String name, String groupName, int[] progress)
    {
        this.name = name;
        this.groupName = groupName;
        this.progress = progress;
    }

    public boolean isExcellentStudent()
    {
        // Является ли студент отличником.
        for (int mark : this.progress)
        {
            if (mark != 9 && mark != 10)
            {
                return false;
            }
        }
        return true;
    }

    public static void printStudentsInfoWithHighMarks(Student[] students)
    {
        // Вывод информации о студентах с высокими оценками: 9 или 10.
        System.out.println("Высокая успеваемость у студентов:");
        for (Student student : students)
        {
            if (student.isExcellentStudent())
            {
                System.out.printf("ФИО: %s. Группа: %s.\n", student.name, student.groupName);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    public void setSomeProgress(int index, int value) throws ArrayIndexOutOfBoundsException {
        /* Устанавливает некоторое значение value на заданную позицию в массиве успеваемости. Если такого элемента
           в массиве не существует, то бросает исключение. */
        if (index >= 0 && index < progress.length)
        {
            progress[index] = value;
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException("Попытка присвоить значение в несуществующий элемент массива");
        }
    }
}