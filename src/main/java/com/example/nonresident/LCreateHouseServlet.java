package com.example.nonresident;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@MultipartConfig
@WebServlet(name = "LCreateHouseServlet", value = "/LCreateHouseServlet")
public class LCreateHouseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        try{
//            HttpSession session = request.getSession();
//
//
//            String sdIDV = (String) session.getAttribute("sdid");
//            String sdhMPV = (String) session.getAttribute("sdName");
//            String SdEmailV = (String) session.getAttribute("sdEmail");
//            String PhoneNumV = (String) session.getAttribute("sdPnum");
//
//            StudentDetails sd = new StudentDetails(sdIDV,sdhMPV,SdEmailV,PhoneNumV);
//            sd.getStudid();
//            sd.getStuname();
//            sd.getEmail();
//            sd.getPhonenum();
//
//
//            out.println("</body></html>");
//        }catch(Exception e){
//            out.println(e);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //picture upload
        Part f=request.getPart("hPic");
        String imageFileName=f.getSubmittedFileName();
        File file = new File("C:/Users/Public/LAB EXERCISE/nonresident/src/images/" + imageFileName);
        System.out.println("my file need upload" + file);

        //agree file upload
        Part agree =request.getPart("hAgree");
        String agreeFileName=agree.getSubmittedFileName();
        File file2 = new File("C:/Users/Public/LAB EXERCISE/nonresident/src/images/" + agreeFileName);
        System.out.println("my file need upload" + file2);

       try{

           String hName    = request.getParameter("hName");
           Double hMP     = Double.parseDouble(request.getParameter("Pricepm"));
           String hAddress = request.getParameter("hAddress");
           boolean hAvailability= Boolean.parseBoolean(request.getParameter("hAvailability"));
           int hNoTenants = Integer.parseInt( request.getParameter("NumOfTenant"));
           int hNoRoom = Integer.parseInt(request.getParameter("NumOfRooms"));
           int hNoToilet = Integer.parseInt(request.getParameter("NumOfToilet"));
           int hNoAC = Integer.parseInt(request.getParameter("NumOfAC"));
           boolean hWifi = Boolean.parseBoolean(request.getParameter("hWifi"));
           int hFurniture = Integer.parseInt(request.getParameter("NumOfSofa"));
           int hWM = Integer.parseInt(request.getParameter("NumOfWM"));
           String desc = request.getParameter("Desc");


           try {

               //for picture
               FileOutputStream fos = new FileOutputStream(file);
               InputStream is = f.getInputStream();

               byte[] data=new byte[is.available()];
               is.read(data);
               fos.write(data);
               fos.close();

               //for agreement file
               FileOutputStream fos2 = new FileOutputStream(file2);
               InputStream is2 = f.getInputStream();

               byte[] data2 =new byte[is.available()];
               is2.read(data2);
               fos2.write(data2);
               fos2.close();


           }catch (Exception e){
               e.printStackTrace();
           }


           try {
           Class.forName("org.postgresql.Driver");
           String dbURL = "jdbc:postgresql://ec2-44-194-101-60.compute-1.amazonaws.com:5432/d2us57cbf117bh";
           String user = "rnscsqosqdtcmz";
           String pass = "0b201fb2e59025b780ce0b4148e508b6747fbaf77f6e8cedc675ee4dbc44638a";
           Connection conn = DriverManager.getConnection(dbURL, user, pass);

           PreparedStatement st;
           String query="insert into housedetails(housename,housemonthlyprice,houseaddress,housepublishdate,houseavailability,housenotenants,housenoroom,housenotoilet,housenoac,housewifi,housefurniture,housewm,housedescription,housepicname,houseagreement,landlordid) values(?,?,?,TO_DATE('23-JAN-2022', 'DD-MON-YYYY'),?,?,?,?,?,?,?,?,?,?,1)";
           st = conn.prepareStatement(query);
               st.setString(1,hName);
               st.setDouble(2,hMP);
               st.setString(3,hAddress);
               st.setBoolean(4,hAvailability);
               st.setInt(5,hNoTenants);
               st.setInt(6,hNoRoom);
               st.setInt(7,hNoToilet);
               st.setInt(8,hNoAC);
               st.setBoolean(9,hWifi);
               st.setInt(10,hFurniture);
               st.setInt(11,hWM);
               st.setString(12,desc);
               st.setString(13,agreeFileName);


               int row= st.executeUpdate();//return no of row effected


               if(row>0){
                   out.println("Record inserted");
               }else{
                   out.println("Record failed");
               }


//           PreparedStatement st2;
//           String query2="insert into housePic(housePicName,landlordid) values(?,?)";
//           st2 = conn.prepareStatement(query2);
//           st2.setString(1,imageFileName);
//           st2.setInt(2,hid);
//
//               int row2= st2.executeUpdate();//return no of row effected
//
//
//               if(row2>0){
//                   out.println("Record inserted");
//               }else{
//                   out.println("Record failed");
//               }

//           PreparedStatement st3;
//           String query3="insert into houseAgree(houseAgreeName,landlordid) values(?,?)";
//           st3 = conn.prepareStatement(query3);
//           st3.setString(1,agreeFileName);
//           st3.setInt(2,hid);
//
//
//           int row3= st3.executeUpdate();//return no of row effected
//
//
//           if(row3>0){
//               out.println("Record inserted");
//           }else{
//               out.println("Record failed");
//           }
           }catch (Exception e){
               e.printStackTrace();
           }



       }catch (Exception e){
           System.out.println(e);
       }
    }
}
