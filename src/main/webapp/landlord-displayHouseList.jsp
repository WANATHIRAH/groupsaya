<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/12/2021
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="landlord-displayHouseList.css"%></style>
<head>
    <title>House List Page</title>
</head>
<body>
<div class="mymenu"><%@include file="Menu.html"%></div>
<div class="TT">
     <p>YOUR HOUSE LIST</p>
</div>
<br>
<%-- for each function insert by row and column --%>
<div class="overflow-auto">
    <div class="Hcont">
        <div class="housepic"></div>  <%--Nnti letak data sql using scrplet --%>
        <div class="houseName">
            <p>Rumah Banglo Taman Permai Indah</p>  <%--Nnti letak data sql using scrplet --%>
        </div>
        <div class="myLink">
            <button onclick="x()">View More</button>
        </div>
    </div>

    <div class="Hcont">
        <div class="housepic"></div>  <%--Nnti letak data sql using scrplet --%>
        <div class="houseName">
            <p>Rumah Teres 22</p>  <%--Nnti letak data sql using scrplet --%>
        </div>
        <div class="myLink">
            <button onclick="x()">View More</button>
        </div>
    </div>


    <div class="C" id="Chouse">
        <button onclick="z()">
	 <span class="button__icon">
	 <ion-icon name="add"></ion-icon>
	 </span>
            <br>
            <span class="button__text">Create</span>
        </button>
    </div>

</div>
<br>
<br>




<script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>





<script type="text/javascript">
    <%--kene ada sql untuk specifickan id rumah mana nak display dalam page ni--%>
    function x() {
        location.href = "landlord-displayMoreInfo.jsp";
    }

    function z() {
        location.href = "landlord-createHouseDetails.jsp";
    }
</script>

</body>
</html>
