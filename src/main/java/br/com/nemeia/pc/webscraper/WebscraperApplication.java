package br.com.nemeia.pc.webscraper;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;


@SpringBootApplication
public class WebscraperApplication {

	public static void main(String[] args) {

		String url = "https://www.kabum.com.br/hardware/placa-de-video-vga?page_number=1&page_size=100&facet_filters=&sort=most_searched";

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element element = document.getElementById("__NEXT_DATA__");
		String content = element.html();

		JSONObject json = null;
        try {
            json = new JSONObject(content);
			JSONObject pageProps = json.getJSONObject("props").getJSONObject("pageProps");
			JSONArray data = new JSONObject(pageProps.get("data").toString()).getJSONObject("catalogServer").getJSONArray("data");
			
			for (int i = 0; i < data.length(); i++) {
				JSONObject item = data.getJSONObject(i);
				System.out.println(item.getString("name"));
				System.out.println(item.getString("price"));
				System.out.println(item.getString("priceWithDiscount"));
				System.out.println(item.getString("available"));
				System.out.println(item.getString("rating"));
				System.out.println(item.getString("ratingCount"));
			}
			
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        SpringApplication.run(WebscraperApplication.class, args);
	}

}
