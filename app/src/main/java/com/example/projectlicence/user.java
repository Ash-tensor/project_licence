package com.example.projectlicence;
public class user {
    int level;
    int str;
    int dex;
    int intl;
    int luk;
    int grade;
    user(int level, int str, int dex, int intl, int luk) {
        this.level = level;
        this.str = str;
        this.dex = dex;
        this.intl = intl;
        this.luk = luk;

    }
    String licences[] = new String[30];

    void setGrade(int grade) {
        this.grade = grade;
    }
    int returnGrade() {
        return this.level;
    }
    void appendLicence(String licence) {
        int tempLength = this.licences.length;
        this.licences[tempLength + 1] = licence;
    }
}
