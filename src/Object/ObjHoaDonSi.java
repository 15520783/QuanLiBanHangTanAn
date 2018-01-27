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
public class ObjHoaDonSi {
    private String SoHDS;
    private String MaKH;
    private Date NgayDat;
    private int TongTien;
    private int SoTienDaThanhToan;
    private int SoNoHienTai;

    public ObjHoaDonSi() {
    }

    public ObjHoaDonSi(String SoHDS, String MaKH, Date NgayDat, int TongTien, int SoTienDaThanhToan, int SoNoHienTai) {
        this.SoHDS = SoHDS;
        this.MaKH = MaKH;
        this.NgayDat = NgayDat;
        this.TongTien = TongTien;
        this.SoTienDaThanhToan = SoTienDaThanhToan;
        this.SoNoHienTai = SoNoHienTai;
    }

    public String getSoHDS() {
        return SoHDS;
    }

    public String getMaKH() {
        return MaKH;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public int getTongTien() {
        return TongTien;
    }

    public int getSoTienDaThanhToan() {
        return SoTienDaThanhToan;
    }

    public int getSoNoHienTai() {
        return SoNoHienTai;
    }

    public void setSoHDS(String SoHDS) {
        this.SoHDS = SoHDS;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public void setSoTienDaThanhToan(int SoTienDaThanhToan) {
        this.SoTienDaThanhToan = SoTienDaThanhToan;
    }

    public void setSoNoHienTai(int SoNoHienTai) {
        this.SoNoHienTai = SoNoHienTai;
    }
    
    
}
