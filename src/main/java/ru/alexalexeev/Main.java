package ru.alexalexeev;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.geekbrains.java4.lesson6.db.dao.CategoriesMapper;
import ru.geekbrains.java4.lesson6.db.dao.ProductsMapper;
import ru.geekbrains.java4.lesson6.db.model.Categories;
import ru.geekbrains.java4.lesson6.db.model.CategoriesExample;
import ru.geekbrains.java4.lesson6.db.model.Products;
import ru.geekbrains.java4.lesson6.db.model.ProductsExample;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory;
        //NyBatis Configuration file
        String resource = "mybatisConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession(true);
        CategoriesMapper categoriesMapper = session.getMapper(CategoriesMapper.class);
        long categoriesCount = categoriesMapper.countByExample(new CategoriesExample());
        System.out.println("Количество категорий: " + categoriesCount);

        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
//        Products product2474 = productsMapper.selectByPrimaryKey(2475L);
//        productsMapper.deleteByPrimaryKey(product2474.getId());
//        session.commit();
//        System.out.println("Количество категорий: " + product2474);

        //productsMapper.updateByExample();
//        Products product = new Products();
//        product.setTitle("update");
//        product.setId(2477L);
//        product.setPrice(20000);
//        product.setCategory_id(2L);

//        ProductsExample example = new ProductsExample();
//        example.createCriteria().andIdEqualTo(2477L);
//        productsMapper.updateByExample(product, example);

//        Categories newCategories = new Categories();
//        newCategories.setId(666);
//        newCategories.setTitle("Furniture");
//        categoriesMapper.insert(newCategories);

        Products product = new Products();
        product.setTitle("3A update");
        product.setId(2700L);
        product.setPrice(270);
        product.setCategory_id(2L);

        ProductsExample example = new ProductsExample();
        example.createCriteria().andIdEqualTo(product.getId());
        productsMapper.updateByExample(product, example);

        productsMapper.insert(new Products(null,"Hendmade by Alex", 666,1L));
    }
}