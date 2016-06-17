package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.ucm.pds.beans.Item;
import edu.ucm.pds.beans.Location;
import edu.ucm.pds.mybatis.MybatisUtil;

public class LocationDAO {
	
	
	public Boolean insertLocation(Location location ){
		Boolean isInserted = false;
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			LocationMapper locationmapper = sqlSession.getMapper(LocationMapper.class);
			locationmapper.insertLocation(location);
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

	public List<Location> getLocations() {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			LocationMapper locationmapper = sqlSession.getMapper(LocationMapper.class);
			return locationmapper.getStores();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return null;
	}

	public void deleteLocation(Location location) {
		SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
		try{
			LocationMapper locationmapper = sqlSession.getMapper(LocationMapper.class);
			locationmapper.deleteLocation(location);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}

}
