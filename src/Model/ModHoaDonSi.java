/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connect.Connect;
import Object.ObjHoaDonSi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ThaiNguyen
 */
public class ModHoaDonSi extends Model{
    private PreparedStatement pstmt;
    SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    
    public ModHoaDonSi() {
        DB=new Connect();
        Table="HOADONSI";
        ID="SoHDS";
    }

    @Override
    public ResultSet GetALL(){
        return super.GetALL();
    }
    
    @Override
    public ResultSet GetByID(String ID){
        return super.GetByID(ID);
    }
    
    @Override
    public ResultSet SearchByID(String ID){
        return super.SearchByID(ID);
    }

    public boolean Insert(ObjHoaDonSi TbHDS) {
        String mySQL="INSERT INTO HOADONSI (SoHDS,MaKH,NgayDat,TongTien,SoTienDaThanhToan,SoNoHienTai) VALUES (?, ?, ?, ?, ?, ?);";
        //System.out.println("INSERT INTO closer2_quanlicuahangson.HOADONSI (SoHDS,MaKH,NgayLap,NgayGiaoDuKien,TongTien,TinhTrangGiaoHang) VALUES ('"+TbHDS.getSoHDS()+"','"+TbHDS.getMaKH()+"','"+TbHDS.getNgayLap()+"','"+TbHDS.getNgayGiaoDuKien()+"','"+TbHDS.getTongTien()+"','"+TbHDS.getTinhTrangGiaoHang()+"')");
        try{
            if(DB.Connected()){
                pstmt=DB.getConDB().prepareStatement(mySQL);
                pstmt.setString(1,TbHDS.getSoHDS());
                pstmt.setString(2,TbHDS.getMaKH());
                pstmt.setString(3,dt.format(TbHDS.getNgayDat()));
                pstmt.setInt(4,TbHDS.getTongTien());
                pstmt.setInt(5,TbHDS.getSoTienDaThanhToan());
                pstmt.setInt(6,TbHDS.getSoNoHienTai());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModHoaDonSi.Insert:"+ex.getMessage());
            return false;
        }finally{
            DB.CloseDB();
        }       
        return true;
    }


    public boolean Update(ObjHoaDonSi TbHDS) {
        String mySQL="Update HOADONSI set MaKH='"+TbHDS.getMaKH()+
                                              "',NgayDat='"+dt.format(TbHDS.getNgayDat())+
                                              "',TongTien='"+TbHDS.getTongTien()+
                                              "',SoTienDaThanhToan='"+TbHDS.getSoTienDaThanhToan()+
                                              "',SoNoHienTai='"+TbHDS.getSoNoHienTai()+
                                              "' where SoHDS='"+TbHDS.getSoHDS()+"'";
        try{
            if(DB.Connected()){
                pstmt=DB.getConDB().prepareStatement(mySQL);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModHoaDonSi.Update:"+ex.getMessage());
            return false;
        }finally{
            DB.CloseDB();
        }
        return true;
    }
    
    public boolean UpdateTTGHDG(String SoHDS) {//Update tình trạng giao hàng đã giao
        String mySQL="Update HOADONSI set TinhTrangGiaoHang=N'Đã giao' where SoHDS='"+SoHDS+"'";
        try{
            if(DB.Connected()){
                pstmt=DB.getConDB().prepareStatement(mySQL);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModHoaDonSi.UpdateTTGHDG:"+ex.getMessage());
            return false;
        }finally{
            DB.CloseDB();
        }
        return true;
    }
    
    public boolean UpdateTTGHCG(String SoHDS) {//Update tình trạng giao hàng chưa giao
        String mySQL="Update HOADONSI set TinhTrangGiaoHang=N'Chưa giao' where SoHDS='"+SoHDS+"'";
        try{
            if(DB.Connected()){
                pstmt=DB.getConDB().prepareStatement(mySQL);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModHoaDonSi.UpdateTTGHCG:"+ex.getMessage());
            return false;
        }finally{
            DB.CloseDB();
        }
        return true;
    }
    
    @Override
    public boolean Delete(String SoHDS){
        return super.Delete(SoHDS);
    }
}
