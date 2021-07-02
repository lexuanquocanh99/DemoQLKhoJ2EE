package com.example.DemoQLKho.DAO;

import com.example.DemoQLKho.Model.MatHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatHangDAO {
    private String url;
    private String user;
    private String pass;
    Connection con = null;

    public MatHangDAO(String _url, String _user, String _pass) {
        url = _url;
        user = _user;
        pass = _pass;
    }

    public void openConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertMatHang(MatHang mh) throws SQLException {
        openConnection();
        String sql = "INSERT INTO mathang(ten, mota, chatlieu, noisx, idnhanhieu, ngaysx) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prstatement = con.prepareStatement(sql);
        prstatement.setString(1, mh.getTen());
        prstatement.setString(2, mh.getMota());
        prstatement.setString(3, mh.getChatlieu());
        prstatement.setString(4, mh.getNoisx());
        prstatement.setInt(5, mh.getIdnhanhieu());
        prstatement.setDate(6, mh.getNgaysx());
        boolean insertrow = prstatement.executeUpdate() > 0;
        prstatement.close();
        con.close();
        return insertrow;
    }

    public boolean updateMatHang(MatHang mh) throws SQLException {
        String sql = "UPDATE mathang SET ten = ?, mota = ? ,chatlieu = ? , noisx = ?, idnhanhieu = ? , ngaysx = ? WHERE id = ?";
        openConnection();
        PreparedStatement prstatement = con.prepareStatement(sql);
        prstatement.setString(1, mh.getTen());
        prstatement.setString(2, mh.getMota());
        prstatement.setString(3, mh.getChatlieu());
        prstatement.setString(4, mh.getNoisx());
        prstatement.setInt(5, mh.getIdnhanhieu());
        prstatement.setDate(6, mh.getNgaysx());
        prstatement.setInt(7, mh.getId());
        boolean updateok = prstatement.execute();
        prstatement.close();
        con.close();
        return updateok;
    }

    public boolean deleteMH(MatHang mh) throws SQLException {
        String sql = "delete from mathang where id = ?";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, mh.getId());
        boolean deleteok = pr.execute();
        pr.close();
        con.close();
        return deleteok;
    }

    public ArrayList<MatHang> getAllMH() throws SQLException {
        String sql = "select * from mathang";
        ArrayList<MatHang> list = new ArrayList<>();
        openConnection();
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            String ten = rs.getString(2);
            String mota = rs.getString(3);
            String chatlieu = rs.getString(4);
            String noisx = rs.getString(5);
            int idnhanhieu = rs.getInt(6);
            Date ngaysx = rs.getDate(7);
            MatHang mh = new MatHang(id, ten, mota, chatlieu, noisx, ngaysx, idnhanhieu);
            list.add(mh);
        }
        rs.close();
        sta.close();
        con.close();
        return list;
    }

    public MatHang getMHByID(int id) throws SQLException {
        openConnection();
        String sql = "select * from mathang WHERE id = ?";
        MatHang mh = null;
        PreparedStatement pr =(PreparedStatement) con.prepareStatement(sql);
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String ten = rs.getString(2);
            String mota = rs.getString(3);
            String chatlieu = rs.getString(4);
            String noisx = rs.getString(5);
            int idnhanhieu = rs.getInt(6);
            Date ngaysx = rs.getDate(7);
            mh = new MatHang(id, ten, mota, chatlieu, noisx, ngaysx ,idnhanhieu);
        }
        rs.close();
        pr.close();
        con.close();
        return mh;
    }

}
