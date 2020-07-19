package com.company.accountmodel.IdentityDocument.children;

import Utils.MyException;
import com.company.accountmodel.IdentityDocument.IdentityDocument;
import com.company.accountmodel.Person.Sex;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Passport extends IdentityDocument {

    /* Класс описывает паспорт. */

    private GregorianCalendar dateOfBirth;
    private String idNumber;
    private String passportNumber;
    private String placeOfBirth;
    private String issuedBy;
    private GregorianCalendar dateOfIssue;
    private GregorianCalendar dateOfExpiry;
    private Sex sex;
    private String codeOfIssuing;
    private String nationality;
    private ArrayList<String> placesOfResidence;

    public Passport()
    {
        super();
        dateOfBirth = new GregorianCalendar();
        idNumber = "";
        passportNumber = "";
        placeOfBirth = "";
        issuedBy = "";
        dateOfIssue = new GregorianCalendar();
        dateOfExpiry = new GregorianCalendar();
        sex = Sex.MAN;
        codeOfIssuing = "";
        nationality = "";
        placesOfResidence = new ArrayList<>();
    }

    public Passport(String surname, String name, String patronymic, GregorianCalendar dateOfBirth, String idNumber, String passportNumber, String placeOfBirth, String issuedBy, GregorianCalendar dateOfIssue, GregorianCalendar dateOfExpiry, Sex sex, String codeOfIssuing, String nationality) {
        super(surname, name, patronymic);
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.passportNumber = passportNumber;
        this.placeOfBirth = placeOfBirth;
        this.issuedBy = issuedBy;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
        this.sex = sex;
        this.codeOfIssuing = codeOfIssuing;
        this.nationality = nationality;
        placesOfResidence = new ArrayList<String>();
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public GregorianCalendar getDateOfIssue() {
        return dateOfIssue;
    }

    public GregorianCalendar getDateOfExpiry() {
        return dateOfExpiry;
    }

    public Sex getSex() {
        return sex;
    }

    public String getCodeOfIssuing() {
        return codeOfIssuing;
    }

    public String getNationality() {
        return nationality;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void setDateOfIssue(GregorianCalendar dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setDateOfExpiry(GregorianCalendar dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setCodeOfIssuing(String codeOfIssuing) {
        this.codeOfIssuing = codeOfIssuing;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPlacesOfResidence(ArrayList<String> placesOfResidence) {
        this.placesOfResidence = placesOfResidence;
    }

    public ArrayList<String> getPlacesOfResidence() {
        return placesOfResidence;
    }

    public void addPlaceOfResidence(String placeOfResidence)
    {
        placesOfResidence.add(placeOfResidence);
    }

    public String getLastPlaceOfResidence() throws MyException {
        int index = placesOfResidence.size() - 1;
        if (index >= 0)
            return placesOfResidence.get(placesOfResidence.size() - 1);
        throw new MyException("В данное поле места прописок еще не вносились");
    }

    @Override
    public String toString() {
        return "Данные паспорта: Фамилия: " + getSurname()
                + ". Имя: " + getName()
                + ". Отчество: " + getPatronymic()
                + ". Дата рождения: " + dateOfBirth.get(Calendar.DAY_OF_MONTH) + "." + dateOfBirth.get(Calendar.MONTH)+ "." + dateOfBirth.get(Calendar.YEAR)
                + ". Идентификационный номер: " + idNumber
                + ". Номер паспорта: " + passportNumber
                + ". Место рождения: " + placeOfBirth
                + ". Выдан: " + issuedBy
                + ". Дата выдачи: " + dateOfIssue.get(Calendar.DAY_OF_MONTH) + "." + dateOfIssue.get(Calendar.MONTH)+ "." + dateOfIssue.get(Calendar.YEAR)
                + ". Годен до: " + dateOfExpiry.get(Calendar.DAY_OF_MONTH) + "." + dateOfExpiry.get(Calendar.MONTH)+ "." +dateOfExpiry.get(Calendar.YEAR)
                + ". Пол: " + sex.getSex()
                + ". Код старны:" + codeOfIssuing
                + ". Гражданство: " + nationality
                + ". Места прописок: " + placesOfResidence.toString();
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }
}