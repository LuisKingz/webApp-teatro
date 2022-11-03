<%-- 
    Document   : login
    Created on : 6/12/2018, 12:29:38 AM
    Author     : lfern
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>

<!DOCTYPE html>
<html>
    <head>
        <link href="<%=context%>/css/style.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <!-- multistep form -->
        <form id="msform">
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Account Setup</li>
                <li>Social Profiles</li>
                <li>Personal Details</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Create your account</h2>
                <h3 class="fs-subtitle">This is step 1</h3>
                <input type="text" name="email" placeholder="Email" />
                <input type="password" name="pass" placeholder="Password" />
                <input type="password" name="cpass" placeholder="Confirm Password" />
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Social Profiles</h2>
                <h3 class="fs-subtitle">Your presence on the social network</h3>
                <input type="text" name="twitter" placeholder="Twitter" />
                <input type="text" name="facebook" placeholder="Facebook" />
                <input type="text" name="gplus" placeholder="Google Plus" />
                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">We will never sell it</h3>
                <input type="text" name="fname" placeholder="First Name" />
                <input type="text" name="lname" placeholder="Last Name" />
                <input type="text" name="phone" placeholder="Phone" />
                <textarea name="address" placeholder="Address"></textarea>
                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="submit" name="submit" class="submit action-button" value="Submit" />
            </fieldset>
        </form>
    </body>
    <script src="<%=context%>/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%=context%>/js/Script.js"></script>
    <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>
</html>
