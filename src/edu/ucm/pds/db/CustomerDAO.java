package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.ucm.pds.beans.Customer;
import edu.ucm.pds.beans.Location;
import edu.ucm.pds.beans.User;
import edu.ucm.pds.mybatis.MybatisUtil;

public class CustomerDAO {

	public Boolean insertCustomer(Customer customer){
		Boolean isInserted = false;
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			CustomerMapper cmapper = sqlSession.getMapper(CustomerMapper.class);
			cmapper.insertCustomer(customer);
			sqlSession.commit();
			isInserted = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			sqlSession.close();
		}
		return isInserted;
	}

	public Customer validateUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			CustomerMapper cmapper = sqlSession.getMapper(CustomerMapper.class);
			return cmapper.validateUser(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}
	public static void main(String[] args) {
		CustomerDAO cdao = new CustomerDAO();
		
		Customer cust = new Customer();
		
		cust.setUsername("cust");
		cust.setPassword("pass");
		cust.setName("Raja");
		cust.setEmailId("raja@gmail.com");
		cust.setRole(1);
		cdao.insertCustomer(cust);
		
	}
}
