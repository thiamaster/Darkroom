package br.com.darkroom.model;

import javax.persistence.*;

@Entity
@Table(name = "forum")
public class Forum {
	@Id
	@GeneratedValue
	@Column(name = "forum_id")
	private long id;
	
	@Column(name = "forum_name")
	private String name;
	
	@Column(name = "forum_description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	

}
