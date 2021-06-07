package stage.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trial implements Serializable{
	
	//title: 428, conditions: 5024, place: 54728

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 500)
	private String title;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String start;
	
	@Column(nullable = false)
	private String ageRange;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false, length = 5500)
	private String conditions;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false, length = 5500)
	private String place;
	
	
	protected Trial() {}
	
	public Trial(String title, String status, String start, String ageRange, String sexTargeted, String conditions, String link, String place) {
		this.title = title;
		this.status = status;
		this.start = start;
		this.ageRange = ageRange;
		this.gender = sexTargeted;
		this.conditions = conditions;
		this.link = link;
		this.place = place;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String sexTargeted) {
		this.gender = sexTargeted;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	

}


