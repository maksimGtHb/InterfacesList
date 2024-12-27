package com.example;

import java.sql.SQLException;
import java.util.List;

public interface IOwnerDB<T> {
    public void disconnect() throws SQLException;
    public void connect() throws Exception;
    public List<T> selectAll() throws Exception;
}