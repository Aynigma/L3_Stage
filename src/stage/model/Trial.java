package stage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trial  implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private Date start;
	
	@Column(nullable = false)
	private String ageRange;
	
	@Column(nullable = false)
	private String sexTargeted;
	
	@Column(nullable = false)
	private String conditions;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private String place;
	
	
	protected Trial() {}
	
	public Trial(String title, String status, Date start, String ageRange, String sexTargeted, String conditions, String link, String place) {
		this.title = title;
		this.status = status;
		this.start = start;
		this.ageRange = ageRange;
		this.sexTargeted = sexTargeted;
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getSexTargeted() {
		return sexTargeted;
	}

	public void setSexTargeted(String sexTargeted) {
		this.sexTargeted = sexTargeted;
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


