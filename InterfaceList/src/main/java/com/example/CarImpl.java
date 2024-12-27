package com.example;

import com.example.DAO.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarImpl implements IOwnerDB<Car> {

    private Connection conn;

    @Override
    public void disconnect() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();       //появление ошибки в случае невыполнения
            }
        }
    }

    @Override
    public void connect() throws Exception {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();      //появление ошибки в случае невыполнения
        }
    }

                                       //загрузка всех элементов
    @Override
    public List<Car> selectAll() throws Exception {
        conn = DBConnection.getConnection();

        List<Car> cars = new ArrayList<>(); //создание списка
        String query = "SELECT * from car"; //запрос для получения всех элементов

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            //считывание элементов
            while (rs.next()) {
                String model = rs.getString("model");  //получение элементов в пользовательский класс
                String version = rs.getString("version"); //
                cars.add(new Car(model, version)); //добавление полученных элементов в список
            }
        }
        catch (SQLException e) {
            throw new Exception("Ошибка извлечения данных", e); //появление ошибки
        } return cars;
    }
}

