package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.ucm.pds.beans.Order;
import edu.ucm.pds.mybatis.MybatisUtil;

public class OrderDAO {

	public Boolean insertOrder(Order order){
		Boolean isInserted = false;
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			OrderMapper ordermapper = sqlSession.getMapper(OrderMapper.class);
			ordermapper.insertOrder(order);
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

	public List<Order> getOrders() {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			OrderMapper ordermapper = sqlSession.getMapper(OrderMapper.class);
			return ordermapper.getOrders();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}


}
