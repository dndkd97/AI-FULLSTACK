package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
	@SequenceGenerator(name="comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
	private Long id;
	
	@Lob
	@Column(nullable=false)
	private String content; // 게시글내용 (긴 텍스트)
	
	@Column
	private boolean deleted;
	
	@Column(name="CREATED_AT", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="UPDATED_AT", nullable=false)
	private LocalDateTime updatedAt;

   @PrePersist void onCreate() {
	      this.createdAt = LocalDateTime.now();
	      this.updatedAt = LocalDateTime.now();
	   }
	   
   @PreUpdate void onUpdate() {
	      this.updatedAt = LocalDateTime.now();
	   }
   
   @ManyToOne
   @JoinColumn(name="APP_USER_ID", nullable=false)
   AppUser user; // @ManyToOne / @OneToMany AppUser
   
   @ManyToOne
   @JoinColumn(name="POST_ID", nullable=false)
   Post post; // @ManyToOne / @OneToMany Post
	
	

}
