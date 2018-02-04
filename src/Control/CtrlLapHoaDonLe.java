/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Connect.Connect;
import java.sql.ResultSet;
import Model.ModLoaiSanPham;
import java.sql.SQLException;



/**
 *
 * @author ThaiNguyen
 */
public class CtrlLapHoaDonLe {
    Connect DB=new Connect();
    public ResultSet LayDanhSachSanPham(){
        String SQL = "Select SP.MaSP,SP.TenSP,SP.DVT,SP.GiaLe,SP.GiaSi,SP.GiaNhap,SP.MoTa, SP.MaLoaiSP,LSP.TenLoaiSP "
                + "from SANPHAM SP,LOAISANPHAM LSP where SP.MaLoaiSP=LSP.MaLoaiSP order by SP.MaSP ASC";
        return DB.GetData(SQL);
    }
    
    public ResultSet SearchSanPhamByID(String MaSP,String MaLSP){
        String SQL = "Select SP.MaSP,SP.TenSP,SP.DVT,SP.GiaLe,SP.GiaSi,SP.GiaNhap,SP.MoTa, SP.MaLoaiSP,LSP.TenLoaiSP "
                + "from SANPHAM SP,LOAISANPHAM LSP where SP.MaLoaiSP=LSP.MaLoaiSP "
                +" and SP.MaSP like '%"+MaSP+"%'";
        if(!MaLSP.equals("")) SQL+=" and SP.MaLoaiSP ='"+MaLSP+"'";
        SQL+= " order by SP.MaSP ASC";
        return DB.GetData(SQL);
    }
    
    public ResultSet LayDanhSachKhachHang(){
        String SQL="Select * from KHACHHANG order by TenKH ASC";
        return DB.GetData(SQL);
    } 
    
    public ResultSet SearchByName(String TenSP, String MaLSP) {
        String SQL = "Select SP.MaSP,SP.TenSP,SP.DVT,SP.GiaLe,SP.GiaSi,SP.GiaNhap,SP.MoTa, SP.MaLoaiSP,LSP.TenLoaiSP "
                + "from SANPHAM SP,LOAISANPHAM LSP where SP.MaLoaiSP=LSP.MaLoaiSP "
                + " and SP.TenSP like '%" + TenSP + "%'";
        if (!MaLSP.equals("")) {
            SQL += " and SP.MaLoaiSP ='" + MaLSP + "'";
        }
        SQL+= " order by SP.MaSP ASC";
        return DB.GetData(SQL);
    }
    
    public ResultSet LayDanhSachLoaiSanPham(){
        ModLoaiSanPham modLSP = new ModLoaiSanPham();
        return modLSP.GetALL();
    } 
    
    public ResultSet TimKhachHang(String TenKH){
        String SQL="Select * from KhachHang where TenKH like '%"+TenKH+"%' order by TenKH ASC";
        return DB.GetData(SQL);
    }
    
    public String LaySoHDL(){
        String ID="HDL0001";
        ResultSet rs=null;
        String SQL="Select * from HOADONLE order by SoHDL DESC limit 1";
        try{
            rs=DB.GetData(SQL);
            if(rs.next()){
                ID=rs.getString("SoHDL");
                int STT = Integer.parseInt(ID.substring(3));
                STT+=1;
                if(STT<10) ID="HDL000"+STT;
                else if(STT<100) ID="HDL00"+STT;
                else ID="HDL0"+STT;
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại CtrlLapHoaDonLe.LaySoHDL:"+ex.getMessage());
        }
        finally{
            DB.CloseDB();
        }
        return ID;
    }
    
    public String LaySoHDS(){
        String ID="HDS0001";
        ResultSet rs=null;
        String SQL="Select * from HOADONSI order by SoHDS DESC limit 1";
        try{
            rs=DB.GetData(SQL);
            if(rs.next()){
                ID=rs.getString("SoHDS");
                int STT = Integer.parseInt(ID.substring(3));
                STT+=1;
                if(STT<10) ID="HDS000"+STT;
                else if(STT<100) ID="HDS00"+STT;
                else ID="HDS0"+STT;
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại CtrlLapHoaDonLe.LaySoHDS:"+ex.getMessage());
        }
        finally{
            DB.CloseDB();
        }
        return ID;
    }
    
    
    public int LaySoLuongSanPham(String MaSP,String SoHDL){
        int SoLuong=0;
        String SQL = "Select SoLuong from CTHDL where SoHDL='"+SoHDL+"' and MaSP='"+MaSP+"'";
        ResultSet rs = DB.GetData(SQL);
        try {
            if(rs.next()){
                SoLuong=Integer.parseInt(rs.getString("SoLuong"));
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại CtrlLapHoaDonLe.LaySoLuongSanPham:"+ex.getMessage());
            return 0;
        }
        SQL="Select SoLuong from SanPham where MaSP='"+MaSP+"'";
        rs=DB.GetData(SQL);
        try {
            if(rs.next()) return SoLuong+Integer.parseInt(rs.getString("SoLuong"));
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại CtrlLapHoaDonLe.LaySoLuongSanPham:"+ex.getMessage());
        }
        finally{
            DB.CloseDB();
        }
        return 0;
    }
    
    
    public boolean CloseConnection(){
        return DB.CloseDB();
    }

}
