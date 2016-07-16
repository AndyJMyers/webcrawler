package webcrawler.engines;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import webcrawler.model.WebCrawlerResults;

@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerEngineImplTest {

	@Mock
	PageParser pageParser;
	
	@InjectMocks 
	private WebCrawlerEngine webCrawlerEngine = new WebCrawlerEngineImpl();

	
	@Test
	public void testProcessPage() throws Exception {
		pageParser.parsePage(Matchers.same("bbc.co.uk"), Matchers.same(new URL("http://www.bbc.co.uk/")), Matchers.any(WebCrawlerResults.class));
		
		webCrawlerEngine.processPage(new URL("http://www.BBC.CO.UK"));
	}

}
