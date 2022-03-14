package components;


import java.util.LinkedHashMap;


import org.springframework.stereotype.Component;

/*
 *  Author: Aman Rajput
 */

// This component keep tracks of inventory 

@Component
public class PartsInventory {

	private LinkedHashMap<String, Integer> parts;
	
	
	public PartsInventory() {
		super();
		this.parts = new LinkedHashMap<String, Integer>();
		this.parts.put("seats", 0);
		this.parts.put("frames", 0);
		this.parts.put("brakesets", 0);
		this.parts.put("handlebars", 0);
		this.parts.put("wheels", 0);
		this.parts.put("tires", 0);
		this.parts.put("chains", 0);
		this.parts.put("crankset", 0);
		this.parts.put("paddles", 0);
		
	}
   
	
	

	public LinkedHashMap<String, Integer> getParts() {
		return parts;
	}




	public void setParts(LinkedHashMap<String, Integer> parts) {
		this.parts = parts;
	}




	@Override
	public String toString() {
		return "PartsInventory [parts=" + parts + "]";
	}


	
	
	
	
}
