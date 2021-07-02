package com.example.DemoQLKho.DAO;

import com.example.DemoQLKho.Model.Kho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoDAO {
    private String url;
    private String user;
    private String pass;
    Connection con = null;

    public KhoDAO(String _url, String _user, String _pass) {
        url = _url;
        user = _user;
        pass = _pass;
    }

    public void  openConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);

            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertKho(Kho kho) throws SQLException {
        openConnection();
        String sql = "insert into kho (ten,diadiem) value (?,?)";
        PreparedStatement prstatement = con.prepareStatement(sql);
        prstatement.setString(1, kho.getTen());
        prstatement.setString(2, kho.getDiadiem());
        boolean insertrow = prstatement.executeUpdate() != 0;
        prstatement.close();
        con.close();
        return insertrow;
    }

    public List<Kho> getAllKho() throws SQLException {
        String sql = "select * from kho";

        List list = new ArrayList<>();
        openConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String tenkho = rs.getString(2);
            String diadiem = rs.getString(3);
            Kho kho = new Kho(id,tenkho,diadiem);
            list.add(kho);
        }
        rs.close();
        statement.close();
        con.close();
        return list;
    }

    public boolean updateK(Kho k) throws SQLException {
        String sql = "update kho set ten=?,diadiem=? where id=? ";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(3, k.getId());
        pr.setString(1,k.getTen());
        pr.setString(2, k.getDiadiem());
        boolean updateok = pr.executeUpdate() > 0;
        pr.close();
        con.close();
        return updateok;
    }

    public boolean deleteKho(Kho kho) throws SQLException {
        String sql = "delete from kho where id=?";
        openConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, kho.getId());
        boolean deleteok = pr.execute();
        pr.close();
        con.close();
        return deleteok;

    }
    public  Kho getKho(int id) throws SQLException {
        openConnection();
        Kho kho=null;
        String sql="select * from kho where id=?";
        PreparedStatement pr =con.prepareStatement(sql);
        pr.setInt(1,id);
        ResultSet rs=pr.executeQuery();
        while(rs.next()) {
            String tenkho=rs.getString(2);
            String diadiem=rs.getString(3);
            kho=new Kho(id,tenkho,diadiem);
        }
        System.out.println(kho.getId());
        return kho;
    }

}
