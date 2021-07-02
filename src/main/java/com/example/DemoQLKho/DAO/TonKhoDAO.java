package com.example.DemoQLKho.DAO;

import com.example.DemoQLKho.Model.TonKho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TonKhoDAO {
    private String url;
    private String user;
    private String pass;
    Connection con = null;

    public TonKhoDAO(String _url, String _user, String _pass) {
        url = _url;
        user = _user;
        pass = _pass;
    }

    public void openConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);

            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean insertTonKho(TonKho tk) throws SQLException {
        openConnection();
        String sql = "insert into tonkho (idmathang, idkho, soluong) value (?, ?, ?)";
        PreparedStatement prstatement = con.prepareStatement(sql);
        prstatement.setInt(1, tk.getIdmathang());
        prstatement.setInt(2, tk.getIdkho());
        prstatement.setInt(3, tk.getSoluong());
        boolean insertrow = prstatement.executeUpdate() > 0;
        prstatement.close();
        con.close();
        return insertrow;
    }

    public List<TonKho> getAllTK() throws SQLException {
        String sql = "select * from tonkho";

        List list = new ArrayList<>();
        openConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            int idK = rs.getInt("idkho");
            int idMH = rs.getInt("idmathang");
            int sl = rs.getInt("soluong");
            TonKho tk = new TonKho(id, idK, idMH, sl);
            list.add(tk);
        }
        rs.close();
        statement.close();
        con.close();
        return list;
    }

    public boolean updateTK( TonKho tk) throws SQLException {
        String sql = "update tonkho set idkho=?, idmathang=?, soluong=? where id=?";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, tk.getIdkho());
        pr.setInt(2, tk.getIdmathang());
        pr.setInt(3, tk.getSoluong());
        pr.setInt(4, tk.getId());
        boolean updateok = pr.executeUpdate() > 0;
        pr.close();
        con.close();
        return updateok;
    }

    public boolean deleteTK( TonKho tk) throws SQLException {
        String sql = "delete from tonkho where id=?";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, tk.getId());
        boolean deleteok = pr.execute();
        pr.close();
        con.close();
        return deleteok;
    }

    public TonKho getTK(int id) throws SQLException {
        openConnection();
        TonKho tk=null;
        String sql="select * from tonkho where id=?";
        PreparedStatement pr =con.prepareStatement(sql);
        pr.setInt(1,id);
        ResultSet rs=pr.executeQuery();
        while(rs.next()) {
            int idK = rs.getInt("idkho");
            int idMH = rs.getInt("idmathang");
            int sl = rs.getInt("soluong");
            tk =new TonKho(id,idK,idMH,sl);
        }
        System.out.println(tk.getId());
        return tk;
    }

    public int GetSLForm2ID (int idkho, int idmathang) throws SQLException {
        openConnection();
        String sql="SELECT soluong FROM tonkho WHERE idkho=? AND idmathang=?";
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1,idkho);
        pr.setInt(2,idmathang);
        ResultSet rs = pr.executeQuery();
        int soluongTK = rs.getInt(1);
        System.out.println(soluongTK);
        return soluongTK;
    }

    public boolean updateSLTK(TonKho tk) throws SQLException {
        String sql = "update tonkho set soluong=? where idkho=? and idmathang=?";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, tk.getSoluong());
        pr.setInt(2, tk.getIdkho());
        pr.setInt(3, tk.getIdmathang());
        boolean updateok = pr.executeUpdate() > 0;
        pr.close();
        con.close();
        return updateok;
    }
}
