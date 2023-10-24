package com.tiny.url.service;

import org.springframework.http.ResponseEntity;

import com.tiny.url.entity.TinyUrl;
import com.tiny.url.vo.TinyUrlRequestBody;
import com.tiny.url.vo.TinyUrlVO;

public interface ITinyUrlService {
	
	ResponseEntity<TinyUrlVO> getShortUrlFromLongUrl(String url);
	ResponseEntity<TinyUrl> createShortUrl(TinyUrlRequestBody tinyUrlRequestBody);

}
