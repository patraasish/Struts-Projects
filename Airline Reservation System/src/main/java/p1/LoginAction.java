package p1;

//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import org.apache.struts2.*;
import com.opensymphony.xwork2.*;
//import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport
	{
	
	ResultSet rs=null;
	private String[] place={"Australia","Bangalore","Berlin","Bhubaneswar","Brazil","Chennai","Delhi","Dhaka","Hydrabad","India","Iraq","IslamaBad","Kolkata","London","Lucknow","Mosco","Mumbai","New Yourk","Raipur","Sanghai","Singapore","South Africa","Tehran","Tokio","Vishakhapatnam","Washington"};
	private String[] clas={"Vip","Gen","Lux"};
	
//	private String[] location={'Australia','Bangalore','Berlin','Bhubaneswar','Brazil','Chennai','Delhi','Dhaka','Hydrabad','India','Iraq','IslamaBad','Kolkata','London','Lucknow','Mosco','Mumbai','New Yourk','Raipur','Sanghai','Singapore','South Africa','Tehran','Tokio','Vishakhapatnam','Washington'};
	
	private Vector<LoginAction> vect;
	
	
	public Vector<LoginAction> getVect() {
		return vect;
	}
	public void setVect(Vector<LoginAction> vect) {
		this.vect = vect;
	}
	
	
	
	
	
	
	public String[] getClas() {
		return clas;
	}
	public void setClas(String[] clas) {
		this.clas = clas;
	}
	public String[] getPlace() {
		return place;
	}
	public void setPlace(String[] place) {
		this.place = place;
	}







	/*	public String[] getPlace() {
		return place;
	}
	public void setPlace(String[] place) {
		this.place = place;
	}
*/
	private String username;
	private String password;
	private String newpassword;
	private String conpassword;
	private String usertype;
	private String firstname;
	private String lastname;
	private Long age;
	private String gender;
	private String address;
	private String state;
	private String country;
	private String email;
	private Long mobile;
	private String secqus;
	private String secans;
	private String msg;
	private String custid;
	private String fid;
	private String flightname;
	private Long flightid;
	private String from;
	private String to;
	private String date;
	private String arrtime;
	private String deptime;
	private Long avail_seat;
	private Long avail;
	private Long tot_seat;
	private Long tot_vip;
	private Long tot_gen;
	private Long tot_lux;
	private Long avail_vip;
	private Long avail_gen;
	private Long avail_lux;
	private Long cost_vip;
	private Long cost_gen;
	private Long cost_lux;
	private Long seat;
	private String fltype;
	private String stclas;
	private Long cost;
	private Double price;
	private Double totPrice=(double)0;
	private String name;
	private String seatfor;
	private String concession;
	private String identityno;
	private Long no=(long)0;
	private String banking;
	private String bank;
	private Long accountno;
	private Double amount;
	private String trpassword;
	private Long pnrno;
	private String bookdate;
	private Long seatno;
	private Long rundays;
	
	private Map<Integer,String> custmap;
	private Map<Integer,String> fltnm;
	
	

	
	

	Map session;
	Map sess1;
	
	//private String ;

	
	
	
	
	
	
	
	public String getUsername()
		{
		return username;
		}
	public Long getRundays() {
		return rundays;
	}
	public void setRundays(Long rundays) {
		this.rundays = rundays;
	}
	public Long getSeatno() {
		return seatno;
	}
	public void setSeatno(Long seatno) {
		this.seatno = seatno;
	}
	public String getBookdate() {
		return bookdate;
	}
	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}
	public Long getPnrno() {
		return pnrno;
	}
	public void setPnrno(Long pnrno) {
		this.pnrno = pnrno;
	}
	public Long getAvail() {
		return avail;
	}
	public void setAvail(Long avail) {
		this.avail = avail;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTrpassword() {
		return trpassword;
	}
	public void setTrpassword(String trpassword) {
		this.trpassword = trpassword;
	}
	public Long getAccountno() {
		return accountno;
	}
	public void setAccountno(Long accountno) {
		this.accountno = accountno;
	}
	public String getBanking() {
		return banking;
	}
	public void setBanking(String banking) {
		this.banking = banking;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Double getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(Double totPrice) {
		this.totPrice = totPrice;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeatfor() {
		return seatfor;
	}
	public void setSeatfor(String seatfor) {
		this.seatfor = seatfor;
	}
	public String getConcession() {
		return concession;
	}
	public void setConcession(String concession) {
		this.concession = concession;
	}
	public String getIdentityno() {
		return identityno;
	}
	public void setIdentityno(String identityno) {
		this.identityno = identityno;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStclas() {
		return stclas;
	}
	public void setStclas(String stclas) {
		this.stclas = stclas;
	}
	public void setUsername(String username)
		{
		this.username=username;
		}
	public String getPassword()
		{
		return password;
		}
	public void setPassword(String password)
		{
		this.password=password;
		}
	public String getConpassword()
		{
		return conpassword;
		}
	public void setConpassword(String conpassword)
		{
		this.conpassword=conpassword;
		}
	public String getUsertype()
		{
		return usertype;
		}
	public void setUsertype(String usertype)
		{
		this.usertype=usertype;
		}
	public Map<Integer,String> getCustmap()
		{
		return custmap;
		}
	public void setCustmap(Map<Integer,String> custmap)
		{
		this.custmap=custmap;
		}
	public String getFirstname()
	{
	return firstname;
	}
	public void setFirstname(String firstname)
		{
		this.firstname=firstname;
		}
	public String getLastname()
		{
		return lastname;
		}
	public void setLastname(String lastname)
		{
		this.lastname=lastname;
		}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender()
		{
		return gender;
		}
	public void setGender(String gender)
		{
		this.gender=gender;
		}
	public String getEmail()
		{
		return email;
		}
	public void setEmail(String email)
		{
		this.email=email;
		}
	public String getAddress()
		{
		return address;
		}
	public void setAddress(String address)
		{
		this.address=address;
		}
	public Long getMobile()
		{
		return mobile;
		}
	public void setMobile(Long mobile)
		{
		this.mobile=mobile;
		}
	public String getSecqus() {
		return secqus;
	}
	public void setSecqus(String secqus) {
		this.secqus = secqus;
	}
	public String getSecans() {
		return secans;
	}
	public void setSecans(String secans) {
		this.secans = secans;
	}
	public String getMsg()
		{
		return msg;
		}
	public void setMsg(String msg)
		{
		this.msg=msg;
		}
	public String getCustid()
		{
		return custid;
		}
	public void setCustid(String custid)
		{
		this.custid=custid;
		}
	public String getFlightname()
		{
		return flightname;
		}
	public void setFligtname(String flightname)
		{
		this.flightname=flightname;
		}
	
	public String getFrom()
		{
		return from;
		}
	public void setFrom(String from)
		{
		this.from = from;
		}
	public String getTo()
		{
		return to;
		}
	public void setTo(String to)
		{
		this.to = to;
		}
	public String getArrtime()
		{
		return arrtime;
		}
	public void setArrtime(String arrtime)
		{
		this.arrtime=arrtime;
		}
	public String getDeptime()
		{
		return deptime;
		}
	public void setDeptime(String deptime)
		{
		this.deptime=deptime;
		}
	public String getDate()
		{
		return date;
		}
	public void setDate(String date)
		{
		this.date=date;
		}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid=fid;
	}
	public void setFlightname(String flightname) {
		this.flightname=flightname;
	}
	public Long getFlightid() {
		return flightid;
	}
	public void setFlightid(Long flightid) {
		this.flightid=flightid;
	}
	public Long getAvail_seat() {
		return avail_seat;
	}
	public void setAvail_seat(Long availSeat) {
		avail_seat = availSeat;
	}
	public Long getTot_seat() {
		return tot_seat;
	}
	public void setTot_seat(Long totSeat) {
		tot_seat = totSeat;
	}
	public Long getTot_vip() {
		return tot_vip;
	}
	public void setTot_vip(Long totVip) {
		tot_vip = totVip;
	}
	public Long getTot_gen() {
		return tot_gen;
	}
	public void setTot_gen(Long totGen) {
		tot_gen = totGen;
	}
	public Long getTot_lux() {
		return tot_lux;
	}
	public void setTot_lux(Long totLux) {
		tot_lux = totLux;
	}
	public Long getAvail_vip() {
		return avail_vip;
	}
	public void setAvail_vip(Long availVip) {
		avail_vip = availVip;
	}
	public Long getAvail_gen() {
		return avail_gen;
	}
	public void setAvail_gen(Long availGen) {
		avail_gen = availGen;
	}
	public Long getAvail_lux() {
		return avail_lux;
	}
	public void setAvail_lux(Long availLux) {
		avail_lux = availLux;
	}
	public Long getCost_vip() {
		return cost_vip;
	}
	public void setCost_vip(Long costVip) {
		cost_vip = costVip;
	}
	public Long getCost_gen() {
		return cost_gen;
	}
	public void setCost_gen(Long costGen) {
		cost_gen = costGen;
	}
	public Long getCost_lux() {
		return cost_lux;
	}
	public void setCost_lux(Long costLux) {
		cost_lux = costLux;
	}
	public Map<Integer, String> getFltnm()
		{
		return fltnm;
		}
	public void setFltnm(Map<Integer, String> fltnm)
		{
		this.fltnm = fltnm;
		}
	public Long getSeat() {
		return seat;
	}
	public void setSeat(Long seat) {
		this.seat = seat;
	}
	public String getFltype() {
		return fltype;
	}
	public void setFltype(String fltype) {
		this.fltype = fltype;
	}
	
	
	
	


	
	
	
	
	
	
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}	
	public Map getSess1() {
		return sess1;
	}
	public void setSess1(Map sess1) {
		this.sess1 = sess1;
	}
	
	
	
	
	
	
	
	
	

	DbLogic dl=new DbLogic();
	
	
	public String AddNewFlt() throws SQLException,ClassNotFoundException
		{
		int i=0;
		i=dl.AddNewFlt(flightid,flightname,fltype,rundays,tot_seat,tot_vip,tot_gen,tot_lux);
		reset();
		if(i>0)
			{
			setMsg("New Flight is added");
			return FlightMgt();
			}
		return null;
		}
	
	public String AddPassenger() throws SQLException,ClassNotFoundException
		{
		Map sess1=(Map)ActionContext.getContext().getSession();///////edit map
		Long cst=(Long)sess1.get("Cost");
		String id=(String)sess1.get("LOGINID");
		Long loginid=Long.parseLong(id);
		System.out.println(loginid+loginid);
		Double prc=(double)cst;
		Double c;
		System.out.println(no+" "+(Long)sess1.get("Seat"));
		if(no < (Long)sess1.get("Seat"))
			{
			if(seatfor.equals("Child"))
				{
				setConcession("Non");
				c=(double)(((double)50/(double)100)*prc);
				}
			else
				{
				if(concession.equals("Senior Citigen"))
					{
					c=(double)(((double)60/(double)100)*prc);
					}
				else if (concession.equals("Handicap"))
					{
					c=(double)(((double)40/(double)100)*prc);
					}
				else
					{
					c=(double)prc;
					}
				}
			int i=0;
			i=dl.AddPassenger(name,age,gender,country,seatfor,concession,identityno,c,loginid);
			reset();
			if(i>0)
				{
				LoginAction la;
				vect=new Vector<LoginAction>();
				ResultSet rs=dl.GetPassenger(loginid);
				while(rs.next())
					{
					la=new LoginAction();
					la.setName(rs.getString(2));
					la.setAge(rs.getLong(3));
					la.setGender(rs.getString(4));
					la.setCountry(rs.getString(5));
					la.setSeatfor(rs.getString(6));
					la.setConcession(rs.getString(7));
					la.setIdentityno(rs.getString(8));
					la.setPrice(rs.getDouble(9));
					vect.addElement(la);
					}
				setNo(no+(long)1);
				sess1.put("Pass", vect);
				System.out.println("iffffffff");
				return "addpass";
				}
			reset();
			System.out.println("ifeeeeeeeeeee");
			return "addpassfail";
			}
		reset();
		System.out.println("nnnnnnnnnnnnnnnnnnnn");
		setMsg("your required tickets exceeds......");
		return "addpassfail";
		}
	
	public String AddFlight() throws SQLException,ClassNotFoundException
		{
		int i=0;
		i=dl.AddFlight(fid,flightid,from,to,date,deptime,arrtime,avail_seat,avail_vip,avail_gen,avail_lux,cost_vip,cost_gen,cost_lux);
		reset();
		if(i>0)
			{
			return FlightMgt();
			}
		return null;
		}
	
	public String ApprovedCust() throws SQLException,ClassNotFoundException
		{
		HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Long id=Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		int i=dl.ApprovedCust(id);
		setMsg("You are approved.......");
		if(i>0)
			{
			return CustMgt();
			}
		return null;
		}
		
	public String Book() throws SQLException,ClassNotFoundException
		{
		System.out.println(flightid+" "+date+" "+deptime+" "+avail_seat+" "+avail);
		Map session=ActionContext.getContext().getSession();
		System.out.println(session.get("LOGINID"));
		Map sess1=ActionContext.getContext().getSession();
		System.out.println(sess1.get("Class")+" "+sess1.get("Seat"));
		String cls=(String)sess1.get("Class");
		Long st=(Long)sess1.get("Seat");
		String lid=(String)session.get("LOGINID");
		sess1.clear();
		session.clear();
		sess1.put("Clas", cls);
		sess1.put("Seat", st);
		sess1.put("Flightid", flightid);
		sess1.put("Date", date);
		sess1.put("Deptime", deptime);
		sess1.put("Avail_Seat", avail_seat);
		sess1.put("Avail", avail);
		session.put("LOGINID", lid);
		ResultSet rs=dl.BookPatrFlt(flightid,date,deptime,cls,st);
		if(rs.next())
			{
			setFlightid(rs.getLong(1));
			setFlightname(rs.getString(2));
			setFrom(rs.getString(3));
			setTo(rs.getString(4));
			setDate(rs.getString(5));
			setDeptime(rs.getString(6));
			setCost(rs.getLong(7));
			sess1.put("Flightname", rs.getString(2));
			sess1.put("From", rs.getString(3));
			sess1.put("To", rs.getString(4));
			sess1.put("Cost", rs.getLong(7));
			}
		return "customer1";
		}
	
	public String BookTkt() throws SQLException,ClassNotFoundException
		{
		System.out.println(flightid+" "+flightname+" "+from+" "+to+" "+date+" "+deptime);
		return "success";
		}
	
	public String Buy() throws SQLException,ClassNotFoundException
		{
		System.out.println("Buy");
		
		return "success";
		}
		
	public String Cancel() throws SQLException,ClassNotFoundException
		{
		System.out.println(pnrno+" "+custid+" "+flightid+" "+date+" "+deptime+" "+seat+" "+stclas+" "+amount+" "+bank+" "+accountno);
		return "success";
		}
	
	public String CancelConfirm() throws SQLException,ClassNotFoundException
		{
		System.out.println(pnrno+" "+custid+" "+flightid+" "+date+" "+deptime+" "+seat+" "+stclas+" "+amount+" "+bank+" "+accountno);
		int i=dl.CancelConfirm(pnrno,custid,flightid,date,deptime,seat,stclas,amount,bank,accountno);
		if(i>0)
			{
			
			System.out.println("Cancel Successful");
			setMsg("Your ticket successfully cancelled");
			return "success";
			}
		setMsg("Your cancellellation failed");
		return "fail";
		}
	
	public String Cancellation() throws SQLException,ClassNotFoundException
		{
		Map session=ActionContext.getContext().getSession();
		String s1=(String)session.get("LOGINID");
		Long id=Long.parseLong(s1);
		System.out.println(id+" "+pnrno);
		rs=dl.Cancellation(id,pnrno);
		if(rs.next())
			{
			setPnrno(rs.getLong(1));
			setCustid(rs.getString(2));
			setFlightid(rs.getLong(3));
			setFlightname(rs.getString(4));
			setDate(rs.getString(5));
			setBookdate(rs.getString(6));
			setSeat(rs.getLong(7));
			setAmount(rs.getDouble(8));
			setBank(rs.getString(9));
			setAccountno(rs.getLong(10));
			setFrom(rs.getString(11));
			setTo(rs.getString(12));
			setDeptime(rs.getString(13));
			setStclas(rs.getString(14));
			System.out.println(pnrno+" "+custid+" "+flightid+" "+flightname+" "+date+" "+bookdate+" "+seat+" "+amount+" "+bank+" "+accountno+" "+from+" "+to+" "+deptime+" "+stclas);
			}
		return "success";
		}
	
	public String ChangePass() throws SQLException,ClassNotFoundException
		{
		if(newpassword.equals(conpassword))
			{
			int i=0;
			Long loginid=Long.parseLong(custid);
			i=dl.ChangePass(loginid,password,newpassword);
			if(i>0)
				{
				setMsg("Your password is changed....");
				return "success";
				}
			setMsg("Your oldpassword is not correct....");
			return "fail";
			}
		setMsg("New password is not matched with Confirm password....");
		return "fail";
		}
	
	public String ChangePsw() throws SQLException,ClassNotFoundException
		{
		Map session=ActionContext.getContext().getSession();
		String id=(String)session.get("LOGINID");
		Long loginid=Long.parseLong(id);
		ResultSet rs=dl.ChangePsw(loginid);
		if(rs.next())
			{
			setCustid(rs.getString(1));
			setUsername(rs.getString(2));
			}
		return "success";
		}
		
	public String CheckFare() throws SQLException,ClassNotFoundException
		{
		System.out.println(fid+" "+flightid+" "+from+" "+to+" "+date+" "+stclas+" "+seat+" "+seatno);
		ResultSet rs=dl.CheckFare(flightid,from,to,date,stclas);
		if(rs.next())
			{
			System.out.println("ifffffffffff");
			setFlightid(rs.getLong(1));
			setFlightname(rs.getString(2));
			setFrom(rs.getString(3));
			setTo(rs.getString(4));
			setDate(rs.getString(5));
			setDeptime(rs.getString(6));
			setCost(rs.getLong(7));
			System.out.println(flightid+" "+flightname+" "+from+" "+to+" "+date+" "+deptime+" "+cost);
			
			totPrice=(seatno*(double)(((double)50/(double)100)*(double)cost))+(seat*(double)cost);
			setTotPrice(totPrice);
			
			
			
//			/*System.out.println(accountno+" "+amount+" "+trpassword+" "+password);
//			Map sess1=ActionContext.getContext().getSession();
//			Long loginid=Long.parseLong((String)sess1.get("LOGINID"));
//			setFlightid((Long)sess1.get("Flightid"));
//			setFlightname((String)sess1.get("Flightname"));
//			setFrom((String)sess1.get("From"));
//			setTo((String)sess1.get("To"));
//			setDate((String)sess1.get("Date"));
//			setDeptime((String)sess1.get("Deptime"));
//			String clas=(String)sess1.get("Clas");
//			setSeat((Long)sess1.get("Seat"));
//			setTotPrice((Double)sess1.get("totPrice"));
//			setBank((String)sess1.get("Bank"));
//			setAvail_seat((Long)sess1.get("Avail_Seat"));
//			setAvail((Long)sess1.get("Avail"));
//			System.out.println(loginid+" "+flightid+" "+flightname+" "+from+" "+to+" "+date+" "+deptime+" "+clas+" "+seat+" "+totPrice+" "+bank+" "+avail_seat+" "+avail);
//			if(password.equals(trpassword))
//				{
//				//totPrice=180.0;
//				System.out.println("1212121212121212");
//				if(amount>=totPrice)
//					{
//					Double amountleft=(amount-totPrice);
//					Long totseatleft=(avail_seat-seat);
//					Long seatleft=(avail-seat);
//					int i=0;
//					i=dl.AddBooking(loginid,flightid,flightname,from,to,date,deptime,clas,seat,totPrice,bank,accountno,amountleft,totseatleft,seatleft);
//					if(i>0)
//						{
//						System.out.println("Booked");
//						setMsg("Your ticket is booked......");
//						return "success";
//						}
//					System.out.println("No Sufficient Amount");
//					return "fail";
//					}
//				setMsg("You have no sufficient amount on your bank account....");
//				System.out.println("No Sufficient Amount");
//				return "fail";
//				}
//			setMsg("Your transaction password is incorrect....");
//			System.out.println("Wrong password");
//			return "fail";
					}
		//return null	
		return "success";
		}
	
	public String CheckFlt() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=dl.CheckFlt(from,to,date,stclas,seat);
		LoginAction la;
		Map sess1=ActionContext.getContext().getSession();
		vect=new Vector<LoginAction>();
		while(rs.next())
			{
			la=new LoginAction();
			la.setFlightid(rs.getLong(1));
			la.setFlightname(rs.getString(2));
			la.setFrom(rs.getString(3));
			la.setTo(rs.getString(4));
			la.setDate(rs.getString(5));
			la.setDeptime(rs.getString(6));
			la.setTot_seat(rs.getLong(7));
			la.setAvail_seat(rs.getLong(8));
			vect.addElement(la);
			}
		sess1.put("Vec", vect);
		sess1.put("Class", stclas);
		sess1.put("Seat", seat);
		return "success";
		}
	
	public String ChooseBank() throws SQLException,ClassNotFoundException
		{
		System.out.println(banking+" "+bank);
		Map sess1=ActionContext.getContext().getSession();
		sess1.put("Bank", bank);
		sess1.put("Banking", banking);
		if(bank.equals("SBI"))
			{
			if(banking.equals("NetBanking"))
				{
				return "SBINET";
				}
			if(banking.equals("DebitCard"))
				{
				return "SBIDEBIT";
				}
			}
			if(bank.equals("ICICI"))
				{
				if(banking.equals("NetBanking"))
				{
				return "ICICINET";
				}
			if(banking.equals("DebitCard"))
				{
				return "ICICIDEBIT";
				}
			}
		return null;
		}

	public String ChooseBanking() throws SQLException,ClassNotFoundException
		{
		HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String id=(String)request.getParameter("id");
		System.out.println(id);
		setBanking(id);
		return "success";
		}
		
	public String CustMgt() throws SQLException,ClassNotFoundException
		{
		custmap=new HashMap<Integer,String>();
		ResultSet rs=dl.CustMgt();
		while(rs.next())
			{
			custmap.put(rs.getInt(1),rs.getString(2));
			}
		return "dispcust";
		}
	
	public String DelPerFlightInfo() throws SQLException,ClassNotFoundException
		{
		System.out.println(flightid+" "+date+" "+deptime);
		int i=dl.DelPerFlightInfo(flightid,date,deptime);
		reset();
		if(i>0)
			{
			setMsg("Flight running and cost deleted..........");
			return FlightMgt();
			}
		return null;
		}
	
	public String EditOwn() throws SQLException,ClassNotFoundException
		{
		Long loginid=Long.parseLong(custid);
		ResultSet rs=dl.EditOwn(loginid);
		if(rs.next())
			{
			setCustid(rs.getString(1));
			setUsername(rs.getString(2));
			setFirstname(rs.getString(3));
			setLastname(rs.getString(4));
			setAge(rs.getLong(5));
			setGender(rs.getString(6));
			setAddress(rs.getString(7));
			setState(rs.getString(8));
			setCountry(rs.getString(9));
			setMobile(rs.getLong(10));
			setEmail(rs.getString(11));
			}
		return "edit";
		}
	
	public String EditPerFlight() throws SQLException,ClassNotFoundException
		{
		System.out.println(flightid+" "+date+" "+deptime);
		Map sess1=ActionContext.getContext().getSession();
		
		ResultSet rs=dl.EditPerFlight(flightid,date,deptime);
		if(rs.next())
			{
			setFlightid(rs.getLong(1));
			sess1.put("ffid",rs.getLong(1));
			setFlightname(rs.getString(2));
			setFltype(rs.getString(3));
			setFrom(rs.getString(4));
			setTo(rs.getString(5));
			setDate(rs.getString(6));
			sess1.put("ddate",rs.getString(6));
			setDeptime(rs.getString(7));
			sess1.put("ddeptime",rs.getString(7));
			setArrtime(rs.getString(8));
			setTot_seat(rs.getLong(9));
			setAvail_seat(rs.getLong(10));
			setTot_vip(rs.getLong(11));
			setAvail_vip(rs.getLong(12));
			setTot_gen(rs.getLong(13));
			setAvail_gen(rs.getLong(14));
			setTot_lux(rs.getLong(15));
			setAvail_lux(rs.getLong(16));
			setCost_vip(rs.getLong(17));
			setCost_gen(rs.getLong(18));
			setCost_lux(rs.getLong(19));
			}
		return "dispflt";
		}
	
	public String FlightMgt() throws SQLException,ClassNotFoundException
		{
		fltnm=new HashMap<Integer,String>();
		ResultSet rs=dl.FlightMgt();
		while(rs.next())
			{
			fltnm.put(rs.getInt(1),rs.getString(2));
			}
		return "dispflt";
		}
	
	public String ForgotPsw() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=dl.ForgotPsw(username);
		if(rs.next())
			{
			setUsername(rs.getString(1));
			setSecqus(rs.getString(2));
			return "success";
			}
		setMsg("Username is not valid.....");
		return "fail";
		}
	
	public String Login() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=dl.Login(username,password,usertype);
		if(rs.next())
			{
			if(usertype.equals("admin"))
				{
				return "admin";
				}
			String status=rs.getString("userstatus");
			System.out.println(status);
			setFirstname(rs.getString(8));
			setLastname(rs.getString(9));
			System.out.println("1111111 "+rs.getString(8)+" "+rs.getString(9)+" 222222");
			System.out.println(firstname+" "+lastname);
			if(status.equals("approved"))
				{
				Map session=ActionContext.getContext().getSession();
				session.put("LOGINID",rs.getString(1));
				return "customer";
				}
			else
				{
				setMsg("Waiting for Approval......");
				return "loginfail";
				}
			}
		setMsg("Your details are not available......");
		return "loginfail";
		}
	
	
	public String LoginBank() throws SQLException,ClassNotFoundException
		{
		Map sess1=ActionContext.getContext().getSession();
		setBank((String)sess1.get("Bank"));
		System.out.println(accountno+" "+username+" "+password+" "+bank);
		ResultSet rs=dl.LoginBank(accountno,username,password,bank);
		reset();
		if(rs.next())
			{
			System.out.println("yyyyyyyyy");
			setAccountno(rs.getLong(1));
			setName(rs.getString(2));
			setAmount(rs.getDouble(3));
			setTrpassword(rs.getString(4));
			System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4));
			return "success";
			}
		setMsg("Your details are not correct....");
		return "fail";
		}
	
/*					LOGOUT() OK												*/
	
	public String MyProfile() throws SQLException,ClassNotFoundException
		{
		Map session=ActionContext.getContext().getSession();
		String id=(String)session.get("LOGINID");
		Long loginid=Long.parseLong(id);
		ResultSet rs=dl.MyProfile(loginid);
		if(rs.next())
			{
			setCustid(rs.getString(1));
			setUsername(rs.getString(2));
			setFirstname(rs.getString(3));
			setLastname(rs.getString(4));
			setAge(rs.getLong(5));
			setGender(rs.getString(6));
			setAddress(rs.getString(7));
			setState(rs.getString(8));
			setCountry(rs.getString(9));
			setMobile(rs.getLong(10));
			setEmail(rs.getString(11));
			}
		return "view";
		}
	
	public String PaySBINet() throws SQLException,ClassNotFoundException
		{
		System.out.println(accountno+" "+amount+" "+trpassword+" "+password);
		Map sess1=ActionContext.getContext().getSession();
		Long loginid=Long.parseLong((String)sess1.get("LOGINID"));
		setFlightid((Long)sess1.get("Flightid"));
		setFlightname((String)sess1.get("Flightname"));
		setFrom((String)sess1.get("From"));
		setTo((String)sess1.get("To"));
		setDate((String)sess1.get("Date"));
		setDeptime((String)sess1.get("Deptime"));
		String clas=(String)sess1.get("Clas");
		setSeat((Long)sess1.get("Seat"));
		setTotPrice((Double)sess1.get("totPrice"));
		setBank((String)sess1.get("Bank"));
		setAvail_seat((Long)sess1.get("Avail_Seat"));
		setAvail((Long)sess1.get("Avail"));
		System.out.println(loginid+" "+flightid+" "+flightname+" "+from+" "+to+" "+date+" "+deptime+" "+clas+" "+seat+" "+totPrice+" "+bank+" "+avail_seat+" "+avail);
		if(password.equals(trpassword))
			{
			//totPrice=180.0;
			System.out.println("1212121212121212");
			if(amount>=totPrice)
				{
				Double amountleft=(amount-totPrice);
				Long totseatleft=(avail_seat-seat);
				Long seatleft=(avail-seat);
				int i=0;
				i=dl.AddBooking(loginid,flightid,flightname,from,to,date,deptime,clas,seat,totPrice,bank,accountno,amountleft,totseatleft,seatleft);
				if(i>0)
					{
					System.out.println("Booked");
					setMsg("Your ticket is booked......");
					return "success";
					}
				System.out.println("No Sufficient Amount");
				return "fail";
				}
			setMsg("You have no sufficient amount on your bank account....");
			System.out.println("No Sufficient Amount");
			return "fail";
			}
		setMsg("Your transaction password is incorrect....");
		System.out.println("Wrong password");
		return "fail";
		}
	
	public String RecoverPsw() throws SQLException,ClassNotFoundException
		{
		System.out.println(username+" "+secqus+" "+secans);
		ResultSet rs=dl.RecoverPsw(username, secqus, secans);
		if(rs.next())
			{
			setUsername(rs.getString(1));
			setPassword(rs.getString(2));
			return "success";
			}
		reset();
		setMsg("Your answer is not correct.....");
		return "fail";
		}
	
/*				REGCUST() OK													*/	
	public String RegCust() throws SQLException,ClassNotFoundException
		{
		System.out.println(firstname+" "+lastname+" "+username+" "+password+" "+conpassword+" "+age+" "+gender+" "+address+" "+state+" "+country+" "+email+" "+mobile);
		System.out.println(secqus);
		System.out.println(secans);
		if(password.equals(conpassword))
			{
			int i=0;
			i=dl.RegCust(firstname,lastname,username,password,age,gender,address,state,country,email,mobile,secqus,secans);
			reset();
			if(i>0)
				{
				setMsg("You are registered......");
				return "registersuccess";
				}
			}
		setMsg("Registration fail......");
		return "registerfail";
		}
	
	public String RejectCust() throws SQLException,ClassNotFoundException
		{
		HttpServletRequest request=(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Long id=Long.parseLong(request.getParameter("id"));
		int i=dl.RejectCust(id);
		setMsg("You are rejected........");
		if(i>0)
			{
			return CustMgt();
			}
		return null;
		}
	
	public String SelectCust() throws SQLException,ClassNotFoundException
		{
		System.out.println(custid+custid);
		Long id=Long.parseLong(custid);
		if(id>0)
			{
			ResultSet rs=dl.SelectCust(id);
			if(rs.next())
				{
				setCustid(rs.getString(1));
				setUsername(rs.getString(2));
				setFirstname(rs.getString(3));
				setLastname(rs.getString(4));
				setAge(rs.getLong(5));
				setGender(rs.getString(6));
				setAddress(rs.getString(7));
				setState(rs.getString(8));
				setCountry(rs.getString(9));
				setMobile(rs.getLong(10));
				setEmail(rs.getString(11));
				}
			return "displaycust";
			}
		setMsg("No customer selected........");
		return CustMgt();
		}
	
	public String ShDelFlight() throws SQLException,ClassNotFoundException
		{
		int i=0;
		i=dl.ShDelFlight(fid);
		reset();
		if(i>0)
			{
			return FlightMgt();
			}	
		return null;
		}
	
	public String ShowFl() throws SQLException,ClassNotFoundException
		{
		System.out.println("kkkkkkkkkkkkkkk  "+seat);
		System.out.println(flightid+" "+flightname+" "+from+" "+to+" "+date+" "+deptime+" "+avail_seat);
		Map sess1=ActionContext.getContext().getSession();
		String s1=(String)sess1.get("Class");
		ResultSet rs=dl.ShowFl(flightid,flightname,from,to,date,deptime,avail_seat,s1);
		if(rs.next())	
			{
			setFlightid(rs.getLong(1));
			setFlightname(rs.getString(2));
			setFltype(rs.getString(3));
			setFrom(rs.getString(4));
			setTo(rs.getString(5));
			setDate(rs.getString(6));
			setDeptime(rs.getString(7));
			setArrtime(rs.getString(8));
			setAvail_seat(rs.getLong(9));
			setAvail(rs.getLong(10));
			setCost(rs.getLong(11));
			
/*			setAvail_vip(rs.getLong(10));
			setAvail_gen(rs.getLong(11));
			setAvail_lux(rs.getLong(12));
			setCost_vip(rs.getLong(13));
			setCost_gen(rs.getLong(14));
			setCost_lux(rs.getLong(15));
	*/		}
		return "success";
		}
	
	public String ShowBook() throws SQLException,ClassNotFoundException
		{
		System.out.println(pnrno);
		Map sess1=ActionContext.getContext().getSession();
		LoginAction la;
		vect=new Vector<LoginAction>();
		
		ResultSet rs=dl.ShowBook(pnrno);
		while(rs.next())
			{
			la=new LoginAction();
			la.setPnrno(rs.getLong(1));
			la.setName(rs.getString(2));
			la.setAge(rs.getLong(3));
			la.setGender(rs.getString(4));
			la.setCountry(rs.getString(5));
			la.setIdentityno(rs.getString(6));
			la.setConcession(rs.getString(7));
			vect.addElement(la);
			}
		sess1.put("Vec", vect);
		return "success";
		}
	
	public String ShowFlight() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=dl.ShowFlight(fid,fltype);
		reset();
		LoginAction la;
		Map sess1=ActionContext.getContext().getSession();
		vect=new Vector<LoginAction>();
		while(rs.next())
			{
			la=new LoginAction();
			la.setFlightid(rs.getLong(1));
			la.setFlightname(rs.getString(2));
			la.setFltype(rs.getString(3));
			la.setFrom(rs.getString(4));
			la.setTo(rs.getString(5));
			la.setDate(rs.getString(6));
			la.setDeptime(rs.getString(7));
			vect.addElement(la);
			}
		sess1.put("Vec", vect);
		return "success";
		}
	
	public String SubmitPassanger() throws SQLException,ClassNotFoundException
		{
		System.out.println("SubmitPassanger enters");
		Map sess1=ActionContext.getContext().getSession();
		String id=(String)sess1.get("LOGINID");
		Long loginid=Long.parseLong(id);
		System.out.println(loginid+loginid);
		System.out.println("11111");
		LoginAction la;
		System.out.println("2222222");
		vect=new Vector<LoginAction>();
		System.out.println("33333333");
		ResultSet rs=dl.GetPassenger(loginid);
		while(rs.next())
			{
			System.out.println("44444");
			la=new LoginAction();
			la.setName(rs.getString(2));
			la.setAge(rs.getLong(3));
			la.setGender(rs.getString(4));
			la.setCountry(rs.getString(5));
			la.setSeatfor(rs.getString(6));
			la.setConcession(rs.getString(7));
			la.setIdentityno(rs.getString(8));
			la.setPrice(rs.getDouble(9));
			System.out.println("5555555");
			setTotPrice(totPrice+rs.getDouble(9));
			System.out.println("66666666666");
			vect.addElement(la);
			}
		System.out.println("7777777");
		sess1.put("TotPrice", totPrice);
		System.out.println(sess1.get("TotPrice"));
		sess1.put("Pass", vect);
		return "success";
		}
	
	public String UpdateFlt() throws SQLException,ClassNotFoundException
		{
		Map sess1=ActionContext.getContext().getSession();
		Long id=(Long)sess1.get("ffid");
		String date1=(String)sess1.get("ddate");
		String dptime=(String)sess1.get("ddeptime");
		System.out.println(id+" "+date1+" "+dptime);
		System.out.println(flightid+" "+fltype+" "+date+" "+deptime);
		int i=dl.UpdateFlt(id,date1,dptime,flightid,from,to,date,deptime,arrtime,avail_seat,avail_vip,avail_gen,avail_lux,cost_vip,cost_gen,cost_lux);
		reset();
		if(i>0)
			{
			setMsg("Flight update successful..........");
			return FlightMgt();
			}
		return null;
		}
	
	public String UpdateOwn() throws SQLException,ClassNotFoundException
		{
		Long id=Long.parseLong(custid);
		int i=0;
		i=dl.UpdateOwn(id,firstname,lastname,age,gender,address,state,country,mobile,email);
		if(i>0)
			{
			setMsg("Your Profile is updated.....");
			}
		else
			{
			setMsg("Your Profile is not updated.....");
			}
		return "update";
		}
	
	public String ViewBooking() throws SQLException,ClassNotFoundException
		{
		System.out.println(fid+" "+flightid+" "+from+" "+to+" "+date);
		Map sess1=ActionContext.getContext().getSession();
		ResultSet rs1=dl.ViewBooking1(flightid,from,to,date);
		LoginAction la;
		vect=new Vector<LoginAction>();
		while(rs1.next())
			{
			la=new LoginAction();
			la.setPnrno(rs1.getLong(1));
			la.setCustid(rs1.getString(2));
			la.setFlightid(rs1.getLong(3));
			la.setFlightname(rs1.getString(4));
			la.setDate(rs1.getString(5));
			la.setBookdate(rs1.getString(6));
			la.setSeat(rs1.getLong(7));
			la.setAmount(rs1.getDouble(8));
			la.setBank(rs1.getString(9));
			la.setAccountno(rs1.getLong(10));
			la.setFrom(rs1.getString(11));
			la.setTo(rs1.getString(12));
			la.setDeptime(rs1.getString(13));
			la.setStclas(rs1.getString(14));
			System.out.println(la.pnrno+" "+la.custid+" "+la.flightid+" "+la.flightname+" "+la.date+" "+la.bookdate+" "+la.seat+" "+la.amount+" "+la.bank+" "+la.accountno+" "+la.from+" "+la.to+" "+la.deptime+" "+la.stclas);
			
			vect.addElement(la);
			}
		sess1.put("Vec", vect);
		System.out.println("Put to session");
		ResultSet rs=dl.ViewBooking(flightid,from,to,date);
		System.out.println("ViewBooking");
		reset();
		if(rs.next())
			{
			System.out.println("iffffffffff");
			setFlightid(rs.getLong(1));
			setFlightname(rs.getString(2));
			setFltype(rs.getString(3));
			setTot_seat(rs.getLong(4));
			setTot_vip(rs.getLong(5));
			setTot_gen(rs.getLong(6));
			setTot_lux(rs.getLong(7));
			setFrom(rs.getString(8));
			setTo(rs.getString(9));
			setDate(rs.getString(10));
			setDeptime(rs.getString(11));
			setAvail_seat(rs.getLong(12));
			setAvail_vip(rs.getLong(13));
			setAvail_gen(rs.getLong(14));
			setAvail_lux(rs.getLong(15));
			return "success";
			}
		System.out.println("If pass");
		setMsg("There is no booking.");
		return FlightMgt();
		}
	
	public String ViewFlight() throws SQLException,ClassNotFoundException
		{
		System.out.println(flightid+" "+flightname+" "+fltype+" "+from+" "+to+" "+date+" "+deptime);
		ResultSet rs=dl.ViewFlight(flightid,flightname,fltype,from,to,date,deptime);
		if(rs.next())	
			{
			setFlightid(rs.getLong(1));
			setFlightname(rs.getString(2));
			setFltype(rs.getString(3));
			setTot_seat(rs.getLong(4));
			setTot_vip(rs.getLong(5));
			setTot_gen(rs.getLong(6));
			setTot_lux(rs.getLong(7));
			setFrom(rs.getString(8));
			setTo(rs.getString(9));
			setDate(rs.getString(10));
			setDeptime(rs.getString(11));
			setArrtime(rs.getString(12));
			setAvail_seat(rs.getLong(13));
			setAvail_vip(rs.getLong(14));
			setAvail_gen(rs.getLong(15));
			setAvail_lux(rs.getLong(16));
			setCost_vip(rs.getLong(17));
			setCost_gen(rs.getLong(18));
			setCost_lux(rs.getLong(19));
			}
		return "success";
		}
	
	public String YesSBINet() throws SQLException,ClassNotFoundException
		{
		System.out.println(accountno+" "+amount+" "+trpassword);
		setAccountno(accountno);
		setAmount(amount);
		setTrpassword(trpassword);
		 
		return "success";
		}
	
	public String MyBooking() throws SQLException,ClassNotFoundException
		{
		Map session=ActionContext.getContext().getSession();
		String s1=(String)session.get("LOGINID");
		Long id=Long.parseLong(s1);
		System.out.println(id);
		Map sess1=ActionContext.getContext().getSession();
		LoginAction la;
		rs=dl.MyBooking(id);
		vect=new Vector<LoginAction>();
		while(rs.next())
			{
			la=new LoginAction();
			la.setPnrno(rs.getLong(1));
			la.setCustid(rs.getString(2));
			la.setFlightid(rs.getLong(3));
			la.setFlightname(rs.getString(4));
			la.setDate(rs.getString(5));
			la.setBookdate(rs.getString(6));
			la.setSeat(rs.getLong(7));
			la.setAmount(rs.getDouble(8));
			la.setBank(rs.getString(9));
			la.setAccountno(rs.getLong(10));
			la.setFrom(rs.getString(11));
			la.setTo(rs.getString(12));
			la.setDeptime(rs.getString(13));
			la.setStclas(rs.getString(14));
			System.out.println(la.pnrno+" "+la.custid+" "+la.flightid+" "+la.flightname+" "+la.date+" "+la.bookdate+" "+la.seat+" "+la.amount+" "+la.bank+" "+la.accountno+" "+la.from+" "+la.to+" "+la.deptime+" "+la.stclas);
			
			vect.addElement(la);
			}
		sess1.put("Vec", vect);
		return "success";
		}
	
	
	
	
	
	public String NotCancel() throws SQLException,ClassNotFoundException
		{
		System.out.println(pnrno+" "+custid+" "+flightid+" "+date+" "+deptime+" "+seat+" "+stclas+" "+amount+" "+bank+" "+accountno);
		setMsg("Your ticket is not cancelled");
		return "success";
		}
	
	
	
	
	
	
	
	
	
	public void reset()
		{
		this.firstname="";
		this.lastname="";
		this.username="";
		this.password="";
		this.newpassword="";
		this.gender="";
		this.email="";
		this.address="";
		this.mobile=null;
		this.msg="";
		this.custid="";
		this.fid="";
		this.flightname="";
		this.flightid=null;
		this.from="";
		this.to="";
		this.date="";
		this.arrtime="";
		this.deptime="";
		this.avail_seat=null;
		this.tot_seat=null;
		this.tot_vip=null;
		this.tot_gen=null;
		this.tot_lux=null;
		this.avail_vip=null;
		this.avail_gen=null;
		this.avail_lux=null;
		this.cost_vip=null;
		this.cost_gen=null;
		this.cost_lux=null;
		this.fltype="";
		this.age=null;
		this.country="";
		this.state="";
		this.secqus="";
		this.secans="";
		this.name="";
		this.seatfor="";
		this.concession="";
		this.identityno="";
		this.cost=null;
		this.price=null;
		this.totPrice=null;
		this.accountno=null;
		
		}
	
/*	
	public String RecoverPsw() throws SQLException,ClassNotFoundException
		{
		
		return ;
		}
	
*/
	}
