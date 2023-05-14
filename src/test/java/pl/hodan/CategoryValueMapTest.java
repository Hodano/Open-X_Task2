package pl.hodan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.hodan.model.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

class CategoryValueMapTest {
private List<Product> productList;


@BeforeEach
    public void initializeProduct(){
    productList = new ArrayList<>();
}
@AfterEach
public  void clear(){
    productList.clear();
}

@Test
    public void ShouldReturnSummedPricesForTheSameCategory() {
    //given
    Product product1 = new Product(BigDecimal.valueOf(100), "Category2");
    Product product2 = new Product(BigDecimal.valueOf(100), "Category1");
    Product product3 = new Product(BigDecimal.valueOf(100), "Category2");
    Product product4 = new Product(BigDecimal.valueOf(100), "Category2");
    productList.add(product1);
    productList.add(product2);
    productList.add(product3);
    productList.add(product4);
    CategoryValueMap categoryValueMap = new CategoryValueMap(productList);
    //when
    Map<String, BigDecimal> categoryAndTotalValueProduct = categoryValueMap.getCategoryValueMapCreateCategorySummary();

    //then
    assertThat(categoryAndTotalValueProduct.get("Category2"), equalTo(BigDecimal.valueOf(300)));
}

    @Test
    public void FunctionShouldReturnSizeTwoBecauseWeHaveTwoSameCategories(){
        //given
        Product product1 = new Product(BigDecimal.valueOf(100),"Category2");
        Product product2 = new Product(BigDecimal.valueOf(100),"Category1");
        Product product3 = new Product(BigDecimal.valueOf(100),"Category2");
        Product product4 = new Product(BigDecimal.valueOf(100),"Category2");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        CategoryValueMap categoryValueMap = new CategoryValueMap(productList);
        //when
        Map<String, BigDecimal> categoryAndTotalValueProduct = categoryValueMap.getCategoryValueMapCreateCategorySummary();

        //then
        assertThat(categoryAndTotalValueProduct.size(),equalTo(2));
}
@Test
    public void shouldReturnEmptyMapWhenProdductListisEmpty(){
        //given
        CategoryValueMap categoryValueMap = new CategoryValueMap(productList);
        //when
        Map<String,BigDecimal>categoryAndTotalValueProduct = categoryValueMap.getCategoryValueMapCreateCategorySummary();
        //then
        assertTrue(categoryAndTotalValueProduct.isEmpty());
    }
    @Test
    public void FunctionShouldCorrectCategoryAndTotalValueProductWhenProductListCoinainNullValue(){
        //given
        Product product1 = new Product(BigDecimal.valueOf(100),"Category1");
        Product product2 = new Product(BigDecimal.valueOf(100),"Category1");
        Product product3 = new Product(BigDecimal.valueOf(100),null);
        Product product4 = new Product(BigDecimal.valueOf(100),"Category1");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        CategoryValueMap categoryValueMap = new CategoryValueMap(productList);
        //when
        Map<String, BigDecimal> categoryAndTotalValueProduct = categoryValueMap.getCategoryValueMapCreateCategorySummary();

        //then
        assertThat(categoryAndTotalValueProduct.size(),equalTo(1));
    }


}