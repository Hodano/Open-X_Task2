package pl.hodan;

import lombok.AllArgsConstructor;
import pl.hodan.model.products.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class CategoryValueMap {
    private List<Product> product;

    public Map<String, BigDecimal> getCategoryValueMapCreateCategorySummary() {
        Map<String, BigDecimal> categoryAndTotalValueProduct = new HashMap<>();
        BigDecimal temp;

        for (Product produ : product) {
            if(produ.getCategory() !=null) {
                if (categoryAndTotalValueProduct.containsKey(produ.getCategory())) {

                    temp = categoryAndTotalValueProduct.get(produ.getCategory()).add(produ.getPrice());
                    categoryAndTotalValueProduct.put(produ.getCategory(), temp);
                } else
                    categoryAndTotalValueProduct.put(produ.getCategory(), produ.getPrice());
            }
        }
        return categoryAndTotalValueProduct;

    }
}