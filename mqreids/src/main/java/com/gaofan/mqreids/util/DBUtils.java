package com.gaofan.mqreids.util;

import java.sql.*;

/**
 * @author gaofan
 * @create 2021-05-12 0:19
 */
public class DBUtils {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?characterEncoding=utf-8&useSSL=false", "root", null);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_book where id = ?");
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("-----------------------------");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(name);
        }
    }

}
