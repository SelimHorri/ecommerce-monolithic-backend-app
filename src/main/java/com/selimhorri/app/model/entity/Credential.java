package com.selimhorri.app.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.selimhorri.app.constant.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
public final class Credential extends AbstractMappedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credential_id", nullable = false)
	private Integer credentialId;
	
	private String username;
	
	private String password;
	
	@Enumerated(value = EnumType.STRING)
	private RoleEnum role;
	
	@Column(name = "is_enabled")
	private Boolean isEnabled;
	
	@Column(name = "is_account_non_expired")
	private Boolean isAccountNonExpired;
	
	@Column(name = "is_account_non_locked")
	private Boolean isAccountNonLocked;
	
	@Column(name = "is_credentials_non_expired")
	private Boolean isCredentialsNonExpired;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "credential",
			cascade = CascadeType.ALL)
	private Set<VerificationToken> verificationTokens;
	
	
	
}









