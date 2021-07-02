package com.example.DemoQLKho.DAO;

import com.example.DemoQLKho.Model.Phieu;
import com.example.DemoQLKho.Model.TonKho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuDAO {
    Connection cnn = null;
    private String url;
    private String user;
    private String pass;

    public PhieuDAO(String _url, String _user, String _pass) {
        url = _url;
        user = _user;
        pass = _pass;
    }
    protected Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi csdl");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cnn;
    }

    public List<Phieu> getAllPhieu() throws SQLException
    {
        List<Phieu> list= new ArrayList<>();
        String sql  = "select * from phieu";
        getConnection();
        Statement statement = cnn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next())
        {
            int id = rs.getInt(1);
            String loaiphieu = rs.getString(2);
            int idkho = rs.getInt(3);
            int idmathang = rs.getInt(4);
            int soluong = rs.getInt(5);
            Date ngay = rs.getDate(6);
            Phieu phieu = new Phieu(id, loaiphieu, idkho, idmathang, soluong, ngay);
            list.add(phieu);
        }
        rs.close();
        statement.close();
        cnn.close();
        return list;
    }

    public boolean Insert(Phieu phieu)throws SQLException {
        // theo cach gege
        getConnection();
        String sql = "INSERT INTO phieu(loaiphieu,idmathang,idkho,soluong,ngay) VALUES (?,?,?,?,?)";
        System.out.println("Ham insert nhan dc data");
        PreparedStatement statement = cnn.prepareStatement(sql);
        statement.setString(1,phieu.getLoaiphieu());
        statement.setInt(2,phieu.getIdmathang());
        statement.setInt(3,phieu.getIdkho());
        statement.setInt(4,phieu.getSoluong());
        statement.setDate(5,phieu.getNgay());

        boolean InsertData = statement.executeUpdate() > 0;
        cnn.close();
        statement.close();
        System.out.println("thanh cong");
        return InsertData;
    }

    public Phieu selectPhieu(int id) throws SQLException { //code tu viet đầu tiên
        getConnection();
        Phieu phieu = null;
        System.out.println("select id: "+id);
        String sql = "SELECT * FROM phieu WHERE id=?";
        PreparedStatement statement = cnn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String loaiphieu = rs.getString(2);
            int idkho = rs.getInt(3);
            int idmathang = rs.getInt(4);
            int soluong = rs.getInt(5);
            Date ngay = rs.getDate(6);
            phieu = new Phieu(id, loaiphieu, idkho, idmathang, soluong, ngay);
        }
        cnn.close();
        statement.close();
        return phieu;
    }

    public boolean delete(Phieu phieu) throws SQLException {
        String sql = "delete from phieu where id = ?";
        getConnection();
        PreparedStatement pr = cnn.prepareStatement(sql);
        pr.setInt(1, phieu.getId());
        boolean deleteok = pr.execute();
        pr.close();
        cnn.close();
        return deleteok;
    }

    public boolean updatePhieu(Phieu phieu) throws SQLException {
        String sql="UPDATE phieu SET loaiphieu=?,idmathang=?,idkho=?,soluong=?,ngay=? WHERE id=?";
        getConnection();
        PreparedStatement statement = cnn.prepareStatement(sql);
        statement.setString(1,phieu.getLoaiphieu());
        statement.setInt(2,phieu.getIdmathang());
        statement.setInt(3,phieu.getIdkho());
        statement.setInt(4,phieu.getSoluong());
        statement.setDate(5,phieu.getNgay());
        statement.setInt(6,phieu.getId());
        boolean x = statement.executeUpdate() > 0;
        cnn.close();
        statement.close();
        return x;
    }

    public int GetSLForm2ID (int idkho, int idmathang) throws SQLException {
        getConnection();
        int soluongTK = 0;
        String sql="SELECT soluong FROM tonkho WHERE idkho=? AND idmathang=?";
        PreparedStatement pr = cnn.prepareStatement(sql);
        pr.setInt(1,idkho);
        pr.setInt(2,idmathang);
        ResultSet rs = pr.executeQuery();
        while(rs.next()) {
            soluongTK = rs.getInt(1);
        }
        System.out.println(soluongTK);
        return soluongTK;
    }

    public boolean updateSLTK(TonKho tk) throws SQLException {
        String sql = "update tonkho set soluong=? where idkho=? and idmathang=?";
        getConnection();
        PreparedStatement pr = cnn.prepareStatement(sql);
        pr.setInt(1, tk.getSoluong());
        pr.setInt(2, tk.getIdkho());
        pr.setInt(3, tk.getIdmathang());
        boolean updateok = pr.executeUpdate() > 0;
        pr.close();
        cnn.close();
        return updateok;
    }

}
