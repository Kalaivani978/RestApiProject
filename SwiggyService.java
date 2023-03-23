package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.SwiggyModel;

/*
 * Method declaration is declared in this interface SwiggyService.
 */
public interface SwiggyService {

	SwiggyModel saveHotel(SwiggyModel hotel);
	List<SwiggyModel>  getHotelFromDb();
	

	SwiggyModel getHotelById(int hotelId);
	SwiggyModel updateHotelDetails(SwiggyModel hotel, int hotelId);
	void deleteHotelById(int hotelId);

}
