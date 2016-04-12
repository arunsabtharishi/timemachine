package com.dragonfly.timemachine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIALS")
public class Credentials {
	@Id
	@Column(name = "USER_ID")
	String user_id;
	
	@Column(name = "PASSWORD")
	String password;
}
