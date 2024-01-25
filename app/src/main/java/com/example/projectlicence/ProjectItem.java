package com.example.projectlicence;

public class ProjectItem {
    int RequiredLevel;
    int RequiredStr;
    int RequiredDex;
    int RequiredIntl;
    int RequiredLuk;
    int RequiredGrade;
    int SellPrice;
    int BuyPrice;
    String Name;
    String Description;
    Rareity rareity;
    String Type;

    public ProjectItem(int RequiredLevel, int RequiredStr, int RequiredDex, int RequiredIntl, int RequiredLuk, int RequiredGrade, int SellPrice, int BuyPrice, String Name, String Description, Rareity rareity, String Type) {
        this.RequiredLevel = RequiredLevel;
        this.RequiredStr = RequiredStr;
        this.RequiredDex = RequiredDex;
        this.RequiredIntl = RequiredIntl;
        this.RequiredLuk = RequiredLuk;
        this.RequiredGrade = RequiredGrade;
        this.SellPrice = SellPrice;
        this.BuyPrice = BuyPrice;
        this.Name = Name;
        this.Description = Description;
        this.rareity = rareity;
        this.Type = Type;
    }
}
