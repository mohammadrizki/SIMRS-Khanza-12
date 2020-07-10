package laporan;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class DlgHAIsPerBangsal extends javax.swing.JDialog {
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;
    private StringBuilder htmlContent;
    private int i=0,deku=0,urine=0,sputum=0,darah=0,pasien=0,jmlpasien=0,ETT=0,CVL=0,IVL=0,UC=0,VAP=0,IAD=0,PLEB=0,
                ISK=0,ILO=0,ANTIBIOTIK=0,jmlHAP,jmlTinea,jmlScabies,jmlETT,jmlCVL,jmlIVL,jmlUC,jmlVAP,jmlIAD,jmlPLEB,jmlISK,
                HAP,Tinea,Scabies,jmlILO,jmldeku,jmlsputum,jmldarah,jmlurine,jmlANTIBIOTIK;
    
    /** Creates new form DlgProgramStudi
     * @param parent
     * @param modal */
    public DlgHAIsPerBangsal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi2 td{font: 8.5px tahoma;height:12px;background: #ffffff;color:#323232;}"+
                ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
        );
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);
        LoadHTML.setDocument(doc);        
    }
    private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kd2 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        panelisi1 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        btnCari = new widget.Button();
        BtnAll = new widget.Button();
        label9 = new widget.Label();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        Scroll = new widget.ScrollPane();
        LoadHTML = new widget.editorpane();

        Kd2.setName("Kd2"); // NOI18N
        Kd2.setPreferredSize(new java.awt.Dimension(207, 23));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 253, 247)), "::[ Laporan HAIs Per Kamar/Bangsal ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 56));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Tanggal :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(55, 23));
        panelisi1.add(label11);

        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelisi1.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi1.add(label18);

        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelisi1.add(Tgl2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi1.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(160, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi1.add(TCari);

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        btnCari.setMnemonic('2');
        btnCari.setToolTipText("Alt+2");
        btnCari.setName("btnCari"); // NOI18N
        btnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        btnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCariKeyPressed(evt);
            }
        });
        panelisi1.add(btnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setToolTipText("Alt+M");
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

        label9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(20, 30));
        panelisi1.add(label9);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
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

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N
        Scroll.setViewportView(LoadHTML);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

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
        try {
            
            File g = new File("file2.css");            
            BufferedWriter bg = new BufferedWriter(new FileWriter(g));
            bg.write(
                    ".isi td{border-right: 1px solid #e2e7dd;font: 11px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                    ".isi2 td{font: 11px tahoma;height:12px;background: #ffffff;color:#323232;}"+                    
                    ".isi3 td{border-right: 1px solid #e2e7dd;font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                    ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
            );
            bg.close();
            
            File f = new File("HarianHAIs.html");            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));            
            bw.write(LoadHTML.getText().replaceAll("<head>","<head><link href=\"file2.css\" rel=\"stylesheet\" type=\"text/css\" />"+
                        "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                            "<tr class='isi2'>"+
                                "<td valign='top' align='center'>"+
                                    "<font size='4' face='Tahoma'>"+akses.getnamars()+"</font><br>"+
                                    akses.getalamatrs()+", "+akses.getkabupatenrs()+", "+akses.getpropinsirs()+"<br>"+
                                    akses.getkontakrs()+", E-mail : "+akses.getemailrs()+"<br><br>"+       
                                "</td>"+
                           "</tr>"+
                        "</table>")
            );
            bw.close();                         
            Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            System.out.println("Notifikasi : "+e);
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

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,Tgl1);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
    prosesCari();
}//GEN-LAST:event_btnCariActionPerformed

private void btnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            btnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, Tgl2, BtnPrint);
        }
}//GEN-LAST:event_btnCariKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prosesCari();
    }//GEN-LAST:event_formWindowOpened

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            btnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        prosesCari();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            TCari.setText("");
            prosesCari();
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgHAIsPerBangsal dialog = new DlgHAIsPerBangsal(new javax.swing.JFrame(), true);
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
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.TextBox Kd2;
    private widget.editorpane LoadHTML;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.Button btnCari;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel6;
    private widget.Label label11;
    private widget.Label label18;
    private widget.Label label9;
    private widget.panelisi panelisi1;
    // End of variables declaration//GEN-END:variables

    private void prosesCari() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            htmlContent = new StringBuilder();
            htmlContent.append(                             
                "<tr class='isi'>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='2%' rowspan='2'>No.</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='15%' rowspan='2'>Kamar/Bangsal</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='5%' rowspan='2'>Jml.Pasien</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='19%' colspan='4'>Hari Pemasangan</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='37%' colspan='8'>Infeksi</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='4%' rowspan='2'>Deku</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='15%' colspan='3'>Hasil Kultur</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center' width='4%' rowspan='2'>Antibiotik</td>"+
                "</tr>"+
                "<tr class='isi'>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>ETT</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>CVL</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>IVL</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>UC</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>VAP</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>IAD</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Pleb</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>ISK</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>ILO</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>HAP</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Tinea</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Scabies</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Sputum</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Darah</td>"+
                    "<td valign='middle' bgcolor='#FFFAF8' align='center'>Urine</td>"+
                "</tr>"
            );     
            ps=koneksi.prepareStatement(
                    "select kd_bangsal,nm_bangsal from bangsal where status='1' and nm_bangsal like ? order by nm_bangsal");
            try {
                i=1;
                jmlETT=0;jmlCVL=0;jmlIVL=0;jmlUC=0;jmlVAP=0;jmlIAD=0;jmlPLEB=0;
                jmlpasien=0;jmlISK=0;jmlILO=0;jmldeku=0;jmlsputum=0;jmldarah=0;
                jmlurine=0;jmlHAP=0;jmlTinea=0;jmlScabies=0;jmlANTIBIOTIK=0;                        
                ps.setString(1,"%"+TCari.getText().trim()+"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    if((!rs.getString("nm_bangsal").toLowerCase().contains("apotek"))&&(!rs.getString("nm_bangsal").toLowerCase().contains("gudang"))&&(!rs.getString("nm_bangsal").toLowerCase().contains("depo"))&&(!rs.getString("nm_bangsal").toLowerCase().contains("farmasi"))){
                        pasien=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=? group by data_HAIs.no_rawat",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlpasien=jmlpasien+pasien;
                        ETT=Sequel.cariInteger("select sum(data_HAIs.ETT) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlETT=jmlETT+ETT;
                        CVL=Sequel.cariInteger("select sum(data_HAIs.CVL) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlCVL=jmlCVL+CVL;
                        IVL=Sequel.cariInteger("select sum(data_HAIs.IVL) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlIVL=jmlIVL+IVL;
                        UC=Sequel.cariInteger("select sum(data_HAIs.UC) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlUC=jmlUC+UC;
                        VAP=Sequel.cariInteger("select sum(data_HAIs.VAP) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlVAP=jmlVAP+VAP;
                        IAD=Sequel.cariInteger("select sum(data_HAIs.IAD) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlIAD=jmlIAD+IAD;
                        PLEB=Sequel.cariInteger("select sum(data_HAIs.PLEB) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlPLEB=jmlPLEB+PLEB;
                        ISK=Sequel.cariInteger("select sum(data_HAIs.ISK) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlISK=jmlISK+ISK;
                        ILO=Sequel.cariInteger("select sum(data_HAIs.ILO) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlILO=jmlILO+ILO;
                        HAP=Sequel.cariInteger("select sum(data_HAIs.HAP) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlHAP=jmlHAP+HAP;
                        Tinea=Sequel.cariInteger("select sum(data_HAIs.Tinea) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlTinea=jmlTinea+Tinea;
                        Scabies=Sequel.cariInteger("select sum(data_HAIs.Scabies) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlScabies=jmlScabies+Scabies;
                        deku=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.DEKU='IYA' and data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmldeku=jmldeku+deku;
                        sputum=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.SPUTUM<>'' and data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlsputum=jmlsputum+sputum;
                        darah=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.DARAH<>'' and data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmldarah=jmldarah+darah;
                        urine=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.URINE<>'' and data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlurine=jmlurine+urine;
                        ANTIBIOTIK=Sequel.cariInteger("select count(data_HAIs.no_rawat) from data_HAIs inner join kamar inner join bangsal on data_HAIs.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where data_HAIs.ANTIBIOTIK<>'' and data_HAIs.tanggal between ? and ? and kamar.kd_bangsal=?",Valid.SetTgl(Tgl1.getSelectedItem()+""),Valid.SetTgl(Tgl2.getSelectedItem()+""),rs.getString("kd_bangsal"));
                        jmlANTIBIOTIK=jmlANTIBIOTIK+ANTIBIOTIK;
                        htmlContent.append(                             
                            "<tr class='isi'>"+
                                "<td valign='middle' align='center'>"+i+"</td>"+
                                "<td valign='middle' align='left'>"+rs.getString("nm_bangsal")+"</td>"+
                                "<td valign='middle' align='center'>"+pasien+"</td>"+
                                "<td valign='middle' align='center'>"+ETT+"</td>"+
                                "<td valign='middle' align='center'>"+CVL+"</td>"+
                                "<td valign='middle' align='center'>"+IVL+"</td>"+
                                "<td valign='middle' align='center'>"+UC+"</td>"+
                                "<td valign='middle' align='center'>"+VAP+"</td>"+
                                "<td valign='middle' align='center'>"+IAD+"</td>"+
                                "<td valign='middle' align='center'>"+PLEB+"</td>"+
                                "<td valign='middle' align='center'>"+ISK+"</td>"+
                                "<td valign='middle' align='center'>"+ILO+"</td>"+
                                "<td valign='middle' align='center'>"+HAP+"</td>"+
                                "<td valign='middle' align='center'>"+Tinea+"</td>"+
                                "<td valign='middle' align='center'>"+Scabies+"</td>"+
                                "<td valign='middle' align='center'>"+deku+"</td>"+
                                "<td valign='middle' align='center'>"+sputum+"</td>"+
                                "<td valign='middle' align='center'>"+darah+"</td>"+
                                "<td valign='middle' align='center'>"+urine+"</td>"+
                                "<td valign='middle' align='center'>"+ANTIBIOTIK+"</td>"+
                            "</tr>"
                        ); 
                        i++;
                    }                        
                }
                htmlContent.append(                             
                    "<tr class='isi'>"+
                        "<td valign='middle' align='right' colspan='2'>Total :</td>"+
                        "<td valign='middle' align='center'>"+jmlpasien+"</td>"+
                        "<td valign='middle' align='center'>"+jmlETT+"</td>"+
                        "<td valign='middle' align='center'>"+jmlCVL+"</td>"+
                        "<td valign='middle' align='center'>"+jmlIVL+"</td>"+
                        "<td valign='middle' align='center'>"+jmlUC+"</td>"+
                        "<td valign='middle' align='center'>"+jmlVAP+"</td>"+
                        "<td valign='middle' align='center'>"+jmlIAD+"</td>"+
                        "<td valign='middle' align='center'>"+jmlPLEB+"</td>"+
                        "<td valign='middle' align='center'>"+jmlISK+"</td>"+
                        "<td valign='middle' align='center'>"+jmlILO+"</td>"+
                        "<td valign='middle' align='center'>"+jmlHAP+"</td>"+
                        "<td valign='middle' align='center'>"+jmlTinea+"</td>"+
                        "<td valign='middle' align='center'>"+jmlScabies+"</td>"+
                        "<td valign='middle' align='center'>"+jmldeku+"</td>"+
                        "<td valign='middle' align='center'>"+jmlsputum+"</td>"+
                        "<td valign='middle' align='center'>"+jmldarah+"</td>"+
                        "<td valign='middle' align='center'>"+jmlurine+"</td>"+
                        "<td valign='middle' align='center'>"+jmlANTIBIOTIK+"</td>"+
                    "</tr>"
                ); 
            } catch (Exception e) {
                System.out.println("laporan.DlgHarianHAIs.prosesCari() : "+e);
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
        } catch (Exception e) {
            System.out.println("laporan.DlgRL4A.prosesCari() 5 : "+e);
        } 
        this.setCursor(Cursor.getDefaultCursor());
        
    }
    
    public void isCek(){
        BtnPrint.setEnabled(akses.gethais_perbangsal());
    }
    
}
