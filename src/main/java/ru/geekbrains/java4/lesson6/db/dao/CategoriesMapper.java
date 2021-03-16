package ru.geekbrains.java4.lesson6.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ru.geekbrains.java4.lesson6.db.model.Categories;
import ru.geekbrains.java4.lesson6.db.model.CategoriesExample;

public interface CategoriesMapper {
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    long countByExample(CategoriesExample example);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int deleteByExample(CategoriesExample example);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int deleteByPrimaryKey(Integer id);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int insert(Categories record);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int insertSelective(Categories record);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    List<Categories> selectByExample(CategoriesExample example);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    Categories selectByPrimaryKey(Integer id);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int updateByExampleSelective(@Param("record") Categories record, @Param("example") CategoriesExample example);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int updateByExample(@Param("record") Categories record, @Param("example") CategoriesExample example);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int updateByPrimaryKeySelective(Categories record);

//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table categories
//     *
//     * @mbg.generated Mon Mar 15 23:13:16 MSK 2021
//     */
    int updateByPrimaryKey(Categories record);
}