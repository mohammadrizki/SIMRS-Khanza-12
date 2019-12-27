/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laporan;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author khanzamedia
 */
public class frmPengaduan extends javax.swing.JFrame {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i=0;
    private StringBuilder htmlContent;
    
    /**
     * Creates new form frmPengaduan
     */
    public frmPengaduan() {
        initComponents();
        
        tabMode=new DefaultTableModel(null,new Object[]{
            "P","Id","Tanggal","Username","Message"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class 
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbPengaduan.setModel(tabMode);
        tbPengaduan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPengaduan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 5; i++) {
            TableColumn column = tbPengaduan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(35);
            }else if(i==2){
                column.setPreferredWidth(125);
            }else if(i==3){
                column.setPreferredWidth(90);
            }else if(i==4){
                column.setPreferredWidth(800);
            }
        }
        tbPengaduan.setDefaultRenderer(Object.class, new WarnaTable());

        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        Pesan.setDocument(new batasInput((int)255).getKata(Pesan));
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        } 
        
        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{padding-top:5px;padding-bottom:5px;font: 8.5px tahoma;height:12px;background: #ffffff;color:#323232;}"+
                ".isi2 td{font: 8.5px tahoma;height:12px;background: #ffffff;color:#323232;}"+
                ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
        );
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);
        jam(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        TabRawat = new javax.swing.JTabbedPane();
        internalFrame2 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbPengaduan = new widget.Table();
        panelisi3 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        label9 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        label10 = new widget.Label();
        LCount = new widget.Label();
        BtnHapus = new widget.Button();
        BtnPrint = new widget.Button();
        BtnHapusTotal = new widget.Button();
        BtnKeluar = new widget.Button();
        internalFrame3 = new widget.InternalFrame();
        LoadHTML = new widget.editorpane();
        panelisi4 = new widget.panelisi();
        label13 = new widget.Label();
        Pesan = new widget.TextBox();
        BtnCari1 = new widget.Button();
        label14 = new widget.Label();
        BtnKeluar1 = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::[ Pengaduan/Chat ]::");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 253, 247)), "::[ Data Pengaduan/Chat ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50,50,50))); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        TabRawat.setBackground(new java.awt.Color(255, 255, 253));
        TabRawat.setForeground(new java.awt.Color(50,50,50));
        TabRawat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TabRawat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatMouseClicked(evt);
            }
        });

        internalFrame2.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame2.setBorder(null);
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Scroll.setOpaque(true);

        tbPengaduan.setAutoCreateRowSorter(true);
        tbPengaduan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPengaduanMouseClicked(evt);
            }
        });
        tbPengaduan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPengaduanKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbPengaduan);

        internalFrame2.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi3.setBorder(null);
        panelisi3.setPreferredSize(new java.awt.Dimension(100, 43));
        panelisi3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label11.setText("Tanggal :");
        label11.setPreferredSize(new java.awt.Dimension(50, 23));
        panelisi3.add(label11);

        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi3.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setPreferredSize(new java.awt.Dimension(25, 23));
        panelisi3.add(label18);

        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi3.add(Tgl2);

        label9.setText("Key Word :");
        label9.setPreferredSize(new java.awt.Dimension(68, 23));
        panelisi3.add(label9);

        TCari.setPreferredSize(new java.awt.Dimension(150, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi3.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('1');
        BtnCari.setToolTipText("Alt+1");
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi3.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('2');
        BtnAll.setToolTipText("2Alt+2");
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelisi3.add(BtnAll);

        label10.setText("Record :");
        label10.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi3.add(label10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelisi3.add(LCount);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setToolTipText("Hapus Yang DIpilih");
        BtnHapus.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelisi3.add(BtnHapus);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setToolTipText("Cetak");
        BtnPrint.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi3.add(BtnPrint);

        BtnHapusTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnHapusTotal.setMnemonic('B');
        BtnHapusTotal.setToolTipText("Bersihkan Semua");
        BtnHapusTotal.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnHapusTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusTotalActionPerformed(evt);
            }
        });
        BtnHapusTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusTotalKeyPressed(evt);
            }
        });
        panelisi3.add(BtnHapusTotal);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setToolTipText("Keluar");
        BtnKeluar.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        panelisi3.add(BtnKeluar);

        internalFrame2.add(panelisi3, java.awt.BorderLayout.PAGE_END);

        TabRawat.addTab("Data Pengaduan", internalFrame2);

        internalFrame3.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame3.setBorder(null);
        internalFrame3.setLayout(new java.awt.BorderLayout(1, 1));

        LoadHTML.setBorder(null);
        internalFrame3.add(LoadHTML, java.awt.BorderLayout.CENTER);

        panelisi4.setBorder(null);
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 43));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label13.setText("Pesan :");
        label13.setPreferredSize(new java.awt.Dimension(48, 23));
        panelisi4.add(label13);

        Pesan.setPreferredSize(new java.awt.Dimension(643, 23));
        Pesan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PesanKeyPressed(evt);
            }
        });
        panelisi4.add(Pesan);

        BtnCari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari1.setMnemonic('1');
        BtnCari1.setToolTipText("Alt+1");
        BtnCari1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari1ActionPerformed(evt);
            }
        });
        BtnCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCari1KeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari1);

        label14.setPreferredSize(new java.awt.Dimension(40, 23));
        panelisi4.add(label14);

        BtnKeluar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar1.setMnemonic('K');
        BtnKeluar1.setToolTipText("Keluar");
        BtnKeluar1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnKeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluar1ActionPerformed(evt);
            }
        });
        panelisi4.add(BtnKeluar1);

        internalFrame3.add(panelisi4, java.awt.BorderLayout.PAGE_END);

        TabRawat.addTab("Ikutan Ngobrol", internalFrame3);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabRawatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabRawatMouseClicked
        if(TabRawat.getSelectedIndex()==0){
           tampil();
        }else if(TabRawat.getSelectedIndex()==1){
           tampil2();
        }
    }//GEN-LAST:event_TabRawatMouseClicked

    private void tbPengaduanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPengaduanMouseClicked
        
    }//GEN-LAST:event_tbPengaduanMouseClicked

    private void tbPengaduanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPengaduanKeyPressed
        
    }//GEN-LAST:event_tbPengaduanKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_UP){
            tbPengaduan.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        
    }//GEN-LAST:event_BtnAllKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        for(i=0;i<tbPengaduan.getRowCount();i++){ 
            if(tbPengaduan.getValueAt(i,0).toString().equals("true")){
                Sequel.queryu2("delete from pengaduan where id=?",1,new String[]{tbPengaduan.getValueAt(i,1).toString()});
            }
        }        
        BtnCariActionPerformed(evt);
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        
    }//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnHapusTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusTotalActionPerformed
        i=JOptionPane.showConfirmDialog(null, "Yakin semua data chat mau dihapus ????","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            Sequel.queryu("truncate table pengaduan");
            tampil();
        }
    }//GEN-LAST:event_BtnHapusTotalActionPerformed

    private void BtnHapusTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnHapusTotalKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TabRawatMouseClicked(null);
    }//GEN-LAST:event_formWindowOpened

    private void PesanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCari1ActionPerformed(null);
        }
    }//GEN-LAST:event_PesanKeyPressed

    private void BtnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari1ActionPerformed
        if(Pesan.getText().trim().equals("")){
            Valid.textKosong(Pesan,"Pesan");
        }else{
            Sequel.menyimpan("pengaduan","?,?,?,?",4,new String[]{
                "0",Sequel.cariIsi("select now()"),akses.getkode(),Pesan.getText()
            });
            Pesan.setText("");
            tampil2();
        }            
    }//GEN-LAST:event_BtnCari1ActionPerformed

    private void BtnCari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCari1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCari1KeyPressed

    private void BtnKeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluar1ActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluar1ActionPerformed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
        }else if(tabMode.getRowCount()!=0){
            Map<String, Object> param = new HashMap<>();   
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());   
                param.put("logo",Sequel.cariGambar("select logo from setting")); 
                Valid.MyReportqry("rptPengaduan.jasper","report","::[ Data Pengaduan ]::",
                        "select id, date_time, username, message from pengaduan where "+
                        "date_time between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 00:00:00' and id like '%"+TCari.getText().trim()+"%' or "+
                        "date_time between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 00:00:00' and username like '%"+TCari.getText().trim()+"%' or "+
                        "date_time between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 00:00:00' and message like '%"+TCari.getText().trim()+"%' order by id ",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,Tgl2,BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPengaduan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnCari1;
    private widget.Button BtnHapus;
    private widget.Button BtnHapusTotal;
    private widget.Button BtnKeluar;
    private widget.Button BtnKeluar1;
    private widget.Button BtnPrint;
    private widget.Label LCount;
    private widget.editorpane LoadHTML;
    private widget.TextBox Pesan;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private javax.swing.JTabbedPane TabRawat;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.Label label10;
    private widget.Label label11;
    private widget.Label label13;
    private widget.Label label14;
    private widget.Label label18;
    private widget.Label label9;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private widget.Table tbPengaduan;
    // End of variables declaration//GEN-END:variables
    private void tampil() {
        Valid.tabelKosong(tabMode);
        try{   
            ps=koneksi.prepareStatement(
                "select id, date_time, username, message from pengaduan where "+
                "date_time between ? and ? and id like ? or "+
                "date_time between ? and ? and username like ? or "+
                "date_time between ? and ? and message like ? order by id ");
            try {
                ps.setString(1,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(2,Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(3,"%"+TCari.getText().trim()+"%");
                ps.setString(4,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(5,Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(6,"%"+TCari.getText().trim()+"%");
                ps.setString(7,Valid.SetTgl(Tgl1.getSelectedItem()+"")+" 00:00:00");
                ps.setString(8,Valid.SetTgl(Tgl2.getSelectedItem()+"")+" 23:59:59");
                ps.setString(9,"%"+TCari.getText().trim()+"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        false,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4) 
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }                
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }
    
    private void tampil2() {
        try{   
            htmlContent = new StringBuilder();
            ps=koneksi.prepareStatement(
                "select id, date_time, username, message from pengaduan order by id limit 2000");
            try {
                rs=ps.executeQuery();
                i=1;
                while(rs.next()){
                    if(i%2==0){
                        if(rs.getString("username").equals(akses.getkode())){
                            htmlContent.append(
                                "<tr class='isi'>"+
                                    "<td align='right' valign='top' bgcolor='#ffffff'>"+rs.getString("date_time")+" "+rs.getString("username")+" : "+rs.getString("message")+"</td>"+
                                "</tr>");
                        }else{
                            htmlContent.append(
                                "<tr class='isi'>"+
                                    "<td align='left' valign='top' bgcolor='#ffffff'>"+rs.getString("date_time")+" "+rs.getString("username")+" : "+rs.getString("message")+"</td>"+
                                "</tr>");
                        }                            
                    }else if(i%2==1){
                        if(rs.getString("username").equals(akses.getkode())){
                            htmlContent.append(
                                "<tr class='isi'>"+
                                    "<td align='right' valign='top' bgcolor='#FFFAF8'>"+rs.getString("date_time")+" "+rs.getString("username")+" : "+rs.getString("message")+"</td>"+
                                "</tr>");
                        }else{
                            htmlContent.append(
                                "<tr class='isi'>"+
                                    "<td align='left' valign='top' bgcolor='#FFFAF8'>"+rs.getString("date_time")+" "+rs.getString("username")+" : "+rs.getString("message")+"</td>"+
                                "</tr>");
                        }
                    }                        
                    i++;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } 
            LoadHTML.setText(
                    "<html>"+
                      "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                       htmlContent.toString()+
                      "</table>"+
                    "</html>");
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }
    
    public void isCek(){
        if(akses.getkode().equals("Admin Utama")){
            BtnHapusTotal.setEnabled(true);
        }else{
            BtnHapusTotal.setEnabled(false);
        }  
    }
    
    private void jam(){
        ActionListener taskPerformer = new ActionListener(){
            private int nilai_detik;
            public void actionPerformed(ActionEvent e) {
                String nol_detik = "";                
                Date now = Calendar.getInstance().getTime();
                nilai_detik = now.getSeconds();
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }
                
                String detik = nol_detik + Integer.toString(nilai_detik);
                if(detik.equals("10")||detik.equals("20")||detik.equals("30")||detik.equals("40")||detik.equals("50")||detik.equals("00")){                    
                    if(TabRawat.getSelectedIndex()==1){
                        tampil2();
                    }                                            
                }
            }
        };
        // Timer
        new Timer(1000, taskPerformer).start();
    }
}
