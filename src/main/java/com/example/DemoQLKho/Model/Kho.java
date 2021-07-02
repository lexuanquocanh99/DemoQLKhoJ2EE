package com.example.DemoQLKho.Model;

public class Kho {
    private int id;
    private String ten;
    private String diadiem;

    public Kho() {

    }

    public Kho(int _id) {
        super();
        this.id = _id;
    }

    public Kho(String _tenkho, String _diadiem) {
        super();
        this.ten = _tenkho;
        this.diadiem =_diadiem;
    }

    public Kho(int _id, String _tenkho, String _diadiem) {
        this.id = _id;
        this.ten = _tenkho;
        this.diadiem = _diadiem;
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

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public void print() {
        System.out.println("ID: "+ id);
        System.out.println("Tenkho: "+ ten);
        System.out.println("Diadiem: "+ diadiem);
    }
}
