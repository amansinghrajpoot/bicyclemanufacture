package services;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import app.ApplicationContextProvider;
import components.PartsInventory;
import components.PartsRequiredFor1Bike;

@Service
public class CalculateRequiredInventory {
	
	public LinkedHashMap<String, Integer> calculate(int noOfBikes ){
		
		LinkedHashMap<String, Integer> rp = new LinkedHashMap<>();		 
		rp.putAll(ApplicationContextProvider.getContext().getBean(PartsRequiredFor1Bike.class).getRequiredParts());
		 
		LinkedHashMap<String, Integer> pi = new LinkedHashMap<>();
		pi.putAll(ApplicationContextProvider.getContext().getBean(PartsInventory.class).getParts());
		
		pi.forEach((k, v) -> rp.merge( k, v, (v1, v2) -> { int t = (v1*noOfBikes)  - (v2);
				                                           if (t > 0) return t; else return 0; }) );
		 
		return rp;
		
	}

}
