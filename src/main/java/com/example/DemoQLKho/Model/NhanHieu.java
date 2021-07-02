package com.example.DemoQLKho.Model;

public class NhanHieu {
    private int id;
    private String ten;
    private String mota;

    public NhanHieu() {

    }

    public NhanHieu(int id) {
        super();
        this.id = id;
    }

    public NhanHieu (String ten, String mota) {
        super();
        this.ten = ten;
        this.mota = mota;
    }

    public NhanHieu(int id, String ten, String mota) {
        super();
        this.id = id;
        this.ten = ten;
        this.mota = mota;
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
}
