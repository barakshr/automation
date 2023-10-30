package com.aiola.selenium.pagepbject.bankproject.enums;

public enum CustomerName {

    HermoineGranger("Hermoine Granger"),
    HarryPotter("Harry Potter"),
    RonWeasly("Ron Weasly");
    ///....


    private final String name;

    CustomerName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
