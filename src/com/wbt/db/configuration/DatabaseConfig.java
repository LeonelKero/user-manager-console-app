package com.wbt.db.configuration;

public class DatabaseConfig {
    public static final String DATABASE_URL = "jdbc:h2:./user-manager;AUTO_SERVER=TRUE";
    public static final String createUserTable =
            "create table if not exists " +
                    "APP_USER (" +
                    "id identity primary key, " +
                    "firstname varchar, " +
                    "lastname varchar," +
                    "email varchar," +
                    "phone varchar)";
    public static final String insertNewUser =
            "insert into APP_USER (firstname, lastname, email, phone)" +
                    " values (?, ?, ?, ?)";
}
