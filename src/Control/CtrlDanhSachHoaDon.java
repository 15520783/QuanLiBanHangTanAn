/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.Connect;
import Model.ModChiTietHDL;
import Model.ModHoaDonLe;
import Model.ModHoaDonSi;
import Model.ModKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThaiNguyen
 */
public class CtrlDanhSachHoaDon {

    Connect DB = new Connect();
    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");

    public ResultSet LayDanhSachHoaDonLe() {
        try {
            String SQL = "Select HDL.*,KH.* from KHACHHANG KH,HOADONLE HDL where KH.MaKH=HDL.MaKH order by HDL.SoHDL DESC";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.LayDanhSachHoaDonLe: " + ex.getMessage());
        }
        return null;
    }

    public ResultSet LayDanhSachHoaDonSi() {
        try {
            String SQL = "Select HDS.*,KH.* from KHACHHANG KH,HOADONSI HDS where KH.MaKH=HDS.MaKH order by HDS.SoHDS DESC";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.LayDanhSachHoaDonSi: " + ex.getMessage());
        }
        return null;
    }

    public ResultSet LayThongTinChiTietHoaDonLe(String SoHDL) {
        try {
            String SQL = "Select CT.*,SP.TenSP,SP.DVT from SANPHAM SP, CTHDL CT where SP.MaSP=CT.MaSP and CT.SoHDL='" + SoHDL + "' order by SP.TenSP ASC";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.LayThongTinChiTietHoaDonLe: " + ex.getMessage());
        }
        return null;
    }

    public ResultSet LayThongTinChiTietHoaDonSi(String SoHDS) {
        try {
            String SQL = "Select CT.*,SP.TenSP,SP.DVT from SANPHAM SP, CTHDS CT where SP.MaSP=CT.MaSP and CT.SoHDS='" + SoHDS + "' order by SP.TenSP ASC";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.LayThongTinChiTietHoaDonSi: " + ex.getMessage());
        }
        return null;
    }

    public ResultSet LayDanhSachKhachHang() {
        try {
            String SQL = "Select MaKH,TenKH from KHACHHANG";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.LayDanhSachKhachHang:" + ex.getMessage());
        }
        return null;
    }

    public ResultSet TimKiemHDL(String TenKH, String SoHDL, Date tungay, Date denngay) {
        try {
            String SQL = "Select * from HOADONLE where TenKH like '%" + TenKH + "%' and SoHDL like '%" + SoHDL + "%' and NgayLap between ('" + dt1.format(tungay) + "') and ('" + dt1.format(denngay) + "  23:59:59')";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.TimKiemHDL:" + ex.getMessage());
        }
        return null;
    }

    public ResultSet TimKiemHDS(String MaKH, String SoHDS, String TinhTrang, Date tungay, Date denngay) {
        try {
            String SQL = "Select HDS.*,KH.TenKH,KH.DiaChi,KH.SDT from KHACHHANG KH,HOADONSI HDS where KH.MaKH=HDS.MaKH and "
                    + "HDS.MaKH like '%" + MaKH + "%' and HDS.SoHDS like '%" + SoHDS + "%' and HDS.TinhTrangGiaoHang like '%" + TinhTrang + "%'"
                    + " and HDS.NgayLap between ('" + dt1.format(tungay) + "') and ('" + dt1.format(denngay) + " 23:59:59')";
            return DB.GetData(SQL);
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.TimKiemHDS: " + ex.getMessage());
        }
        return null;
    }

    public boolean KiemTraSoHDL(String SoHDL, String MaKH) {
        String SQL = "Select SoHDL from HOADONLE where MaKH='" + MaKH + "' order by SoHDL DESC limit 1";
        ResultSet rs = null;
        rs = DB.GetData(SQL);
        try {
            if (rs.next()) {
                if(rs.getString("SoHDL").equals(SoHDL))
                return true;
                else return false;
            }
            else return true;
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.KiemTraSoHDL:" + ex.getMessage());
        }
        return true;
    }
    
    public boolean KiemTraSoHDS(String SoHDS, String MaKH) {
        String SQL = "Select SoHDS from HOADONSI where MaKH='" + MaKH + "' order by SoHDS DESC limit 1";
        ResultSet rs = null;
        rs = DB.GetData(SQL);
        try {
            if (rs.next()) {
                if(rs.getString("SoHDS").equals(SoHDS))
                return true;
                else return false;
            } 
            else return true;
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlDanhSachHoaDon.KiemTraSoHDL:" + ex.getMessage());
        }
        return true;
    }

    public boolean CloseConnection() {
        return DB.CloseDB();
    }

    public static void main(String args[]) {
        CtrlDanhSachHoaDon ctrl = new CtrlDanhSachHoaDon();
        if(ctrl.KiemTraSoHDL("HDL0001", "KH028")) System.out.println("true");
        else System.out.println("false");
    }
}
