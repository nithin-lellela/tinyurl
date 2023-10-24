package com.tiny.url.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TinyUrlVO {
	
	public TinyUrlVO(Integer id2, Integer userId2, String originalUrl2, String shortUrl2) {
		this.id = id2;
		this.userId = userId2;
		this.OriginalUrl = originalUrl2;
		this.shortUrl = shortUrl2;
	}
	private Integer id;
	private Integer userId;
	private String shortUrl;
	private String OriginalUrl;

}
