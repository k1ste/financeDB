package db.hsb.financeDB.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import de.hsb.app.financeDB.download.iDownload;

public class DownloadController implements iDownload {

	public void downloadURL(String url, String filename, String file_ex) throws IOException {
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
