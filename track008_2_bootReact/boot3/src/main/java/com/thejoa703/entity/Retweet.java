package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="RETWEETS", uniqueConstraints = @UniqueConstraint(name="UK_RETWEET_USER_ORIG",columnNames={"APP_USER_ID","ORIGINAL_POST_ID"}))
public class Retweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "retweets_seq")
	@SequenceGenerator(name="retweets_seq", sequenceName = "RETWEETS_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name="CREATED_AT", nullable=false)
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID",nullable=false)
	AppUser user; // 리트윗한 사람 @ManyToOne
	
	@ManyToOne
	@JoinColumn(name="ORIGINAL_POST_ID",nullable=false)
	Post originalPost; // 리트윗한 글 번호 @ManyToOne
	
	@PrePersist void onCreate() {
      this.createdAt = LocalDateTime.now();
   }

	public Retweet(AppUser user, Post originalPost) {
		super();
		this.user = user;
		this.originalPost = originalPost;
	}
	
	
}
