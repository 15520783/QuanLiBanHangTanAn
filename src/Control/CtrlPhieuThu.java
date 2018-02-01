/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connect.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thanh
 */
public class CtrlPhieuThu {
    Connect DB=new Connect();
    SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    public ResultSet LayDanhSachPhieuThu(){
        String SQL="Select PT.*,KH.* from PHIEUTHU PT, KHACHHANG KH where PT.MaKH=KH.MaKH order by PT.MaPT DESC;";
        return DB.GetData(SQL);           
    }
    public ResultSet LayDanhSachKhachHang(){
        String SQL="Select * from KHACHHANG order by TenKH ASC";
        return DB.GetData(SQL);
    }
    public ResultSet Search(String MaKH,String MaPT){
        String sql="SELECT * FROM PHIEUTHU PT,KHACHHANG KH WHERE PT.MaKH=KH.MaKH AND KH.MaKH like '%"+MaKH+"%' AND PT.MaPT like '%"+MaPT+"%'";
        return DB.GetData(sql);
    }
    public ResultSet Search(Date tungay, Date denngay, String MaKH,String MaPT){
        String sql="SELECT * FROM PHIEUTHU PT,KHACHHANG KH WHERE PT.MaKH=KH.MaKH AND KH.MaKH like '%"+MaKH+"%' AND PT.MaPT like '%"+MaPT+"%' AND  PT.NgayThu BETWEEN '"+dt.format(tungay)+"' and '"+dt.format(denngay)+"'";
        return DB.GetData(sql);
    }
    
    public ResultSet SearchTheoNgay(Date tungay, Date denngay){
        String sql="SELECT * FROM PHIEUTHU,KHACHHANG WHERE PHIEUTHU.MaKH=KHACHHANG.MaKH AND PHIEUTHU.NgayThu BETWEEN '"+dt.format(tungay)+"' and '"+dt.format(denngay)+"'";
        return DB.GetData(sql);
    }
    public ResultSet SearchTheoText(String TenKH, String MaPT, String LyDoThu){
        String sql="SELECT * FROM PHIEUTHU,KHACHHANG WHERE PHIEUTHU.MaKH=KHACHHANG.MaKH AND TenKH like '%"+TenKH+"%' AND MaPT like '%"+MaPT+"%' AND LyDoThu like '%"+LyDoThu+"%'";
        return DB.GetData(sql);
    }
    
    
    public String TaoMaPT(){
        String ID="PT0001";
        ResultSet rs=null;
        String SQL="Select * from PHIEUTHU order by MaPT DESC limit 1";
        try{
            rs=DB.GetData(SQL);
            if(rs.next()){
                ID=rs.getString("MaPT");
                int STT = Integer.parseInt(ID.substring(3));
                STT+=1;
                if(STT<10) ID="PT0000"+STT;
                else if(STT<100) ID="PT000"+STT;
                else if(STT<1000) ID="PT00"+STT;
                else ID="PT0"+STT;
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại CtrlPhieuThu.TaoMaPT:"+ex.getMessage());
        }
        return ID;
    }
    
    public boolean KiemTraPhieuThu(String MaPT, String MaKH) {
        String SQL = "Select MaPT from  PHIEUTHU where MaKH='" + MaKH + "' order by MaPT DESC limit 1";
        ResultSet rs = null;
        rs = DB.GetData(SQL);
        try {
            if (rs.next()) {
                if(rs.getString("MaPT").equals(MaPT))
                return true;
                else return false;
            } 
            else return true;
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại CtrlPhieuThu.KiemTraPhieuThu:" + ex.getMessage());
        }
        return true;
    }
    
    public boolean CloseConnection(){
        return DB.CloseDB();
    }
}
