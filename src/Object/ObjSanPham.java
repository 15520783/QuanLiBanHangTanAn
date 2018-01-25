/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author ICAFE8
 */
public class ObjSanPham {
    private String MaSP;
    private String TenSP;
    private String MaLoaiSP;
    private String TenLoaiSP;
    private int GiaLe;
    private int GiaSi;
    private int GiaNhap;
    private String DVT;
    private String MoTa;
    
    public ObjSanPham() {
    }

    public ObjSanPham(String MaSP, String TenSP, String MaLoaiSP, int GiaLe, int GiaSi, int GiaNhap, String DVT, String MoTa) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaLoaiSP = MaLoaiSP;
        this.GiaLe = GiaLe;
        this.GiaSi = GiaSi;
        this.GiaNhap = GiaNhap;
        this.DVT = DVT;
        this.MoTa = MoTa;
    }

    public ObjSanPham(String MaSP, String TenSP, String MaLoaiSP, String TenLoaiSP, int GiaLe, int GiaSi, int GiaNhap, String DVT, String MoTa) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaLoaiSP = MaLoaiSP;
        this.TenLoaiSP = TenLoaiSP;
        this.GiaLe = GiaLe;
        this.GiaSi = GiaSi;
        this.GiaNhap = GiaNhap;
        this.DVT = DVT;
        this.MoTa = MoTa;
    }

    public ObjSanPham(String MaSP, String TenSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public int getGiaLe() {
        return GiaLe;
    }

    public int getGiaSi() {
        return GiaSi;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public String getDVT() {
        return DVT;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public void setTenLoaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }

    public void setGiaLe(int GiaLe) {
        this.GiaLe = GiaLe;
    }

    public void setGiaSi(int GiaSi) {
        this.GiaSi = GiaSi;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
