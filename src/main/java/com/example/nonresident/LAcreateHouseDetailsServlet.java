package com.example.nonresident;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java. util. Date;
import java.lang.reflect.Field;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "landlord-createHouseDetailsServlet", value = "/landlord-createHouseDetailsServlet")
public class LAcreateHouseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            connectDB(out);
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void connectDB(PrintWriter out) throws
            ClassNotFoundException
    {

            try{
                Class.forName("org.postgresql.Driver");
                String dbURL = "jdbc:postgresql://ec2-44-194-101-60.compute-1.amazonaws.com:5432/d2us57cbf117bh";
                String userName = "rnscsqosqdtcmz";
                String password = "0b201fb2e59025b780ce0b4148e508b6747fbaf77f6e8cedc675ee4dbc44638a";
                Connection con = DriverManager.getConnection(dbURL, userName, password);
                String sql = "select * from landlord";

                if (con != null)
                {
                    Statement statement = con.createStatement();
                    ResultSet res = statement.executeQuery(sql);

                    while (res.next())
                    {
                        out.println("<h1>" + " Username name: " +
                                res.getString("landlordusername") + "</h1>");
                        out.println("<h1>" + "Landlord password : " +
                                res.getString("landlordpassword") + "</h1>");
                        out.println("<h1>" + "Landlord name : " +
                                res.getString("landlordname") + "</h1>");
                        out.println("<h1>" + "Landlord name : " +
                        res.getString("landlordemail") + "</h1>");
                        out.println("<h1>" + "Landlord name : " +
                        res.getString("landlordage") + "</h1>");
                        out.println("<h1>" + "Landlord name : " +
                        res.getString("landlordphoneno") + "</h1>");
                        out.println("<h1>" + "Landlord name : " +
                                res.getString("landlordgender") + "</h1>");
                    }
                }
            }catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("Error in connecting postgreSQL");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hName    = request.getParameter("hName");
        String hMP     = request.getParameter("hMP");
        String hAddress = request.getParameter("hAddress");
        String hPublishDate = request.getParameter ("hPublishDate");
        String hAvailability = request.getParameter("hAvailability");
        String hNoTenants = request.getParameter("hNoTenants");
        String hNoRoom = request.getParameter("hNoRoom");
        String hNoToilet = request.getParameter("hNoToilet");
        String hNoAC = request.getParameter("hNoAC");
        String hWifi = request.getParameter("hWifi");
        String hFurniture = request.getParameter("hFurniture");
        String hWM = request.getParameter("hWM");
        String desc = request.getParameter("desc");
        String hPicture = request.getParameter("hPicture");
        String hPicName = request.getParameter("hPicName");
        String hAgreeName = request.getParameter("hAgreeName");


        //convert string to other data type
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Double MonthlyPay = Double.parseDouble("hMP");
            Date PuDate = sdf.parse("hPublishDate");
            Boolean hAv = Boolean.parseBoolean("hAvailability");
            Boolean HWifi = Boolean.parseBoolean("hWifi");
            Integer hWm = Integer.parseInt("hWM");
            Integer HnoTenant = Integer.parseInt("hNoTenants");
            Integer HnoRoom = Integer.parseInt("hNoRoom");
            Integer HnoToilet = Integer.parseInt("hNoToilet");
            Integer HnoAC = Integer.parseInt("hNoAC");
            Integer HnoFurniture = Integer.parseInt("hFurniture");





            //setvalue in java method
            HouseDetails hs = new HouseDetails();
            hs.sethName(hName);
            hs.sethAddress(hAddress);
            hs.sethMP(MonthlyPay);
            hs.sethAvailability(hAv);
            hs.sethWifi(HWifi);
            hs.sethNoTenants(HnoTenant);
            hs.sethNoRoom(HnoRoom);
            hs.sethNoToilet(HnoToilet);
            hs.sethNoAC(HnoAC);
            hs.sethWM(hWm);
            hs.sethFurniture(HnoFurniture);
            //hs.sethPicture(hPicture);
            hs.sethPicName(hPicName);
            hs.sethAgreeName(hAgreeName);



        } catch (ParseException e) {
            e.printStackTrace();
        }
        //convert date to string //out.println(sdf.format(startDate));


     }
    }

