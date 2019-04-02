/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticketing;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Yousaf
 */
public class BookingInterface {

    static int sId = 0;

    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button b10 = new Button("10");
    Button b11 = new Button("11");
    Button b12 = new Button("12");
    Button b13 = new Button("13");
    Button b14 = new Button("14");
    Button b15 = new Button("15");
    Button b16 = new Button("16");
    Button b17 = new Button("17");
    Button b18 = new Button("18");
    Button b19 = new Button("19");
    Button b20 = new Button("20");
    Button b21 = new Button("21");
    Button b22 = new Button("22");
    Button b23 = new Button("23");
    Button b24 = new Button("24");
    Button b25 = new Button("25");
    Button b26 = new Button("26");
    Button b27 = new Button("27");
    Button b28 = new Button("28");
    Button b29 = new Button("29");
    Button b30 = new Button("30");
    Button b31 = new Button("31");
    Button b32 = new Button("32");
    Button b33 = new Button("33");
    Button b34 = new Button("34");
    Button b35 = new Button("35");
    Button b36 = new Button("36");
    Button b37 = new Button("37");
    Button b38 = new Button("38");
    Button b39 = new Button("39");
    Button b40 = new Button("40");

    final String[] col = {"from", "to", "fare"};
    final String[][] row1 = {{"Lahore", "Islamabad", "1000"},
    {"Lahore", "Karachi", "4000"}, {"Lahore", "Peshawar", "1300"},
    {"Lahore", "Multan", "900"}, {"Lahore", "Murree", "1100"},
    {"Lahore", "Faisalabad", "500"}, {"Lahore", "Rawalpindi", "950"},
    {"Lahore", "Sialkot", "400"}, {"Lahore", "Sargodha", "430"}};

    //table
    JTable jTable = new JTable(row1, col);

    //buttons
    JButton btnLoadSeats = new JButton("Load Seats");
    JButton btnPrintTicket = new JButton("Print Ticket");
    JButton btnLogout = new JButton("Logout");

    //frame
    JFrame f2 = new JFrame("Booking Interface");

    //labels
    JLabel Fromlbl = new JLabel("From: ");
    JLabel Tolbl = new JLabel("To: ");
    JLabel Namelbl = new JLabel("Name: ");
    ImageIcon TOPimg = new ImageIcon("daewoointerface.PNG");
    JLabel topimg;
    TextField Tname = new TextField();
    JButton b;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    int id;
    Iterator it;

    private String[] cities = {"Islamabad", "Faisalabad", "Sialkot", "Gujranwala", "Karachi",
        "Murree", "Multan", "Rawalpindi", "Sargodha", "Peshawar"};
    private JComboBox CBoxFromCities = new JComboBox();
    private JComboBox CBoxToCities = new JComboBox(cities);
    private String[] Time = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "18:00", "20:00", "22:00"};
    private JComboBox CBoxTime = new JComboBox(Time);

    static ArrayList<Integer> list;
    ArrayList<Integer> seatsAlreadyBooked;

    public BookingInterface() {
        getStaticID();

        seatsAlreadyBooked = new ArrayList<>();

        showAllData(CBoxToCities.getSelectedItem(), CBoxTime.getSelectedItem());

        btnLoadSeats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllData(CBoxToCities.getSelectedItem(), CBoxTime.getSelectedItem());

            }
        });

        CBoxTime.setBounds(50, 200, 100, 20);
        f2.add(CBoxTime);

        list = new ArrayList<>();
        CBoxFromCities.addItem("Lahore");

        for (int i = 0; i < 8; i++) {
            ImageIcon image = new ImageIcon("programming.jpg");
            JButton button = new JButton(image);
        }

        f2.setSize(1200, 600);
        f2.setLayout(null);
        topimg = new JLabel(TOPimg);

        jTable.setBounds(700, 10, 450, 450);
        topimg.setBounds(0, 0, 682, 75);
        CBoxFromCities.setBounds(50, 150, 100, 20);
        CBoxToCities.setBounds(200, 150, 100, 20);
        Fromlbl.setBounds(50, 130, 100, 10);
        Tolbl.setBounds(200, 130, 100, 10);
        Namelbl.setBounds(340, 130, 100, 20);
        Tname.setBounds(340, 150, 150, 22);
        btnLogout.setBounds(530, 100, 110, 30);
        btnLoadSeats.setBounds(530, 150, 110, 30);
        btnPrintTicket.setBounds(530, 200, 110, 30);

        f2.add(btnPrintTicket);
        f2.add(Namelbl);
        f2.add(topimg);
        f2.add(Fromlbl);
        f2.add(Tolbl);
        f2.add(CBoxFromCities);
        f2.add(CBoxToCities);
        f2.add(btnLoadSeats);
        f2.add(btnLogout);
        f2.add(Tname);
        f2.add(jTable);

        f2.setVisible(true);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
                java.awt.Window win[] = java.awt.Window.getWindows();
                for (int i = 0; i < win.length; i++) {
                    win[i].dispose();
                }
                new BusTicketing();
            }
        });

        btnPrintTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate localDate = LocalDate.now();
                String date = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
                System.out.println(date);
                int fare = 0;
                for (int i = 0; i < row1.length; i++) {
                    if (row1[i][1] == CBoxToCities.getSelectedItem().toString()) {
                        fare = Integer.parseInt(row1[i][2]);
                        System.out.println(row1[i][2]);
                    }
                }
                String name = Tname.getText().toString();
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter customer name.");
                } else {
                    if (list.size() > 0) {
                        new print(list, id++, name, CBoxToCities.getSelectedItem().toString(),
                                CBoxTime.getSelectedItem().toString(), date, fare);
                    } else if (list.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Please Select Seats");

                    }
                }

            }
        });

        b1.setBounds(50, 250, 50, 50);
        f2.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(1);
                b2.setBackground(Color.red);
            }
        });

        b2.setBounds(50, 310, 50, 50);
        f2.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(2);
                b2.setBackground(Color.red);
            }
        });

        b3.setBounds(50, 410, 50, 50);
        f2.add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(3);
                b3.setBackground(Color.red);
            }
        });

        b4.setBounds(50, 470, 50, 50);
        f2.add(b4);
        b4.setVisible(true);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(4);
                b4.setBackground(Color.red);
            }
        });

        b5.setBounds(110, 250, 50, 50);
        f2.add(b5);
        b5.setVisible(true);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(5);
                b5.setBackground(Color.red);
            }
        });

        b6.setBounds(110, 310, 50, 50);
        f2.add(b6);
        b6.setVisible(true);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(6);
                b6.setBackground(Color.red);
            }
        });

        b7.setBounds(110, 410, 50, 50);
        f2.add(b7);
        b7.setVisible(true);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(7);
                b7.setBackground(Color.red);
            }
        });

        b8.setBounds(110, 470, 50, 50);
        f2.add(b8);
        b8.setVisible(true);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(8);
                b8.setBackground(Color.red);
            }
        });

        b9.setBounds(170, 250, 50, 50);
        f2.add(b9);
        b9.setVisible(true);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(9);
                b9.setBackground(Color.red);
            }
        });

        b10.setBounds(170, 310, 50, 50);
        f2.add(b10);
        b10.setVisible(true);
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(10);
                b10.setBackground(Color.red);
            }
        });

        b11.setBounds(170, 410, 50, 50);
        f2.add(b11);
        b11.setVisible(true);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(11);
                b11.setBackground(Color.red);
            }
        });

        b12.setBounds(170, 470, 50, 50);
        f2.add(b12);
        b12.setVisible(true);
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(12);
                b12.setBackground(Color.red);
            }
        });

        b13.setBounds(230, 250, 50, 50);
        f2.add(b13);
        b13.setVisible(true);
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(13);
                b13.setBackground(Color.red);
            }
        });

        b14.setBounds(230, 310, 50, 50);
        f2.add(b14);
        b14.setVisible(true);
        b14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(14);
                b14.setBackground(Color.red);
            }
        });

        b15.setBounds(230, 410, 50, 50);
        f2.add(b15);
        b15.setVisible(true);
        b15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(15);
                b15.setBackground(Color.red);
            }
        });

        b16.setBounds(230, 470, 50, 50);
        f2.add(b16);
        b16.setVisible(true);
        b16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(16);
                b16.setBackground(Color.red);
            }
        });

        b17.setBounds(290, 250, 50, 50);
        f2.add(b17);
        b17.setVisible(true);
        b17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(17);
                b17.setBackground(Color.red);
            }
        });

        b18.setBounds(290, 310, 50, 50);
        f2.add(b18);
        b18.setVisible(true);
        b18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(18);
                b18.setBackground(Color.red);
            }
        });

        b19.setBounds(290, 410, 50, 50);
        f2.add(b19);
        b19.setVisible(true);
        b19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(19);
                b19.setBackground(Color.red);
            }
        });

        b20.setBounds(290, 470, 50, 50);
        f2.add(b20);
        b20.setVisible(true);
        b20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(20);
                b20.setBackground(Color.red);
            }
        });

        b21.setBounds(350, 250, 50, 50);
        f2.add(b21);
        b21.setVisible(true);
        b21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(21);
                b21.setBackground(Color.red);
            }
        });

        b22.setBounds(350, 310, 50, 50);
        f2.add(b22);
        b22.setVisible(true);
        b22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(22);
                b22.setBackground(Color.red);
            }
        });

        b23.setBounds(350, 410, 50, 50);
        f2.add(b23);
        b23.setVisible(true);
        b23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(23);
                b23.setBackground(Color.red);
            }
        });

        b24.setBounds(350, 470, 50, 50);
        f2.add(b24);
        b24.setVisible(true);
        b24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(24);
                b24.setBackground(Color.red);
            }
        });

        b25.setBounds(410, 250, 50, 50);
        f2.add(b25);
        b25.setVisible(true);
        b25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(25);
                b25.setBackground(Color.red);
            }
        });

        b26.setBounds(410, 310, 50, 50);
        f2.add(b26);
        b26.setVisible(true);
        b26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(26);
                b26.setBackground(Color.red);
            }
        });

        b27.setBounds(410, 410, 50, 50);
        f2.add(b27);
        b27.setVisible(true);
        b27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(27);
                b27.setBackground(Color.red);
            }
        });

        b28.setBounds(410, 470, 50, 50);
        f2.add(b28);
        b28.setVisible(true);
        b28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(28);
                b28.setBackground(Color.red);
            }
        });

        b29.setBounds(470, 250, 50, 50);
        f2.add(b29);
        b29.setVisible(true);
        b29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(29);
                b29.setBackground(Color.red);
            }
        });

        b30.setBounds(470, 310, 50, 50);
        f2.add(b30);
        b30.setVisible(true);
        b30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(30);
                b30.setBackground(Color.red);
            }
        });

        b31.setBounds(470, 410, 50, 50);
        f2.add(b31);
        b31.setVisible(true);
        b31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(31);
                b31.setBackground(Color.red);
            }
        });

        b32.setBounds(470, 470, 50, 50);
        f2.add(b32);
        b32.setVisible(true);
        b32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(32);
                b32.setBackground(Color.red);
            }
        });

        b33.setBounds(530, 250, 50, 50);
        f2.add(b33);
        b33.setVisible(true);
        b33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(33);
                b33.setBackground(Color.red);
            }
        });

        b34.setBounds(530, 310, 50, 50);
        f2.add(b34);
        b34.setVisible(true);
        b34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(34);
                b34.setBackground(Color.red);
            }
        });

        b35.setBounds(530, 410, 50, 50);
        f2.add(b35);
        b35.setVisible(true);
        b35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(35);
                b35.setBackground(Color.red);
            }
        });

        b36.setBounds(530, 470, 50, 50);
        f2.add(b36);
        b36.setVisible(true);
        b36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(36);
                b36.setBackground(Color.red);
            }
        });

        b37.setBounds(590, 250, 50, 60);
        f2.add(b37);
        b37.setVisible(true);
        b37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(37);
                b37.setBackground(Color.red);
            }
        });

        b38.setBounds(590, 320, 50, 60);
        f2.add(b38);
        b38.setVisible(true);
        b38.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(38);
                b38.setBackground(Color.red);
            }
        });

        b39.setBounds(590, 390, 50, 60);
        f2.add(b39);
        b39.setVisible(true);
        b39.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(39);
                b39.setBackground(Color.red);
            }
        });

        b40.setBounds(590, 460, 50, 60);
        f2.add(b40);
        b40.setVisible(true);
        b40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(40);
                b40.setBackground(Color.red);
            }
        });

    }

    void setBackgroundToNull() {
        b1.setBackground(null);
        b2.setBackground(null);
        b3.setBackground(null);
        b4.setBackground(null);
        b5.setBackground(null);
        b6.setBackground(null);
        b7.setBackground(null);
        b8.setBackground(null);
        b9.setBackground(null);
        b10.setBackground(null);
        b11.setBackground(null);
        b12.setBackground(null);
        b13.setBackground(null);
        b14.setBackground(null);
        b15.setBackground(null);
        b16.setBackground(null);
        b17.setBackground(null);
        b18.setBackground(null);
        b19.setBackground(null);
        b20.setBackground(null);
        b21.setBackground(null);
        b22.setBackground(null);
        b23.setBackground(null);
        b24.setBackground(null);
        b25.setBackground(null);
        b26.setBackground(null);
        b27.setBackground(null);
        b28.setBackground(null);
        b29.setBackground(null);
        b30.setBackground(null);
        b31.setBackground(null);
        b32.setBackground(null);
        b33.setBackground(null);
        b34.setBackground(null);
        b35.setBackground(null);
        b36.setBackground(null);
        b37.setBackground(null);
        b38.setBackground(null);
        b39.setBackground(null);
        b40.setBackground(null);
    }

    private void showAllData(Object city, Object time) {
        setBackgroundToNull();

        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bus", "root", "root");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select seats_booked,name from ROOT.routes_table where travelling_to='" + city + "' and time='" + time + "'");
            String name;
            int seat;
            while (resultSet.next()) {
                name = resultSet.getString(2);

                StringTokenizer st = new StringTokenizer(resultSet.getString(1));
                while (st.hasMoreElements()) {
                    seat = Integer.parseInt(st.nextToken());
                    seatsAlreadyBooked.add(seat);
                    String btn = "b" + seat;

                    switch (btn) {
                        case "b1":
                            b1.setBackground(Color.red);
                            break;
                        case "b2":
                            b2.setBackground(Color.red);
                            break;
                        case "b3":
                            b3.setBackground(Color.red);
                            break;
                        case "b4":
                            b4.setBackground(Color.red);
                            break;
                        case "b5":
                            b5.setBackground(Color.red);
                            break;
                        case "b6":
                            b6.setBackground(Color.red);
                            break;
                        case "b7":
                            b7.setBackground(Color.red);
                            break;
                        case "b8":
                            b8.setBackground(Color.red);
                            break;
                        case "b9":
                            b9.setBackground(Color.red);
                            break;
                        case "b10":
                            b10.setBackground(Color.red);
                            break;
                        case "b11":
                            b11.setBackground(Color.red);
                            break;
                        case "b12":
                            b12.setBackground(Color.red);
                            break;
                        case "b13":
                            b13.setBackground(Color.red);
                            break;
                        case "b14":
                            b14.setBackground(Color.red);
                            break;
                        case "b15":
                            b15.setBackground(Color.red);
                            break;
                        case "b16":
                            b16.setBackground(Color.red);
                            break;
                        case "b17":
                            b17.setBackground(Color.red);
                            break;
                        case "b18":
                            b18.setBackground(Color.red);
                            break;
                        case "b19":
                            b19.setBackground(Color.red);
                            break;
                        case "b20":
                            b20.setBackground(Color.red);
                            break;
                        case "b21":
                            b21.setBackground(Color.red);
                            break;
                        case "b22":
                            b22.setBackground(Color.red);
                            break;
                        case "b23":
                            b23.setBackground(Color.red);
                            break;
                        case "b24":
                            b24.setBackground(Color.red);
                            break;
                        case "b25":
                            b25.setBackground(Color.red);
                            break;
                        case "b26":
                            b26.setBackground(Color.red);
                            break;
                        case "b27":
                            b27.setBackground(Color.red);
                            break;
                        case "b28":
                            b28.setBackground(Color.red);
                            break;
                        case "b29":
                            b29.setBackground(Color.red);
                            break;
                        case "b30":
                            b30.setBackground(Color.red);
                            break;
                        case "b31":
                            b31.setBackground(Color.red);
                            break;
                        case "b32":
                            b32.setBackground(Color.red);
                            break;
                        case "b33":
                            b33.setBackground(Color.red);
                            break;
                        case "b34":
                            b34.setBackground(Color.red);
                            break;
                        case "b35":
                            b35.setBackground(Color.red);
                            break;
                        case "b36":
                            b36.setBackground(Color.red);
                            break;
                        case "b37":
                            b37.setBackground(Color.red);
                            break;
                        case "b38":
                            b38.setBackground(Color.red);
                            break;
                        case "b39":
                            b39.setBackground(Color.red);
                            break;
                        case "b40":
                            b40.setBackground(Color.red);
                            break;
                        default:
                            break;
                    }
                }

                System.out.println("Seats booked by " + name + " are: ");
                it = seatsAlreadyBooked.iterator();
                while (it.hasNext()) {
                    System.out.print(it.next() + " ");
                }
                System.out.println("");

                seatsAlreadyBooked.removeAll(seatsAlreadyBooked);

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    int getStaticID() {
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bus", "root", "root");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from ROOT.routes_table");

            while (resultSet.next()) {
                sId++;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            id = sId;

        }

        return id;
    }

}
