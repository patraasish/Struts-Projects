<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<TITLE>EditFlight.jsp</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<style type="text/css">
<!--
.style1 {
	color: #333333;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #FF0000;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 16px;
}
.style3 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: #FFFFFF;
}
.style5 {color: #333333; font-weight: bold; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 14px; }
.style6 {
	color: #590660;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
}
.style13 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 11px; color: #590660; }
.style14 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: #0B6191;
	font-weight: bold;
}
.style15 {font-size: 10px; color: #0B6191; font-family: Verdana, Arial, Helvetica, sans-serif;}
.style16 {
	color: #0B6191;
	font-weight: bold;
	font-size: 14px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
.style18 {
	font-size: 11px;
	color: #000000;
}
.style20 {font-size: 10px; color: #590660; font-family: Verdana, Arial, Helvetica, sans-serif;}
.style22 {
	color: #0E7DBB;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
}
.style23 {
	color: #590660;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
}
.style24 {
	color: #0E7DBB;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
}
body {
	background-image: url(images/main_bg.jpg);
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
	color: #000000;
}
a:active {
	text-decoration: none;
	color: #000000;
}
.style31 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 13px;
	color: #003366;
}
.style32 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
}
-->
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>
<!-- ImageReady Slices (travel001.psd) -->
<table width="770" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td align="center" valign="top"><table width="770" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="123"><IMG SRC="images/index_01.jpg" WIDTH=123 HEIGHT=29 ALT=""></td>
        <td width="79" background="images/butbg.jpg"><div align="center" class="style31"><a href="Home.jsp">Home</a></div></td>
        <td width="107" background="images/butbg.jpg"><div align="center"><span class="style31"><a href="AboutUs.jsp">About Us</a></span></div></td>
        <td width="107" background="images/butbg.jpg"><div align="center"><span class="style31"><a href="ContactUs.jsp">Contact Us</a></span></div></td>
        <td width="112" background="images/butbg.jpg"><div align="center"><span class="style31"><a href="Login.jsp">Logout</a></span></div></td>
        <td width="119" background="images/butbg.jpg"><div align="center"><span class="style31"></span></div></td>
        <td><IMG SRC="images/index_07.jpg" WIDTH=123 HEIGHT=29 ALT=""></td>
      </tr>
    </table>
      <table width="770" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="61"><IMG SRC="images/index_08.jpg" WIDTH=61 HEIGHT=196 ALT=""></td>
          <td width="62"><IMG SRC="images/index_09.jpg" WIDTH=62 HEIGHT=196 ALT=""></td>
          <td width="66"><IMG SRC="images/index_10.jpg" WIDTH=66 HEIGHT=196 ALT=""></td>
          <td width="135"><IMG SRC="images/index_11.jpg" WIDTH=135 HEIGHT=196 ALT=""></td>
          <td width="299" valign="top"><table width="299" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><IMG SRC="images/index_12.jpg" WIDTH=299 HEIGHT=29 ALT=""></td>
            </tr>
            <tr>
              <td><IMG SRC="images/index_15.jpg" WIDTH=299 HEIGHT=75 ALT=""></td>
            </tr>
            <tr>
              <td><table width="299" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="228" background="images/index_16.jpg"><table width="228" border="0" cellspacing="0" cellpadding="0">
                    
                    
                  </table></td>
                  <td><table width="71" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><IMG SRC="images/index_17.jpg" WIDTH=71 HEIGHT=52 ALT=""></td>
                    </tr>
                    <tr>
                      <td><IMG SRC="images/index_18.jpg" WIDTH=71 HEIGHT=19 ALT=""></td>
                    </tr>
                    <tr>
                      <td><IMG SRC="images/index_19.jpg" WIDTH=71 HEIGHT=21 ALT=""></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
          <td width="70"><IMG SRC="images/index_13.jpg" WIDTH=70 HEIGHT=196 ALT=""></td>
          <td><IMG SRC="images/index_14.jpg" WIDTH=77 HEIGHT=196 ALT=""></td>
        </tr>
      </table>
      <table width="770" border="0" cellpadding="0" cellspacing="0" background="images/index_21.jpg">
        <tr>
          <td><IMG SRC="images/index_21.jpg" WIDTH=10 HEIGHT=10 ALT=""></td>
        </tr>
      </table>
      <table width="770" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="346" valign="top"><table width="346" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="95" align="center" background="images/index_23.jpg"><table width="300" border="0" cellspacing="0" cellpadding="0">
                
                <tr>
                  <td align="center"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td><table width="346" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="175"><IMG SRC="images/index_27.jpg" WIDTH=175 HEIGHT=27 ALT=""></td>
                  <td width="99"><IMG SRC="images/index_28.jpg" WIDTH=99 HEIGHT=27 ALT=""></td>
                  <td><IMG SRC="images/index_29.jpg" WIDTH=72 HEIGHT=27 ALT=""></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
          <td width="74"><IMG SRC="images/index_24.jpg" WIDTH=74 HEIGHT=122 ALT=""></td>
          <td width="225" align="center" valign="top" background="images/index_25.jpg"></td>
          <td width="125"><IMG SRC="images/index_26.jpg" WIDTH=125 HEIGHT=122 ALT=""></td>
        </tr>
      </table>
      <table width="770" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="250" align="center"><table width="226" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="158" valign="bottom" background="images/index_31.jpg">
                
                <tr>
                <td>
					<a href="AddNewFlight.jsp">Add New Flight</a><br>
				  	<a href="AddFlight">Add Flight Running</a><br>
				  	<a href="DeleteFlight">Delete Flight</a>
                </td>
                </tr>
                
                
              
            
            
          </table></td>
          <td width="520" align="center" valign="top"><table width="470" border="0" cellspacing="0" cellpadding="0">
            
            <tr>
              <td align="center"><table width="440" border="0" cellspacing="0" cellpadding="0">
                
                <tr>
                  <td align="right" valign="top"><table width="210" border="0" cellspacing="0" cellpadding="0">
                    
                    
                    
                  </table></td>
                </tr>
                
                
              </table></td>
            </tr>
            <tr><td>
    
    
    
    <center>
  	<h1><u>EditFlight Page</u></h1>
  	
  	<table>
  	<s:form action="UpdateFlt">
	  	<tr><td><s:textfield name="flightid" label="Flight No " readonly="true" ></s:textfield></td></tr>
	  	<tr><td><s:textfield name="flightname" label="Flight Name " readonly="true" ></s:textfield></td></tr>
	  	<tr><td><s:textfield name="fltype" label="Flight Type " readonly="true"></s:textfield></td></tr>
	  	<tr><td><s:select name="from" label="From " list="place"></s:select></td></tr>
	  	<tr><td><s:select name="to" label="To " list="place"></s:select></td></tr>
	  	<tr><td><s:textfield name="date" label="Date "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="deptime" label="Departure Time "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="arrtime" label="Arrival Time "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="tot_seat" label="Total Seat " readonly="true"></s:textfield></td></tr>
	  	<tr><td><s:textfield name="avail_seat" label="Available_Seat "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="tot_vip" label="Total Seat Vip " readonly="true"></s:textfield></td></tr>
	  	<tr><td><s:textfield name="avail_vip" label="Available_Vip "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="tot_gen" label="Total Seat Gen " readonly="true"></s:textfield></td></tr>
	  	<tr><td><s:textfield name="avail_gen" label="Available_Gen "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="tot_lux" label="Total Seat Lux" readonly="true"></s:textfield></td></tr>
	  	<tr><td><s:textfield name="avail_lux" label="Available_Lux "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="cost_vip" label="Cost_Of_Vip "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="cost_gen" label="Cost_Of_Gen "></s:textfield></td></tr>
	  	<tr><td><s:textfield name="cost_lux" label="Cost_Of_Lux "></s:textfield></td></tr>
	  	<tr><td><s:submit value="Update"></s:submit></td><td><s:reset value="Reset"></s:reset></td></tr>
  	</s:form>
  	</table>
  	</center>
    
    
    
    
    
    
    
    
    
          
            
  	
  	</td></tr>
          </table></td>
        </tr>
      </table>
      <table width="770" border="0" cellpadding="0" cellspacing="0" background="images/index_49.jpg">
        <tr>
          <td width="17"><IMG SRC="images/index_49.jpg" WIDTH=17 HEIGHT=28 ALT=""></td>
          <td align="center" class="style3 style18"><a href="Home.jsp">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;<a href="AboutUs.jsp">About Us</a>&nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp; <a href="ContactUs.jsp">Contact Us</a> &nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">About Us</a>&nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">Contact Us</a></td>
          <td width="17">&nbsp;</td>
        </tr>
      </table>
      <table width="770" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="20" align="center"><span class="style32">Designed by <A href="http://www.free-css-templates.com/" target="_blank">Free CSS   Templates</A>, Thanks to <a href="http://www.openwebdesign.org/">pro web design</a></span></td>
        </tr>
      </table></td>
  </tr>
</table>
<!-- End ImageReady Slices -->
</BODY>
</HTML>