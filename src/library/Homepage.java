/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;   
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author 91904
 */

public class Homepage extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    public Homepage() {
        initComponents();
        showPieChart();
        setBookDetailsToTable();
        setStudentDetailsToTable();
        setDataToCards1();
        setDataToCardstwo();
        setDataToCardsthree();
        setDataToCardsfour();
    }
    
     public void setDataToCards1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/library", "root", "abcd");
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM bookdetail";
            ResultSet resultSet = statement.executeQuery(sql);
            int totalBooks = 0;

            while (resultSet.next()) {
                int quantity = resultSet.getInt("Quantity");
                totalBooks += quantity;
            }
             jLabel23.setText(String.valueOf(totalBooks));
            resultSet.close();
            statement.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
     }
     
      public void setDataToCardstwo() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/library", "root", "abcd");
        Statement statement = con.createStatement();
        String countQuery = "SELECT COUNT(*) FROM student";
        ResultSet countResult = statement.executeQuery(countQuery);

        if (countResult.next()) {
            int rowCount = countResult.getInt(1);
            jLabel20.setText(String.valueOf(rowCount));
        }

        countResult.close();
        statement.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

      public void setDataToCardsthree() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/library", "root", "abcd");
        Statement statement = con.createStatement();
        String countQuery = "SELECT COUNT(*) FROM issue_detail WHERE Status = 'pending'";
        ResultSet countResult = statement.executeQuery(countQuery);

        if (countResult.next()) {
            int rowCount = countResult.getInt(1);
            jLabel21.setText(String.valueOf(rowCount));
        }

        countResult.close();
        statement.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
public void setDataToCardsfour() {
    try {
        long currentTime = System.currentTimeMillis();
        java.util.Date todaysDate = new java.util.Date(currentTime);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/library", "root", "abcd");
        String countQuery = "SELECT COUNT(*) FROM issue_detail WHERE Duedate < ? AND Status = ?";
        PreparedStatement pst = con.prepareStatement(countQuery);
        pst.setDate(1, new java.sql.Date(todaysDate.getTime()));
        pst.setString(2, "pending");
        ResultSet countResult = pst.executeQuery();

        if (countResult.next()) {
            int rowCount = countResult.getInt(1);
            jLabel22.setText(String.valueOf(rowCount));
        }

        countResult.close();
        con.close();

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}



    
     public void setBookDetailsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/library","root","abcd");
            String sql = "select * from bookdetail";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            table_book.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     public void setStudentDetailsToTable(){
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/library","root","abcd");
            String sql = "select * from student";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            table_student.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
     }
    
      
  
     
     public void showPieChart() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/library", "root", "abcd");
        String sql = "SELECT Name, Quantity FROM bookdetail";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        while (rs.next()) {
            String bookName = rs.getString("Name");
            int quantity = rs.getInt("Quantity");
            pieDataset.setValue(bookName, quantity);
        }

        JFreeChart piechart = ChartFactory.createPieChart("Library", pieDataset, false, true, false);
        PiePlot piePlot = (PiePlot) piechart.getPlot();

        // You can customize the colors if needed
        piePlot.setBackgroundPaint(Color.white);

        // Create chartPanel to display chart(graph)
        ChartPanel pieChartPanel = new ChartPanel(piechart);
        PanelPieChart.removeAll();
        PanelPieChart.add(pieChartPanel, BorderLayout.CENTER);
        PanelPieChart.validate();

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_book = new rojeru_san.complementos.RSTableMetro();
        PanelPieChart = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_student = new rojeru_san.complementos.RSTableMetro();

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(rSTableMetro1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 5, 50));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\91904\\OneDrive\\Pictures\\Screenshots\\admin.png")); // NOI18N
        jLabel3.setText("Welcome, Admin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\91904\\OneDrive\\Pictures\\Screenshots\\menu.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("LMS Dashboard");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Features");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));

        jLabel6.setBackground(new java.awt.Color(102, 153, 255));
        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel6.setText("  Log out");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 160, -1));

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel26MouseEntered(evt);
            }
        });
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel26.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel28.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel28.setText("Manage Books");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
        });
        jPanel28.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel26.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 50));

        jLabel10.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel10.setText("Manage Students");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel26.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, -1));

        jPanel3.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel26.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel26.setText("Manage Books");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
        });
        jPanel22.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel18.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 50));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel9.setText("Manage Books");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel20.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel3.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 40));

        jPanel30.setBackground(new java.awt.Color(51, 51, 51));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel30MouseEntered(evt);
            }
        });
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(51, 51, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel29.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel29.setText("Manage Books");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel30.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setBackground(new java.awt.Color(51, 51, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel30.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel30.setText("Manage Books");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
        });
        jPanel32.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel30.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, 50));

        jPanel3.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jPanel36.setBackground(new java.awt.Color(51, 51, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel14.setText("Issue Book");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel36.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel39.setBackground(new java.awt.Color(51, 51, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(51, 51, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel27.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel27.setText("Issue Book");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel39.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel36.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 40));

        jPanel41.setBackground(new java.awt.Color(51, 51, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel42.setBackground(new java.awt.Color(51, 51, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel31.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel31.setText("Issue Book");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });
        jPanel41.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel43.setBackground(new java.awt.Color(51, 51, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel44.setBackground(new java.awt.Color(51, 51, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel32.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel32.setText("Issue Book");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
        });
        jPanel43.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel41.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 40));

        jPanel36.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 40));

        jPanel3.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 50));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel12.setText("Return Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel24.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel3.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 40));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel5.setText("   Home Page");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel34.setBackground(new java.awt.Color(51, 51, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(51, 51, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel13.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel13.setText("View Record");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel34.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel3.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 40));

        jPanel38.setBackground(new java.awt.Color(51, 51, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel45.setBackground(new java.awt.Color(51, 51, 51));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel38.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 40));

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel15.setText("Defaulter List");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel38.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel3.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 460));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel23.setText("10");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 70));

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(102, 153, 255)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 110, 70));

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 110, 70));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 110, 70));

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 110, 70));

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 110, 70));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 110, 70));

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 110, 70));

        jLabel20.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        jLabel20.setText("10");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 120, 70));

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        jLabel21.setText("10");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        jPanel6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 120, 70));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(102, 153, 255)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jLabel22.setText("10");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 120, 70));

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("No. of Students");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel17.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Issued Books");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Defaulters");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("No. of Books");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, -1));

        jLabel24.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Book Details");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel25.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Student Details");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        table_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Id", "Name", "Author ", "Quantity"
            }
        ));
        table_book.setAltoHead(30);
        table_book.setColorBackgoundHead(new java.awt.Color(102, 153, 255));
        table_book.setColorBordeFilas(new java.awt.Color(102, 153, 255));
        table_book.setColorBordeHead(new java.awt.Color(255, 255, 255));
        table_book.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_book.setColorFilasForeground1(new java.awt.Color(102, 153, 255));
        table_book.setColorFilasForeground2(new java.awt.Color(102, 153, 255));
        table_book.setColorSelBackgound(new java.awt.Color(255, 255, 255));
        table_book.setColorSelForeground(new java.awt.Color(102, 153, 255));
        table_book.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        table_book.setFuenteFilas(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_book.setFuenteFilasSelect(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_book.setFuenteHead(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_book.setGridColor(new java.awt.Color(102, 153, 255));
        table_book.setMaximumSize(new java.awt.Dimension(30, 20));
        table_book.setMinimumSize(new java.awt.Dimension(30, 20));
        table_book.setRowHeight(17);
        table_book.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane3.setViewportView(table_book);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 440, 100));

        PanelPieChart.setBackground(new java.awt.Color(255, 255, 255));
        PanelPieChart.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        PanelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel6.add(PanelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 220, 210));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        table_student.setAltoHead(30);
        table_student.setColorBackgoundHead(new java.awt.Color(102, 153, 255));
        table_student.setColorBordeFilas(new java.awt.Color(102, 153, 255));
        table_student.setColorBordeHead(new java.awt.Color(255, 255, 255));
        table_student.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_student.setColorFilasForeground1(new java.awt.Color(102, 153, 255));
        table_student.setColorFilasForeground2(new java.awt.Color(102, 153, 255));
        table_student.setColorSelBackgound(new java.awt.Color(255, 255, 255));
        table_student.setColorSelForeground(new java.awt.Color(102, 153, 255));
        table_student.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        table_student.setFuenteFilas(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_student.setFuenteFilasSelect(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_student.setFuenteHead(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        table_student.setGridColor(new java.awt.Color(102, 153, 255));
        table_student.setMaximumSize(new java.awt.Dimension(30, 20));
        table_student.setMinimumSize(new java.awt.Dimension(30, 20));
        table_student.setRowHeight(17);
        table_student.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane4.setViewportView(table_student);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 440, 100));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 690, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        ManageBooks books =  new ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jPanel20.setBackground(mouseEnterColor);
        
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jPanel20.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
       jPanel26.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        jPanel26.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        ManageStudents stu =  new ManageStudents();
        stu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jPanel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel26MouseEntered

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jPanel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseEntered

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        ReturnBook ret = new ReturnBook();
        ret.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        ViewRecord view = new ViewRecord();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
         IssueBook isu = new IssueBook();
         isu.setVisible(true);
         dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
         jPanel36.setBackground(mouseEnterColor); 
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jPanel36.setBackground(mouseExitColor); 
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jPanel24.setBackground(mouseEnterColor);        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        jPanel24.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
     // jPanel38.setBackground(mouseEnterColor);
     jPanel34.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
       jPanel34.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jPanel38.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jPanel38.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        try {
            // TODO add your handling code here:
            Defaulter defu = new Defaulter();
            defu.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        signuppage s=new signuppage();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseExited

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPieChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private rojeru_san.complementos.RSTableMetro table_book;
    private rojeru_san.complementos.RSTableMetro table_student;
    // End of variables declaration//GEN-END:variables
}
