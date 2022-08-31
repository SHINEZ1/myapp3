package com.kh.myapp3.test;

import com.kh.myapp3.domain.Product;
import com.kh.myapp3.domain.dao.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class junitTest {

  @Autowired
  private static ProductDAO productDAO;

  @BeforeAll
  static void beforeAll() {
    for (int i = 0; i < 3; i++) {
      Product product = new Product();
      product.setPname("상품1" + (i + 1));
      product.setQuantity(10 + i);
      product.setPrice(10000 + (i * 1000));
      productDAO.save(product);
    }
  }


  @Test
  void test1(){
    log.info("test1() called");
  }
  @Test
  void test2(){
    log.info("test2() called");
  }

  @BeforeEach
  void beforeEach(){
    log.info("beforeEach() called");
  }

  @AfterEach
  void afterEach(){
    log.info("afterEach() called");
  }


  @AfterAll
  static void afterAll(){
    log.info("afterAll() called");
  }

}
