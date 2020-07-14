package module6;

import java.util.List;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.Feature.FeatureType;
import de.fhpotsdam.unfolding.data.MultiFeature;
import de.fhpotsdam.unfolding.data.ShapeFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.MultiMarker;
import de.fhpotsdam.unfolding.marker.SimplePolygonMarker;
import processing.core.PGraphics;


public class CountryMarker extends  SimplePolygonMarker{
	CountryMarker(Feature country ) {
		super(((ShapeFeature)country).getLocations(), country.getProperties());
		System.out.println(getStringProperty("name"));
	}
	
	public void draw(PGraphics pg, float x, float y) {
		
		pg.fill(250);
		pg.rect(x, y, 100, 100);
	}
}
