package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    JLabel labelname, labelfname, labeldob, labelaadhar, labelempid;
    JTextField tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfeducation;
    JButton add, back;
    String empid;

    UpdateEmployee(String empid) {

        this.empid = empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        add(labelfname);

        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(50, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(200, 200, 150, 30);
        add(labeldob);

        JLabel lblsalary = new JLabel("Salary:");
        lblsalary.setBounds(400, 200, 150, 30);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400, 250, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lbledu = new JLabel("Highest Education:");
        lbledu.setBounds(400, 300, 150, 30);
        lbledu.setFont(new Font("serif", Font.PLAIN, 19));
        add(lbledu);

        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        tfeducation.setBackground(Color.WHITE);
        add(tfeducation);

        JLabel lbldesignation = new JLabel("Designation:");
        lbldesignation.setBounds(50, 350, 150, 30);
        lbldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel lblaadhar = new JLabel("Aadhar Number:");
        lblaadhar.setBounds(400, 350, 150, 30);
        lblaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblaadhar);

        labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        add(labelaadhar);

        JLabel lblempid = new JLabel("Employee Id:");
        lblempid.setBounds(50, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);

        labelempid = new JLabel();
        labelempid.setBounds(200, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employee e WHERE e.empid = '" + empid + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labelempid.setText(rs.getString("empid"));
                labelaadhar.setText(rs.getString("aadhar"));
                labeldob.setText(rs.getString("dob"));
                tfeducation.setText(rs.getString("education"));
                tfaddress.setText(rs.getString("address"));
                tfdesignation.setText(rs.getString("designation"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tfsalary.setText(rs.getString("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String designation = tfdesignation.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String salary = tfsalary.getText();
            String education = tfeducation.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE employee SET salary = '" + salary + "', phone = '" + phone + "',email = '"
                        + email + "',education = '" + education + "',designation  = '" + designation
                        + "' WHERE empid = '" + empid + "'";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        // new UpdateEmployee();
    }
}
