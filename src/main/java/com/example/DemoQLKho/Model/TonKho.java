package com.example.DemoQLKho.Model;

public class TonKho {
    private int id;
    private int idmathang;
    private int idkho;
    private int soluong;

    public TonKho(int id){
        super();
        this.id = id;
    }

    public TonKho(int id, int idK, int idMH, int sl) {
        super();
        this.id = id;
        this.idkho = idK;
        this.idmathang = idMH;
        this.soluong = sl;
    }

    public TonKho(int idK, int idMH, int sl) {
        super();
        this.idkho = idK;
        this.idmathang = idMH;
        this.soluong = sl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void print() {
        System.out.println("ID: "+ id);
        System.out.println("idCH: "+ idkho);
        System.out.println("idMH: "+ idmathang);
        System.out.println("sl: "+ soluong);

    }
}
