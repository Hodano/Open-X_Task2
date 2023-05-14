package pl.hodan.model.carts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hodan.model.carts.cartsproducts.CartProducts;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int id;
    private int userId;
    private Date date;
    private List<CartProducts> products;
    private int __v;

    public Cart(int userId, List<CartProducts> products) {
        this.userId = userId;
        this.products = products;
    }
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", products=" + products +
                ", __v=" + __v +
                '}';
    }


}
