package com.example.DemoQLKho.Model;

import java.sql.Date;

public class Phieu {
    private int id;
    private String loaiphieu;
    private int idmathang;
    private int idkho;
    private int soluong;
    private Date ngay;

    public Phieu() {

    }

    public Phieu(int id) {
        super();
        this.id = id;
    }

    public Phieu(int id, String loaiphieu, int idmathang, int idkho, int soluong, Date ngay) {
        super();
        this.id = id;
        this.loaiphieu = loaiphieu;
        this.idmathang = idmathang;
        this.idkho = idkho;
        this.soluong = soluong;
        this.ngay = ngay;
    }

    public Phieu(String loaiphieu, int idmathang, int idkho, int soluong, Date ngay) {
        super();
        this.loaiphieu = loaiphieu;
        this.idmathang = idmathang;
        this.idkho = idkho;
        this.soluong = soluong;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiphieu() {
        return loaiphieu;
    }

    public void setLoaiphieu(String loaiphieu) {
        this.loaiphieu = loaiphieu;
    }

    public int getIdmathang() {
        return idmathang;
    }

    public void setIdmathang(int idmathang) {
        this.idmathang = idmathang;
    }

    public int getIdkho() {
        return idkho;
    }

    public void setIdkho(int idkho) {
        this.idkho = idkho;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
