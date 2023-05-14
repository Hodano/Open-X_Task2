package pl.hodan.maping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mapper {
    private ObjectMapper objectMapper;
    private URL url;

    public static final Logger LOGGER = Logger.getLogger(Mapper.class.getName());

    public Mapper() {
        this.objectMapper = new ObjectMapper();

    }

    public <T> List<T> jsonMapper(String link,TypeReference<List<T>> tTypeReference) { // zmienić nazwę
        List<T> listJson = null;

        try {
            url = new URL(link);
            listJson = objectMapper.readValue(url, tTypeReference);

        }
        catch (MalformedURLException e1) {
            LOGGER.log(Level.SEVERE,"invalid adress");
        }

        catch (IOException e) {
            LOGGER.log(Level.SEVERE,"file read error");
        }

        return listJson;
    }


}

