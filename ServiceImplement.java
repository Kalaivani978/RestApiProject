package com.example.demo.ServiceImplement;
import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.demo.Repository.SwiggyRepository;
import com.example.demo.Service.SwiggyService;
import com.example.demo.model.SwiggyModel;
/*
 * All Method Definition is defined in this class.
 */

@Service
public class ServiceImplement implements SwiggyService{

	SwiggyRepository resrepo;        //class type attribute

	public ServiceImplement(SwiggyRepository resrepo) {
		this.resrepo = resrepo;
	}

/*
 * have used save method is used to create.
 */
	@Override
	public SwiggyModel saveHotel(SwiggyModel hotel) {
		return resrepo.save(hotel) ;
	}
/*
 * have used findAll method to display
 */
	@Override
	public List<SwiggyModel> getHotelFromDb() {
		return resrepo.findAll();
	}
/*
 * have used findById method to search.
 */
	@Override
	public SwiggyModel getHotelById(int hotelId) {
		Optional<SwiggyModel>resDetails  = resrepo.findById(hotelId);
		if(resDetails.isPresent()) {
			return resDetails.get();
		}
		else {
			return null;
		}

	}
	/*
	 * have used set and get to set and get the value.
	 */

	@Override
	public SwiggyModel updateHotelDetails(SwiggyModel newHotel, int hotelId) {
		Optional<SwiggyModel>resDetails = resrepo.findById(hotelId);
		if(resDetails.isPresent()) {
			SwiggyModel existingHotel = resDetails.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingHotel.setLocation(newHotel.getLocation());
			existingHotel.setFoodType(newHotel.getFoodType());
			resrepo.save(existingHotel);
			return existingHotel;
		}
		else {
			return null;
		}

	}
	/*
	 * Have used deleteById is used to delete.
	 */

	@Override
	public void deleteHotelById(int hotelId) {
		Optional<SwiggyModel>resDetails = resrepo.findById(hotelId);
		if(resDetails.isPresent()) {
			resrepo.deleteById(hotelId);
		}	

	}

}
