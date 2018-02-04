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
public class ObjTaiKhoan {
    private String ID;
    private String Pass;
    private String Ten;

    public ObjTaiKhoan() {
    }

    public ObjTaiKhoan(String ID, String Pass, String Ten) {
        this.ID = ID;
        this.Pass = Pass;
        this.Ten = Ten;
    }

    public ObjTaiKhoan(String ID, String Pass) {
        this.ID = ID;
        this.Pass = Pass;
    }

    public String getID() {
        return ID;
    }

    public String getPass() {
        return Pass;
    }

    public String getTen() {
        return Ten;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
}
