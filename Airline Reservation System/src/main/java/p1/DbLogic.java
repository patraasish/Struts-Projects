package p1;
import java.sql.*;

public class DbLogic
	{
	ResultSet rs=null;

	public int AddNewFlt(Long flightid,String flightname,String fltype,Long rundays,Long tot_seat,Long tot_vip,Long tot_gen,Long tot_lux) throws SQLException,ClassNotFoundException
		{
		int i=0;
		try{
		i=DbConnect.getStatement().executeUpdate("insert into FLIGHT_INFO values("+flightid+",'"+flightname+"',"+rundays+",'"+fltype+"',"+tot_seat+","+tot_vip+","+tot_gen+","+tot_lux+")");
		System.out.println("Insert to flight_info");
		}catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		return i;
		}
	
	public int AddBooking(Long loginid,Long flightid,String flightname,String from,String to,String date,String deptime,String clas,Long seat,Double totPrice,String bank,Long accountno,Double amountleft,Long totseatleft,Long seatleft) throws SQLException,ClassNotFoundException
		{
		int i=0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		int n=0;
		try{
		Statement st=DbConnect.getStatement();
		if(bank.equals("SBI"))		
			l=st.executeUpdate("update SBI set AMOUNT="+amountleft+" where ACCNO="+accountno+"");
		if(bank.equals("ICICI"))
			l=st.executeUpdate("update ICICI set AMOUNT="+amountleft+" where ACCNO="+accountno+"");
		if(l>0)
			{
			System.out.println("Bank account update");
			if(clas.equals("Vip"))
				{
				System.out.println("Update flight vip");
				m=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+totseatleft+",AVAIL_SEAT_VIP="+seatleft+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");
				}
			if(clas.equals("Gen"))
				{
				System.out.println("Update flight gen");
				m=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+totseatleft+",AVAIL_SEAT_GEN="+seatleft+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");
				}
			if(clas.equals("Lux"))
				{
				System.out.println("Update flight lux");
				m=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+totseatleft+",AVAIL_SEAT_LUX="+seatleft+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");	
				}
			if(m>0)
				{
				i=st.executeUpdate("insert into BOOKING_INFO values(pnrno.nextval,"+loginid+","+flightid+",'"+flightname+"','"+date+"',sysdate,"+seat+","+totPrice+",'"+bank+"',"+accountno+",'"+from+"','"+to+"','"+deptime+"','"+clas+"')");
				n=st.executeUpdate("insert into TEMP_PNR values(pnrno.currval,"+loginid+")");
				if(i>0)
					{
					j=st.executeUpdate("insert into BOOKING_DETAILS (pnrno,name,age,gender,country,IDENTITYNO,concession) select b.PNRNO,t.NAME,t.age,t.gender,t.country,t.IDENTITYNO,t.CONCESSION from TEMP_PNR b, TEMP_PASSENGER t where b.LOGINID=t.LOGINID and b.LOGINID="+loginid+" and t.LOGINID="+loginid+"");
					
					if(j>0)
						{
						System.out.println("Insert to Booking_Details");
						k=st.executeUpdate("delete from TEMP_PASSENGER where LOGINID="+loginid+"");
						k=st.executeUpdate("delete from TEMP_PNR where LOGINID="+loginid+"");
						if(k>0)
							{
							System.out.println("Temp table deleted...");
							}
						}
					}
				}
			}
					
			}catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		return i;
		}	
	
	public int AddFlight(String fid,Long flightid,String from,String to,String date,String deptime,String arrtime,Long avail_seat,Long avail_vip,Long avail_gen,Long avail_lux,Long cost_vip,Long cost_gen,Long cost_lux) throws SQLException,ClassNotFoundException
		{
		int i=0;
		int j=0;
		System.out.println(fid);
		Long id=Long.parseLong(fid);
		try{
		i=DbConnect.getStatement().executeUpdate("insert into FLIGHT_RUNNING values("+id+",'"+from+"','"+to+"','"+date+"','"+deptime+"','"+arrtime+"',"+avail_seat+","+avail_vip+","+avail_gen+","+avail_lux+")");
		System.out.println("Insert to flight_running");
		j=DbConnect.getStatement().executeUpdate("insert into FLIGHT_COST values("+id+",'"+date+"','"+deptime+"',"+cost_vip+","+cost_gen+","+cost_lux+")");
		System.out.println("Insert to flight_cost");	
			}catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		return i;
		}
	
	public int AddPassenger(String name,Long age,String gender,String country,String seatfor,String concession,String identityno,Double c,Long loginid) throws SQLException,ClassNotFoundException
		{
		System.out.println(name+" "+age+" "+gender+" "+country+" "+seatfor+" "+concession+" "+identityno+" "+c);
		int i=0;
		try{
		i=DbConnect.getStatement().executeUpdate("insert into TEMP_PASSENGER values(passid.nextval,'"+name+"',"+age+",'"+gender+"','"+country+"','"+seatfor+"','"+concession+"','"+identityno+"',"+c+","+loginid+")");
		System.out.println("Insert to TEMP_PASSENGER");
		}catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		return i;
		}
	
	public int ApprovedCust(Long id) throws SQLException,ClassNotFoundException
		{
		int i=DbConnect.getStatement().executeUpdate("update USER_LOGIN set userstatus='approved' where loginid="+id+"");
		System.out.println("Update USER_LOGIN ok");
		return i;
		}
	
	public ResultSet BookPatrFlt(Long flightid,String date,String deptime,String stclas,Long seat) throws SQLException,ClassNotFoundException
		{
		if(stclas.equals("Vip"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.COST_VIP from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and r.DOJ='"+date+"' and c.DOJ='"+date+"' and r.deptime='"+deptime+"' and c.deptime='"+deptime+"' and (AVAIL_SEAT_VIP >= "+seat+")");
			return rs;
			}
		if(stclas.equals("Gen"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.COST_GEN from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and r.DOJ='"+date+"' and c.DOJ='"+date+"' and r.deptime='"+deptime+"' and c.deptime='"+deptime+"' and (AVAIL_SEAT_GEN >= "+seat+")");
			return rs;
			}
		if(stclas.equals("Lux"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.COST_LUX from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and r.DOJ='"+date+"' and r.deptime='"+deptime+"' and c.DOJ='"+date+"' and c.deptime='"+deptime+"' and (AVAIL_SEAT_LUX >= "+seat+")");
			return rs;
			}
		return null;
		}
	
	
	
	public int CancelConfirm(Long pnrno,String custid,Long flightid,String date,String deptime,Long seat,String stclas,Double amount,String bank,Long accountno) throws SQLException,ClassNotFoundException
		{
		System.out.println(stclas);
		Statement st=DbConnect.getStatement();
		Long id=Long.parseLong(custid);
		Long avail=(long)0;
		Long availpart=(long)0;
		int i=0;
		int j=0;
		int k=0;
		if(stclas.equals("Vip"))
			{
			ResultSet rs=st.executeQuery("select AVAIL_SEAT,AVAIL_SEAT_VIP  from FLIGHT_RUNNING where flightid="+flightid+" and doj='"+date+"' and deptime='"+deptime+"'");
			if(rs.next())
				{
				System.out.println(rs.getLong(1)+" "+rs.getLong(2));
				avail=rs.getLong(1);
				availpart=rs.getLong(2);
				}
			avail=avail+seat;
			availpart=availpart+seat;
			i=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+avail+",AVAIL_SEAT_VIP="+availpart+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME ='"+deptime+"'");
			System.out.println("Flight running updated");
			}
		if(stclas.equals("Gen"))
			{
			ResultSet rs=st.executeQuery("select AVAIL_SEAT,AVAIL_SEAT_GEN  from FLIGHT_RUNNING where flightid="+flightid+" and doj='"+date+"' and deptime='"+deptime+"'");
			if(rs.next())
				{
				System.out.println(rs.getLong(1)+" "+rs.getLong(2));
				avail=rs.getLong(1);
				availpart=rs.getLong(2);
				}
			avail=avail+seat;
			availpart=availpart+seat;
			i=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+avail+",AVAIL_SEAT_GEN="+availpart+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");
			System.out.println("Flight running updated");
			}
		if(stclas.equals("Lux"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select AVAIL_SEAT,AVAIL_SEAT_LUX  from FLIGHT_RUNNING where flightid="+flightid+" and doj='"+date+"' and deptime='"+deptime+"'");
			if(rs.next())
				{
				System.out.println(rs.getLong(1)+" "+rs.getLong(1));
				avail=rs.getLong(1);
				availpart=rs.getLong(2);
				}
			avail=avail+seat;
			availpart=availpart+seat;
			i=st.executeUpdate("update FLIGHT_RUNNING set AVAIL_SEAT="+avail+",AVAIL_SEAT_LUX="+availpart+" where FLIGHTID="+flightid+" and DOJ='"+date+"' and DEPTIME ='"+deptime+"'");
			System.out.println("Flight running updated");
			}
		if(i>0)
			{
			j=st.executeUpdate("delete from BOOKING_INFO where PNRNO="+pnrno+"");
			System.out.println("delete from booking");
			if(j>0)
				{
				Double d=(double)0;
				if(bank.equals("SBI"))
					{
					ResultSet rs=st.executeQuery("select AMOUNT from SBI where ACCNO="+accountno+"");
					if(rs.next())
						{
						d=rs.getDouble(1);
						}
					d=d+amount;
					k=st.executeUpdate("update SBI set AMOUNT="+d+" where ACCNO="+accountno+"");
					System.out.println("Bank updated");
					}
				if(bank.equals("ICICI"))
					{
					ResultSet rs=st.executeQuery("select AMOUNT from ICICI where ACCNO="+accountno+"");
					if(rs.next())
						{
						d=rs.getDouble(1);
						}
					d=d+amount;
					k=st.executeUpdate("update ICICI set AMOUNT="+d+" where ACCNO="+accountno+"");
					System.out.println("Bank updated");
					}
				}
			}
		return k;
		}
	
	public ResultSet Cancellation(Long id,Long pnrno) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select * from BOOKING_INFO where loginid="+id+" and pnrno="+pnrno+"");
		return rs;
		}
	
	public int ChangePass(Long loginid,String password,String newpassword) throws SQLException,ClassNotFoundException
		{
		int i=DbConnect.getStatement().executeUpdate("update USER_LOGIN set  password='"+newpassword+"' where loginid="+loginid+" and password='"+password+"'");
		return i;
		}
	
	public ResultSet ChangePsw(Long loginid) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select loginid,username from USER_LOGIN where loginid="+loginid+"");
		return rs;
		}
	
	public ResultSet CheckFare(Long flightid,String from,String to,String date,String stclas) throws SQLException,ClassNotFoundException
		{
		if(stclas.equals("Vip"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.cost_vip from flight_info i,flight_running r,flight_cost c where i.flightid=r.flightid and i.flightid=c.flightid and r.DOJ='"+date+"' and c.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and i.flightid="+flightid+"");
			return rs;
			}
		if(stclas.equals("Gen"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.cost_gen from flight_info i,flight_running r,flight_cost c where i.flightid=r.flightid and i.flightid=c.flightid and r.DOJ='"+date+"' and c.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and i.flightid="+flightid+"");
			return rs;
			}
		if(stclas.equals("Lux"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,c.cost_lux from flight_info i,flight_running r,flight_cost c where i.flightid=r.flightid and i.flightid=c.flightid and r.DOJ='"+date+"' and c.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and i.flightid="+flightid+"");
			return rs;
			}
		return null;
		}
	
	public ResultSet CheckFlt(String from,String to,String date,String stclas,Long seat) throws SQLException,ClassNotFoundException
		{
		System.out.println(from+"  "+to+"  "+date+"  "+stclas+"  "+seat);
		if(stclas.equals("Vip"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,i.tot_seat,r.avail_seat from flight_info i,flight_running r where i.flightid=r.flightid and r.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and (AVAIL_SEAT_VIP >= "+seat+")");
			return rs;
			}
		if(stclas.equals("Gen"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,i.tot_seat,r.avail_seat from flight_info i,flight_running r where i.flightid=r.flightid and r.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and (AVAIL_SEAT_GEN >= "+seat+")");
			return rs;
			}
		if(stclas.equals("Lux"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,r.source,r.destination,r.doj,r.deptime,i.tot_seat,r.avail_seat from flight_info i,flight_running r where i.flightid=r.flightid and r.DOJ='"+date+"' and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and (AVAIL_SEAT_LUX >= "+seat+")");
			return rs;
			}
		return null;
		}
	
	public ResultSet CustMgt() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select * from USER_LOGIN where usertype='customer'");
		return rs;
		}
	
	public int DelPerFlightInfo(Long flightid,String date,String deptime) throws SQLException,ClassNotFoundException
		{
		int i=0;
		int j=0;
		Statement st=DbConnect.getStatement();
		try{
		i=st.executeUpdate("delete from FLIGHT_RUNNING where flightid="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");
		j=st.executeUpdate("delete from FLIGHT_COST where flightid="+flightid+" and DOJ='"+date+"' and DEPTIME='"+deptime+"'");
		}catch (Exception e) {
			e.printStackTrace();
			}
		return i;
		}
	
	public ResultSet EditOwn(Long loginid) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select l.loginid,l.username,i.firstname,i.lastname,i.age,i.gender,i.address,i.state,i.country,i.mobile,i.email from USER_LOGIN l,USER_INFO i where l.loginid=i.loginid and l.loginid="+loginid+"");
		return rs;
		}

	public ResultSet EditPerFlight(Long flightid,String date,String deptime) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime,r.arrtime,i.TOT_SEAT,r.AVAIL_SEAT,i.TOT_SEAT_vip,r.AVAIL_SEAT_VIP,i.TOT_SEAT_gen,r.AVAIL_SEAT_gen,i.TOT_SEAT_lux,r.AVAIL_SEAT_lux,c.COST_vip,c.COST_gen,c.COST_lux from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"'");
		return rs;
		}
	
	public ResultSet FlightMgt() throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select * from flight_info order by FLIGHTID");
		return rs;
		}
	
	public ResultSet ForgotPsw(String username) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select username,SECQUS from USER_LOGIN where username='"+username+"'");
		return rs;
		}
	
	public ResultSet GetFlightName(Long flightid1) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select flightname from FLIGHT_INFO where FLIGHTID="+flightid1+"");
		return rs;
		}
	
	public ResultSet GetPassenger(Long loginid) throws SQLException,ClassNotFoundException
		{
		System.out.println("getpass");
		rs=DbConnect.getStatement().executeQuery("select * from TEMP_PASSENGER where LOGINID="+loginid+" order by PASSID");
		return rs;
		}
	
	public ResultSet Login(String username,String password,String usertype) throws SQLException,ClassNotFoundException
		{
		if(usertype.equals("admin"))
			{
			rs=DbConnect.getStatement().executeQuery("select * from admin where username='"+username+"' and password='"+password+"' and usertype='"+usertype+"'");
			return rs;
			}
		rs=DbConnect.getStatement().executeQuery("select l.*,i.FIRSTNAME,i.LASTNAME  from USER_LOGIN l,USER_INFO i where l.LOGINID=i.LOGINID and username='"+username+"' and password='"+password+"' and usertype='"+usertype+"'");
		return rs;
		}
	
	public ResultSet LoginBank(Long accountno,String username,String password,String bank) throws SQLException,ClassNotFoundException
		{
		if(bank.equals("SBI"))
			{
			System.out.println("SBI");
			rs=DbConnect.getStatement().executeQuery("select s.accno,s.name,s.amount,n.trpassword from SBI s,SBINET n where s.accno=n.accno and s.ACCNO="+accountno+" and n.accno="+accountno+" and username='"+username+"' and password='"+password+"' ");
			return rs;
			}
		if(bank.equals("ICICI"))
			{
			System.out.println("ICICI");
			rs=DbConnect.getStatement().executeQuery("select s.accno,s.name,s.amount,n.trpassword from ICICI s,ICICINET n where s.accno=n.accno and s.ACCNO="+accountno+" and n.accno="+accountno+" and username='"+username+"' and password='"+password+"' ");
			return rs;
			}
		return null;
		}
	
	public ResultSet MyBooking(Long id) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select * from BOOKING_INFO where loginid="+id+"");
		return rs;
		}
	
	public ResultSet MyProfile(Long loginid) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select l.loginid,l.username,i.firstname,i.lastname,i.age,i.gender,i.address,i.state,i.country,i.mobile,i.email from USER_LOGIN l,USER_INFO i where l.loginid=i.loginid and l.loginid="+loginid+"");
		return rs;
		}
	
	public ResultSet RecoverPsw(String username,String secqus,String secans) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select username,password from USER_LOGIN where username='"+username+"' and SECQUS='"+secqus+"' and SECANS='"+secans+"'");
		return rs;
		}
	
	public int RegCust(String firstname,String lastname,String username,String password,Long age,String gender,String address,String state,String country,String email,Long mobile,String secqus,String secans) throws SQLException
		{
		int i=0;
		int j=0;
		try	{
			Statement st=DbConnect.getStatement();
			i=st.executeUpdate("insert into USER_LOGIN values(loginid1.nextval,'"+username+"','"+password+"','customer','notapproved','"+secqus+"','"+secans+"')");
			j=st.executeUpdate("insert into USER_INFO values(custid1.nextval,'"+firstname+"','"+lastname+"',"+age+",'"+gender+"','"+address+"','"+state+"','"+country+"',"+mobile+",'"+email+"',loginid1.currval)");
			}catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		return i;
		}
	
	public int RejectCust(Long id) throws SQLException,ClassNotFoundException
		{
		int j=DbConnect.getStatement().executeUpdate("delete from student_info where loginid="+id+"");
		int i=DbConnect.getStatement().executeUpdate("delete from USER_LOGIN where loginid="+id+"");
		return i;
		}
	
	public ResultSet SelectCust(Long id) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select l.loginid,l.username,c.firstname,c.lastname,c.age,c.gender,c.address,c.state,c.country,c.mobile,c.email from USER_LOGIN l,USER_INFO c where l.loginid=c.loginid and l.loginid="+id+"");
		return rs;
		}
	
	public int ShDelFlight(String fid) throws SQLException,ClassNotFoundException
		{
		System.out.println(fid);
		Long id=Long.parseLong(fid);
		int i=DbConnect.getStatement().executeUpdate("delete from flight_info where flightid="+id+"");
		return i;
		}
	
	public ResultSet ShowBook(Long pnrno) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select * from BOOKING_DETAILS where PNRNO="+pnrno+"");
		return rs;
		}
		
	public ResultSet ShowFl(Long flightid,String flightname,String from,String to,String date,String deptime,Long avail_seat,String s1) throws SQLException,ClassNotFoundException
		{
		if(s1.equals("Vip"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime,r.arrtime,r.AVAIL_SEAT,r.AVAIL_SEAT_VIP,c.COST_vip from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and i.flightname='"+flightname+"' and r.source='"+from+"' and r.destination='"+to+"' and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"' and r.AVAIL_SEAT="+avail_seat+"");
			return rs;
			}
		if(s1.equals("Gen"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime,r.arrtime,r.AVAIL_SEAT,r.AVAIL_SEAT_gen,c.COST_gen from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and i.flightname='"+flightname+"' and r.source='"+from+"' and r.destination='"+to+"' and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"' and r.AVAIL_SEAT="+avail_seat+"");
			return rs;
			}
		if(s1.equals("Lux"))
			{
			ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime,r.arrtime,r.AVAIL_SEAT,r.AVAIL_SEAT_lux,c.COST_lux from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and i.flightname='"+flightname+"' and r.source='"+from+"' and r.destination='"+to+"' and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"' and r.AVAIL_SEAT="+avail_seat+"");
			return rs;
			}
		return null;
//		ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime,r.arrtime,r.AVAIL_SEAT,r.AVAIL_SEAT_VIP,r.AVAIL_SEAT_gen,r.AVAIL_SEAT_lux,c.COST_vip,c.COST_gen,c.COST_lux from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and i.flightname='"+flightname+"' and r.source='"+from+"' and r.destination='"+to+"' and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"' and r.AVAIL_SEAT="+avail_seat+"");
//		return rs;
		}
	
	public ResultSet ShowFlight(String fid,String fltype) throws SQLException,ClassNotFoundException
		{
		Long id=Long.parseLong(fid);
		String flnm=null;
		ResultSet rs1=DbConnect.getStatement().executeQuery("select flightname from flight_info where flightid="+id+"");
		if(rs1.next())
			{
			flnm=rs1.getString(1);
			}
		ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,r.source,r.destination,r.doj,r.deptime from flight_info i,flight_running r where i.flightid=r.flightid and i.flightname='"+flnm+"' and flight_type='"+fltype+"'");
		return rs;
		}
	
	public int UpdateFlt(Long id,String date1,String dptime,Long flightid,String from,String to,String date,String deptime,String arrtime,Long avail_seat,Long avail_vip,Long avail_gen,Long avail_lux,Long cost_vip,Long cost_gen,Long cost_lux) throws SQLException,ClassNotFoundException
		{
		int i=0;
		int j=0;
		Statement st=null;
		try{
		st=DbConnect.getStatement();
		i=st.executeUpdate("update FLIGHT_RUNNING set SOURCE='"+from+"',DESTINATION='"+to+"',DOJ='"+date+"',DEPTIME='"+dptime+"',ARRTIME='"+arrtime+"',AVAIL_SEAT="+avail_seat+",AVAIL_SEAT_VIP="+avail_vip+",AVAIL_SEAT_GEN="+avail_gen+",AVAIL_SEAT_LUX="+avail_lux+" where FLIGHTID="+id+" and DOJ='"+date1+"' and DEPTIME='"+dptime+"'");
		j=st.executeUpdate("update FLIGHT_COST set DOJ='"+date+"',DEPTIME='"+dptime+"',COST_VIP="+cost_vip+",COST_GEN="+cost_gen+",COST_LUX="+cost_lux+" where FLIGHTID="+id+" and DOJ='"+date1+"' and DEPTIME='"+dptime+"'");
		}catch (Exception e) {
			e.printStackTrace();
			}
		return i;
		}
	
	public int UpdateOwn(Long id,String firstname,String lastname,Long age,String gender,String address,String state,String country,Long mobile,String email) throws SQLException,ClassNotFoundException
		{
		int i=DbConnect.getStatement().executeUpdate("update USER_INFO set firstname='"+firstname+"',lastname='"+lastname+"',age="+age+",gender='"+gender+"',address='"+address+"',state='"+state+"',country='"+country+"',mobile="+mobile+",email='"+email+"' where loginid="+id+"");
		return i;
		}
	
	public ResultSet ViewBooking(Long flightid,String from,String to,String date) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select i.FLIGHTID,i.FLIGHTNAME,i.FLIGHT_TYPE,i.TOT_SEAT,i.TOT_SEAT_VIP,i.TOT_SEAT_GEN,i.TOT_SEAT_LUX,r.SOURCE,r.DESTINATION,r.DOJ,r.DEPTIME,r.AVAIL_SEAT,r.AVAIL_SEAT_VIP,r.AVAIL_SEAT_GEN,r.AVAIL_SEAT_LUX from FLIGHT_INFO i,FLIGHT_RUNNING r where i.FLIGHTID=r.FLIGHTID and i.FLIGHTID="+flightid+" and r.SOURCE='"+from+"' and r.DESTINATION='"+to+"' and r.DOJ='"+date+"'");
		return rs;
		}

	public ResultSet ViewBooking1(Long flightid,String from,String to,String date) throws SQLException,ClassNotFoundException
		{
		rs=DbConnect.getStatement().executeQuery("select * from BOOKING_INFO where FLIGHTID="+flightid+" and SOURCE='"+from+"' and DESTINATION='"+to+"' and DOJ='"+date+"'");
		return rs;
		}
	
	public ResultSet ViewFlight(Long flightid,String flightname,String fltype,String from,String to,String date,String deptime) throws SQLException,ClassNotFoundException
		{
		ResultSet rs=DbConnect.getStatement().executeQuery("select i.flightid,i.flightname,i.flight_type,i.TOT_SEAT,i.TOT_SEAT_vip,i.TOT_SEAT_gen,i.TOT_SEAT_lux,r.source,r.destination,r.doj,r.deptime,r.arrtime,r.AVAIL_SEAT,r.AVAIL_SEAT_VIP,r.AVAIL_SEAT_gen,r.AVAIL_SEAT_lux,c.COST_vip,c.COST_gen,c.COST_lux from flight_info i,flight_running r,FLIGHT_COST c where i.flightid=r.flightid and i.flightid=c.flightid and i.flightid="+flightid+" and i.flightname='"+flightname+"' and i.flight_type='"+fltype+"' and r.source='"+from+"' and r.destination='"+to+"' and r.doj='"+date+"' and r.deptime='"+deptime+"' and c.doj='"+date+"' and c.deptime='"+deptime+"'");
		return rs;
		}
	}
