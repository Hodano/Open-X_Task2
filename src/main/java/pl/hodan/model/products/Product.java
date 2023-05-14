package pl.hodan.model.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hodan.model.products.ratings.Rating;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", raiting=" + rating +
                '}';
    }

    public Product(BigDecimal price, String category) {
        this.price = price;
        this.category = category;
    }

    public Product(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}
