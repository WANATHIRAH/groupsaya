package com.example.nonresident;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "AddImagesServlet", value = "/AddImagesServlet")
public class AddImagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // obtains the upload file part in this multipart request

        Part f=request.getPart("hPic");
        String imageFileName=f.getSubmittedFileName();
        File file = new File("C:/Users/Public/LAB EXERCISE/nonresident/src/images/" + imageFileName);
        System.out.println("my file need upload" + file);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = f.getInputStream();

            byte[] data=new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        try{

            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-44-194-101-60.compute-1.amazonaws.com:5432/d2us57cbf117bh";
            String user = "rnscsqosqdtcmz";
            String pass = "0b201fb2e59025b780ce0b4148e508b6747fbaf77f6e8cedc675ee4dbc44638a";
            Connection conn = DriverManager.getConnection(dbURL, user, pass);

            PreparedStatement st;
            String query="insert into housepic(housepicname) values(?)";
            st = conn.prepareStatement(query);
            st.setString(1,imageFileName);
            int row= st.executeUpdate();//return no of row effected


            if(row>0){
                out.println("Record inserted");
            }else{
                out.println("Record failed");
            }



        }catch(Exception e){
            out.println(e);
        }

        //connection database
   }
}
