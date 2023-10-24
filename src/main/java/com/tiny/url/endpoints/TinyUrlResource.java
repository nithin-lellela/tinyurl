package com.tiny.url.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiny.url.entity.TinyUrl;
import com.tiny.url.service.ITinyUrlService;
import com.tiny.url.vo.TinyUrlRequestBody;
import com.tiny.url.vo.TinyUrlVO;

@RestController
@RequestMapping("/tinyurl")
public class TinyUrlResource {

	private final ITinyUrlService tinyUrlService;

	@Autowired
	public TinyUrlResource(ITinyUrlService tinyUrlService) {
		this.tinyUrlService = tinyUrlService;
	}

	@GetMapping("/{shorturl}")
	public ResponseEntity<TinyUrlVO> getTinyUrl(@PathVariable(value = "shortUrl") String url) {
		return this.tinyUrlService.getShortUrlFromLongUrl(url);
	}

	@PostMapping("/")
	public ResponseEntity<TinyUrl> createTinyUrl(@RequestBody TinyUrlRequestBody tinyUrl) {
		return this.tinyUrlService.createShortUrl(tinyUrl);
	}

}
