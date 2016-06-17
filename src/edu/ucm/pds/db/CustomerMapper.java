package edu.ucm.pds.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.ucm.pds.beans.Customer;
import edu.ucm.pds.beans.User;

public interface CustomerMapper {

	@Insert("insert into customer (username,password,emailId,role,name,address,location,phoneNum,status) values(#{username},#{password},#{emailId},#{role},#{name},#{address},#{location},#{phoneNum},#{status})")
	public void insertCustomer(Customer customer);

	@Select("select username,password,emailId,role,name,address,location,phoneNum,status from customer where username = #{username} and password=#{password}")
	public Customer validateUser(User user);

}
