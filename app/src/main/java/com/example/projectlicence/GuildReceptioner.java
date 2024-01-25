package com.example.projectlicence;
import java.util.List;

public class GuildReceptioner {
    String name;
    List<String> ConversationList;
    int level;
    int str;
    int dex;
    int intl;
    int luk;
    int grade;
    String condition;
    int lovePoint;
    List<ProjectItem> Inventory;

    public GuildReceptioner(String name, List<String> ConversationList,
                            int level, int str, int dex, int intl,
                            int luk, int grade, String condition,
                            int lovePoint, List<ProjectItem> Inventory) {
        this.name = name;
        this.ConversationList = ConversationList;
        this.level = level;
        this.str = str;
        this.dex = dex;
        this.intl = intl;
        this.luk = luk;
        this.grade = grade;
        this.condition = condition;
        this.lovePoint = lovePoint;
        this.Inventory = Inventory;
    }
}
