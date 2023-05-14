package pl.hodan.maping;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.hodan.model.products.Product;
import pl.hodan.model.users.User;
import pl.hodan.websiteslinks.UrlCollection;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class MapperTest {
    Mapper mapper;
    ObjectMapper objectMapper;


    @BeforeEach
    public void initializeObjectMapper() {
        mapper = new Mapper();
        objectMapper = new ObjectMapper();
    }


    @Test
    public void jsonMapperForTheCorrectUrlShouldGetThisValue() throws IOException {
        //given
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {
        };
        UrlCollection urlCollection = new UrlCollection();
        String correctUrl = urlCollection.getUrlUserJson();
        //when
        List<User> users = mapper.jsonMapper(correctUrl, typeRef);

        //then
        assertThat(users, notNullValue());
        assertThat(users, is(not(empty())));
        assertThat(users.size(), equalTo(10));
        assertThat(users.get(0).getUserName(), equalTo("johnd"));


    }

    @Test
    public void jsonMapperForTheNullUrlShouldThrowMalformedURLException() throws IOException {
        //given
        String inCorrectUrl = null;
        URL url;
        //when

        //then
        assertThrows(MalformedURLException.class, () -> new URL(inCorrectUrl));
    }

    @Test
    public void jsonMapperForTheBadValueUrlShouldThrowMalformedURLException() throws IOException {
        //given
        String inCorrectUrl = "xd";
        //when

        //then
        assertThrows(MalformedURLException.class, () -> new URL(inCorrectUrl));
    }

    @Test
    public void JsonmapperForTheIncorrectUrlShouldNullBecouseWeHaveCatch() throws IOException {
        //given
        UrlCollection urlCollection = new UrlCollection();
        TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
        };
        String incorrectUrl = "https://fakestoreapi.com/users";
        //when
        //then
        assertNull(mapper.jsonMapper(incorrectUrl,typeReference));
    }


    }