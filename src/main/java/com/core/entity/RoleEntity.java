package com.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "core_role")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RoleEntity {

	private static final long serialVersionUID = -7500608077680839602L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	@Column(name = "DELETED")
	private String deleted;

}
