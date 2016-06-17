package edu.ucm.pds.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.ucm.pds.beans.Customer;
import edu.ucm.pds.beans.Item;
import edu.ucm.pds.beans.Location;

public interface LocationMapper	 {
	@Insert("insert into location (locationId,locationName) values(#{locationId},#{locationName})")
	public void insertLocation(Location location);

	@Select("select locationId,locationName from location")
	public List<Location> getStores();

	@Delete("delete from location where locationId=#{locationId}")
	public void deleteLocation(Location location);
}
