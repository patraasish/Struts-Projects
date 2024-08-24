<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="p1.LoginAction"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<TITLE>CancellationConfirm.jsp</TITLE>
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
					<a href="MyProfile">My Profile</a><br>
				  	<a href="ChangePsw">Change Password</a><br>
				  	<a href="MyBooking">My Booking</a><br>
				  	<a href="Cancellation.jsp">Cancellation</a><br>
				  	<a href="Enquire.jsp">Enquire</a>
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
  	<h1><u>CancellationConfirm Page</u></h1>
  	<br/>
  	<FONT size="5" color="green" face="Monotype Corsiva">
  	Your 10% money will be charged for cancellation.<br/><br/>
  	Are you sure to cancel your ticket having PNR No- <s:property value="pnrno"/>
  	  	
  	</FONT>
  	<br>
  	<s:form action="CancelConfirm">
  	<table>
	  	<tr><td><s:hidden name="pnrno"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="custid"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="flightid"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="date"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="deptime"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="seat"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="stclas"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="amount"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="bank"></s:hidden></td></tr>
	  	<tr><td><s:hidden name="accountno"></s:hidden></td></tr>
	  	<tr><td><s:submit value="Yes"></s:submit></td></tr>
	  	<tr><td><s:submit value="No" action="NotCancel"></s:submit></td></tr>
  	</table>
  	</s:form>
  	<br/><br/><br/>
  	<FONT size="4" color="red"><s:property value="msg"/></FONT>
  	
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