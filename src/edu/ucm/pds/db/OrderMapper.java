package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.ucm.pds.beans.Order;

public interface OrderMapper {

	@Insert("insert into order (orderId,itemId,paymentStatus,orderCreated,deliveryDate,total,locationId) values(#{orderId},#{itemId},#{paymentStatus},#{orderCreated},#{deliveryDate},#{total},#{locationId})")
	public void insertOrder(Order order);

	@Select("select orderId,itemId,paymentStatus,orderCreated,deliveryDate,total,locationId from order")
	public List<Order> getOrders();

}
