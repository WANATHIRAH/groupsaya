<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/12/2021
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/HD.css"%></style>

<head>
    <title>House Application Page</title>
</head>
<head>
    <title>HOUSE INFORMATION APPLICATION</title>
</head>
<body>
<%@include file="Menu.html"%>
<div class="tintedbg">
    <div class="container">
    <form name="HouseInfoForm" method="post" action="HouseDetails.jsp"  enctype = "multipart/form-data">
    <br/>
    <br/>
        <div class="row">
            <div class="col-1">
                <label for="hName">House Name</label>
            </div>
            <div class="col-2">
                <input type="text" id="hName" name="hName" placeholder="Your House Name">
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="hAddress">Address</label>
            </div>
            <div class="col-2">
                <input type="text" id="hAddress" name="hAddress" placeholder="eg: Taman Sentosa Jaya">
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="Pricepm">Price per month (RM)</label>
            </div>
            <div class="col-2">
                <input type="number" id="Pricepm" name="Pricepm" placeholder="eg: 300">
            </div>
            <div class="col-3">
                <p>House Availability</p>
            </div>
            <div class="col-4">
                <input type="radio"  id="OYes" name="hAvailability" value="Yes">
                <label for="OYes">Yes</label>
            </div>
            <div class="col-5">
                <input type="radio"  id="ONo" name="hAvailability" value="No">
                <label for="ONo">No</label>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label for="NumOfHT"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button" id="btn1" name="quant1">-</button>
                    <input type="text" id="NumOfHT" name="quant1" value="1">
                    <button class="btn plus-btn" type="button" id="btn2" name="quant1">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="NumOfTenant">Number of Tenant</label>
            </div>
            <div class="col-2">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfTenant" name="quant2"  value="1">
                    <button class="btn plus-btn" type="button" >+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="Desc">Description:</label>
            </div>
            <div class="col-2">
                <textarea id="Desc" name="Desc" rows="4" cols="50"></textarea>
            </div>
        </div>



        <div class="row">
            <div class="col-3">
                <label for="NumOfRooms"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfRooms" name="quant[3]"  value="1">
                    <button class="btn plus-btn" type="button">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label for="NumOfToilet"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfToilet" name="quant[4]"  value="1">
                    <button class="btn plus-btn" type="button">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label for="NumOfAC"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfAC" name="quant[5]"  value="1">
                    <button class="btn plus-btn" type="button">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label for="NumOfSofa"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfSofa" name="quant[6]"  value="1">
                    <button class="btn plus-btn" type="button">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-3">
                <label for="NumOfWM"></label>
            </div>
            <div class="col-4">
                <div class="quantity">
                    <button class="btn minus-btn disabled" type="button">-</button>
                    <input type="text" id="NumOfWM" name="quant[7]"  value="1">
                    <button class="btn plus-btn" type="button">+</button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="hPic">Upload House Image :</label>
            </div>
            <div class="col-2">
                <input type = "file" id="hPic" name = "hPic" size = "50" />
            </div>
        </div>

        <div class="row">
            <div class="col-1">
                <label for="hAgree">Upload House Agreement:</label>
            </div>
            <div class="col-2">
                <input type = "file" id="hAgree" name = "hAgree" size = "50" />
            </div>
        </div>

    <br/>
        <div class="row">
            <input type="submit" value="Submit">
        </div>
    <br/>
    </form>
    </div>


<script>

    //setting default attribute to disable minus button
    document.querySelector(".minus-btn").setAttribute("disabled", "disabled");

    //value increment and decrement
    var valueCount;

    //plus button
    document.querySelector(".plus-btn").addEventListener("click", function () {
        //getting value input
        if (document.getElementById("NumOfTenant").name == "quant2") {
            valueCount = document.getElementById("NumOfHT").value;


            //input value increment by 1
            valueCount++;

            //setting increment input value
            document.getElementById("NumOfTenant").value = valueCount


            if (valueCount > 1) {
                document.querySelector(".minus-btn").removeAttribute("disabled");
                document.querySelector(".minus-btn").classList.remove("disabled");

            }
        }
    })


    //minus button
    document.querySelector(".minus-btn").addEventListener("click",function()
    {
        if (document.getElementById("NumOfTenant").name == "quant2") {
            //getting value input
            valueCount = document.getElementById("NumOfHT").value;

            //input value increment by 1
            valueCount--;

            //setting increment input value
            document.getElementById("NumOfTenant").value = valueCount

            if (valueCount == 1) {
                document.querySelector(".minus-btn").setAttribute("disabled", "disabled")
            }
        }
    })


</script>

</div>
</body>
</html>
