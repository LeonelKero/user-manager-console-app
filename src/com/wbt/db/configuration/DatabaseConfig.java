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
    public static final String deleteUserById = "delete APP_USER where id = ?";
    public static final String selectAll = "select * from APP_USER";
    public static final String selectUserById = "select * from APP_USER where id = ?";
}
