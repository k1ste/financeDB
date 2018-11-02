package de.hsb.app.financeDB.download;

import java.io.IOException;

public interface iDownload {
	public void downloadURL(String url, String filename, String file_ex) throws IOException;
}
