import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

public class muayene extends JFrame{
    private JPanel muayene;
    private JLabel musteriLabel;
    private JTextField musteritextField1;
    private JLabel projeadiLabel;
    private JTextField projeaditextField1;
    private JLabel testyeriLabel;
    private JTextField testyeritextField1;
    private JLabel muayenestandardiLabel;
    private JTextField muayenestandarditextField1;
    private JLabel degerlendirmestandardiLabel;
    private JTextField degerlendirmestandarditextField1;
    private JLabel muayeneproseduruLabel;
    private JTextField muayeneprosedurutextField1;
    private JButton okbutton1;
    private JButton silbutton1;
    private JButton guncellebutton1;
    private JLabel muayenekapsamiLabel;
    private JTextField muayenekapsamitextField1;
    private JLabel resimnoLabel;
    private JTextField resimnotextField1;
    private JLabel yuzeydurumuLabel;
    private JTextField yuzeydurumutextField1;
    private JLabel muayeneasamasi;
    private JTextField muayeneasamasitextField1;
    private JLabel sayfanoLabel;
    private JTextField sayfanotextField1;
    private JLabel rapornoLabel;
    private JTextField rapornotextField1;
    private JLabel raportarihiLabel;
    private JTextField raportarihitextField1;
    private JLabel isemrinoLabel;
    private JTextField isemrinotextField1;
    private JLabel teklifnoLabel;
    private JTextField teklifnotextField1;
    private JComboBox mustericomboBox1;
    private JComboBox yuzeydurumucomboBox1;
    private JComboBox muayeneasamasicomboBox1;
    private JComboBox isemrinocomboBox1;
    private JComboBox teklifnocomboBox1;
    private JButton ExportforExcelbutton1;
    private JButton ExportforPdfbutton1;


    public static Connection connect=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public static String url="jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public  static String user="root",pass="Kule1845";

    public muayene(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(muayene);
        ExportforExcelbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AdvancedDb2ExcelExporter exporter=new AdvancedDb2ExcelExporter();
                exporter.export("muayene");
            }
        });
        ExportforPdfbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String url = "jdbc:mysql://localhost:3306/connect_mysql_database?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
                String user = "root";
                String pass = "Kule1845";
                try {
                    Class.forName ("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(url,user,pass);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Statement stmt = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ResultSet query_set = null;
                try {
                    query_set = stmt.executeQuery("SELECT * FROM muayene ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Document my_pdf_report = new Document();
                try {
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("muayene.pdf"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                my_pdf_report.open();
                PdfPTable my_report_table = new PdfPTable(15);
                PdfPCell table_cell;
                while (true) {
                    try {
                        if (!query_set.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    String musteri = null;
                    try {
                        musteri = query_set.getString("musteri");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(musteri));
                    my_report_table.addCell(table_cell);
                    String projeadi= null;
                    try {
                        projeadi = query_set.getString("projeadi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(projeadi));
                    my_report_table.addCell(table_cell);
                    String testyeri= null;
                    try {
                        testyeri = query_set.getString("testyeri");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(testyeri));
                    my_report_table.addCell(table_cell);
                    String muayenestandardi = null;
                    try {
                        muayenestandardi = query_set.getString("muayenestandardi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenestandardi));
                    my_report_table.addCell(table_cell);
                    String degerlendirmestandardi= null;
                    try {
                        degerlendirmestandardi = query_set.getString("degerlendirmestandardi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(degerlendirmestandardi));
                    my_report_table.addCell(table_cell);
                    String muayeneproseduru= null;
                    try {
                        muayeneproseduru = query_set.getString("muayeneproseduru");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayeneproseduru));
                    my_report_table.addCell(table_cell);
                    String muayenekapsami = null;
                    try {
                        muayenekapsami = query_set.getString("muayenekapsami");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayenekapsami));
                    my_report_table.addCell(table_cell);
                    String resimno= null;
                    try {
                        resimno = query_set.getString("resimno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(resimno));
                    my_report_table.addCell(table_cell);
                    String yuzeydurumu= null;
                    try {
                        yuzeydurumu = query_set.getString("yuzeydurumu");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(yuzeydurumu));
                    my_report_table.addCell(table_cell);
                    String muayeneasamasi = null;
                    try {
                        muayeneasamasi = query_set.getString("muayeneasamasi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(muayeneasamasi));
                    my_report_table.addCell(table_cell);
                    String sayfano= null;
                    try {
                        sayfano = query_set.getString("sayfano");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(sayfano));
                    my_report_table.addCell(table_cell);
                    String raporno= null;
                    try {
                        raporno = query_set.getString("raporno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(raporno));
                    my_report_table.addCell(table_cell);
                    String raportarihi = null;
                    try {
                        raportarihi = query_set.getString("raportarihi");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(raportarihi));
                    my_report_table.addCell(table_cell);
                    String isemrino= null;
                    try {
                        isemrino = query_set.getString("isemrino");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(isemrino));
                    my_report_table.addCell(table_cell);
                    String teklifno= null;
                    try {
                        teklifno = query_set.getString("teklifno");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    table_cell=new PdfPCell(new Phrase(teklifno));
                    my_report_table.addCell(table_cell);
                }
                try {
                    my_pdf_report.add(my_report_table);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                my_pdf_report.close();


                try {
                    query_set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });
        silbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x=mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
                try {

                    statement.executeUpdate("DELETE FROM muayene where musteri='"+x+"'");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        okbutton1.addActionListener(new ActionListener() {



            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String x = mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);

                try {
                    statement.executeUpdate("INSERT INTO muayene VALUES ('" + x + "','" + y + "','" + z + "','"+ a +"','"+ b +"','"+ c +"','"+d+"','"+f+"','"+g+"','"+h+"','"+ı+"','"+i+"','"+j+"','"+k+"','"+l+"')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        guncellebutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = mustericomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,x);
                String y = projeaditextField1.getText();
                String z = testyeritextField1.getText();
                String a= muayenestandarditextField1.getText();
                String b= degerlendirmestandarditextField1.getText();
                String c= muayeneprosedurutextField1.getText();
                String d=muayenekapsamitextField1.getText();
                String f=resimnotextField1.getText();
                String g=yuzeydurumucomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,g);
                String h=muayeneasamasicomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,h);
                String ı=sayfanotextField1.getText();
                String i=rapornotextField1.getText();
                String j=raportarihitextField1.getText();
                String k=isemrinocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,k);
                String l=teklifnocomboBox1.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,l);
                try{
                    statement.executeUpdate("UPDATE muayene set projeadi='"+y+"',testyeri='"+z+"',muayenestandardi='"+a+"',degerlendirmestandardi='"+b+"',muayeneproseduru='"+c+"',muayenekapsami='"+d+"',resimno='"+f+"',yuzeydurumu='"+g+"',muayeneasamasi='"+h+"',sayfano='"+ı+"',raporno='"+i+"',raportarihi='"+j+"',isemrino='"+k+"',teklifno='"+l+"'where musteri='"+x+"'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

}
    public static void main(String[] args) {
        JFrame frame=new muayene("Muayene");
        JComboBox mustericomboBox=new JComboBox();
        DefaultComboBoxModel comboBoxModel=new DefaultComboBoxModel();
        comboBoxModel.setSelectedItem(mustericomboBox);
        JComboBox yuzeydurumucomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(yuzeydurumucomboBox);
        JComboBox muayeneasamasicomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(muayeneasamasicomboBox);
        JComboBox isemrinocomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(isemrinocomboBox);
        JComboBox teklifnocomboBox=new JComboBox();
        comboBoxModel.setSelectedItem(teklifnocomboBox);



        frame.setVisible(true);



        try{
           // Class.forName("com.mysql.cj.jdbc.Driver");
            //connect = DriverManager.getConnection(url, user, pass);
            Connection connect=database.getConnection();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from muayene");
            while (resultSet.next()) {
                String musteri = resultSet.getString(1);
                String projeadi = resultSet.getString(2);
                String testyeri = resultSet.getString(3);
                String muayenestandardi=resultSet.getString(4);
                String degerlendirmestandardi=resultSet.getString(5);
                String muayeneproseduru=resultSet.getString(6);
                String muayenekapsami=resultSet.getString(7);
                String resimno=resultSet.getString(8);
                String yuzeydurumu=resultSet.getString(9);
                String muayeneasamasi=resultSet.getString(10);
                String sayfano=resultSet.getString(11);
                String raporno=resultSet.getString(12);
                String raportarihi=resultSet.getString(13);
                String isemrino=resultSet.getString(14);
                String teklifno=resultSet.getString(15);
                System.out.println(musteri + " " +projeadi  + " " +testyeri+" "+muayenestandardi+" "+degerlendirmestandardi+" "+muayeneproseduru+" "+muayenekapsami+" "+resimno+" "+yuzeydurumu+" "+muayeneasamasi+" "+sayfano+" "+raporno+" "+raportarihi+" "+isemrino+" "+teklifno);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }//catch (ClassNotFoundException e){
           // e.printStackTrace();
        //}


    }




}
