package extension;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PConstants;
import processing.core.PGraphics;


public class CountryMarker extends SimplePointMarker{
	// country id
	String id = null;
	
//	// for ShapeFeature
//	CountryMarker(Feature country) {
//		super();
//		ShapeFeature f = (ShapeFeature) country;
//		Marker marker = new SimplePolygonMarker(f.getLocations(), f.getProperties());
//		this.addMarkers(marker);
//		this.id = f.getId();
//	}
//	
//	// for MultiFeature
//	CountryMarker(MultiFeature multiFeature) {
//		List<Feature> features = multiFeature.getFeatures();
//		this.id = multiFeature.getId();
//		for(Feature feature: features) {
//			ShapeFeature f = (ShapeFeature) feature;
//			SimplePolygonMarker marker = new SimplePolygonMarker(f.getLocations(), f.getProperties());
//			this.addMarkers(marker);
//		}
//	}
	
	CountryMarker(Feature feature) {
		super(((PointFeature)feature).getLocation(), feature.getProperties());
	}
	
	// return the country id of marker
	public String getId() {
		return this.id;
	}
	
	public void draw(PGraphics pg, float x, float y) {
		pg.fill(255, 0, 0);
		pg.rect(x, y, 4, 4);
		if(selected) {
			String country = "Country:"+getCountry();
			String income = "Income:"+getIncome();
			String enrollment = "Enrollment:"+getEnrollment();
			String status = "Status:"+getStatus();
		
			pg.fill(255);
			pg.rect(x, y, 165, 65);
			
			pg.fill(0);
			pg.textSize(11);
			pg.textAlign(PConstants.LEFT);
			pg.text(country, x+6, y+18);
			pg.text(income, x+6, y+32);
			pg.text(status, x+6, y+46);;
			pg.text(enrollment, x+6, y+60);
			
		}
	}
	
	private String getCountry() {
		return getStringProperty("country");
	}
	
	private String getIncome() {
		return getStringProperty("income");
	}
	
	private String getEnrollment() {
		return getStringProperty("enrollment");
	}
	
	private String getStatus() {
		return getStringProperty("status");
	}
}
