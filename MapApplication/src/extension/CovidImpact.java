package extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;
import processing.core.PGraphics;

public class CovidImpact extends PApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String fileName = "covid-data.csv";
	HashMap<String , Feature> impact;
	List<Feature> countries;
	List<Marker> countryMarkers;
	List<Marker> countryPointMarkers;
	UnfoldingMap map;
	private CountryMarker lastSelected;
	PGraphics pg;
	
	public void setup() {
		size(900, 700, OPENGL);
		map = new UnfoldingMap(this,200, 50, 650, 600, new Microsoft.RoadProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		impact = ParseFeed.loadCovidDataFromCSV(this, fileName);
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
//		countryPointMarkers = createSimplePoint(impact);
		
		countryPointMarkers = new ArrayList<>();
		map.addMarkers(countryMarkers);
		shadeCountries();
		map.addMarkers(countryPointMarkers);
		
		
	}
	
	public void draw() {
		map.draw();
		addKey();
	}
	
//	private List<Marker> createSimplePoint(HashMap<String, Feature> impact) {
//		List<Marker> points = new ArrayList<>();
//		for(Feature feature: impact.values()) {
//			CountryMarker marker = new CountryMarker(feature);
//			points.add(marker);
//		}
//		return points;
//	}
	
	private void addKey() {
		fill(255, 250, 240);
		
		int xbase = 25;
		int ybase = 50;
		
		rect(xbase, ybase, 150, 200);
		
		fill(0);
		textAlign(LEFT, CENTER);
		textSize(12);
		text("Covid Impact Key", xbase+25, ybase+25);
		fill(255, 0, 0);
		rect(xbase+10, ybase+70, 4, 4);
		fill(color(255, 175, 100));
		rect(xbase+10, ybase+90, 8, 8);
		fill(color(255, 155, 55));
		rect(xbase+10, ybase+110, 8, 8);
		fill(color(255, 125, 0));
		rect(xbase+10, ybase+130, 8, 8);
		fill(color(200, 100, 0));
		rect(xbase+10, ybase+150, 8, 8);
		fill(185);
		rect(xbase+10, ybase+170, 8, 8);
		fill(0);
		text("Country Marker", xbase+25, ybase+70);
		text("Closed", xbase+25, ybase+90);
		text("Closed (in select areas)", xbase+25, ybase+110);
		text("Open with limitations", xbase+25, ybase+130);
		text("Open", xbase+25, ybase+150);
		text("No data", xbase+25, ybase+170);
	}
	
	@Override
	public void mouseMoved()
	{
		// clear the last selection
		if (lastSelected != null) {
			lastSelected.setSelected(false);
			lastSelected = null;
		
		}
		selectMarkerIfHover(countryPointMarkers);
		//loop();
	}
	
	private void selectMarkerIfHover(List<Marker> markers)
	{
		// Abort if there's already a marker selected
		if (lastSelected != null) {
			return;
		}
		
		for (Marker m : markers) 
		{
			CountryMarker marker = (CountryMarker)m;
			if (marker.isInside(map,  mouseX, mouseY)) {
				lastSelected = marker;
				marker.setSelected(true);
				return;
			}
		}
	}
	
	private void shadeCountries() {
		for(Marker marker: countryMarkers) {
			if(impact.containsKey(marker.getId())) {
				
				// creating a CountryMarker and add it to markers list
				Feature f = impact.get(marker.getId());
				CountryMarker countryMarker = new CountryMarker(f);
				countryPointMarkers.add(countryMarker);
				
				// shading countries according to status of schools 
				String status = f.getStringProperty("status");
				int color = color(255, 255, 255);
				if(status.equals("Closed")) color = color(255, 175, 100); 
				else if(status.equals("Closed (in select areas)")) color = color(255, 155, 55);
				else if(status.equals("Open with limitations")) color = color(255, 125, 0);
				else if(status.equals("Open")) color = color(200, 100, 0);
				marker.setColor(color);
			}
			else marker.setColor(185);
		}
	}
}
