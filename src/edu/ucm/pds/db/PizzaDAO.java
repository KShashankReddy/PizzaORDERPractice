package edu.ucm.pds.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.ucm.pds.beans.Item;
import edu.ucm.pds.beans.Order;
import edu.ucm.pds.mybatis.MybatisUtil;

public class PizzaDAO {

	public Boolean insertPizza(Item item){
		Boolean isInserted = false;
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			ItemMapper itemmapper = sqlSession.getMapper(ItemMapper.class);
			itemmapper.insertItem(item);
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

	public List<Item> getItems() {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			ItemMapper itemmapper = sqlSession.getMapper(ItemMapper.class);
			return itemmapper.getItems();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}

	public void deleteItem(Item item) {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			ItemMapper itemmapper = sqlSession.getMapper(ItemMapper.class);
			itemmapper.deleteItem(item);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}

	public static void main(String[] args) {
		
		PizzaDAO pdao = new PizzaDAO();
System.out.println(pdao.getItems());
	}

}
