package com.simpleapp.Model;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	@Column(name = "todo_id")
	private String id;
	private String title;
	private String Content;
	private Date CreatedDate;

}
