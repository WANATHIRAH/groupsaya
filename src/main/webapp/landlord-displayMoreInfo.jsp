<%--
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

<div class="showgrid">
<div class="topic">RUMAH BANGLO TAMAN PERMAI INDAH</div>

<div class="mybtn">
    <button onclick="booking()">Booking</button>
    <button onclick="edit()">Edit</button>
    <button onclick="delx()">Delete</button>
</div>


<div class="tintedbg2">
    <div class="k">
         <div class="colk">
             <div class="imagex">
                 <%-- display image by house-id and image array --%>
                     <div class="w3-content w3-display-container">
                         <img class="mySlides" src="pic/k1.jpg" style="width:100%">
                         <img class="mySlides" src="pic/k2.jpg" style="width:100%">
                         <img class="mySlides" src="pic/k3.jpg" style="width:100%">

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
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">Address</td>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">Price (per month) RM</td>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">Number of Tenant</td>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">House Availability</td>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">Wifi Availability</td>
                        <td colspan="3">&nbsp;</td>
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
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">House Description</td>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">Tenancy Agreement</td>
                        <td colspan="3">&nbsp;</td>
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

    function delx(){
        confirm("Are you sure you want to delete your house? Your action cannot be undone!");
        //its booking history will be keep in database, only house will be delete
    }

    function booking(){
        location.href = "landlord-displayBookingList.jsp";
    }

    function edit(){
        location.href = "landlord-updateHouseDetails.jsp";
    }

    function popw () {
        window.open('http://localhost:8088/nonresident_war_exploded/pic/k2.jpg','popup','width=600,height=600'); return false;
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
