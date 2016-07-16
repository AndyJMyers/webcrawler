package webcrawler.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webcrawler.engines.WebCrawlerEngine;
import webcrawler.model.WebCrawlerResults;

@RestController
public class WebCrawlerController {

	static final Logger logger = Logger.getLogger(WebCrawlerController.class);

	@Autowired
	WebCrawlerEngine webCrawlerEngine; 
	
    @RequestMapping(value = "/webcrawler", method = GET)
    public WebCrawlerResults webcrawler(@RequestParam(value = "url") URL url) {

    	logger.info("Endpoint /webcrawler called, requested url to crawl = [" + url + "]");
    	
    	WebCrawlerResults results = webCrawlerEngine.processPage(url);
    	
    	logger.info("Found [" + (results == null ? 0 : results.getPagesInDomain().size()) + "] linked pages");
    	
    	return results;
    	
    }
    
    
}