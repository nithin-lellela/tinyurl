package com.tiny.url.endpoints;

public interface ITinyUrlResource {
	
	/**@GetMapping("/{shortUrl}")
	ResponseEntity<TinyUrlVO> getTinyUrl(@PathVariable(value = "shortUrl") String url);
	
	@PostMapping("/")
	ResponseEntity<TinyUrl> createTinyUrl(@RequestBody TinyUrlRequestBody tinyUrl);**/
	
}
