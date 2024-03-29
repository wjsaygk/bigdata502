package com.cos.crud.model;

import java.sql.Timestamp;

import javax.xml.ws.BindingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createDate;
	
}
