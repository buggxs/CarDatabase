package de.buggxs.mygarage.common;

public abstract class Translate {
    protected String translateLanguage(LangModel langModel, String lang) {
        return switch (lang) {
            case LangModel.ENGLISH -> langModel.getNameEn();
            case LangModel.FRANCE -> langModel.getNameFr();
            default -> langModel.getNameDe();
        };
    }
}
