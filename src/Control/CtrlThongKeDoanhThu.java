/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.Connect;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ICAFE8
 */
public class CtrlThongKeDoanhThu {
    Connect DB = new Connect();
    SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
    public ResultSet LayDanhSachThongKe(String MaLoaiSP,String TenSP,Date tungay,Date denngay){
        try{
            String SQL="Select MaSP,TenSP,MaLoaiSP,TenLoaiSP,DVT,Sum(SoLuong) as SoLuong,Sum(ThanhTien) as DoanhSo " +
                       "from (SELECT SP.MaSP,SP.TenSP,LSP.MaLoaiSP,LSP.TenLoaiSP,SP.DVT,CTL.SoLuong,CTL.ThanhTien " +
                              " FROM CTHDL CTL, HOADONLE HDL,SANPHAM SP,LOAISANPHAM LSP " +
                              " WHERE CTL.SoHDL=HDL.SoHDL AND SP.MaSP=CTL.MaSP AND SP.MaLoaiSP=LSP.MaLoaiSP " +
                              " AND HDL.NgayDat BETWEEN ('" + dt.format(tungay) + "')" +
                              " and('" + dt.format(denngay) + " 23:59:59')" +
                              " union " +
                              " SELECT SP.MaSP, SP.TenSP,LSP.MaLoaiSP,LSP.TenLoaiSP,SP.DVT, (CTS.SoLuong),( CTS.ThanhTien)" +
                              " FROM CTHDS CTS, HOADONSI HDS, SANPHAM SP,LOAISANPHAM LSP" +
                              " WHERE CTS.SoHDS = HDS.SoHDS AND SP.MaSP = CTS.MaSP AND SP.MaLoaiSP=LSP.MaLoaiSP " +
                              " AND HDS.NgayDat BETWEEN('" + dt.format(tungay) + "')" +
                              " and('" + dt.format(denngay) + " 23:59:59'))"+
                              " as B where MaLoaiSP like '%"+MaLoaiSP+"%' and TenSP like '%"+TenSP+"%' group by MaSP,TenSP";
            return DB.GetData(SQL);
        }
        catch(Exception ex){
            System.out.println("Ngoại lệ tại CtrlThongKeDoanhThu.LayDanhSachThongKe:"+ex.getMessage());
        }
        return null;
    }
    
    public ResultSet LayDanhSachLoaiSP(){
        try{
            String SQL="Select * from LoaiSanPham";
            return DB.GetData(SQL);
        }
        catch(Exception ex){
            System.out.println("Ngoại lệ tại CtrlThongKeDoanhThu.LayDanhSachLoaiSP: + "+ex.getMessage());
        }
        return null;
    }
}
