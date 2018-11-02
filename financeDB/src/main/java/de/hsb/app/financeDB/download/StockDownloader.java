package de.hsb.app.financeDB.download;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class StockDownloader implements iDownload {

	public void downloadURL(String url, String filename, String file_ex) {
		HttpGet request = null;
	    try {
	      HttpClient client = HttpClientBuilder.create().build();
	      request = new HttpGet(url);
	      request.addHeader("User-Agent", "Apache HTTPClient");
	      HttpResponse response = client.execute(request);
	      HttpEntity entity = response.getEntity();
	      String content = EntityUtils.toString(entity);
	      FileUtils.writeStringToFile(new File(filename + "." + file_ex), content);     

	    } finally {
	      if (request != null) {
	        request.releaseConnection();
	      }
	    }
	  }		
	}
}
