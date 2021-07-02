package com.example.DemoQLKho.DAO;

import com.example.DemoQLKho.Model.NhanHieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanHieuDAO {
    private String url = "jdbc:mysql://localhost:3306/quanlykho?useSSL=false";
    private String username = "root";
    private String password = "";
    Connection connection = null;

    private static final String Insert_NH_Query = "INSERT INTO nhanhieu (ten, mota) VALUES (?, ?);";
    private static final String Select_NH_By_Id_Query = "SELECT id, ten, mota FROM nhanhieu WHERE id = ?;";
    private static final String Select_All_NH_Query = "SELECT * FROM nhanhieu;";
    private static final String Update_NH_Query = "UPDATE nhanhieu SET ten = ?, mota = ? WHERE id = ?;";
    private static final String Delete_NH_Query = "DELETE FROM nhanhieu WHERE id = ?;";

    public NhanHieuDAO() {}

    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertBrand(NhanHieu brand) throws SQLException {
        openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Insert_NH_Query);
        preparedStatement.setString(1, brand.getTen());
        preparedStatement.setString(2, brand.getMota());
        boolean insertRow = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return insertRow;
    }

    public List< NhanHieu > getAllBrands() throws SQLException {
        openConnection();
        List brandList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Select_All_NH_Query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            NhanHieu brand = new NhanHieu(id, name, description);
            brandList.add(brand);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return brandList;
    }

    public boolean deleteBrand(NhanHieu brand) throws SQLException {
        openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Delete_NH_Query);
        preparedStatement.setInt(1, brand.getId());
        boolean is_deleted = preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return is_deleted;
    }

    public boolean updateBrand(NhanHieu brand) throws SQLException {
        openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Update_NH_Query);
        preparedStatement.setString(1, brand.getTen());
        preparedStatement.setString(2, brand.getMota());
        preparedStatement.setInt(3, brand.getId());
        boolean is_updated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        connection.close();
        return is_updated;
    }

    public NhanHieu getBrandById(int id) throws SQLException {
        openConnection();
        NhanHieu brand = null;
        PreparedStatement preparedStatement = connection.prepareStatement(Select_NH_By_Id_Query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            brand = new NhanHieu(id, name, description);
        }
        return brand;
    }
}
