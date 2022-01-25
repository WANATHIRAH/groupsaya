package com.example.nonresident;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "InsertDetailsServlet", value = "/InsertDetailsServlet")
public class InsertDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//yg dalam doget ni x de kaitan ni just cara nk buat sesssion
//
//        HttpSession session = request.getSession(); // if nk wujudkan session mcm sir buat
//
//        // tarik value dri form dalam jsp lalu kot javascript bawah tu
//        String sdIDV = (String) session.getAttribute("sdid");
//        String sdhMPV = (String) session.getAttribute("sdName");
//        String SdEmailV = (String) session.getAttribute("sdEmail");
//        String PhoneNumV = (String) session.getAttribute("sdPnum");
//
//        //masukkan value ke dlm java class StudentDetails
//        StudentDetails sd = new StudentDetails(sdIDV, sdhMPV, SdEmailV, PhoneNumV);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
          //  dlm parameter ni pastikan nama sama dalam form jsp name=""
        String sdID1   = request.getParameter("stuid");
        String sdhMP   = request.getParameter("stuname");
        String SdEmail = request.getParameter("email");
        String PhoneNum = request.getParameter ("phonenum");


            //nk testing keluar masuk data pastikan xampp, heroku , database connected

        Class.forName("org.postgresql.Driver"); // ni stay
        String dbURL = "jdbc:postgresql://ec2-44-194-101-60.compute-1.amazonaws.com:5432/d2us57cbf117bh"; //ni url dri url dalam data source
        String user = "rnscsqosqdtcmz"; //ni user dri heroku database
        String pass = "0b201fb2e59025b780ce0b4148e508b6747fbaf77f6e8cedc675ee4dbc44638a"; //ni password dri heroku database
        Connection conn = DriverManager.getConnection(dbURL, user, pass);
            // klau buat postgress atas2 ni amik yg details dri heroku

            PreparedStatement st;
            String query="insert into studentdetails(studid,stuname,email,phonenum) values(?,?,?,?)";
            st = conn.prepareStatement(query);
            st.setString(1,sdID1);
            st.setString(2,sdhMP);
            st.setString(3,SdEmail);
            st.setString(4,PhoneNum);
            int row= st.executeUpdate();//return no of row effected

            if(row>0){
                out.println("Record inserted");
            }else{
                out.println("Record failed");
            }

        }catch(Exception e){
            out.println(e);
        }

    }
}
