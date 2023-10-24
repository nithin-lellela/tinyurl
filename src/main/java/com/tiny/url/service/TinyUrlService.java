package com.tiny.url.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tiny.url.dao.TinyUrlRepository;
import com.tiny.url.entity.TinyUrl;
import com.tiny.url.vo.TinyUrlRequestBody;
import com.tiny.url.vo.TinyUrlVO;

@Service
public class TinyUrlService implements ITinyUrlService {

	private final TinyUrlRepository tinyUrlRepository;

	@Autowired
	public TinyUrlService(TinyUrlRepository tinyUrlRepository) {
		this.tinyUrlRepository = tinyUrlRepository;
	}

	@Override
	public ResponseEntity<TinyUrlVO> getShortUrlFromLongUrl(String url) {
		List<TinyUrl> tinyUrl = this.tinyUrlRepository.getShortUrl(url);
		if (tinyUrl != null) {
			return new ResponseEntity<>(mapToTinyUrlVO(tinyUrl.get(0)), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@Override
	public ResponseEntity<TinyUrl> createShortUrl(TinyUrlRequestBody tinyUrlRequestBody) {
		try {
			TinyUrl url = this.tinyUrlRepository
					.save(new TinyUrl(tinyUrlRequestBody.getUserId(), tinyUrlRequestBody.getOriginalUrl()));
			return new ResponseEntity<>(url, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private TinyUrlVO mapToTinyUrlVO(TinyUrl tinyUrl) {
		TinyUrlVO tinyUrlVo = new TinyUrlVO(tinyUrl.getId(), tinyUrl.getUserId(), tinyUrl.getOriginalUrl(),
				tinyUrl.getShortUrl());
		return tinyUrlVo;
	}

}
