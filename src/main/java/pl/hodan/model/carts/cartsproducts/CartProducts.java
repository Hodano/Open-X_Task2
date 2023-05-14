package pl.hodan.model.carts.cartsproducts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CartProducts {
   private int productId;
   private int quantity;

   @Override
   public String toString() {
      return "CartProducts{" +
              "productId=" + productId +
              ", quantity=" + quantity +
              '}';
   }
}
