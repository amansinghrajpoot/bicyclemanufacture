package components;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

@Component
public class PartsRequiredFor1Bike {
	
	private LinkedHashMap<String, Integer> partsrequired;
	
	

	public PartsRequiredFor1Bike() {
		super();
		this.partsrequired = new LinkedHashMap<String, Integer>();
		this.partsrequired.put("seats", 1);
		this.partsrequired.put("frames", 1);
		this.partsrequired.put("brakesets", 2);
		this.partsrequired.put("handlebars", 1);
		this.partsrequired.put("wheels", 2);
		this.partsrequired.put("tires", 2);
		this.partsrequired.put("chains", 1);
		this.partsrequired.put("crankset", 1);
		this.partsrequired.put("paddles", 2);
		
	}

	public LinkedHashMap<String, Integer> getRequiredParts() {
		return partsrequired;
	}

	public void setPartsrequired(LinkedHashMap<String, Integer> partsrequired) {
		this.partsrequired = partsrequired;
	}
	
	

}
