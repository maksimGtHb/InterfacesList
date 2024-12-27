package com.example;

import com.example.DAO.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class CarImplTest {

    private CarImpl carImpl;
    private final Connection conn;

    public CarImplTest(Connection conn) {
        this.conn = conn;               //конструктор
    }

    @BeforeEach
    public void setUp() {
        carImpl = new CarImpl();      //установка параметров перед тестированием

    }

    @Test
    public void disconnectTest() throws SQLException {

        carImpl.disconnect();
        assertNull(conn);     //проверка подключения на "null"
    }

    @Test
    public void connectTest() throws Exception {

        carImpl.connect();
        assertNotNull(conn); //проверка подключения на "не null"
        String dataBaseName = conn.getCatalog(); // получение имени подключаемой базы данных
        assertEquals("postgres", dataBaseName, "Имя базы данных должно быть 'postgres'");
    }

    @Test
    public void selectAllTest() throws Exception {

        List<Car> cars = carImpl.selectAll();
        assertEquals(2, cars.size(), "Должно быть два элемента.");
        assertEquals("Corolla", cars.get(0).getModel(), "Должно быть совпадение с 'Corolla'.");
        assertEquals("JJE", cars.get(1).getVersion(), "Должно быть совпадение с 'JJE'.");
    }
}
