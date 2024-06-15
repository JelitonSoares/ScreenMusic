package br.com.jeli.screenmusic.domain;

public enum MusicCategory {
    SERTANEJO("Sertanejo"),
    FUNK("Funk"),
    ELETRONICA("Eletrônica"),
    PAGODE("Pagode"),
    ROCK("Rock"),
    POP("Pop");

    private String categoryPortuguese;

  MusicCategory(String categoryPortuguese) {
        this.categoryPortuguese = categoryPortuguese;
    }

    public static MusicCategory fromPortuguese(String categoryPortuguese) {
        for (MusicCategory musicCategory : MusicCategory.values()) {
            if (musicCategory.categoryPortuguese.equalsIgnoreCase(categoryPortuguese)) {
                return musicCategory;
            }
        }

        throw new RuntimeException("Category Not found!!");
    }
}
