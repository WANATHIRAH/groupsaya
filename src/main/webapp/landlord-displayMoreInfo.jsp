<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/1/2022
  Time: 2:48 AM
  To change this template use File | Settings | File Templates.
--%>

<!--BOOTSTRAP JS-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="landlord-displayMoreInfo.css"%></style>
<head>
    <title>House More Info Page</title>
</head>
<body>

<%@include file="Menu.html"%>
<%
    String houseidJ= (String)request.getAttribute("hids");
    String housenameJ= (String)request.getAttribute("hnames");
    String housemonth= (String)request.getAttribute("hpaymonth");
    String houseadd= (String)request.getAttribute("haddress");
    String houseloc= (String)request.getAttribute("houseloc");
    Date d= (Date) request.getAttribute("hpdate");
    String available= (String)request.getAttribute("hava");
    String hnotenant= (String)request.getAttribute("hnoT");
    String hnoroom= (String)request.getAttribute("hnoR");
    String hnotoilet= (String)request.getAttribute("hnoToil");
    String hnoac= (String)request.getAttribute("hnoAC");
    String wifi= (String)request.getAttribute("hnoWifi");
    String furnish= (String)request.getAttribute("hnoFur");
    String washing= (String)request.getAttribute("hnoWM");
    String housedesc= (String)request.getAttribute("hdec");
    String housepic= (String)request.getAttribute("hpic");
    String landid= (String)request.getAttribute("landid");


%>
<div class="showgrid">
    <%
        if(housenameJ!="" && houseidJ!=""){
    %>
<div class="topic"><%=housenameJ%></div>
    <%
        }
    %>

    <form action="" method="post" id="theForm">
        <div>
            <input type="number" id="hid" name="hid" value="<%=houseidJ%>" hidden/>
            <input type="number" id="landid" name="landid" value="<%=landid%>" hidden/>
        </div>
     <div class="mybtn">
        <button formaction="#" type="submit" onclick="booking()">Booking</button>
        <button formaction="DisplayOldDetailsServlet" type="submit">Edit</button>
        <button formaction="DeleteHouseDetailsServlet" type="submit" onclick="delx()">Delete</button>
     </div>
    </form>


<div class="tintedbg2">
    <div class="k">
         <div class="colk">
             <div class="imagex">
                 <%-- display image by house-id and image array --%>
                     <div class="w3-content w3-display-container">
                         <%-- kene ada foreach klau nk display bnyk image nnti --%>
                         <img class="mySlides" src="images/<%=housepic%>" style="width:100%">

                         <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                         <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
                     </div>
             </div>
         </div>

        <div class="coll">
            <div class="overflow-auto">
                <div class="mytable">
                <table>
                    <tr>
                        <td colspan="2">Publish Date </td>
                        <td colspan="3"><%=d%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Address</td>
                        <td colspan="3"><%=houseadd%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Location</td>
                        <td colspan="3"><%=houseloc%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Price (per month) RM</td>
                        <td colspan="3"><%=housemonth%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Number of Tenant</td>
                        <td colspan="3"><%=hnotenant%></td>
                    </tr>
                    <tr>
                        <td colspan="2">House Availability</td>
                        <td colspan="3"><%=available%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Wifi Availability</td>
                        <td colspan="3"><%=wifi%></td>
                    </tr>
                    <tr>
                        <td><img src="pic/bed.png" height="18px" width="12px" class="center"></td>
                        <td><img src="pic/bath.png" height="18px" width="12px" class="center"></td>
                        <td><img src="pic/aircond.png" height="18px" width="12px" class="center"></td>
                        <td><img src="pic/wm.png" height="18px" width="12px" class="center"></td>
                        <td><img src="pic/sofa.png" height="18px" width="12px" class="center"></td>
                    </tr>
                    <tr>
                        <td text-align="center">Bedroom</td>
                        <td text-align="center">Bathroom</td>
                        <td text-align="center">Air Conditioner</td>
                        <td text-align="center">Washing Machine</td>
                        <td text-align="center">Furniture</td>
                    </tr>
                    <tr>
                        <td><%=hnoroom%></td>
                        <td><%=hnotoilet%></td>
                        <td><%=hnoac%></td>
                        <td><%=washing%></td>
                        <td><%=furnish%></td>
                    </tr>
                    <tr>
                        <td colspan="2">House Description</td>
                        <td colspan="3"><%=housedesc%></td>
                    </tr>
                </table>
                </div>
            </div>
        </div>
     </div>
</div>
<br>
</div>

<script>

   document.getElementById("delx").addEventListener("click", delx);

    function delx(){

        if (confirm("Are you sure you want to delete your house? Your action cannot be undone!") == true) {
          document.getElementById("theForm").submit();
        } else {
            return false;
        }
    }

    function booking(){
        location.href = "landlord-displayBookingList.jsp";
    }


   //for slideimage show
    var slideIndex = 1;
    showDivs(slideIndex);

    function plusDivs(n) {
        showDivs(slideIndex += n);
    }

    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = x.length
        }
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex - 1].style.display = "block";
    }
</script>

</body>
</html>
