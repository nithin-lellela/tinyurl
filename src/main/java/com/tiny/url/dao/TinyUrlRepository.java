package com.tiny.url.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tiny.url.entity.TinyUrl;

@Repository
public interface TinyUrlRepository extends JpaRepository<TinyUrl, Long>{

	@Query(value = "SELECT t FROM TinyUrl t where t.shortUrl = :url", nativeQuery = true)
	List<TinyUrl> getShortUrl(String url);
	
}
