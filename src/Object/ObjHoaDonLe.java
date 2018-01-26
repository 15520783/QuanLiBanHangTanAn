/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Date;

/**
 *
 * @author ICAFE8
 */
public class ObjHoaDonLe {
    private String SoHDL;
    private String MaKH;
    private Date NgayDat;
    private int SoTienDaThanhToan;
    private int TongTien;
    private int SoNoHienTai;

    public ObjHoaDonLe() {
    }

    public ObjHoaDonLe(String SoHDL, String MaKH, Date NgayDat, int SoTienDaThanhToan, int TongTien, int SoNoHienTai) {
        this.SoHDL = SoHDL;
        this.MaKH = MaKH;
        this.NgayDat = NgayDat;
        this.SoTienDaThanhToan = SoTienDaThanhToan;
        this.TongTien = TongTien;
        this.SoNoHienTai = SoNoHienTai;
    }

    public String getSoHDL() {
        return SoHDL;
    }

    public String getMaKH() {
        return MaKH;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public int getSoTienDaThanhToan() {
        return SoTienDaThanhToan;
    }

    public int getTongTien() {
        return TongTien;
    }

    public int getSoNoHienTai() {
        return SoNoHienTai;
    }

    public void setSoHDL(String SoHDL) {
        this.SoHDL = SoHDL;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public void setSoTienDaThanhToan(int SoTienDaThanhToan) {
        this.SoTienDaThanhToan = SoTienDaThanhToan;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public void setSoNoHienTai(int SoNoHienTai) {
        this.SoNoHienTai = SoNoHienTai;
    }
    
    
}
