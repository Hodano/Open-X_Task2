package pl.hodan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.hodan.model.carts.Cart;
import pl.hodan.model.carts.cartsproducts.CartProducts;
import pl.hodan.model.products.Product;
import pl.hodan.model.users.User;
import pl.hodan.model.users.name.Name;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

class UserWithTheMostExpensiveCartTest {
    private List<User> userList;
    private List<Product> productList;

    private List<Cart> cartList;

    @BeforeEach
    public void initialize() {
        userList = new ArrayList<>();
        productList = new ArrayList<>();
        cartList = new ArrayList<>();


        Product product = new Product(1, BigDecimal.valueOf(10));
        Product product1 = new Product(2, BigDecimal.valueOf(5));
        Product product2 = new Product(3, BigDecimal.valueOf(3));

        productList.add(product);
        productList.add(product1);
        productList.add(product2);

        Cart cart = new Cart(1,Arrays.asList(
                new CartProducts(1, 1),
                new CartProducts(2, 2),
                new CartProducts(3, 1)
        ));
        Cart cart1 = new Cart(2,Arrays.asList(
                new CartProducts(1, 1),
                new CartProducts(2, 3),
                new CartProducts(3, 1)
        ));
        Cart cart2 = new Cart(3,Arrays.asList(
                new CartProducts(1, 1),
                new CartProducts(2, 4),
                new CartProducts(3, 1)
        ));
        cartList.add(cart);
        cartList.add(cart1);
        cartList.add(cart2);
    }

    @AfterEach
    public void clear() {
        userList.clear();
        productList.clear();
        cartList.clear();
    }

    @Test
    public void getProductIdAndPriceShouldReturnCorrectProductIdAndPrice() {
        //given

        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList, productList, cartList);
        Map<Integer, BigDecimal> checkProductIdAndPrice = Map.of(1, BigDecimal.valueOf(10), 2, BigDecimal.valueOf(5),3, BigDecimal.valueOf(3));

        //when
        Map<Integer, BigDecimal> nowProductIdAndPrice = userWithTheMostExpensiveCart.getProductIdAndPrice();

        //then
        assertThat(nowProductIdAndPrice, equalTo(checkProductIdAndPrice));

    }

    @Test
    public void calculateCartPriceShouldReturnCorrectPriceForCart() {
        //given
        Cart cart = new Cart(1,Arrays.asList(
                new CartProducts(1, 3),
                new CartProducts(2, 2),
                new CartProducts(3, 1)
        ));


        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList, productList, cartList);
        BigDecimal exceptedPrice = BigDecimal.valueOf(43);

        //when
        //then
        assertThat(userWithTheMostExpensiveCart.calculateCartPrice(cart), equalTo(exceptedPrice));
    }
    @Test
    public void calculateCartPriceShouldReturnNullArgumentExceptionBecouseCartIsNull(){
        //given


        Cart cart = null;

        cartList.add(cart);

        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList,productList,cartList);


        //when
        //then
        assertThrows(NullPointerException.class,() ->userWithTheMostExpensiveCart.calculateCartPrice(cart));

}
@Test
    public void findCartWithMaxPriceShouldReturnMaxPrice(){
        //given
        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList,productList,cartList);


        //when maxPrice is cart2;
        Cart excpetedCart = cartList.get(2);

        //then
        assertEquals(excpetedCart,userWithTheMostExpensiveCart.findCartWithMaxPrice());

    }
    @Test
    public void  findMaxCartPricShouldReturnCartWithMaxPrice(){
        //given
        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList,productList,cartList);


        //when maxCart is cart2;
        Cart excpetedCart = cartList.get(2);

        //then
        assertEquals(excpetedCart,userWithTheMostExpensiveCart.findCartWithMaxPrice());

    }

    @Test
    public void getNameAndSurnameWithMaxCartPriceShouldReturnNameAndSurnameUserWithMaxCartPrice(){
        //given
        UserWithTheMostExpensiveCart userWithTheMostExpensiveCart = new UserWithTheMostExpensiveCart(userList,productList,cartList);
       User user = new User(1,new Name("Mariusz", "Kowal"));
       User user1 = new User(2,new Name("Franek", "Ziob"));
       User user2 = new User(3,new Name("Henio", "Murzyn"));

       userList.add(user);
       userList.add(user1);
       userList.add(user2);
       //UserWithMaxValue
       Name excpetionName = new Name("Henio","Murzyn");
       //then
        assertEquals(excpetionName,userWithTheMostExpensiveCart.getNameAndSurnameUserWithMaxCartPrice());
    }


    }
