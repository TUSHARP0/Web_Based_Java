package dao;

import java.sql.SQLException;

import pojo.Users;

public interface UserDao {
	
	Users authenticateUser(String email,String password) throws SQLException;
	
	String registeredUser(String firstName,String lastName,String email,String password,String dob) throws SQLException;
}
