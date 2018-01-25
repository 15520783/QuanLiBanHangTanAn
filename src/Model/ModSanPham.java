/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Connect.Connect;
import Object.ObjSanPham;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ThaiNguyen
 */
public class ModSanPham extends Model{

    private PreparedStatement pstmt;
    
    public ModSanPham() {
        DB=new Connect();
        Table="SANPHAM";
        ID="MaSP";
    }

    public ResultSet GetALL(){
        return super.GetALL();
    }
    
    public ResultSet GetByID(String ID){
        return super.GetByID(ID);
    }
    
    public ResultSet SearchByID(String ID){
        return super.SearchByID(ID);
    }
    
    
    
    public boolean Insert(ObjSanPham TbSanPham) {
        String SQL="INSERT INTO SANPHAM (MaSP,TenSP,MaLoaiSP,Giale,GiaSi,GiaNhap,DVT,MoTa) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try{
            if(DB.Connected()){
                pstmt=DB.getConDB().prepareStatement(SQL);
                pstmt.setString(1,TbSanPham.getMaSP());
                pstmt.setString(2,TbSanPham.getTenSP());
                pstmt.setString(3,TbSanPham.getMaLoaiSP());
                pstmt.setString(4,Integer.toString(TbSanPham.getGiaLe()));
                pstmt.setString(5, Integer.toString(TbSanPham.getGiaSi()));
                pstmt.setString(6, Integer.toString(TbSanPham.getGiaNhap()));
                pstmt.setString(7, TbSanPham.getDVT());
                pstmt.setString(8, TbSanPham.getMoTa());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModSanPham.Insert: "+ex.getMessage());
            return false;
        }
        finally{
            DB.CloseDB();
        }
        return true;
    }

    
    public boolean Update(ObjSanPham TbSanPham) {
        String SQL="Update SANPHAM set TenSP=N'" + TbSanPham.getTenSP()+ 
                                    "',Giale='" + TbSanPham.getGiaLe() +
                                    "',GiaSi='" + TbSanPham.getGiaSi() + 
                                    "',GiaNhap='" + TbSanPham.getGiaNhap()+
                                    "',DVT=N'" +TbSanPham.getDVT()+ 
                                    "',MoTa=N'" +TbSanPham.getMoTa() + 
                                    "',MaLoaiSP='"+TbSanPham.getMaLoaiSP()+
       "' where MaSP='"+ TbSanPham.getMaSP()+"';";
       try{
           if(DB.Connected()){
               stmDB=(Statement) DB.getConDB().createStatement();
               stmDB.executeUpdate(SQL);
           }
       } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại ModSanPham.Update: "+ex.getMessage());
       }
       finally{
           DB.CloseDB();
       }
        return false;
    }
    
    public boolean Delete(ObjSanPham TbSanPham){
        return super.Delete(TbSanPham.getMaSP());
    }
}
