package com.wbt.db.configuration;

public class DatabaseConfig {
    public static final String DATABASE_URL = "jdbc:h2:./user-manager;AUTO_SERVER=TRUE";
    private static final String USER_TABLE = "APP_USER";

    public static final String CREATE_USER_TABLE_QUERY =
            "create table if not exists " +
                    USER_TABLE + " (" +
                    "id identity primary key, " +
                    "firstname varchar, " +
                    "lastname varchar," +
                    "email varchar," +
                    "phone varchar)";

    public static final String INSERT_USER_QUERY =
            "insert into " + USER_TABLE + " (firstname, lastname, email, phone)" +
                    " values (?, ?, ?, ?)";

    public static final String deleteUserById = "delete " + USER_TABLE + " where id = ?";
    public static final String selectAll = "select * from " + USER_TABLE;
    public static final String selectUserById = "select * from " + USER_TABLE + " where id = ?";
    public static final String updateUser = "update " + USER_TABLE + " set firstname = ?, lastname = ? where id = ?";
    public static final String selectUserByEmail = "select * from " + USER_TABLE + " where email = ?";
}
