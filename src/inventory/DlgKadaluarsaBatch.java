package inventory;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import keuangan.Jurnal;

public class DlgKadaluarsaBatch extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Jurnal jur=new Jurnal();
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;

    /** 
     * @param parent
     * @param modal */
    public DlgKadaluarsaBatch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Object[] row={
            "No.Batch","Kode Barang","Nama Barang","Satuan","Tgl.Datang",
            "Kadaluarsa","Asal","No.Faktur","Harga Beli","Jml.Beli","Sisa"
        };
        tabMode=new DefaultTableModel(null,row){
            @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Double.class,java.lang.Double.class,java.lang.Double.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        tbDokter.setModel(tabMode);

        tbDokter.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbDokter.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 11; i++) {
            TableColumn column = tbDokter.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(70);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(180);
            }else if(i==3){
                column.setPreferredWidth(50);
            }else if(i==4){
                column.setPreferredWidth(80);
            }else if(i==5){
                column.setPreferredWidth(80);
            }else if(i==6){
                column.setPreferredWidth(80);
            }else if(i==7){
                column.setPreferredWidth(100);
            }else if(i==8){
                column.setPreferredWidth(80);
            }else if(i==9){
                column.setPreferredWidth(50);
            }else if(i==10){
                column.setPreferredWidth(50);
            }
        }
        tbDokter.setDefaultRenderer(Object.class, new WarnaTable());         
        
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        prosesCari();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        prosesCari();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        prosesCari();
                    }
                }
            });
        }   
     
    }    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        scrollPane1 = new widget.ScrollPane();
        tbDokter = new widget.Table();
        panelisi1 = new widget.panelisi();
        label1 = new widget.Label();
        tanggal1 = new widget.Tanggal();
        label2 = new widget.Label();
        tanggal2 = new widget.Tanggal();
        label10 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        label9 = new widget.Label();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 253, 247)), "::[ Data Kadaluarsa Berdasarkan Data Batch ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        scrollPane1.setName("scrollPane1"); // NOI18N
        scrollPane1.setOpaque(true);

        tbDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDokter.setName("tbDokter"); // NOI18N
        scrollPane1.setViewportView(tbDokter);

        internalFrame1.add(scrollPane1, java.awt.BorderLayout.CENTER);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 56));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label1.setText("Kadaluarsa :");
        label1.setName("label1"); // NOI18N
        label1.setPreferredSize(new java.awt.Dimension(68, 23));
        panelisi1.add(label1);

        tanggal1.setDisplayFormat("dd-MM-yyyy");
        tanggal1.setName("tanggal1"); // NOI18N
        tanggal1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi1.add(tanggal1);

        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("s.d");
        label2.setName("label2"); // NOI18N
        label2.setPreferredSize(new java.awt.Dimension(23, 23));
        panelisi1.add(label2);

        tanggal2.setDisplayFormat("dd-MM-yyyy");
        tanggal2.setName("tanggal2"); // NOI18N
        tanggal2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi1.add(tanggal2);

        label10.setText("Key Word :");
        label10.setName("label10"); // NOI18N
        label10.setPreferredSize(new java.awt.Dimension(69, 23));
        panelisi1.add(label10);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(170, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi1.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
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
        panelisi1.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('A');
        BtnAll.setToolTipText("Alt+A");
        BtnAll.setName("BtnAll"); // NOI18N
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
        panelisi1.add(BtnAll);

        label9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(20, 30));
        panelisi1.add(label9);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('P');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+P");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
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
        panelisi1.add(BtnPrint);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
private void KdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKdKeyPressed
    Valid.pindah(evt,BtnCari,Nm);
}//GEN-LAST:event_TKdKeyPressed
*/

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Map<String, Object> param = new HashMap<>(); 
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReportqry("rptKadaluarsaBatch.jasper","report","::[ Kadaluarsa Batch ]::",
               "select data_batch.no_batch,data_batch.kode_brng,databarang.nama_brng,"+
               "kodesatuan.satuan,data_batch.tgl_beli,data_batch.tgl_kadaluarsa,"+
               "data_batch.asal,data_batch.no_faktur,data_batch.h_beli,data_batch.jumlahbeli,"+
               "data_batch.sisa from data_batch inner join databarang inner join kodesatuan "+
               "on data_batch.kode_brng=databarang.kode_brng and "+
               "kodesatuan.kode_sat=databarang.kode_sat where "+
               "data_batch.tgl_kadaluarsa between '"+Valid.SetTgl(tanggal1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(tanggal2.getSelectedItem()+"")+"' and data_batch.no_batch like '%"+TCari.getText().trim()+"%' or "+
               "data_batch.tgl_kadaluarsa between '"+Valid.SetTgl(tanggal1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(tanggal2.getSelectedItem()+"")+"' and data_batch.kode_brng like '%"+TCari.getText().trim()+"%' or "+
               "data_batch.tgl_kadaluarsa between '"+Valid.SetTgl(tanggal1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(tanggal2.getSelectedItem()+"")+"' and databarang.nama_brng like '%"+TCari.getText().trim()+"%' or "+
               "data_batch.tgl_kadaluarsa between '"+Valid.SetTgl(tanggal1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(tanggal2.getSelectedItem()+"")+"' and data_batch.asal like '%"+TCari.getText().trim()+"%' or "+
               "data_batch.tgl_kadaluarsa between '"+Valid.SetTgl(tanggal1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(tanggal2.getSelectedItem()+"")+"' and data_batch.no_faktur like '%"+TCari.getText().trim()+"%' "+
               "order by data_batch.tgl_kadaluarsa",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,TCari,BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,TCari);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
        prosesCari();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
        prosesCari();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prosesCari();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgKadaluarsaBatch dialog = new DlgKadaluarsaBatch(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.TextBox TCari;
    private widget.InternalFrame internalFrame1;
    private widget.Label label1;
    private widget.Label label10;
    private widget.Label label2;
    private widget.Label label9;
    private widget.panelisi panelisi1;
    private widget.ScrollPane scrollPane1;
    private widget.Tanggal tanggal1;
    private widget.Tanggal tanggal2;
    private widget.Table tbDokter;
    // End of variables declaration//GEN-END:variables

    private void prosesCari() {
        Valid.tabelKosong(tabMode);
        try {
            ps=koneksi.prepareStatement(
               "select data_batch.no_batch,data_batch.kode_brng,databarang.nama_brng,"+
               "kodesatuan.satuan,data_batch.tgl_beli,data_batch.tgl_kadaluarsa,"+
               "data_batch.asal,data_batch.no_faktur,data_batch.h_beli,data_batch.jumlahbeli,"+
               "data_batch.sisa from data_batch inner join databarang inner join kodesatuan "+
               "on data_batch.kode_brng=databarang.kode_brng and "+
               "kodesatuan.kode_sat=databarang.kode_sat where "+
               "data_batch.tgl_kadaluarsa between ? and ? and data_batch.no_batch like ? or "+
               "data_batch.tgl_kadaluarsa between ? and ? and data_batch.kode_brng like ? or "+
               "data_batch.tgl_kadaluarsa between ? and ? and databarang.nama_brng like ? or "+
               "data_batch.tgl_kadaluarsa between ? and ? and data_batch.asal like ? or "+
               "data_batch.tgl_kadaluarsa between ? and ? and data_batch.no_faktur like ? "+
               "order by data_batch.tgl_kadaluarsa");
            try {
                ps.setString(1,Valid.SetTgl(tanggal1.getSelectedItem()+""));
                ps.setString(2,Valid.SetTgl(tanggal2.getSelectedItem()+""));
                ps.setString(3,"%"+TCari.getText().trim()+"%");
                ps.setString(4,Valid.SetTgl(tanggal1.getSelectedItem()+""));
                ps.setString(5,Valid.SetTgl(tanggal2.getSelectedItem()+""));
                ps.setString(6,"%"+TCari.getText().trim()+"%");
                ps.setString(7,Valid.SetTgl(tanggal1.getSelectedItem()+""));
                ps.setString(8,Valid.SetTgl(tanggal2.getSelectedItem()+""));
                ps.setString(9,"%"+TCari.getText().trim()+"%");
                ps.setString(10,Valid.SetTgl(tanggal1.getSelectedItem()+""));
                ps.setString(11,Valid.SetTgl(tanggal2.getSelectedItem()+""));
                ps.setString(12,"%"+TCari.getText().trim()+"%");
                ps.setString(13,Valid.SetTgl(tanggal1.getSelectedItem()+""));
                ps.setString(14,Valid.SetTgl(tanggal2.getSelectedItem()+""));
                ps.setString(15,"%"+TCari.getText().trim()+"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getDouble(9),rs.getDouble(10),rs.getDouble(11)
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }   
        } catch (Exception e) {
            System.out.println("Notif : "+e);
        }
    }
    
    public void isCek(){
         BtnPrint.setEnabled(akses.getkadaluarsa_batch());
    }
    
}
