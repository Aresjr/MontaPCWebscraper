package br.com.nemeia.pc.webscraper.service;

import br.com.nemeia.pc.webscraper.enums.Store;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;

public interface WebScraperService {

    String STORE_INDEX = "store";

    String getUrl();

    default Document getModelsFromPage() throws IOException {
        return Jsoup.connect(getUrl()).get();
    }

    JSONArray extractModels(Document document) throws JSONException;

    Store getStoreName();

    default void setStore(JSONObject json) throws JSONException {
        json.put(STORE_INDEX, getStoreName());
    }

}
