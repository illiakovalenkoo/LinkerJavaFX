package org.feodal.projectjavafx;

import java.sql.*;

public class DB {


    private Connection dbConn = null;

    private final String URL = "jdbc:mysql://localhost:3306/spring3_db";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private Connection getDbConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void isConnected() throws ClassNotFoundException, SQLException {
        dbConn = getDbConnection();
        System.out.println("Connection" + (dbConn.isValid(1000) ? " done" : " not done"));
    }

    public ResultSet getAll() {
        String sql = "SELECT * FROM `links`";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getOneLink(String id) {
        String sql = "SELECT * FROM `links` WHERE `id` = ?";
        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.setString(1, id);
            return statement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addLink(String longLink, String shortLink) {
        String sql = "INSERT INTO `links` (`long_link`, `short_link`) VALUES (?, ?)";
        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.setString(1, longLink);
            statement.setString(2, shortLink);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isExists(String shortLink) {
        String sql = "SELECT * FROM `links` WHERE `short_link` = ?";
        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.setString(1, shortLink);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteLink(String id) {
        String sql = "DELETE FROM `links` WHERE `id` = ?";
        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
