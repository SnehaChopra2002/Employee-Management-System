package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadhar;
    JButton add, back;
    JComboBox<String> cbeducation;
    JDateChooser dcdob;
    JLabel labelempid;

    AddEmployee() {

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

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lbldob = new JLabel("Date of Birth:");
        lbldob.setBounds(50, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

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

        String[] courses = { "BBA", "BCA", "BA", "B.COM", "B.TECH", "MBA", "MCA", "MA", "MTECH" };
        cbeducation = new JComboBox<String>(courses);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

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

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblempid = new JLabel("Employee Id:");
        lblempid.setBounds(50, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);

        labelempid = new JLabel("" + number);
        labelempid.setBounds(200, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

        add = new JButton("Add Details");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String address = tfaddress.getText();
            String aadhar = tfaadhar.getText();
            String designation = tfdesignation.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String salary = tfsalary.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String education = (String) (cbeducation.getSelectedItem());
            String empid = labelempid.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO employee VALUES('" + name + "','" + fname + "','" + dob + "','" + salary
                        + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation
                        + "','" + aadhar + "','" + empid + "')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
