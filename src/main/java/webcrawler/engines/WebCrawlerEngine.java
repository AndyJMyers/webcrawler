package webcrawler.engines;

import java.net.URL;

import webcrawler.model.WebCrawlerResults;

public interface WebCrawlerEngine {

	WebCrawlerResults processPage(URL url);

}
