package net.bagelvulture.tutorialmod.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum TardigradeVariant {
    DEFAULT(0),
    ORANGE(1),
    BLUE(2),
    GREEN(3),
    PURPLE(4);

    private static final TardigradeVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(TardigradeVariant::getId)).toArray(TardigradeVariant[]::new);
    private final int id;

    TardigradeVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static TardigradeVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}