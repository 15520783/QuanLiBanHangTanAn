/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Edit.Edit;
import Control.CtrlLapHoaDonLe;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Object.ObjSanPham;
import Object.ObjChiTietHDL;
import Object.ObjHoaDonLe;
import Object.ObjKhachHang;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ThaiNguyen
 */
public class FormLapHoaDonLe extends javax.swing.JFrame {

    boolean ChinhSua = false;
    int xx = 0, yy = 0;
    Edit editFrm = new Edit();
    ArrayList<ObjSanPham> listSP = new ArrayList<>();
    ArrayList<String> listComboboxLSP = new ArrayList<>();
    ArrayList<ObjChiTietHDL> ListGioHang = new ArrayList<>();
    CtrlLapHoaDonLe CtrlHDL = new CtrlLapHoaDonLe();
    FormDuyetHoaDonLe frmDuyetHDL;
    ObjHoaDonLe objectHDL = new ObjHoaDonLe();

    /**
     * Creates new form FormLapHoaDonLe
     */
    public FormLapHoaDonLe() {
        initComponents();
        this.setLocationRelativeTo(null);
        LoadForm();              
    }

    public FormLapHoaDonLe(ObjHoaDonLe objHDL, ArrayList<ObjChiTietHDL> ListCT, Date NgayLap) {
        initComponents();
        LoadForm();
        this.setLocationRelativeTo(null);
        objectHDL = objHDL;
        jtxtSoHDL.setText(objHDL.getSoHDL());
        jDateNgayLap.setDate(objHDL.getNgayDat());
        jcbbKH.setSelectedItem(objHDL.getTenKH());
        jcbbKH.setEnabled(false);
        try {
            DefaultTableModel Model = (DefaultTableModel) jtbGioHang.getModel();
            for (int i = 0; i < ListCT.size(); i++) {
                this.ListGioHang.add(ListCT.get(i));
                Vector v = new Vector();
                v.add(ListCT.get(i).getMaSP());
                v.add(ListCT.get(i).getTenSP());
                v.add(ListCT.get(i).getDVT());
                v.add(ListCT.get(i).getSoLuong());
                v.add(String.format("%,d", ListCT.get(i).getDonGia()));
                v.add(String.format("%,d", ListCT.get(i).getThanhTien()));
                Model.addRow(v);
            }
            jtxtTongTien.setText(String.format("%,d", TinhTongTienGioHang()));
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonSi():" + ex.getMessage());
        }
        
        jBtnHuy.setVisible(false);
    }

    public FormLapHoaDonLe(String SoHDL, String TenKH, ArrayList<ObjChiTietHDL> ListCT, Date NgayLap) {
        initComponents();
        LoadForm();
        this.setLocationRelativeTo(null);

        jtxtSoHDL.setText(SoHDL);
        jDateNgayLap.setDate(NgayLap);
        jcbbKH.setSelectedItem(TenKH);
        jcbbKH.setEnabled(false);
        try {
            DefaultTableModel Model = (DefaultTableModel) jtbGioHang.getModel();
            for (int i = 0; i < ListCT.size(); i++) {
                this.ListGioHang.add(ListCT.get(i));
                Vector v = new Vector();
                v.add(ListCT.get(i).getMaSP());
                v.add(ListCT.get(i).getTenSP());
                v.add(ListCT.get(i).getDVT());
                v.add(ListCT.get(i).getSoLuong());
                v.add(String.format("%,d", ListCT.get(i).getDonGia()));
                v.add(String.format("%,d", ListCT.get(i).getThanhTien()));
                Model.addRow(v);
            }
            jtxtTongTien.setText(String.format("%,d", TinhTongTienGioHang()));
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonSi():" + ex.getMessage());
        }        
        jBtnHuy.setVisible(false);
    }
    ArrayList<ObjKhachHang> listComboboxKH = new ArrayList<>();

    public void LoadComboboxKhachHang() {
        listComboboxKH.clear();
        jcbbKH.removeAllItems();
        jcbbKH.addItem("---Chọn khách hàng---");
        listComboboxKH.add(new ObjKhachHang());
        ResultSet rs = CtrlHDL.LayDanhSachKhachHang();
        try {
            while (rs.next()) {
                ObjKhachHang itemKH = new ObjKhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("SDT"), rs.getString("DiaChi"), rs.getString("Email"), rs.getInt("TienNo"));
                jcbbKH.addItem(itemKH.getTenKH());
                listComboboxKH.add(itemKH);
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonSi.LoadComboboxNhaCungCap: " + ex.getMessage());
        } finally {
            CtrlHDL.CloseConnection();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtSoHDL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateNgayLap = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jtxtTongTien = new javax.swing.JTextField();
        jPnThongtinHD = new javax.swing.JPanel();
        jcbbKH = new javax.swing.JComboBox<>();
        jBtnTimKiem = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jBtnLamMoi = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrGioHang = new javax.swing.JScrollPane();
        jtbGioHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPnGioHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCbbTimTheo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jCbbLoaiSP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtxtTimKiem = new javax.swing.JTextField();
        jPnTimkiemSP = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrDSSP = new javax.swing.JScrollPane();
        jtbDSSP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPnDSSP = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtxtDVT = new javax.swing.JTextField();
        jtxtDonGia = new javax.swing.JTextField();
        jPnThongtinSP = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtTenSP = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jtxtTenLoaiSP = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jbtnDuyetGioHang = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jBtnHuy = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jBtnThem = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jBtnXoa = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lập hoá đơn lẻ");
        setFocusable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Thông tin hóa đơn :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 20));

        jLabel2.setText("Số hóa đơn  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 54, -1, -1));

        jLabel3.setText("Khách hàng :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 95, -1, 20));

        jtxtSoHDL.setEditable(false);
        jtxtSoHDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSoHDLActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtSoHDL, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 51, 207, -1));

        jLabel4.setText("Ngày lập :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 54, -1, -1));

        jDateNgayLap.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(jDateNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 51, 190, -1));

        jLabel5.setText("Tổng tiền :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 101, -1, -1));

        jtxtTongTien.setEditable(false);
        jtxtTongTien.setText("0");
        jPanel1.add(jtxtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 98, 190, -1));

        jPnThongtinHD.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPnThongtinHDLayout = new javax.swing.GroupLayout(jPnThongtinHD);
        jPnThongtinHD.setLayout(jPnThongtinHDLayout);
        jPnThongtinHDLayout.setHorizontalGroup(
            jPnThongtinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        jPnThongtinHDLayout.setVerticalGroup(
            jPnThongtinHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPnThongtinHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 689, 30));

        jcbbKH.setEditable(true);
        jcbbKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbbKH.setAutoscrolls(true);
        jPanel1.add(jcbbKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 90, 280, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 689, 150));

        jBtnTimKiem.setPreferredSize(new java.awt.Dimension(102, 50));
        jBtnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnTimKiemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnTimKiemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnTimKiemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnTimKiemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnTimKiemMouseReleased(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Search_45px.png"))); // NOI18N

        javax.swing.GroupLayout jBtnTimKiemLayout = new javax.swing.GroupLayout(jBtnTimKiem);
        jBtnTimKiem.setLayout(jBtnTimKiemLayout);
        jBtnTimKiemLayout.setHorizontalGroup(
            jBtnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnTimKiemLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jBtnTimKiemLayout.setVerticalGroup(
            jBtnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        getContentPane().add(jBtnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 125, 110, 65));

        jBtnLamMoi.setPreferredSize(new java.awt.Dimension(105, 50));
        jBtnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLamMoiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnLamMoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnLamMoiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnLamMoiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnLamMoiMouseReleased(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Refresh_45px.png"))); // NOI18N

        javax.swing.GroupLayout jBtnLamMoiLayout = new javax.swing.GroupLayout(jBtnLamMoi);
        jBtnLamMoi.setLayout(jBtnLamMoiLayout);
        jBtnLamMoiLayout.setHorizontalGroup(
            jBtnLamMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBtnLamMoiLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jBtnLamMoiLayout.setVerticalGroup(
            jBtnLamMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        getContentPane().add(jBtnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 125, 112, 65));

        jtbGioHang.setAutoCreateRowSorter(true);
        jtbGioHang.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jtbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Sản phẩm", "ĐVT", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbGioHang.setFocusable(false);
        jtbGioHang.setRowHeight(25);
        jtbGioHang.setSelectionBackground(new java.awt.Color(218, 223, 225));
        jtbGioHang.setSelectionForeground(new java.awt.Color(255, 51, 0));
        jtbGioHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbGioHang.setShowHorizontalLines(false);
        jtbGioHang.getTableHeader().setReorderingAllowed(false);
        jtbGioHang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtbGioHangPropertyChange(evt);
            }
        });
        jScrGioHang.setViewportView(jtbGioHang);
        if (jtbGioHang.getColumnModel().getColumnCount() > 0) {
            jtbGioHang.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtbGioHang.getColumnModel().getColumn(1).setPreferredWidth(300);
            jtbGioHang.getColumnModel().getColumn(2).setPreferredWidth(80);
            jtbGioHang.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtbGioHang.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtbGioHang.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        getContentPane().add(jScrGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 255, 679, 400));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Giỏ hàng :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, 20));

        jPnGioHang.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPnGioHangLayout = new javax.swing.GroupLayout(jPnGioHang);
        jPnGioHang.setLayout(jPnGioHangLayout);
        jPnGioHangLayout.setHorizontalGroup(
            jPnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPnGioHangLayout.setVerticalGroup(
            jPnGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPnGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 689, 440));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setText("Tìm theo :");

        jCbbTimTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên sản phẩm", "Mã sản phẩm" }));
        jCbbTimTheo.setFocusable(false);
        jCbbTimTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbbTimTheoActionPerformed(evt);
            }
        });

        jLabel10.setText("Loại sản phẩm :");

        jCbbLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Chọn loại sản phẩm---" }));
        jCbbLoaiSP.setAutoscrolls(true);
        jCbbLoaiSP.setFocusable(false);
        jCbbLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbbLoaiSPActionPerformed(evt);
            }
        });

        jLabel11.setText("Từ tìm kiếm :");

        jtxtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtTimKiemKeyReleased(evt);
            }
        });

        jPnTimkiemSP.setBackground(new java.awt.Color(0, 204, 204));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tìm kiếm sản phẩm :");

        javax.swing.GroupLayout jPnTimkiemSPLayout = new javax.swing.GroupLayout(jPnTimkiemSP);
        jPnTimkiemSP.setLayout(jPnTimkiemSPLayout);
        jPnTimkiemSPLayout.setHorizontalGroup(
            jPnTimkiemSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnTimkiemSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPnTimkiemSPLayout.setVerticalGroup(
            jPnTimkiemSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnTimkiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addComponent(jCbbTimTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jCbbLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPnTimkiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbbTimTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(jCbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 600, 150));

        jtbDSSP.setAutoCreateRowSorter(true);
        jtbDSSP.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        jtbDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Giá lẻ", "Giá sỉ", "Giá nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDSSP.setFocusable(false);
        jtbDSSP.setRowHeight(25);
        jtbDSSP.setSelectionBackground(new java.awt.Color(218, 223, 225));
        jtbDSSP.setSelectionForeground(new java.awt.Color(255, 51, 0));
        jtbDSSP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbDSSP.setShowHorizontalLines(false);
        jtbDSSP.setShowVerticalLines(false);
        jtbDSSP.getTableHeader().setReorderingAllowed(false);
        jtbDSSP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jtbDSSPMouseDragged(evt);
            }
        });
        jtbDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbDSSPMousePressed(evt);
            }
        });
        jScrDSSP.setViewportView(jtbDSSP);
        if (jtbDSSP.getColumnModel().getColumnCount() > 0) {
            jtbDSSP.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        getContentPane().add(jScrDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 255, 590, 260));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Danh sách sản phẩm :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 20));

        jPnDSSP.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPnDSSPLayout = new javax.swing.GroupLayout(jPnDSSP);
        jPnDSSP.setLayout(jPnDSSPLayout);
        jPnDSSPLayout.setHorizontalGroup(
            jPnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPnDSSPLayout.setVerticalGroup(
            jPnDSSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPnDSSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 600, 300));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Tên sản phẩm :");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jLabel18.setText("Đơn giá :");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jtxtDVT.setEditable(false);
        jPanel7.add(jtxtDVT, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 90, 210, 20));

        jtxtDonGia.setEditable(false);
        jtxtDonGia.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtxtDonGiaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel7.add(jtxtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 195, -1));

        jPnThongtinSP.setBackground(new java.awt.Color(0, 204, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Thông tin sản phẩm : ");

        javax.swing.GroupLayout jPnThongtinSPLayout = new javax.swing.GroupLayout(jPnThongtinSP);
        jPnThongtinSP.setLayout(jPnThongtinSPLayout);
        jPnThongtinSPLayout.setHorizontalGroup(
            jPnThongtinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnThongtinSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnThongtinSPLayout.setVerticalGroup(
            jPnThongtinSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel7.add(jPnThongtinSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);

        jtxtTenSP.setEditable(false);
        jtxtTenSP.setColumns(1);
        jtxtTenSP.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jtxtTenSP.setRows(5);
        jScrollPane1.setViewportView(jtxtTenSP);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 195, 40));

        jLabel27.setText("Loại :");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 20));

        jtxtTenLoaiSP.setEditable(false);
        jPanel7.add(jtxtTenLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 210, -1));

        jLabel28.setText("ĐVT :");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 20));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 531, 600, 130));

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

        jbtnDuyetGioHang.setBackground(new java.awt.Color(204, 204, 204));
        jbtnDuyetGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnDuyetGioHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtnDuyetGioHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtnDuyetGioHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtnDuyetGioHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jbtnDuyetGioHangMouseReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Tick_Box_40px.png"))); // NOI18N
        jLabel22.setText("Duyệt giỏ hàng");

        javax.swing.GroupLayout jbtnDuyetGioHangLayout = new javax.swing.GroupLayout(jbtnDuyetGioHang);
        jbtnDuyetGioHang.setLayout(jbtnDuyetGioHangLayout);
        jbtnDuyetGioHangLayout.setHorizontalGroup(
            jbtnDuyetGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbtnDuyetGioHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jbtnDuyetGioHangLayout.setVerticalGroup(
            jbtnDuyetGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jbtnDuyetGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, 190, 50));

        jBtnHuy.setBackground(new java.awt.Color(204, 204, 204));
        jBtnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnHuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnHuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnHuyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnHuyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnHuyMouseReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Close_Window_40px.png"))); // NOI18N
        jLabel23.setText("Hủy giỏ hàng");

        javax.swing.GroupLayout jBtnHuyLayout = new javax.swing.GroupLayout(jBtnHuy);
        jBtnHuy.setLayout(jBtnHuyLayout);
        jBtnHuyLayout.setHorizontalGroup(
            jBtnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnHuyLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jBtnHuyLayout.setVerticalGroup(
            jBtnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jBtnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 670, 190, 50));

        jBtnThem.setBackground(new java.awt.Color(204, 204, 204));
        jBtnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnThemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnThemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnThemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnThemMouseReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Add_Shopping_Cart_40px.png"))); // NOI18N
        jLabel24.setText("Thêm vào giỏ");

        javax.swing.GroupLayout jBtnThemLayout = new javax.swing.GroupLayout(jBtnThem);
        jBtnThem.setLayout(jBtnThemLayout);
        jBtnThemLayout.setHorizontalGroup(
            jBtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnThemLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel24)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jBtnThemLayout.setVerticalGroup(
            jBtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jBtnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, 190, 50));

        jBtnXoa.setBackground(new java.awt.Color(204, 204, 204));
        jBtnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnXoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnXoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnXoaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnXoaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnXoaMouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Clear_Shopping_Cart_40px.png"))); // NOI18N
        jLabel26.setText("Xóa khỏi giỏ");

        javax.swing.GroupLayout jBtnXoaLayout = new javax.swing.GroupLayout(jBtnXoa);
        jBtnXoa.setLayout(jBtnXoaLayout);
        jBtnXoaLayout.setHorizontalGroup(
            jBtnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBtnXoaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jBtnXoaLayout.setVerticalGroup(
            jBtnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jBtnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 670, 190, 50));

        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 730));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pexels-photo-530024.jpeg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void LoadForm() {
        HienThiDanhSachSanPham(CtrlHDL.LayDanhSachSanPham());
        LoadComboboxLoaiSP();
        LoadComboboxKhachHang();
        Binding();
        jDateNgayLap.setDate(new Date());
        AutoCompleteDecorator.decorate(jcbbKH);
        JPanel ListPn[] = new JPanel[]{jPanel1, jPanel2, jPanel3, jPanel4, jPanel7};
        editFrm.MakeTransparentPanel(ListPn);

        JPanel ListTitle[] = new JPanel[]{jPnDSSP, jPnGioHang, jPnThongtinHD, jPnThongtinSP, jPnTimkiemSP};
        editFrm.MakeTransparentTitle(ListTitle);

        JPanel ListButton[] = new JPanel[]{jbtnDuyetGioHang, jBtnBack, jBtnHuy, jBtnLamMoi, jBtnThem, jBtnTimKiem, jBtnXoa};
        editFrm.MakeTransparentButton(ListButton);

        jPanel5.setBackground(new Color(0, 0, 0, 0));

        jtxtTenSP.setLineWrap(true);

        editFrm.MakeTransparentTable(jScrGioHang, jtbGioHang);
        editFrm.MakeTransparentTable(jScrDSSP, jtbDSSP);

        jtxtSoHDL.setText(CtrlHDL.LaySoHDL());
        
        TableModel tm = jtbGioHang.getModel();

        tm.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent tme) {
                try {
                    if (jtbGioHang.getCellEditor() == null) {
                        System.out.println("Not Edited");
                    } else {
                        int SL = Integer.parseInt(tm.getValueAt(jtbGioHang.getSelectedRow(), 3).toString());
                        int DonGia = Integer.parseInt(tm.getValueAt(jtbGioHang.getSelectedRow(), 4).toString().replace(",", ""));
                        int ThanhTien = SL * DonGia;
                        if (SL != ListGioHang.get(jtbGioHang.getSelectedRow()).getSoLuong()) {
                            ListGioHang.get(jtbGioHang.getSelectedRow()).setSoLuong(SL);
                        }
                        if (DonGia != ListGioHang.get(jtbGioHang.getSelectedRow()).getDonGia()) {
                            ListGioHang.get(jtbGioHang.getSelectedRow()).setDonGia(DonGia);
                            tm.setValueAt(String.format("%,d", DonGia), jtbGioHang.getSelectedRow(), 4);
                        }
                        if (ThanhTien != ListGioHang.get(jtbGioHang.getSelectedRow()).getThanhTien()) {
                            ListGioHang.get(jtbGioHang.getSelectedRow()).setThanhTien(ThanhTien);
                            tm.setValueAt(String.format("%,d", ThanhTien), jtbGioHang.getSelectedRow(), 5);
                        }
                        jtxtTongTien.setText(String.format("%,d", TinhTongTienGioHang()));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nhập không hợp lệ.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void HienThiDanhSachSanPham(ResultSet rs) {
        listSP.clear();
        DefaultTableModel model;
        model = (DefaultTableModel) jtbDSSP.getModel();
        model.getDataVector().removeAllElements(); // remove data in table
        model.fireTableDataChanged();
        try {
            while (rs.next()) {
                ObjSanPham itemSP;
                itemSP = new ObjSanPham(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("MaLoaiSP"), rs.getString("TenLoaiSP"), rs.getInt("GiaLe"), rs.getInt("GiaSi"), rs.getInt("GiaNhap"), rs.getString("DVT"), rs.getString("MoTa"));
                listSP.add(itemSP);
                model.addRow(new Object[]{itemSP.getTenSP(), String.format("%,d", itemSP.getGiaLe()), String.format("%,d", itemSP.getGiaSi()), String.format("%,d", itemSP.getGiaNhap())});
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonLe.HienThiDanhSachSanPham: " + ex.getMessage());
        } finally {
            CtrlHDL.CloseConnection();
        }
        jtbDSSP.changeSelection(0, 0, false, false);
    }

    public void LoadComboboxLoaiSP() {
        listComboboxLSP.clear();
        jCbbLoaiSP.removeAllItems();
        jCbbLoaiSP.addItem("---Chọn loại sản phẩm---");
        listComboboxLSP.add("");
        ResultSet rs = CtrlHDL.LayDanhSachLoaiSanPham();
        try {
            while (rs.next()) {
                jCbbLoaiSP.addItem(rs.getString("TenLoaiSP"));
                listComboboxLSP.add(rs.getString("MaLoaiSP"));
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonLe.LoadComboboxLoaiSP: " + ex.getMessage());
        } finally {
            CtrlHDL.CloseConnection();
        }
    }

    public void ReloadForm() {
        HienThiDanhSachSanPham(CtrlHDL.LayDanhSachSanPham());
        ListGioHang.clear();
        LoadComboboxLoaiSP();
        LoadComboboxKhachHang();
        jtxtTimKiem.setText("");
        jtxtTongTien.setText("0");
        jtbGioHang.removeAll();
        jtxtSoHDL.setText(CtrlHDL.LaySoHDL());
        jDateNgayLap.setDate(new Date());
        DefaultTableModel model;
        model = (DefaultTableModel) jtbGioHang.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    public void Binding() {
        TableModel model = jtbDSSP.getModel();
        try {
            int viewRow = jtbDSSP.getSelectedRow();
            int modelRow = jtbDSSP.convertRowIndexToModel(viewRow);
            if (viewRow > -1) {
                jtxtTenSP.setText(listSP.get(modelRow).getTenSP());
                jtxtDVT.setText(listSP.get(modelRow).getDVT());
                jtxtDonGia.setText(String.format("%,d", listSP.get(modelRow).getGiaLe()));
                jtxtTenSP.setText(listSP.get(modelRow).getTenSP());
                jtxtTenLoaiSP.setText(listSP.get(modelRow).getTenLoaiSP());
                int dongia = Integer.parseInt(jtxtDonGia.getText().replace(",", ""));
            }
        } catch (Exception ex) {
            System.out.println("Ngoại lệ tại FormLapHoaDonLe.Binding: " + ex.getMessage());
        }
    }


    private void jBtnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTimKiemMouseClicked
        // TODO add your handling code here:
        if (jCbbTimTheo.getSelectedIndex() == 0) {
            HienThiDanhSachSanPham(CtrlHDL.SearchByName(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
        } else {
            HienThiDanhSachSanPham(CtrlHDL.SearchSanPhamByID(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
        }
        Binding();
        CtrlHDL.CloseConnection();
    }//GEN-LAST:event_jBtnTimKiemMouseClicked

    private void jBtnTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTimKiemMouseEntered
        // TODO add your handling code here:
        setColor(jBtnTimKiem);
    }//GEN-LAST:event_jBtnTimKiemMouseEntered

    private void jBtnTimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTimKiemMouseExited
        // TODO add your handling code here:
        resetColor(jBtnTimKiem);
    }//GEN-LAST:event_jBtnTimKiemMouseExited

    private void jBtnTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTimKiemMousePressed
        // TODO add your handling code here:
        resetColor(jBtnTimKiem);
    }//GEN-LAST:event_jBtnTimKiemMousePressed

    private void jBtnTimKiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnTimKiemMouseReleased
        // TODO add your handling code here:
        setColor(jBtnTimKiem);
    }//GEN-LAST:event_jBtnTimKiemMouseReleased

    private void jBtnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLamMoiMouseClicked
        // TODO add your handling code here:
        HienThiDanhSachSanPham(CtrlHDL.LayDanhSachSanPham());
        LoadComboboxLoaiSP();
        jtxtTimKiem.setText("");
    }//GEN-LAST:event_jBtnLamMoiMouseClicked

    private void jBtnLamMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLamMoiMouseEntered
        // TODO add your handling code here:
        setColor(jBtnLamMoi);
    }//GEN-LAST:event_jBtnLamMoiMouseEntered

    private void jBtnLamMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLamMoiMouseExited
        // TODO add your handling code here:
        resetColor(jBtnLamMoi);
    }//GEN-LAST:event_jBtnLamMoiMouseExited

    private void jBtnLamMoiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLamMoiMousePressed
        // TODO add your handling code here:
        resetColor(jBtnLamMoi);
    }//GEN-LAST:event_jBtnLamMoiMousePressed

    private void jBtnLamMoiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLamMoiMouseReleased
        // TODO add your handling code here:
        setColor(jBtnLamMoi);
    }//GEN-LAST:event_jBtnLamMoiMouseReleased

    private void jBtnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaMouseClicked
        // TODO add your handling code here
        DefaultTableModel Model = (DefaultTableModel) jtbGioHang.getModel();
        try {
            int viewRow = jtbGioHang.getSelectedRow();
            int modelRow = jtbGioHang.convertRowIndexToModel(viewRow);
            ListGioHang.remove(modelRow);
            Model.removeRow(modelRow);
            jtxtTongTien.setText(String.format("%,d", TinhTongTienGioHang()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm được chọn.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBtnXoaMouseClicked

    private void jBtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jBtnBackMouseClicked

    private void jBtnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseEntered
        // TODO add your handling code here:
        setColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseEntered

    private void jBtnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseExited
        // TODO add your handling code here:
        resetColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseExited

    private void jBtnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMousePressed
        // TODO add your handling code here:
        resetColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMousePressed

    private void jBtnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBackMouseReleased
        // TODO add your handling code here:
        setColor(jBtnBack);
    }//GEN-LAST:event_jBtnBackMouseReleased

    private void jbtnDuyetGioHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDuyetGioHangMouseEntered
        // TODO add your handling code here:
        setColor(jbtnDuyetGioHang);
    }//GEN-LAST:event_jbtnDuyetGioHangMouseEntered

    private void jbtnDuyetGioHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDuyetGioHangMouseExited
        // TODO add your handling code here:
        resetColor(jbtnDuyetGioHang);
    }//GEN-LAST:event_jbtnDuyetGioHangMouseExited

    private void jbtnDuyetGioHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDuyetGioHangMousePressed
        // TODO add your handling code here:
        resetColor(jbtnDuyetGioHang);
    }//GEN-LAST:event_jbtnDuyetGioHangMousePressed

    private void jbtnDuyetGioHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDuyetGioHangMouseReleased
        // TODO add your handling code here:
        setColor(jbtnDuyetGioHang);
    }//GEN-LAST:event_jbtnDuyetGioHangMouseReleased

    private void jBtnHuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnHuyMouseEntered
        // TODO add your handling code here:
        setColor(jBtnHuy);
    }//GEN-LAST:event_jBtnHuyMouseEntered

    private void jBtnHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnHuyMouseExited
        // TODO add your handling code here:
        resetColor(jBtnHuy);
    }//GEN-LAST:event_jBtnHuyMouseExited

    private void jBtnHuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnHuyMousePressed
        // TODO add your handling code here:
        resetColor(jBtnHuy);
    }//GEN-LAST:event_jBtnHuyMousePressed

    private void jBtnHuyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnHuyMouseReleased
        // TODO add your handling code here:
        setColor(jBtnHuy);
    }//GEN-LAST:event_jBtnHuyMouseReleased

    private void jBtnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemMouseEntered
        // TODO add your handling code here:
        setColor(jBtnThem);
    }//GEN-LAST:event_jBtnThemMouseEntered

    private void jBtnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemMouseExited
        // TODO add your handling code here:
        resetColor(jBtnThem);
    }//GEN-LAST:event_jBtnThemMouseExited

    private void jBtnThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemMousePressed
        // TODO add your handling code here:
        resetColor(jBtnThem);
    }//GEN-LAST:event_jBtnThemMousePressed

    private void jBtnThemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemMouseReleased
        // TODO add your handling code here:
        setColor(jBtnThem);
    }//GEN-LAST:event_jBtnThemMouseReleased

    private void jBtnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaMouseEntered
        // TODO add your handling code here:
        setColor(jBtnXoa);
    }//GEN-LAST:event_jBtnXoaMouseEntered

    private void jBtnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaMouseExited
        // TODO add your handling code here:
        resetColor(jBtnXoa);
    }//GEN-LAST:event_jBtnXoaMouseExited

    private void jBtnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaMousePressed
        // TODO add your handling code here:
        resetColor(jBtnXoa);
    }//GEN-LAST:event_jBtnXoaMousePressed

    private void jBtnXoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnXoaMouseReleased
        // TODO add your handling code here:
        setColor(jBtnXoa);
    }//GEN-LAST:event_jBtnXoaMouseReleased

    private void jtbDSSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDSSPMousePressed
        // TODO add your handling code here:
        Binding();
    }//GEN-LAST:event_jtbDSSPMousePressed

    public int TinhTongTienGioHang() {
        int Tong = 0;
        for (int i = 0; i < ListGioHang.size(); i++) {
            Tong += ListGioHang.get(i).getThanhTien();
        }
        return Tong;
    }

    private void jBtnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnThemMouseClicked
        // TODO add your handling code here:
        boolean exist = false;
        DefaultTableModel Model;
        int viewRow = jtbDSSP.getSelectedRow();
        int modelRow = jtbDSSP.convertRowIndexToModel(viewRow);
        Model = (DefaultTableModel) jtbGioHang.getModel();
        String inputdialog = JOptionPane.showInputDialog(this, "Nhập số lượng:", "");
        if (inputdialog != null) {
            try {
                int SL = Integer.parseInt(inputdialog);
                if (!inputdialog.equals("0")) {
                    ObjChiTietHDL itemGioHang = new ObjChiTietHDL(listSP.get(modelRow).getMaSP(), listSP.get(modelRow).getTenSP(), listSP.get(modelRow).getDVT(), SL, listSP.get(modelRow).getGiaLe());
                    try {
                        for (int i = 0; i < Model.getRowCount(); i++) {
                            if (Model.getValueAt(i, 0).toString().equals(itemGioHang.getMaSP())) {
                                exist = true;
                                SL += Integer.parseInt(Model.getValueAt(i, 3).toString());
                                int ThanhTien = SL * Integer.parseInt(Model.getValueAt(i, 4).toString().replace(",", ""));
                                Model.setValueAt(SL, i, 3);
                                Model.setValueAt(String.format("%,d", ThanhTien), i, 5);
                                ListGioHang.get(i).setSoLuong(SL);
                                ListGioHang.get(i).setThanhTien(ThanhTien);
                                break;
                            }
                        }
                        if (!exist) {
                            ListGioHang.add(itemGioHang);
                            Model.addRow(new Object[]{itemGioHang.getMaSP(), itemGioHang.getTenSP(), itemGioHang.getDVT(), itemGioHang.getSoLuong(), String.format("%,d", itemGioHang.getDonGia()), String.format("%,d", itemGioHang.getThanhTien())});
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Ngoại lệ tại FormLapHoaDonLe.Binding: " + ex.getMessage());
                    }
                } else {
                    jBtnXoaMouseClicked(null);
                }
                jtxtTongTien.setText(String.format("%,d", TinhTongTienGioHang()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jBtnThemMouseClicked

    private void jtxtDonGiaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtxtDonGiaInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jtxtDonGiaInputMethodTextChanged

    private void jCbbTimTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbbTimTheoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbbTimTheoActionPerformed

    private void jbtnDuyetGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnDuyetGioHangMouseClicked
        // TODO add your handling code here:
        try {
            if (jcbbKH.getSelectedIndex() != 0) {
                if (ListGioHang.size() > 0) {

                    if (ChinhSua) {
                        frmDuyetHDL = new FormDuyetHoaDonLe(objectHDL,listComboboxKH.get(jcbbKH.getSelectedIndex()),ListGioHang,jtxtTongTien.getText());
                        frmDuyetHDL.ChinhSua = true;
                    } else {
                        frmDuyetHDL = new FormDuyetHoaDonLe(jtxtSoHDL.getText(), jDateNgayLap.getDate(), jtxtTongTien.getText(), listComboboxKH.get(jcbbKH.getSelectedIndex()), ListGioHang);
                    }
                    frmDuyetHDL.setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Giỏ hàng trống.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error:"+ ex.getMessage(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtnDuyetGioHangMouseClicked

    private void jtxtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBtnTimKiemMouseClicked(null);
        }
    }//GEN-LAST:event_jtxtTimKiemKeyPressed

    private void jBtnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnHuyMouseClicked
        // TODO add your handling code here:
        if (jBtnHuy.isEnabled()) {
            ReloadForm();
        }
    }//GEN-LAST:event_jBtnHuyMouseClicked


    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jtxtSoHDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSoHDLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSoHDLActionPerformed

    private void jtxtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTimKiemKeyReleased
        // TODO add your handling code here:
        if (jCbbTimTheo.getSelectedIndex() == 0) {
            HienThiDanhSachSanPham(CtrlHDL.SearchByName(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
        } else {
            HienThiDanhSachSanPham(CtrlHDL.SearchSanPhamByID(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
        }
        Binding();
        CtrlHDL.CloseConnection();
    }//GEN-LAST:event_jtxtTimKiemKeyReleased

    private void jCbbLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbbLoaiSPActionPerformed
        // TODO add your handling code here:
        try {
            if (jCbbTimTheo.getSelectedIndex() == 0) {
                HienThiDanhSachSanPham(CtrlHDL.SearchByName(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
            } else {
                HienThiDanhSachSanPham(CtrlHDL.SearchSanPhamByID(jtxtTimKiem.getText(), listComboboxLSP.get(jCbbLoaiSP.getSelectedIndex()).toString()));
            }
            Binding();
            CtrlHDL.CloseConnection();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jCbbLoaiSPActionPerformed

    private void jtbGioHangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtbGioHangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbGioHangPropertyChange

    private void jtbDSSPMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDSSPMouseDragged
        // TODO add your handling code here:
        Binding();
    }//GEN-LAST:event_jtbDSSPMouseDragged

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
            java.util.logging.Logger.getLogger(FormLapHoaDonLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLapHoaDonLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLapHoaDonLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLapHoaDonLe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormLapHoaDonLe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBtnBack;
    private javax.swing.JPanel jBtnHuy;
    private javax.swing.JPanel jBtnLamMoi;
    private javax.swing.JPanel jBtnThem;
    private javax.swing.JPanel jBtnTimKiem;
    private javax.swing.JPanel jBtnXoa;
    private javax.swing.JComboBox<String> jCbbLoaiSP;
    private javax.swing.JComboBox<String> jCbbTimTheo;
    private com.toedter.calendar.JDateChooser jDateNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPnDSSP;
    private javax.swing.JPanel jPnGioHang;
    private javax.swing.JPanel jPnThongtinHD;
    private javax.swing.JPanel jPnThongtinSP;
    private javax.swing.JPanel jPnTimkiemSP;
    private javax.swing.JScrollPane jScrDSSP;
    private javax.swing.JScrollPane jScrGioHang;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jbtnDuyetGioHang;
    private javax.swing.JComboBox<String> jcbbKH;
    private javax.swing.JTable jtbDSSP;
    private javax.swing.JTable jtbGioHang;
    private javax.swing.JTextField jtxtDVT;
    private javax.swing.JTextField jtxtDonGia;
    private javax.swing.JTextField jtxtSoHDL;
    private javax.swing.JTextField jtxtTenLoaiSP;
    private javax.swing.JTextArea jtxtTenSP;
    private javax.swing.JTextField jtxtTimKiem;
    private javax.swing.JTextField jtxtTongTien;
    // End of variables declaration//GEN-END:variables
}
