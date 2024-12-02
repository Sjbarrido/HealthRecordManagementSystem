package healthrecordmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import healthrecordmanagementsystem.DataBase;

public class HealthCareManagementSystemView extends javax.swing.JFrame {

    /**
     * Creates new form HealthCareManagementSystemView
     */
    public HealthCareManagementSystemView() {
        initComponents();  
    } 
    
// Method to clear the input fields
public void clear() {
    txtId.setText(""); // Clear the text in the txtId field
    txtIDDOC.setText(""); // Clear the text in the txtIDDOC field
    txtPatient.setText(""); // Clear the text in the txtPatient field
    txtAge.setText(""); // Clear the text in the txtAge field
    txtGender.setText(""); // Clear the text in the txtGender field
    txtDoc.setText(""); // Clear the text in the txtDoc field
}

// Method to get the selected status from the comboStats dropdown
public String getStatus() {
    return (String) comboStats.getSelectedItem(); // Retrieve and return the selected item as a String
}

// Method to get the selected appointment from the comboApp dropdown
public String getApp() {
    return (String) comboApp.getSelectedItem(); // Retrieve and return the selected item as a String
}

// Method to load data from the database into the table
private void loadTableData() {
    try {
        Connection conn = DataBase.getConnection(); // Establish a database connection
        DefaultTableModel dtm = (DefaultTableModel) table.getModel(); // Get the table model
        dtm.setRowCount(0); // Clear the existing rows in the table
        Statement s = conn.createStatement(); // Create a statement for executing queries
        ResultSet rs = s.executeQuery("SELECT * FROM tblhealth"); // Execute a query to fetch all data from tblhealth

        // Iterate through the result set and populate the table
        while (rs.next()) {
            Vector<String> vec = new Vector<>(); // Create a new vector for each row
            vec.add(rs.getString(1)); // Add the first column value
            vec.add(rs.getString(2)); // Add the second column value
            vec.add(rs.getString(3)); // Add the third column value
            vec.add(rs.getString(4)); // Add the fourth column value
            vec.add(rs.getString(5)); // Add the fifth column value
            vec.add(rs.getString(6)); // Add the sixth column value
            vec.add(rs.getString(7)); // Add the seventh column value
            vec.add(rs.getString(8)); // Add the eighth column value
            dtm.addRow(vec); // Add the vector as a row in the table model
        }
        conn.close(); // Close the database connection
    } catch (Exception e) {
        // Show an error message dialog in case of an exception
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Method to set up live search functionality for the table
private void setupLiveSearch() {
    DefaultTableModel def = (DefaultTableModel) table.getModel(); // Get the table model
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(def); // Create a row sorter for the table model
    table.setRowSorter(sorter); // Set the sorter to the table

    // Add a document listener to the search text field
    txtSearch.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filterTable(sorter); // Call filterTable when text is inserted
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filterTable(sorter); // Call filterTable when text is removed
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filterTable(sorter); // Call filterTable when text changes
        }
    });
}

// Method to filter the table based on the search text
private void filterTable(TableRowSorter<TableModel> sorter) {
    String searchText = txtSearch.getText(); // Get the text from the search field
    if (searchText.trim().isEmpty()) { // Check if the search text is empty
        sorter.setRowFilter(null); // Clear the filter if the text is empty
    } else {
        // Set a case-insensitive regex filter based on the search text
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtPatient = new javax.swing.JTextField();
        txtDoc = new javax.swing.JTextField();
        comboApp = new javax.swing.JComboBox<>();
        comboStats = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtIDDOC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.setDoubleBuffered(false);

        btnAdd.setBackground(new java.awt.Color(0, 0, 255));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 255));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("+");

        btnShow.setBackground(new java.awt.Color(0, 0, 255));
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setText("SHOW");
        btnShow.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), null));
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        txtPatient.setBackground(new java.awt.Color(255, 0, 0));
        txtPatient.setForeground(new java.awt.Color(255, 255, 255));
        txtPatient.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "PATIENT NAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N
        txtPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientActionPerformed(evt);
            }
        });

        txtDoc.setBackground(new java.awt.Color(255, 0, 0));
        txtDoc.setForeground(new java.awt.Color(255, 255, 255));
        txtDoc.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "DOCTOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Print", 0, 12))); // NOI18N
        txtDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocActionPerformed(evt);
            }
        });

        comboApp.setBackground(new java.awt.Color(255, 0, 0));
        comboApp.setForeground(new java.awt.Color(255, 255, 255));
        comboApp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Routine or Preventive", "Acute Care Appointment", "Specialist Appointment", "Follow-Up Appointment", "Emergency Appointment", "Telehealth (Virtual) Appointment", "Mental Health Appointment", "Diagnostic Appointment", "Surgical Appointment", "Chronic Disease Management Appointment", "Wellness Appointment", "Palliative or Hospice Care Appointment", "Second Opinion Appointment", "Pre-Natal/Post-Natal Appointment", "Immunization Appointment", "Referral Appointment", "In-Home Care Appointment", "Pre-Operative Appointment", " ", " " }));
        comboApp.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "APPOINTMENT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N
        comboApp.setMinimumSize(new java.awt.Dimension(277, 55));
        comboApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAppActionPerformed(evt);
            }
        });

        comboStats.setBackground(new java.awt.Color(255, 0, 0));
        comboStats.setForeground(new java.awt.Color(255, 255, 255));
        comboStats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient Status", "Health Status", "Social Determinants of Health Status", "Admission or Discharge Status", "Insurance or Coverage Status", "Emergency vs. Non-Emergency Status", "Legal Status", "Clinical Status in Research", "Healthcare Provider Status", "Healthcare Facility Status", " " }));
        comboStats.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "STATUS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N
        comboStats.setMinimumSize(new java.awt.Dimension(277, 55));
        comboStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatsActionPerformed(evt);
            }
        });

        txtId.setBackground(new java.awt.Color(255, 0, 0));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "ID NUMBER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtAge.setBackground(new java.awt.Color(255, 0, 0));
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        txtAge.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "AGE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Print", 0, 12))); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        txtGender.setBackground(new java.awt.Color(255, 0, 0));
        txtGender.setForeground(new java.awt.Color(255, 255, 255));
        txtGender.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "GENDER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Print", 0, 12))); // NOI18N
        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });

        txtIDDOC.setBackground(new java.awt.Color(255, 0, 0));
        txtIDDOC.setForeground(new java.awt.Color(255, 255, 255));
        txtIDDOC.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "ID NUMBER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N
        txtIDDOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDDOCActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PATIENT", "AGE", "GENDER", "ID DOCTOR", "DOCTOR", "STATUS", "APPOINTMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        txtSearch.setBackground(new java.awt.Color(255, 0, 0));
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "SEARCH", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIDDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStats, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboApp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStats, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboApp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setText("HEALTH CARE MANAGEMENT SYSTEM");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientActionPerformed

    private void txtDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocActionPerformed

    private void comboAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAppActionPerformed

    private void comboStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatsActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenderActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed





















// Retrieve values from input fields and dropdowns
String id = txtId.getText(); // Get the text from the ID input field
String idDoc = txtIDDOC.getText(); // Get the text from the Doctor ID input field
String pName = txtPatient.getText(); // Get the text from the Patient Name input field
String age = txtAge.getText(); // Get the text from the Age input field
String gender = txtGender.getText(); // Get the text from the Gender input field
String dName = txtDoc.getText(); // Get the text from the Doctor Name input field
String status = comboStats.getSelectedItem().toString(); // Get the selected item from the Status dropdown
String appointment = comboApp.getSelectedItem().toString(); // Get the selected item from the Appointment dropdown

// Declare database connection and prepared statement variables
Connection conn;
PreparedStatement stmt;

// Create a new instance of the Methods class with the retrieved values
Methods m = new Methods(id, pName, age, gender, idDoc, dName, status, appointment);

// Validate input fields to ensure no field is empty
if (id.isEmpty() || idDoc.isEmpty() || pName.isEmpty() || age.isEmpty() || gender.isEmpty() || dName.isEmpty()) {
    // Display an error message if any field is empty
    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
    clear(); // Clear the input fields
    return; // Exit the method to prevent further execution
}

try {
    conn = DataBase.getConnection(); // Establish a connection to the database

    // SQL query to insert data into the tblhealth table
    String sql = "INSERT INTO tblhealth (idNumber, pName, age, gender, idDoc, docName, status, appointment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    stmt = conn.prepareStatement(sql); // Prepare the SQL statement

    // Set the parameters for the prepared statement using the Methods object
    stmt.setString(1, m.getId()); // Set the ID
    stmt.setString(2, m.getpName()); // Set the Patient Name
    stmt.setString(3, m.getAge()); // Set the Age
    stmt.setString(4, m.getGender()); // Set the Gender
    stmt.setString(5, m.getIdDoc()); // Set the Doctor ID
    stmt.setString(6, m.getdName()); // Set the Doctor Name
    stmt.setString(7, m.getStatus()); // Set the Status
    stmt.setString(8, m.getApp()); // Set the Appointment

    stmt.execute(); // Execute the SQL statement to insert the data

    // Display a success message
    JOptionPane.showMessageDialog(null, "PATIENT ID ADDED");

    clear(); // Clear the input fields after successful insertion
} catch (SQLException s) {
    // Handle SQL exceptions
    if (s.getErrorCode() == 1062) { // Check if the error code indicates a duplicate entry
        // Display an error message if the ID already exists in the database
        JOptionPane.showMessageDialog(null, "PATIENT ID IS ALREADY ADDED", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
} catch (Exception ex) {
    // Log and display any other exceptions
    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex); // Log the exception
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); // Display an error message
}

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
  // Retrieve values from input fields and dropdowns
String id = txtId.getText(); // Get the text from the ID input field
String idDoc = txtIDDOC.getText(); // Get the text from the Doctor ID input field
String pName = txtPatient.getText(); // Get the text from the Patient Name input field
String age = txtAge.getText(); // Get the text from the Age input field
String gender = txtGender.getText(); // Get the text from the Gender input field
String dName = txtDoc.getText(); // Get the text from the Doctor Name input field
String status = comboStats.getSelectedItem().toString(); // Get the selected item from the Status dropdown
String appointment = comboApp.getSelectedItem().toString(); // Get the selected item from the Appointment dropdown

// Declare database connection and prepared statement variables
Connection conn;
PreparedStatement stmt;

// Create a new instance of the Methods class with the retrieved values
Methods m = new Methods(id, pName, age, gender, idDoc, dName, status, appointment);

try {
    conn = DataBase.getConnection(); // Establish a connection to the database

    // SQL query to update the record in the tblhealth table where the ID matches
    String sql = "UPDATE tblhealth SET pName = ?, age = ?, gender = ?, idDoc = ?, docName = ?, status = ?, appointment = ? WHERE idNumber = ?";

    stmt = conn.prepareStatement(sql); // Prepare the SQL statement

    // Set the parameters for the prepared statement using the Methods object
    stmt.setString(1, m.getpName()); // Set the Patient Name
    stmt.setString(2, m.getAge()); // Set the Age
    stmt.setString(3, m.getGender()); // Set the Gender
    stmt.setString(4, m.getIdDoc()); // Set the Doctor ID
    stmt.setString(5, m.getdName()); // Set the Doctor Name
    stmt.setString(6, m.getStatus()); // Set the Status
    stmt.setString(7, m.getApp()); // Set the Appointment
    stmt.setString(8, m.getId()); // Set the ID (condition for the WHERE clause)

    int rowsAffected = stmt.executeUpdate(); // Execute the update query and get the number of rows affected

    // Check if the update was successful
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Instructor updated successfully!"); // Display success message
    } else {
        JOptionPane.showMessageDialog(null, "No instructor found with ID: " + id); // Display message if no record was found
    }

    clear(); // Clear the input fields after the operation
} catch (SQLException s) {
    // Log and display SQL-specific errors
    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, s); // Log the exception
    JOptionPane.showMessageDialog(null, "Error: " + s.getMessage()); // Show error message
} catch (Exception ex) {
    // Log and display any other exceptions
    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex); // Log the exception
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); // Show error message
}


                        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
      loadTableData();
      setupLiveSearch();
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       // Get the selected row in the table
int row = table.getSelectedRow(); 

if (row >= 0) { // Check if a row is selected
    // Get the ID from the first column of the selected row
    String id = table.getValueAt(row, 0).toString();

    // Show a confirmation dialog to confirm deletion
    int confirm = JOptionPane.showConfirmDialog(
            null, // Parent component for the dialog
            "DELETE: " + id + "?", // Confirmation message
            "Delete Record", // Dialog title
            JOptionPane.YES_NO_OPTION // Yes/No button options
    );

    if (confirm == JOptionPane.YES_OPTION) { // Check if the user confirmed deletion
        deleteRecord(id); // Call the method to delete the record
    }
} else {
    // Show a message if no row is selected
    JOptionPane.showMessageDialog(null, "Please select a record to delete.");
}
    }
// Method to delete a record from the database based on the provided ID
private void deleteRecord(String id) {
    Connection conn; // Variable for database connection
    PreparedStatement stmt; // Variable for the prepared SQL statement

    try {
        conn = DataBase.getConnection(); // Establish a connection to the database

        // SQL query to delete a record from the table based on the ID
        String sql = "DELETE FROM tblhealth WHERE idNumber = ?";
        stmt = conn.prepareStatement(sql); // Prepare the SQL statement
        stmt.setString(1, id); // Set the ID parameter for the query

        int rowsAffected = stmt.executeUpdate(); // Execute the query and get the number of rows affected

        // Check if the deletion was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Record deleted successfully!"); // Display success message
            loadTableData(); // Reload the table data to reflect changes
        } else {
            // Show a message if no record was found with the specified ID
            JOptionPane.showMessageDialog(null, "No record found with ID: " + id);
        }
    } catch (SQLException ex) {
        // Log and display SQL-specific errors
        Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex); // Log the exception
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); // Show error message
    }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtIDDOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDDOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDDOCActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboApp;
    private javax.swing.JComboBox<String> comboStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtIDDOC;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
