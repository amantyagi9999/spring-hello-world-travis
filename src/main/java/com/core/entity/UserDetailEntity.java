package com.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "core_user_detail")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDetailEntity {

	private static final long serialVersionUID = -7500608077680839602L;
	@Id
	@Column(name = "ID")
	private Integer id;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CRETAED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "DELETED")
	private String deleted;

}
