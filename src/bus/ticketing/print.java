package bus.ticketing;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Yousaf
 */
public class print {

    int id, total_seats, fare, total;
    String name, travelling_to, travelling_from, time, seats_booked, date;
    String bookedSeats = "";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    JFrame printFrame = new JFrame("Print Ticket");

    ImageIcon TOPimg = new ImageIcon("daewoointerface.PNG");
    JLabel Seriallbl = new JLabel("Serial No.");
    JLabel Datelbl = new JLabel("Date ");
    JLabel Farelbl = new JLabel("Fare ");
    JLabel Namelbl = new JLabel("Name ");
    JLabel Routelbl = new JLabel("Route ");
    JLabel Timelbl = new JLabel("Time ");
    JLabel Seatlbl = new JLabel("Seat ");
    JLabel topimg;

    JLabel SerialTF;
    JLabel DateTF;
    JLabel FareTF;
    JLabel NameTF;
    JLabel RouteTF;
    JLabel TimeTF;
    JLabel SeatTF;

    JLabel CautionsTA = new JLabel("<html><strong>TERMS & CONDITIONS:</strong></br>"
            + "Company will not be responsible for </br>"
            + "late departure or arrival due to road</br> "
            + "construction / traffic congestion </br> "
            + "/ accident / tragic incident or any </br>"
            + " improper weather condition.</html>");

    public print(ArrayList<Integer> list, int id, String name, String travelling_to, String time, String date, int fare) {

        this.id = id;
        this.name = name;
        this.travelling_to = travelling_to;
        this.time = time;
        this.travelling_from = "Lahore";
        this.total_seats = list.size();
        this.date = date;
        this.fare = fare;
        total = this.fare * total_seats;
        System.out.println("Date is: " + date);

        printFrame.setSize(500, 380);
        printFrame.setLayout(null);
        topimg = new JLabel(TOPimg);

        Collections.sort(list);
        list = removeDuplicates(list);
        Iterator iterator = list.iterator();

        System.out.println("Booked seats are: ");
        while (iterator.hasNext()) {
            bookedSeats = bookedSeats + String.valueOf(iterator.next()) + " ";
        }
        this.seats_booked = bookedSeats;

        System.out.println(bookedSeats);
        System.out.println("");

        list.removeAll(list);

        insertDataIntoTable();

        SerialTF = new JLabel("100000");
        DateTF = new JLabel(this.date);
        FareTF = new JLabel(String.valueOf(total));
        NameTF = new JLabel(this.name);
        RouteTF = new JLabel(this.travelling_to);
        TimeTF = new JLabel(this.time);
        SeatTF = new JLabel(seats_booked);

        topimg.setBounds(0, 0, 480, 75);

        Seriallbl.setBounds(20, 100, 100, 15);
        Datelbl.setBounds(350, 100, 100, 15);
        Farelbl.setBounds(20, 150, 100, 15);
        Namelbl.setBounds(20, 200, 100, 15);
        Routelbl.setBounds(20, 250, 100, 15);
        Timelbl.setBounds(250, 250, 80, 15);
        Seatlbl.setBounds(350, 250, 80, 15);

        CautionsTA.setBounds(140, 50, 200, 150);

        SerialTF.setBounds(20, 120, 100, 20);
        NameTF.setBounds(20, 220, 410, 20);
        FareTF.setBounds(20, 170, 100, 20);
        DateTF.setBounds(350, 120, 80, 20);
        RouteTF.setBounds(20, 270, 200, 20);
        TimeTF.setBounds(250, 270, 80, 20);
        SeatTF.setBounds(350, 270, 80, 20);

        printFrame.add(topimg);

        printFrame.add(SerialTF);
        printFrame.add(DateTF);
        printFrame.add(NameTF);
        printFrame.add(FareTF);
        printFrame.add(RouteTF);
        printFrame.add(TimeTF);
        printFrame.add(SeatTF);

        printFrame.add(Seriallbl);
        printFrame.add(Namelbl);
        printFrame.add(Datelbl);
        printFrame.add(Routelbl);
        printFrame.add(Timelbl);
        printFrame.add(Seatlbl);
        printFrame.add(Farelbl);

        printFrame.add(CautionsTA);

        printFrame.setVisible(true);

    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set 
        set.addAll(list);

        // Clear the list 
        list.clear();

        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set);

        // return the list 
        return list;
    }

    void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bus", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertDataIntoTable() {
        try {
            createConnection();
            statement.execute("insert into ROOT.routes_table (id, name, travelling_to, travelling_from, total_seats, time, seats_booked, date) values ("
                    + this.id + ", '" + this.name + "', '" + this.travelling_to + "', '" + this.travelling_from + "', " + this.total_seats + ", '" + this.time + "', '"
                    + this.seats_booked + "', '" + this.date + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
