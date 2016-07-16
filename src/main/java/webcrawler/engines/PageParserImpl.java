package webcrawler.engines;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;

import webcrawler.model.WebCrawlerResults;
import webcrawler.utils.URLUtils;

@Controller
public class PageParserImpl implements PageParser {
	static final Logger logger = Logger.getLogger(PageParserImpl.class);

	@Override
	public void parsePage(String domainName, URL url, WebCrawlerResults crawlerResults) throws IOException {
		logger.info("about to parse page: [" + url + "]");

		Document doc = Jsoup.connect(url.toString()).userAgent("Mozilla").get();

		//get all links and recursively call self if correct domain and not seen before.
		Elements elements = doc.select("a[href]");
		for (Element link: elements) {
			if (isCorrectDomain(domainName, link)) {
				String linkedPage = link.attr("abs:href");
				URL linkedPageURL = URLUtils.normalise(linkedPage);
				
				if (crawlerResults.alreadySeenPage(linkedPageURL.toString())) {
					logger.info("Already seen this page: " + linkedPageURL);
				} else {
					logger.info("New page: " + linkedPageURL);
					crawlerResults.addPage(linkedPageURL.toString());
					parsePage(domainName, linkedPageURL, crawlerResults);
				}
				
			}
		}
	}

	// TODO This implementation will give some false positives for urls with a different domain but with query params including the original domain.
	private boolean isCorrectDomain(String domainName, Element link) {
		return link.attr("href").contains(domainName);
	}
	
}
