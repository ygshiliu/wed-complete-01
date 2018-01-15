package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.City;
import com.atguigu.bean.District;
import com.atguigu.bean.Province;
import com.atguigu.dao.CityDao;
import com.atguigu.dao.DistrictDao;
import com.atguigu.dao.ProvinceDao;

public class TestDao {

	ProvinceDao provinceDao = new ProvinceDao();
	CityDao cityDao = new CityDao();
	DistrictDao districtDao = new DistrictDao();
	
	@Test
	public void test01(){
		List<City> cityByProId = cityDao.getCityByProId("1");
		
		for (City city : cityByProId) {
			System.out.println(city);
		}
	}
	
	@Test
	public void testDao() {
		
		List<Province> provinceList = provinceDao.getProvinceList();
		
		for (Province province : provinceList) {
			
			System.out.println(province);
			
		}
		
		List<City> cityByProId = cityDao.getCityByProId("1");
		
		for (City city : cityByProId) {
			System.out.println(city);
		}
		
		cityByProId = cityDao.getCityByProId("2");
		for (City city : cityByProId) {
			System.out.println(city);
		}
		cityByProId = cityDao.getCityByProId("3");
		for (City city : cityByProId) {
			System.out.println(city);
		}
		
		for (District district : districtDao.getListByCityId("1")) {
			System.out.println(district);	
		}
		for (District district : districtDao.getListByCityId("2")) {
			System.out.println(district);	
		}
		for (District district : districtDao.getListByCityId("3")) {
			System.out.println(district);	
		}
		for (District district : districtDao.getListByCityId("4")) {
			System.out.println(district);	
		}
	}

}
