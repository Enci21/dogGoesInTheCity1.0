package com.doggoesinthecity.doggoesapp.model;

public enum Type {
    RESTAURANT("Restaurant"),
    SHOP("Shop"),
    COFFEE("Coffee"),
    PUB("Pub"),
    HOTEL("Hotel"),
    CONFECTIONERY("Confectionery");

    public final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
