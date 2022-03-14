package services;

import java.util.Collections;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import app.ApplicationContextProvider;
import components.PartsInventory;
import components.PartsRequiredFor1Bike;

@Service
public class CalculateBicycles {
	

	public int calculate(){
		
		int noOfBikes = 0;
		
		 LinkedHashMap<String, Integer> rp = new LinkedHashMap<>();		 
		 rp.putAll(ApplicationContextProvider.getContext().getBean(PartsRequiredFor1Bike.class).getRequiredParts());
		 
		 LinkedHashMap<String, Integer> pi = new LinkedHashMap<>();
		 pi.putAll(ApplicationContextProvider.getContext().getBean(PartsInventory.class).getParts());
		
		 pi.forEach((k, v) -> rp.merge( k, v, (v1, v2) -> v2/v1 ));
		
		 noOfBikes = Collections.min(rp.values());
		 
		return noOfBikes;
	}

}
