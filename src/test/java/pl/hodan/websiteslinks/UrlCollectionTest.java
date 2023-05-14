package pl.hodan.websiteslinks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class UrlCollectionTest {
    private UrlCollection urlCollection;

    @BeforeEach
    public void initializeUrlCollection(){
        urlCollection = new UrlCollection();
    }


    @Test
    void checkIfGetUrlUserJsonIsEmpty() {
        //given
        //when
        //then
       assertThat(urlCollection.getUrlUserJson(),is(notNullValue()));
    }

    @Test
    void checkIfGetUrlCartJsonIsEmpty() {
        //given
        //when
        //then
        assertThat(urlCollection.getUrlCartsJson(),is(notNullValue()));
    }

    @Test
    void checkIfGetUrlProductJsonIsEmpty() {
        //given
        //when
        //then
        assertThat(urlCollection.getUrlProductsJson(),is(notNullValue()));
    }
}