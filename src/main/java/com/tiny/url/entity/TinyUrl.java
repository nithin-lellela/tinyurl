package com.tiny.url.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tiny_url")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TinyUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "short_url", nullable = false)
	private String shortUrl;
	@Column(name = "original_url", nullable = false)
	private String originalUrl;
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	public TinyUrl(Integer userId2, String originalUrl2) {
		this.userId = userId2;
		this.originalUrl = originalUrl2;
		this.shortUrl = originalUrl2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
