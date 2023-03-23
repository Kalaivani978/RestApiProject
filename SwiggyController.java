package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImplement.ServiceImplement;
import com.example.demo.model.SwiggyModel;
/*
 * @Restcontroller(combination of Responsebody and controller)
 * @RequestMapping(the respective mapping link is in the bracket)
 * @PostMapping is used to add the detail
 * @GetMapping is used to display
 * @PutMapping is used to update the detail.
 * @DeleteMapping is used to delete the detail.
 */
@RestController
@RequestMapping("/Swiggy.com")
public class SwiggyController {


		public ServiceImplement resServ;
		public SwiggyController(ServiceImplement resServ) {
			this.resServ=resServ;


		}
		@PostMapping("/addResDetails")//create and save
		public ResponseEntity<SwiggyModel> saveHotel(@RequestBody SwiggyModel hotel){
			return new ResponseEntity<SwiggyModel>(resServ.saveHotel(hotel), HttpStatus.CREATED);
		}

		@GetMapping("/readResDetails")
		public List<SwiggyModel> getAllHotel(){
			return resServ.getHotelFromDb();
		}

		@GetMapping("/readResDetails/{id}")
		public ResponseEntity<SwiggyModel>  gethotelById(@PathVariable("id")  int hotelId){
			return new ResponseEntity<SwiggyModel>(resServ.getHotelById(hotelId), HttpStatus.OK);
		}

		@PutMapping("/updateResDetails/{restaurantId}")
		public ResponseEntity<SwiggyModel> updatehotelById(@PathVariable("restaurantId") int id,
				@RequestBody SwiggyModel hotel){
			return new ResponseEntity<SwiggyModel>(resServ.updateHotelDetails(hotel, id), HttpStatus.OK);
		}


		@DeleteMapping("/deleteResDetails/{id}")
		public ResponseEntity<String> deletehotelById(@PathVariable("id")  int hotelId){
			resServ.deleteHotelById(hotelId);
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		}

	
}
