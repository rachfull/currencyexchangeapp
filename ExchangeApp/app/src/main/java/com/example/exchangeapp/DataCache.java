package com.example.exchangeapp;

public class DataCache {
    private static final DataCache instance = new DataCache();

    public static DataCache getInstance() {
        return instance;
    }

    private DataCache() {}

    private String homeCurrVal = null;
    private String targetCurrVal = null;
    private boolean allWelcomeFieldsFill = false;

    public boolean isAllWelcomeFieldsFill() {
        return allWelcomeFieldsFill;
    }

    public void setAllWelcomeFieldsFill() {
        if (homeCurrVal != null) {
            if (targetCurrVal != null) {
                this.allWelcomeFieldsFill = true;
                return;
            }
        }
        this.allWelcomeFieldsFill = false;
    }





}
