package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.ucm.pds.beans.Item;

public interface ItemMapper {
	
	@Insert("insert into item (itemId,itemName,itemDesc,price,qty,type,status) values(#{itemId},#{itemName},#{itemDesc},#{price},#{qty},#{type},#{status})")
	public void insertItem(Item item);

	@Select("select itemId,itemName,itemDesc,price,qty,type,status from item")
	public List<Item> getItems();
	
	@Delete("delete from item where itemid=#{itemId}")
	public void deleteItem(Item item);
	
}
