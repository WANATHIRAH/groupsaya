package com.example.nonresident;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "DeleteHouseDetailsServlet", value = "/DeleteHouseDetailsServlet")
public class DeleteHouseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int hids = Integer.parseInt(request.getParameter("hid"));
        //int landid = Integer.parseInt(request.getParameter("landid"));

        try{

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-44-194-101-60.compute-1.amazonaws.com:5432/d2us57cbf117bh"; //ni url dri heroku database
            String user = "rnscsqosqdtcmz"; //ni user dri heroku database
            String pass = "0b201fb2e59025b780ce0b4148e508b6747fbaf77f6e8cedc675ee4dbc44638a"; //ni password dri heroku database
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            PreparedStatement pst = conn.prepareStatement("DELETE FROM housedetails WHERE houseid = ?");
            pst.setInt(1,hids);
            //pst.setInt(1,landid);

           pst.executeUpdate();


        }catch(Exception e){
            System.out.println(e);
        }

        response.sendRedirect("landlord-displayHouseList.jsp");
    }
}
