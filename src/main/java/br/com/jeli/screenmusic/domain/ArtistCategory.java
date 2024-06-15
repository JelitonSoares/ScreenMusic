package br.com.jeli.screenmusic.domain;

public enum ArtistCategory {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String categoryPortuguese;

    ArtistCategory(String categoryPortuguese) {
        this.categoryPortuguese = categoryPortuguese;
    }

    public static ArtistCategory fromPortuguese(String categoryPortuguese) {
        for (ArtistCategory category : ArtistCategory.values()) {
            if (category.categoryPortuguese.equalsIgnoreCase(categoryPortuguese)) {
                return category;
            }
        }

        throw new RuntimeException("Category not found!!");
    }
}
