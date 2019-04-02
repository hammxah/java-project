# java-project

This project [Bus Ticket Reservation System] is developed as a semester project for the JAVA Programming course taught at The University of Lahore.


To run this project:
1. Download or clone this project

2. Copy the *Bus* folder from the project folder to your default *.netbeans-derby* folder

3. If you are not able to find your default *.netbeans-derby* folder then simply you can run these SQL queries to create database.
  Query1: CREATE TABLE ROUTES_TABLE (ID INTEGER NOT NULL, "NAME" VARCHAR(255), TRAVELLING_TO VARCHAR(255), TRAVELLING_FROM VARCHAR(255), TOTAL_SEATS INTEGER, "TIME" VARCHAR(6), SEATS_BOOKED VARCHAR(255), "DATE" VARCHAR(20), PRIMARY KEY (ID));<br>
  Query2: CREATE TABLE USER_TABLE (ID INTEGER NOT NULL, USERNAME VARCHAR(255), PASSWORD VARCHAR(255), PRIMARY KEY (ID));
  
4. If you have followed step 3 then you have to add users manually by going to <br>
   _Services -> Databases -> jdbc:derby://localhost:1527/Bus -> ROOT -> Tables -> USER_TABLE_
 
5. If you have followed step 2 then default credentials are: <br>
   Username: hamza<br>
   Password: hamza
