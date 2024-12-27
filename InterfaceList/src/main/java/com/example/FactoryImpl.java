package com.example;

import com.example.DAO.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FactoryImpl implements IOwnerDB<Factory> {
    private Connection conn;

    @Override
    public void disconnect() throws SQLException {
        if (conn != null){
            try {
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();                //появление ошибки в случае невыполнения
            }
        }
    }
    @Override
    public void connect() throws Exception {
        try{
            conn = DBConnection.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();                   //появление ошибки в случае невыполнения
        }
    }

    //загрузка всех элементов
    @Override
    public List<Factory> selectAll() throws Exception {

        conn = DBConnection.getConnection();

        List<Factory> factories = new ArrayList<>();   //создание списка
        String query = "SELECT * from factory"; //запрос для получения всех элементов

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            //считывание элементов
            while (rs.next()) { String name = rs.getString("name");
                String country = rs.getString("country");
                factories.add(new Factory(name, country)); //добавление полученных элементов в список
            }
        }

        catch (SQLException e) {
            throw new Exception("Ошибка извлечения данных", e); //появление ошибки
        } return factories;
    }
}
