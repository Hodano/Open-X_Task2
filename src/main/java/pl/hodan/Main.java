package pl.hodan;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.hodan.maping.Mapper;
import pl.hodan.model.carts.Cart;
import pl.hodan.model.products.Product;
import pl.hodan.model.users.User;
import pl.hodan.websiteslinks.UrlCollection;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        UrlCollection urlCollection = new UrlCollection();

        ///1
        List<User> users = mapper.jsonMapper(urlCollection.getUrlUserJson(), new TypeReference<List<User>>() {
        });
        List<Product> products = mapper.jsonMapper(urlCollection.getUrlProductsJson(), new TypeReference<List<Product>>() {
        });
        List<Cart> carts = mapper.jsonMapper(urlCollection.getUrlCartsJson(), new TypeReference<List<Cart>>() {
        });

        ///2
        CategoryValueMap categoryValueMap = new CategoryValueMap(products);
        System.out.println(categoryValueMap.getCategoryValueMapCreateCategorySummary());

        ///3
        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(users,products,carts);
        System.out.println(userWithTheMostExpensiveCart.findMaxCartPrice());
        System.out.println(userWithTheMostExpensiveCart.getNameAndSurnameUserWithMaxCartPrice());

        //4
        FindFurthestUsersGetUsersWithMaxDistance findFurthestUsersGetUsersWithMaxDistance = new FindFurthestUsersGetUsersWithMaxDistance(users);
        System.out.println(findFurthestUsersGetUsersWithMaxDistance.usersWithMaxDestanceFromEachOther());
    }




    }
