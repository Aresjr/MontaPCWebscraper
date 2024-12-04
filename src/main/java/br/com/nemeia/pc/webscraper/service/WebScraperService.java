package br.com.nemeia.pc.webscraper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;

public interface WebScraperService {

    String getUrl();

    default Document getModelsFromPage() throws IOException {
        return Jsoup.connect(getUrl()).get();
    }

    JSONArray extractModels(Document document) throws JSONException;

}
