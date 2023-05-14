package pl.hodan.websiteslinks;

import lombok.Getter;


@Getter
public class UrlCollection {
    private String urlUserJson ;
    private String urlCartsJson ;
    private String urlProductsJson;

    public UrlCollection() {
        this.urlUserJson = "https://fakestoreapi.com/users";
        this.urlCartsJson = "https://fakestoreapi.com/carts";
        this.urlProductsJson = "https://fakestoreapi.com/products";
    }

}
