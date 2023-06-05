package com.lwdevelop.backend.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "members")
public class Member {

	@Id
	@Column(name = "mid", unique = true, nullable = false, length = 50)
	private String mid;
	@NonNull
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;
	@NonNull
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	@NonNull
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	@NonNull
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "update_time")
	private Date updateTime;

}