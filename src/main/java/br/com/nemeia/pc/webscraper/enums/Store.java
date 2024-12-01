package br.com.nemeia.pc.webscraper.enums;

public enum Store {

    KABUM("KaBuM!");

    Store(String name) {
        this.name = name;
    }

    private final String name;

    public String toString() {
        return this.name;
    }
}
