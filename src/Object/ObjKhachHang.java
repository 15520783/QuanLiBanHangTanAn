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
public class ObjKhachHang {
    private String MaKH;
    private String TenKH;
    private String SDT;
    private String DiaChi;
    private String Email;
    private int TienNo;

    public ObjKhachHang() {
    }

    public ObjKhachHang(String MaKH, String TenKH, String SDT, String DiaChi, String Email, int TienNo) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.TienNo = TienNo;       
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public int getTienNo() {
        return TienNo;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTienNo(int TienNo) {
        this.TienNo = TienNo;
    }
    
    
}
