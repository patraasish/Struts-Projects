//	New_User validation
function ValidateForm(frm)
	{
	  var fname=frm.firstname.value;
	  var lname=frm.lastname.value;
	  var uname=frm.username.value;
	  var password=frm.password.value;
	  var conpassword=frm.conpassword.value;
	  var age=frm.age.value;
	  var gender1=frm.gender[0].checked;
	  var gender2=frm.gender[1].checked;
	  var add=frm.address.value;
	  var state=frm.state.value;
	  var country=frm.country.value;
	  var email=frm.email.value;
	  var mob=frm.mobile.value;
	  var secqus=frm.secqus.value;
	  var secans=frm.secans.value;
	  	  
	  if(fname.length==0)
		  {
		  alert("plz enter fname");
		  frm.firstname.focus();
		  return false;
		  }
	  if(lname.length==0)
		  {
		  alert("plz enter lname");
		  frm.lastname.focus();
		  return false;
		  }
	  if(uname.length==0)
		  {
		  alert("plz enter uname");
		  frm.username.focus();
		  return false;
		  }
	  if(password.length==0)
		  {
		  alert("plz enter password");
		  frm.password.focus();
		  return false;
		  }
	  if(conpassword.length==0)
		  {
		  alert("plz enter conpassword");
		  frm.conpassword.focus();
		  return false;
		  }
	  if(age.length==0)
		  {
		  alert("plz enter age");
		  frm.age.focus();
		  return false;
		  }
	  if((gender1==false) && (gender2==false))
		  {
		  alert("plz select  one gender");
		  frm.gender[0].focus();
		  return false;
		  }  
	  if(add.length==0)
		  {
		  alert("plz enter address");
		  frm.address.focus();
		  return false;
		  }
	  if(state.length==0)
		  {
		  alert("plz enter state");
		  frm.state.focus();
		  return false;
		  }
	  if(country.length==0)
		  {
		  alert("plz enter country");
		  frm.country.focus();
		  return false;
		  }
	  if(email.length==0)
		  {
		  alert("plz enter email");
		  frm.email.focus();
		  return false;
		  }
	   
	  var atpos=email.indexOf("@");
	  var dotpos=email.lastIndexOf(".");
	  
	  if(atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
		  {
		  alert("Not a valid e-mail address");
		  return false;
		  }
	  
	  return true;
	  }

//	NumberValdation(event)

function NumberValdation(event)
	{
	
	var charcode=event.keyCode;
	
	if(charcode<48 || charcode>57)
		{
		alert("Plz Enter Number ");
		return false;
		}
	return true;
	}  

