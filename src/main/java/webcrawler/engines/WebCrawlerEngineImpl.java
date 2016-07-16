package webcrawler.engines;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webcrawler.model.WebCrawlerResults;
import webcrawler.utils.URLUtils;

@Controller
public class WebCrawlerEngineImpl implements WebCrawlerEngine {

	static final Logger logger = Logger.getLogger(WebCrawlerEngineImpl.class);

	@Autowired
	PageParser pageParser;


	@Override
	public WebCrawlerResults processPage(URL url) {
		WebCrawlerResults crawlerResults = new WebCrawlerResults();

		URL normalisedUrl = URLUtils.normalise(url.toString());
		
		String domainName = URLUtils.getDomainName(normalisedUrl);

		logger.info("normalisedUrl = " + normalisedUrl + ", domainName = " + domainName);

		try {
			pageParser.parsePage(domainName, normalisedUrl, crawlerResults);
		} catch (IOException ioe) {
			logger.error("Unable to parse page: " + normalisedUrl);
			logger.error("Stack trace: " + ioe);
		}
		
		return crawlerResults;
	}
}
