package com.example.nonresident;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java. util. Date;
import java.lang.reflect.Field;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HouseDetailsServlet", value = "/HouseDetailsServlet")
public class HouseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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
        //String hPicture = request.getParameter("hPicture");
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


//            change string to image
//            Part part = request.getPart("hPic");
//            if(part !=null){
//                   Connection con = DB.getConnection();
//                    PreparedStatement ps = con.preparedStatement("insert into data (hPic) values (?)");
//                    InputStream IS = part.getInputStream();
//                    ps.setBlob(1, IS);
//                    result = ps.executeUpdate();
//                    if (result > 0) {
//                        response.sendRedirect("HouseListPage.jsp");
//                    } else {
//                        response.sendRedirect("HouseDetails.jsp? message=ERROR+OCCURED");
//                    }
//            }



            //setvalue in java method
            HouseDetails hs = new HouseDetails(1,hName,MonthlyPay,hAddress,PuDate,hAv,HnoTenant,HnoRoom,HnoToilet,HnoAC,HWifi,HnoFurniture,hWm,desc,hPicName,hAgreeName);
            hs.sethID(1);
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

