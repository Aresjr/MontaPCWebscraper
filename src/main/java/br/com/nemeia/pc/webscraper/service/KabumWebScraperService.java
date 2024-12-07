package br.com.nemeia.pc.webscraper.service;

import br.com.nemeia.pc.commons.enums.Store;
import br.com.nemeia.pc.commons.model.Gpu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KabumWebScraperService implements WebScraperService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private GpuService gpuService;

    @Override
    public String getUrl() {
        return "https://www.kabum.com.br/hardware/placa-de-video-vga?page_number=1&page_size=100&facet_filters=&sort=most_searched";
    }

    @Scheduled(fixedRate = 1000 * 60 * 10)
    public void obtemModelosGpu() throws JSONException, IOException {
        //TODO - make pagination
        JSONArray gpuModels = extractModels(getModelsFromPage());
        for (int i = 0; i < gpuModels.length(); i++) {
            JSONObject gpuModel = gpuModels.getJSONObject(i);
            Gpu gpu = mapper.readValue(gpuModel.toString(), Gpu.class);
            gpu.setStore(Store.KABUM);
            gpuService.sendToKafka(gpu);
        }
    }

    @Override
    public JSONArray extractModels(Document document) throws JSONException {
        Element element = document.getElementById("__NEXT_DATA__");
        assert element != null;
        String content = element.html();

        JSONObject json = new JSONObject(content);
        JSONObject pageProps = json.getJSONObject("props").getJSONObject("pageProps");
        JSONObject data = new JSONObject(pageProps.get("data").toString());
        return data.getJSONObject("catalogServer").getJSONArray("data");
    }

}
