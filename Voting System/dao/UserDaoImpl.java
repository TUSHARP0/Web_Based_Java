package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import pojo.Users;

public class UserDaoImpl implements UserDao{

	//pst3=cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
	
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
		
	public UserDaoImpl() throws SQLException {
		cn=openConnection();
		pst1=cn.prepareStatement("Select * from users where email=? and password=?");
		pst2=cn.prepareStatement("insert into users values(default,?,?,?,?,?,0,'voter')");
		System.out.println("Dao is created");
	}
	@Override
	public Users authenticateUser(String email,String password) throws SQLException{
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next()) {
				//// id | first_name | last_name | email| password | dob| status | role
				return new Users(rst.getInt(1),rst.getString(2),rst.getString(3),email,password,rst.getDate(6),rst.getBoolean(7),rst.getString(8));
			}
		}
		return null;
	}
	
	@Override
	public String registeredUser(String firstName,String lastName,String email,String password,String dob) throws SQLException{
		
		Date sqlDate=Date.valueOf(dob);
		LocalDate d=LocalDate.parse(dob);
		int years=Period.between(d, LocalDate.now()).getYears();
		if(years>=21) {
			pst2.setString(1, firstName);
			pst2.setString(2, lastName);
			pst2.setString(3, email);
			pst2.setString(4, password);
			pst2.setDate(5, sqlDate);
			
			int insert=pst2.executeUpdate();
			if(insert==1) {
				return "Success";
			}else {
				return"Can't Insert";
			}
			
		}else {
		return "Can't Insert";
		}
        
 	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null) {
			pst1.close();
			closeConnection();
			System.out.println("Dao connection is closed");
		}
	}
	
}
