package controllers;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.ApplicationContextProvider;
import components.PartsInventory;
import components.PartsRequiredFor1Bike;
import services.CalculateBicycles;
import services.CalculateRequiredInventory;

@RestController
public class BicycleController {
	
	@GetMapping("/getpartsinventory")
	public  Map<String, Integer> getPartsInventory() {

	     return ApplicationContextProvider.getContext().getBean(PartsInventory.class).getParts();
	}
	
	@GetMapping("/getpartsrequiredfor1bike")
	public LinkedHashMap<String, Integer> getPartsRequiredFor1Bike(){
		
		return ApplicationContextProvider.getContext().getBean(PartsRequiredFor1Bike.class).getRequiredParts();
	}
	
	@GetMapping("/calculatebikes/{bikes}")
	public String calculateBikes(@PathVariable int bikes) {
		return "Number of Bicycles which can be produced with current inventory: "
	    + ApplicationContextProvider.getContext().getBean(CalculateBicycles.class).calculate()
	    + "\n"
	    +"Number of parts required to produce "+bikes+" Bikes: \n"
	    + ApplicationContextProvider.getContext().getBean(CalculateRequiredInventory.class).
	    calculate(bikes);
	}
	@PutMapping("/updatepartsinventory")
	public void updatePartsInventory(@RequestBody PartsInventory partsinventory) {
		
		PartsInventory pi = ApplicationContextProvider.getContext().getBean(PartsInventory.class);
		pi.setParts(partsinventory.getParts());
	}
	
	@PutMapping("/updatepartsrequiredfor1bike")
	public void updatepartsrequiredfor1bike(@RequestBody PartsRequiredFor1Bike requiredparts) {
		
		PartsRequiredFor1Bike rp = ApplicationContextProvider.getContext().getBean(PartsRequiredFor1Bike.class);
		rp.setPartsrequired(requiredparts.getRequiredParts());
	}
	

}
