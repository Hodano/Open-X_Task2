package pl.hodan;

import lombok.AllArgsConstructor;
import pl.hodan.model.carts.Cart;
import pl.hodan.model.carts.cartsproducts.CartProducts;
import pl.hodan.model.products.Product;
import pl.hodan.model.users.User;
import pl.hodan.model.users.name.Name;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class UserWithTheMostExpensiveCart {
    private List<User> users;
    private List<Product> products;
    private List<Cart> carts;



    public Map<Integer, BigDecimal> getProductIdAndPrice() {
        Map<Integer, BigDecimal> productIdAndPrice = new HashMap<>();
        for (Product prod : products) {
            productIdAndPrice.put(prod.getId(), prod.getPrice());
        }
        return productIdAndPrice;
    }
    private BigDecimal IdToPirceMap(int idKey, Map<Integer, BigDecimal> getIProductAndHisPrice) {
        return getIProductAndHisPrice.get(idKey);
    }

    public BigDecimal calculateCartPrice(Cart cart) {
        BigDecimal price = BigDecimal.valueOf(0);
        for (CartProducts cartProducts : cart.getProducts()) {
            BigDecimal productPrice = IdToPirceMap(cartProducts.getProductId(),getProductIdAndPrice());
            BigDecimal quantity = BigDecimal.valueOf(cartProducts.getQuantity());
            price = price.add(productPrice.multiply(quantity));
        }
        return price;
    }



    public Cart findCartWithMaxPrice(){
        BigDecimal maxCartPrice = BigDecimal.valueOf(0);
         Cart cartMax = null;
        for(Cart cart :carts){
            BigDecimal price = calculateCartPrice(cart);
            if(price.compareTo(maxCartPrice) >0){
                maxCartPrice = price;
                cartMax = cart;
            }
        }
        return cartMax;
    }
    public Name  getNameAndSurnameUserWithMaxCartPrice(){
        Name name = null;
        for (User user:users) {
            if(user.getId() == findCartWithMaxPrice().getUserId())
                name =  user.getName();
        }
        return name;
    }


    public BigDecimal findMaxCartPrice(){
        BigDecimal maxCartPrice = BigDecimal.valueOf(0);
        for (Cart cart:carts) {
            BigDecimal price = calculateCartPrice(cart);
            if(price.compareTo(maxCartPrice) >0) {
                maxCartPrice = price;
            }
        }
        return maxCartPrice;
    }





}


