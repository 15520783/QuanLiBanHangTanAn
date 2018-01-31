/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Connect.Connect;
import Control.CtrlLapHoaDonLe;
import java.awt.Color;
import javax.swing.JPanel;
import Edit.Edit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import Model.ModChiTietHDL;
import Model.ModChiTietHDS;
import Model.ModHoaDonSi;
import Object.ObjChiTietHDL;
import Object.ObjChiTietHDS;
import Object.ObjHoaDonSi;
import Object.ObjKhachHang;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.JOptionPane;

/**
 *
 * @author ThaiNguyen
 */
public class FormDuyetHoaDonSi extends javax.swing.JFrame {

    boolean ChinhSua = false;
    ArrayList<ObjChiTietHDS> ListCTHDS = new ArrayList<>();
    ObjHoaDonSi ObjHDS = new ObjHoaDonSi();
    ModHoaDonSi modHDS = new ModHoaDonSi();
    ModChiTietHDS modCTHDS = new ModChiTietHDS();
    Edit editFrm = new Edit();
    boolean LuuThanhCong = false;
    FormLapHoaDonSi frmLapHDS;

    /**
     * Creates new form FormDuyetHoaDon
     */
    public FormDuyetHoaDonSi() {
    }

    public FormDuyetHoaDonSi(String SoHDS, Date NgayLap, String TongTien, ObjKhachHang ObjKH, ArrayList<ObjChiTietHDS> listGioHang) {
        initComponents();
        LoadForm();
        jtxtDiaChi.setLineWrap(true);
        EnableComponent(true);
        jtxtSoHDS.setText(SoHDS);
        jtxtTenKH.setText(ObjKH.getTenKH());
        jtxtMaKH.setText(ObjKH.getMaKH());
        jtxtSDT.setText(ObjKH.getSDT());
        jtxtDiaChi.setText(ObjKH.getDiaChi());
        jDateNgayLap.setDate(NgayLap);
        jtxtTongTien.setText(TongTien);
        jtxtSoTienNo.setText(String.format("%,d", ObjKH.getTienNo()));
        jtxtSoTienCanThanhToan.setText(String.format("%,d", Integer.parseInt(TongTien.replace(",", "")) + ObjKH.getTienNo()));
        DefaultTableModel Model = (DefaultTableModel) jTbCTHDS.getModel();

        for (int i = 0; i < listGioHang.size(); i++) {
            Vector v = new Vector();
            ObjChiTietHDS ObjCTHDS = new ObjChiTietHDS(listGioHang.get(i).getMaSP(), listGioHang.get(i).getTenSP(), listGioHang.get(i).getDVT(), listGioHang.get(i).getSoLuong(), listGioHang.get(i).getDonGia());
            ListCTHDS.add(ObjCTHDS);
            v.add(listGioHang.get(i).getMaSP());
            v.add(listGioHang.get(i).getTenSP());
            v.add(listGioHang.get(i).getDVT());
            v.add(listGioHang.get(i).getSoLuong());
            v.add(String.format("%,d", listGioHang.get(i).getDonGia()));
            v.add(String.format("%,d", listGioHang.get(i).getThanhTien()));
            Model.addRow(v);
        }
    }
    
     public FormDuyetHoaDonSi(ObjHoaDonSi objectHDS, ObjKhachHang ObjKH, ArrayList<ObjChiTietHDS> listGioHang,String TongTien) {
        initComponents();
        LoadForm();
        ObjHDS=objectHDS;
        jtxtDiaChi.setLineWrap(true);
        EnableComponent(true);
        jtxtSoHDS.setText(objectHDS.getSoHDS());
        jtxtTenKH.setText(ObjKH.getTenKH());
        jtxtMaKH.setText(ObjKH.getMaKH());
        jtxtSDT.setText(ObjKH.getSDT());
        jtxtDiaChi.setText(ObjKH.getDiaChi());
        jDateNgayLap.setDate(objectHDS.getNgayDat());
        jtxtTongTien.setText(TongTien);
        jtxtSoTienNo.setText(String.format("%,d", objectHDS.getSoNoHienTai()));
        jtxtSoTienCanThanhToan.setText(String.format("%,d", Integer.parseInt(TongTien.replace(",", "")) + objectHDS.getSoNoHienTai()));
        jtxtSoTienDaThanhToan.setText(String.format("%,d", objectHDS.getSoTienDaThanhToan()));
        DefaultTableModel Model = (DefaultTableModel) jTbCTHDS.getModel();

        for (int i = 0; i < listGioHang.size(); i++) {
            Vector v = new Vector();
            ObjChiTietHDS ObjCTHDS = new ObjChiTietHDS(listGioHang.get(i).getMaSP(), listGioHang.get(i).getTenSP(), listGioHang.get(i).getDVT(), listGioHang.get(i).getSoLuong(), listGioHang.get(i).getDonGia());
            ListCTHDS.add(ObjCTHDS);
            v.add(listGioHang.get(i).getMaSP());
            v.add(listGioHang.get(i).getTenSP());
            v.add(listGioHang.get(i).getDVT());
            v.add(listGioHang.get(i).getSoLuong());
            v.add(String.format("%,d", listGioHang.get(i).getDonGia()));
            v.add(String.format("%,d", listGioHang.get(i).getThanhTien()));
            Model.addRow(v);
        }
    }

    public void LoadForm() {
        jPanel1.setBackground(new Color(0, 0, 0, 0));

        JPanel ListPn[] = new JPanel[]{jPanel2, jPanel3};
        editFrm.MakeTransparentPanel(ListPn);

        JPanel ListTitle[] = new JPanel[]{jPnCTHDL, jPnThongtinHD};
        editFrm.MakeTransparentTitle(ListTitle);

        JPanel ListButton[] = new JPanel[]{jBtnLuu, jBtnBack, jBtnXemPhieuIn};
        editFrm.MakeTransparentButton(ListButton);

        editFrm.MakeTransparentTable(jScrCTHDS, jTbCTHDS);
    }

    public void EnableComponent(boolean Active) {
        jBtnLuu.setVisible(Active);
        jlbLuu.setEnabled(Active);
        jBtnXemPhieuIn.setVisible(!Active);
        jlbIn.setEnabled(!Active);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnGroupTinhTrangGiaoHang = new javax.swing.ButtonGroup();
        jBtnBack = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jBtnLuu = new javax.swing.JPanel();
        jlbLuu = new javax.swing.JLabel();
        jBtnLuu1 = new javax.swing.JPanel();
        jlbLuu1 = new javax.swing.JLabel();
        jBtnXemPhieuIn = new javax.swing.JPanel();
        jlbIn = new javax.swing.JLabel();
        jBtnXemPhieuIn1 = new javax.swing.JPanel();
        jlbIn1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPnThongtinHD = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtSoHDS = new javax.swing.JTextField();
        jtxtTenKH = new javax.swing.JTextField();
        jtxtTongTien = new javax.swing.JTextField();
        jDateNgayLap = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jtxtMaKH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtSDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtDiaChi = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jtxtSoTienNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtxtSoTienCanThanhToan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtxtSoTienDaThanhToan = new javax.swing.JTextField();
        jScrCTHDS = new javax.swing.JScrollPane();
        jTbCTHDS = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPnCTHDL = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1200, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnBackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnBackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnBackMouseReleased(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Left_40px.png"))); // NOI18N

        javax.swing.GroupLayout jBtnBackLayout = new javax.swing.GroupLayout(jBtnBack);
        jBtnBack.setLayout(jBtnBackLayout);
        jBtnBackLayout.setHorizontalGroup(
            jBtnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnBackLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jBtnBackLayout.setVerticalGroup(
            jBtnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnBackLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jBtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jBtnLuu.setBackground(new java.awt.Color(204, 204, 204));
        jBtnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLuuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnLuuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnLuuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnLuuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnLuuMouseReleased(evt);
            }
        });
        jBtnLuu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbLuu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Save_55px.png"))); // NOI18N
        jBtnLuu.add(jlbLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 65, 70));

        getContentPane().add(jBtnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 230, -1));

        jBtnLuu1.setBackground(new java.awt.Color(204, 204, 204));
        jBtnLuu1.setOpaque(false);
        jBtnLuu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLuu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnLuu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnLuu1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnLuu1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnLuu1MouseReleased(evt);
            }
        });
        jBtnLuu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbLuu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLuu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Save_55px.png"))); // NOI18N
        jlbLuu1.setEnabled(false);
        jBtnLuu1.add(jlbLuu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 65, 70));

        getContentPane().add(jBtnLuu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 230, -1));

        jBtnXemPhieuIn.setBackground(new java.awt.Color(204, 204, 204));
        jBtnXemPhieuIn.setPreferredSize(new java.awt.Dimension(102, 50));
        jBtnXemPhieuIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuInMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuInMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuInMouseReleased(evt);
            }
        });
        jBtnXemPhieuIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbIn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Print_60px_1.png"))); // NOI18N
        jBtnXemPhieuIn.add(jlbIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 69, 70));

        getContentPane().add(jBtnXemPhieuIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 230, 70));

        jBtnXemPhieuIn1.setBackground(new java.awt.Color(204, 204, 204));
        jBtnXemPhieuIn1.setOpaque(false);
        jBtnXemPhieuIn1.setPreferredSize(new java.awt.Dimension(102, 50));
        jBtnXemPhieuIn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuIn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuIn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuIn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuIn1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnXemPhieuIn1MouseReleased(evt);
            }
        });
        jBtnXemPhieuIn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbIn1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbIn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Print_60px_1.png"))); // NOI18N
        jlbIn1.setEnabled(false);
        jBtnXemPhieuIn1.add(jlbIn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 69, 70));

        getContentPane().add(jBtnXemPhieuIn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 230, 70));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnThongtinHD.setBackground(new java.awt.Color(0, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Thông tin hóa đơn:");

        javax.swing.GroupLayout jPnThongtinHDLayout = new javax.swing.GroupLayout(jPnThongtinHD);
        jPnThongtinHD.setLayout(jPnThongtinHDLayout);
        jPnThongtinHDLayout.setHorizontalGroup(
            jPnThongtinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnThongtinHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnThongtinHDLayout.setVerticalGroup(
            jPnThongtinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnThongtinHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPnThongtinHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, -1));

        jLabel2.setText("Số hóa đơn :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, -1, -1));

        jLabel3.setText("Tên khách hàng :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, -1, -1));

        jLabel4.setText("Ngày lập :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 281, -1, 20));

        jLabel7.setText("Tổng tiền :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 322, -1, -1));

        jtxtSoHDS.setEditable(false);
        jPanel2.add(jtxtSoHDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 55, 306, -1));

        jtxtTenKH.setEditable(false);
        jPanel2.add(jtxtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 93, 306, -1));

        jtxtTongTien.setEditable(false);
        jtxtTongTien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jtxtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 319, 306, -1));

        jDateNgayLap.setDateFormatString("dd/MM/yyyy");
        jPanel2.add(jDateNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 281, 306, -1));

        jLabel8.setText("Mã  khách hàng :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 134, -1, -1));

        jtxtMaKH.setEditable(false);
        jPanel2.add(jtxtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 131, 306, -1));

        jLabel9.setText("Địa chỉ :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, -1, -1));

        jLabel10.setText("Số điện thoại :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 246, -1, -1));

        jtxtSDT.setEditable(false);
        jPanel2.add(jtxtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 243, 306, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtxtDiaChi.setEditable(false);
        jtxtDiaChi.setColumns(20);
        jtxtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jtxtDiaChi.setRows(5);
        jtxtDiaChi.setBorder(null);
        jScrollPane1.setViewportView(jtxtDiaChi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 167, 306, 57));

        jLabel13.setText("Số tiền nợ :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jtxtSoTienNo.setEditable(false);
        jtxtSoTienNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jtxtSoTienNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 357, 306, -1));

        jLabel14.setText("Số tiền cần thanh toán :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 398, -1, -1));

        jtxtSoTienCanThanhToan.setEditable(false);
        jtxtSoTienCanThanhToan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel2.add(jtxtSoTienCanThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 395, 306, -1));

        jLabel15.setText("Số tiền đã thanh toán :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 436, -1, -1));

        jtxtSoTienDaThanhToan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtSoTienDaThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSoTienDaThanhToanKeyReleased(evt);
            }
        });
        jPanel2.add(jtxtSoTienDaThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 433, 305, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 470, 460));

        jTbCTHDS.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jTbCTHDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "ĐVT", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbCTHDS.setFocusable(false);
        jTbCTHDS.setRowHeight(25);
        jTbCTHDS.setSelectionBackground(new java.awt.Color(218, 223, 225));
        jTbCTHDS.setSelectionForeground(new java.awt.Color(255, 51, 0));
        jScrCTHDS.setViewportView(jTbCTHDS);
        if (jTbCTHDS.getColumnModel().getColumnCount() > 0) {
            jTbCTHDS.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTbCTHDS.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTbCTHDS.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTbCTHDS.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTbCTHDS.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTbCTHDS.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        getContentPane().add(jScrCTHDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 102, 690, 495));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPnCTHDL.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Chi tiết hóa đơn:");

        javax.swing.GroupLayout jPnCTHDLLayout = new javax.swing.GroupLayout(jPnCTHDL);
        jPnCTHDL.setLayout(jPnCTHDLLayout);
        jPnCTHDLLayout.setHorizontalGroup(
            jPnCTHDLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCTHDLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPnCTHDLLayout.setVerticalGroup(
            jPnCTHDLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnCTHDLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnCTHDL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPnCTHDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 503, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 700, 540));

        jPanel1.setOpaque(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pexels-photo-530024.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseReleased
        // TODO add your handling code here:
        setColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseReleased

    private void jBtnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMousePressed
        // TODO add your handling code here:
        resetColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMousePressed

    private void jBtnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseExited
        // TODO add your handling code here:
        resetColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseExited

    private void jBtnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseEntered
        // TODO add your handling code here:
        setColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseEntered

    private void jBtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        if (!ChinhSua) {
            if (LuuThanhCong) {
                new FormLapHoaDonSi().setVisible(true);
            } else {
                new FormLapHoaDonSi(jtxtSoHDS.getText(), jtxtTenKH.getText(), ListCTHDS, jDateNgayLap.getDate()).setVisible(true);
            }
        } else {
            if (!LuuThanhCong) {
                FormLapHoaDonSi FrmLapHDS = new FormLapHoaDonSi(ObjHDS, ListCTHDS, jDateNgayLap.getDate());
                FrmLapHDS.ChinhSua = true;
                FrmLapHDS.setVisible(true);
            }
        }
    }//GEN-LAST:event_jBtnBackMouseClicked

    private void jBtnXemPhieuInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuInMouseClicked
        // TODO add your handling code here:
//        try {
//            Connect con = new Connect();
//            con.Connected();
//            Hashtable hash = new Hashtable();
//            InputStream is = null;          
//            is = new FileInputStream("src/Report/ReportHoaDonSi.jasper");
//            hash.put("SoHDS", jtxtSoHDS.getText());
//            JasperPrint print = JasperFillManager.fillReport(is, hash, con.getConDB());
//            JasperViewer.viewReport(print, false);
//        } catch (Exception ex) {
//            System.out.println("Ngoại lệ tại FormDuyetHoaDonSi.jBtnXemPhieuInMouseClicked:" + ex.getMessage());
//            ex.printStackTrace();
//        }
    }//GEN-LAST:event_jBtnXemPhieuInMouseClicked

    private void jBtnXemPhieuInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuInMouseEntered
        // TODO add your handling code here:
        setColor(jBtnXemPhieuIn);
    }//GEN-LAST:event_jBtnXemPhieuInMouseEntered

    private void jBtnXemPhieuInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuInMouseExited
        // TODO add your handling code here:
        resetColor(jBtnXemPhieuIn);
    }//GEN-LAST:event_jBtnXemPhieuInMouseExited

    private void jBtnXemPhieuInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuInMousePressed
        // TODO add your handling code here:
        resetColor(jBtnXemPhieuIn);
//        System.out.println("IN");
//        EnableComponent(true);
    }//GEN-LAST:event_jBtnXemPhieuInMousePressed

    private void jBtnXemPhieuInMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuInMouseReleased
        // TODO add your handling code here:
        setColor(jBtnXemPhieuIn);
    }//GEN-LAST:event_jBtnXemPhieuInMouseReleased

    private void jBtnLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuuMouseEntered
        // TODO add your handling code here:
        setColor(jBtnLuu);
    }//GEN-LAST:event_jBtnLuuMouseEntered

    private void jBtnLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuuMouseExited
        // TODO add your handling code here:
        resetColor(jBtnLuu);
    }//GEN-LAST:event_jBtnLuuMouseExited

    private void jBtnLuuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuuMousePressed
        // TODO add your handling code here:
        resetColor(jBtnLuu);

    }//GEN-LAST:event_jBtnLuuMousePressed

    private void jBtnLuuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuuMouseReleased
        // TODO add your handling code here:
        setColor(jBtnLuu);
    }//GEN-LAST:event_jBtnLuuMouseReleased

    private void jBtnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuuMouseClicked
        // TODO add your handling code here:
        CtrlLapHoaDonLe ctrlLHDS = new CtrlLapHoaDonLe();
        String SoHDS = ctrlLHDS.LaySoHDS();
        if (!ChinhSua) {
            ObjHDS = new ObjHoaDonSi(SoHDS, jtxtMaKH.getText(), jDateNgayLap.getDate(), Integer.parseInt(jtxtTongTien.getText().replace(",", "")), Integer.parseInt(jtxtSoTienDaThanhToan.getText().replace(",", "")), Integer.parseInt(jtxtSoTienNo.getText().replace(",", "")));
            try {
                if (modHDS.Insert(ObjHDS)) {
                    for (int i = 0; i < ListCTHDS.size(); i++) {
                        ListCTHDS.get(i).setSoHDS(SoHDS);
                        if (!modCTHDS.Insert(ListCTHDS.get(i))) {
                            JOptionPane.showMessageDialog(this, "Sản phẩm có mã " + ListCTHDS.get(i).getMaSP() + " lưu không thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    EnableComponent(false);
                    JOptionPane.showMessageDialog(this, "Hóa đơn lưu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    LuuThanhCong = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Hóa đơn lưu thất bại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                System.out.println("Ngoại lệ tại FormDuyetHoaDonSi.jBtnLuuMouseClicked:" + ex.getMessage());
            }
        } else {
//            ObjHDS = new ObjHoaDonSi(jtxtSoHDS.getText(), jtxtMaKH.getText(), jDateNgayLap.getDate(), jDateNgayGiao.getDate(), Integer.parseInt(jtxtTongTien.getText().replace(",", "")), "");            
//            if (!ObjHDS.getMaKH().equals("")) {
//                try {
//                    if (modHDS.Update(ObjHDS) && modCTHDS.Delete(ObjHDS.getSoHDS())) {
//                        for (int i = 0; i < ListCTHDS.size(); i++) {
//                            if (!modCTHDS.Insert(ListCTHDS.get(i))) {
//                                JOptionPane.showMessageDialog(this, "Sản phẩm có mã " + ListCTHDS.get(i).getMaSP() + " cập nhật không thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            }
//                        }
//                        EnableComponent(false);
//                        JOptionPane.showMessageDialog(this, "Hóa đơn " + ObjHDS.getSoHDS() + " cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                        LuuThanhCong = true;
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Hóa đơn " + ObjHDS.getSoHDS() + " cập nhật không thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } catch (Exception ex) {
//                    System.out.println("Ngoại lệ tại FormDuyetHoaDonSi.jBtnLuuMouseClicked:" + ex.getMessage());
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            }
        }
    }//GEN-LAST:event_jBtnLuuMouseClicked

    private void jBtnLuu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuu1MouseClicked

    private void jBtnLuu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuu1MouseEntered

    private void jBtnLuu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuu1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuu1MouseExited

    private void jBtnLuu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuu1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuu1MousePressed

    private void jBtnLuu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLuu1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuu1MouseReleased

    private void jBtnXemPhieuIn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuIn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXemPhieuIn1MouseClicked

    private void jBtnXemPhieuIn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuIn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXemPhieuIn1MouseEntered

    private void jBtnXemPhieuIn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuIn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXemPhieuIn1MouseExited

    private void jBtnXemPhieuIn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuIn1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXemPhieuIn1MousePressed

    private void jBtnXemPhieuIn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXemPhieuIn1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXemPhieuIn1MouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    int xx, yy;

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jtxtSoTienDaThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSoTienDaThanhToanKeyReleased
        // TODO add your handling code here:
        if (!jtxtSoTienDaThanhToan.getText().equals("")) {
            try {
                jtxtSoTienDaThanhToan.setText(String.format("%,d", Integer.parseInt(jtxtSoTienDaThanhToan.getText().replace(",", ""))));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Số tiền nhập vào không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtxtSoTienDaThanhToanKeyReleased

    public void setColor(JPanel pn) {
        if (pn.isEnabled()) {
            pn.setSize(pn.getWidth() + 1, pn.getHeight() + 1);
            pn.setBackground(new Color(60, 209, 127, 50));
        }
    }

    public void resetColor(JPanel pn) {
        if (pn.isEnabled()) {
            pn.setSize(pn.getWidth() - 1, pn.getHeight() - 1);
            pn.setBackground(new Color(153, 153, 153, 180));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDuyetHoaDonSi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDuyetHoaDonSi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDuyetHoaDonSi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDuyetHoaDonSi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDuyetHoaDonSi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBtnBack;
    private javax.swing.ButtonGroup jBtnGroupTinhTrangGiaoHang;
    private javax.swing.JPanel jBtnLuu;
    private javax.swing.JPanel jBtnLuu1;
    private javax.swing.JPanel jBtnXemPhieuIn;
    private javax.swing.JPanel jBtnXemPhieuIn1;
    private com.toedter.calendar.JDateChooser jDateNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPnCTHDL;
    private javax.swing.JPanel jPnThongtinHD;
    private javax.swing.JScrollPane jScrCTHDS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbCTHDS;
    private javax.swing.JLabel jlbIn;
    private javax.swing.JLabel jlbIn1;
    private javax.swing.JLabel jlbLuu;
    private javax.swing.JLabel jlbLuu1;
    private javax.swing.JTextArea jtxtDiaChi;
    private javax.swing.JTextField jtxtMaKH;
    private javax.swing.JTextField jtxtSDT;
    private javax.swing.JTextField jtxtSoHDS;
    private javax.swing.JTextField jtxtSoTienCanThanhToan;
    private javax.swing.JTextField jtxtSoTienDaThanhToan;
    private javax.swing.JTextField jtxtSoTienNo;
    private javax.swing.JTextField jtxtTenKH;
    private javax.swing.JTextField jtxtTongTien;
    // End of variables declaration//GEN-END:variables
}
