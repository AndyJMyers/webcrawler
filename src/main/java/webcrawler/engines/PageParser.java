package webcrawler.engines;

import java.io.IOException;
import java.net.URL;

import webcrawler.model.WebCrawlerResults;

public interface PageParser {

	void parsePage(String domainName, URL url, WebCrawlerResults crawlerResults) throws IOException;

}