package com.selimhorri.app.model.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@MappedSuperclass
@Data
abstract public class AbstractMappedEntity {
	
	private static final String INSTANT_PATTERN = "dd-MM-yyyy_HH:mm:ss-SSS";
	
	@CreatedDate
	@DateTimeFormat(pattern = INSTANT_PATTERN)
	@JsonFormat(pattern = INSTANT_PATTERN, shape = Shape.STRING)
	@Column(name = "created_at", updatable = false, 
			insertable = true, nullable = false)
	private Instant createdAt;
	
	@LastModifiedDate
	@DateTimeFormat(pattern = INSTANT_PATTERN)
	@JsonFormat(pattern = INSTANT_PATTERN, shape = Shape.STRING)
	@Column(name = "updated_at", updatable = true, 
			insertable = true)
	private Instant updatedAt;
	
	
	
}









