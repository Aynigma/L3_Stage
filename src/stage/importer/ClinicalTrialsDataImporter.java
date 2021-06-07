package stage.importer;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import stage.model.Trial;

public class ClinicalTrialsDataImporter implements DataImporter{
	
	
	public int titleMaxLength = 0; 
	public int conditionMaxLength = 0; 
	public int placeMaxLength = 0; 
	
	
	
	
	@Override
	public Trial read(File file) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		
		Element root = document.getDocumentElement();
		
		
		//Get title
		String title = "";
		NodeList titleNode = root.getElementsByTagName("official_title");
		if(titleNode.getLength() > 0) {
			title = titleNode.item(0).getTextContent();
		}else {
			titleNode = root.getElementsByTagName("brief_title");
			if(titleNode.getLength() > 0) {
				title = titleNode.item(0).getTextContent();
			}
		}
		if(title.length() > titleMaxLength) titleMaxLength = title.length();
		
		//Get status
		String status = "";
		NodeList statusNode = root.getElementsByTagName("overall_status");
		if(statusNode.getLength() > 0 && !statusNode.item(0).getTextContent().equals("Unknown status")) {
			status = statusNode.item(0).getTextContent();
		}else {
			statusNode = root.getElementsByTagName("last_known_status");
			if(statusNode.getLength() > 0) {
				status = statusNode.item(0).getTextContent();
			}
		}
		
		
		//Get start date
		String startDate = "";
		NodeList startDateNode = root.getElementsByTagName("start_date");
		if(startDateNode.getLength() > 0) {
			startDate = startDateNode.item(0).getTextContent();
		}
		
		
		
		//Get eligibility Node
		NodeList eligibilityNode = root.getElementsByTagName("eligibility");
		Element eligibility = null;
		if(eligibilityNode.getLength() > 0) {
			eligibility = (Element)eligibilityNode.item(0);
		}
		
		//Get ageRange
		String ageRange = "";
		if(eligibility != null) {
			NodeList ageMinNode = eligibility.getElementsByTagName("minimum_age");
			if(ageMinNode.getLength() > 0) {
				String ageMin = ageMinNode.item(0).getTextContent().replace("Years", "").trim();
				if(ageMin.equals("N/A")) {
					ageMin = "0";
				}
				ageRange += ageMin; 
			}
			
			ageRange += "-";
			
			NodeList ageMaxNode = eligibility.getElementsByTagName("maximum_age");
			if(ageMaxNode.getLength() > 0) {
				String ageMax = ageMaxNode.item(0).getTextContent().replace("Years", "").trim();
				if(ageMax.equals("N/A")) {
					ageMax = "111";
				}
				ageRange += ageMax;
			}
			
		}
		
		
		//Get gender
		String gender = "";
		if(eligibility != null) {
			NodeList genderNode = eligibility.getElementsByTagName("gender");
			if(genderNode.getLength() > 0) {
				gender = genderNode.item(0).getTextContent();
			}
		}
		
		
		//Get conditions
		String conditions = "";
		
		//TODO from condition
		NodeList conditionNodes = root.getElementsByTagName("condition");
		for (int i = 0; i < conditionNodes.getLength(); i++) {
			conditions += conditionNodes.item(i).getTextContent() + "; ";
		}
		
		
		//from keywords
		NodeList keywordNodes = root.getElementsByTagName("keyword");
		conditions += "\n";
		for (int i = 0; i < keywordNodes.getLength(); i++) {
			conditions += keywordNodes.item(i).getTextContent() + "; ";
		}

		//from mesh_terms
		NodeList conditionBrowseNodes = root.getElementsByTagName("condition_browse");
		if(conditionBrowseNodes.getLength() > 0) {
			NodeList meshTermNodes = ((Element)conditionBrowseNodes.item(0)).getElementsByTagName("mesh_term");
			conditions += "\n";
			for (int i = 0; i < meshTermNodes.getLength(); i++) {
				conditions += meshTermNodes.item(i).getTextContent() + "; ";
			}
		}
		if(conditions.length() > conditionMaxLength) conditionMaxLength = conditions.length();
		
		
		//Get url
		String url = "";
		NodeList requiredHeaderNode = root.getElementsByTagName("required_header");
		if(requiredHeaderNode.getLength() > 0) {
			NodeList urlNode = ((Element)requiredHeaderNode.item(0)).getElementsByTagName("url");
			if(urlNode.getLength() > 0) {
				url = urlNode.item(0).getTextContent();
			}
		}
		
		
		
		//Get location/place
		String place = "";
		NodeList locationNodes = root.getElementsByTagName("location");
		if(locationNodes.getLength() > 0) {
			for (int i = 0; i < locationNodes.getLength(); i++) {
				NodeList facilityNode = ((Element)locationNodes.item(i)).getElementsByTagName("facility");
				if(facilityNode.getLength() > 0) {
					NodeList nameNode = ((Element)facilityNode.item(0)).getElementsByTagName("name");
					if(nameNode.getLength() > 0) {
						String name = nameNode.item(0).getTextContent().replace(",", " ").replace(";", " ");
						place += name;
					}
					
					NodeList addressNode = ((Element)facilityNode.item(0)).getElementsByTagName("address");
					if(addressNode.getLength() > 0) {
						NodeList cityNode = ((Element)addressNode.item(0)).getElementsByTagName("city");
						if(cityNode.getLength() > 0) {
							String city = cityNode.item(0).getTextContent().replace(",", " ").replace(";", " ");
							place += ", " + city;
						}
						NodeList countryNode = ((Element)addressNode.item(0)).getElementsByTagName("country");
						if(countryNode.getLength() > 0) {
							String country = countryNode.item(0).getTextContent().replace(",", " ").replace(";", " ");
							place += ", " + country;
						}
					}
				}
				place += "; ";
				
			}
		}
		if(place.length() > placeMaxLength) placeMaxLength = place.length();
		
		
		
		System.out.println(file+"\n"+title+"\n"+status+"\n"+startDate+"\n"+ageRange+"\n"+gender+"\n"+conditions+"\n"+url+"\n"+place+"\n---\n");
		
		return new Trial(title, status, startDate, ageRange, gender, conditions, url, place);
	}

	
	
}
