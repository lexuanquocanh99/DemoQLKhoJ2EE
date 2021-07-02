package com.example.DemoQLKho.Model;

import java.sql.Date;

public class MatHang {
    private int id;
    private String ten;
    private String mota;
    private String chatlieu;
    private String noisx;
    private Date ngaysx;
    private int idnhanhieu;

    public MatHang() {
        super();
    }

    public MatHang(int id) {
        super();
        this.id = id;
    }

    public MatHang(int id, String ten, String mota, String chatlieu, String noisx, Date ngaysx, int idnhanhieu) {
        super();
        this.id = id;
        this.ten = ten;
        this.mota = mota;
        this.chatlieu = chatlieu;
        this.noisx= noisx;
        this.ngaysx = ngaysx;
        this.idnhanhieu = idnhanhieu;
    }

    public MatHang(String ten, String mota, String chatlieu, String noisx, Date ngaysx, int idnhanhieu) {
        super();
        this.ten = ten;
        this.mota = mota;
        this.chatlieu = chatlieu;
        this.noisx= noisx;
        this.ngaysx = ngaysx;
        this.idnhanhieu = idnhanhieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getNoisx() {
        return noisx;
    }

    public void setNoisx(String noisx) {
        this.noisx = noisx;
    }

    public Date getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(Date ngaysx) {
        this.ngaysx = ngaysx;
    }

    public int getIdnhanhieu() {
        return idnhanhieu;
    }

    public void setIdnhanhieu(int idnhanhieu) {
        this.idnhanhieu = idnhanhieu;
    }
}
