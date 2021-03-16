package ru.alexalexeev;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.alexalexeev.base.enums.Category;
import ru.alexalexeev.dto.Product;
import ru.alexalexeev.service.ProductService;
import ru.alexalexeev.util.DButils;
import ru.alexalexeev.util.RetrofitUtils;
import ru.geekbrains.java4.lesson6.db.dao.CategoriesMapper;
import ru.geekbrains.java4.lesson6.db.dao.ProductsMapper;
import ru.geekbrains.java4.lesson6.db.model.Products;
import ru.geekbrains.java4.lesson6.db.model.ProductsExample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CreateProductTest {
    static ProductService productService;
    Product product;
    Faker faker = new Faker();

    int id;
    Long idL;
    static ProductsMapper productsMapper;
    static CategoriesMapper categoriesMapper;

    @BeforeAll
    static void beforeAll() {
        productsMapper = DButils.getProductsMapper();
        categoriesMapper = DButils.getCategoriesMapper();
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle(Category.FOOD.title)
                .withPrice((int) (Math.random() * 10000));
    }

    @Test
    @SneakyThrows
    void createProductInFoodCategoryTestTitle() {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body() != null ? response.body().getId() : 666;
        idL = (long) id;

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(String.valueOf(productsMapper.selectByPrimaryKey(idL).getTitle()), is(product.getTitle()));
//        assertThat(String.valueOf(productsMapper.selectByPrimaryKey(Long.valueOf(id))), equals(product.getId()));
//        assertThat(String.valueOf(productsMapper.selectByPrimaryKey(idL).getTitle()), equals(product.getTitle()));

    }
    @Test
    @SneakyThrows
    void createProductInFoodCategoryTestPrice() {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body() != null ? response.body().getId() : 6666;
        idL = (long) id;

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(productsMapper.selectByPrimaryKey(idL).getPrice(), is(product.getPrice()));

    }
    @Test
    @SneakyThrows
    void createProductInFoodCategoryTestUpdate() {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body() != null ? response.body().getId() : 666;
        idL = (long) id;

        Products productUpdate = new Products();
        productUpdate.setTitle("Update by Alex");
        productUpdate.setId(idL);
        productUpdate.setPrice(777);
        productUpdate.setCategory_id(777L);

        ProductsExample example = new ProductsExample();
        example.createCriteria().andIdEqualTo(productUpdate.getId());
        productsMapper.updateByExample(productUpdate, example);

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(String.valueOf(productsMapper.selectByPrimaryKey(idL).getTitle()), is(productUpdate.getTitle()));

    }


    @SneakyThrows
    @AfterEach
    void tearDown() {
        if(product!=null)
            categoriesMapper.deleteByPrimaryKey(id);
//        Response<ResponseBody> response = productService.deleteProduct(id)
//                .execute();
//        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}