package com.project.mad.fincheck;

/**
 * Created by SAHAJA on 27-03-2018.
 */

public class DB {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FOOD = "food";
    public static final String COLUMN_HEALTH = "health";
    public static final String COLUMN_EDU = "edu";
    public static final String COLUMN_SHOP = "shop";
    public static final String COLUMN_TRAVEL = "travel";
    public static final String COLUMN_MISC = "misc";

    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String food, health, edu, shop, travel, misc;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FOOD + " TEXT,"
                    + COLUMN_HEALTH + " TEXT,"
                    + COLUMN_EDU + " TEXT,"
                    + COLUMN_SHOP + " TEXT,"
                    + COLUMN_TRAVEL + " TEXT,"
                    + COLUMN_MISC + " TEXT,"
                    + COLUMN_TIMESTAMP + " TEXT"
                    + ")";

    public DB() {

    }

    public DB(int id, String food, String health, String edu, String shop, String travel, String misc, String timestamp) {
        this.id = id;
        this.food = food;
        this.health = health;
        this.edu = edu;
        this.shop = shop;
        this.travel = travel;
        this.misc = misc;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}