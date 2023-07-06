package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="author")
@JsonIgnoreType
public class Author extends BaseEntity {
	
	private String authorName;
	private int age;
	private String address;
	private String email;
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Books> booklist=new ArrayList<>();
}
