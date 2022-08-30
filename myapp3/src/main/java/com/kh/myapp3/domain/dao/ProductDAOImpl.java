package com.kh.myapp3.domain.dao;

import com.kh.myapp3.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Slf4j
@Repository
@RequiredArgsConstructor    //final필드를 생성자의 매개변수로 해서 생성자를 만들어줌.
public class ProductDAOImpl implements ProductDAO{

  private final JdbcTemplate jt;

//  private  JdbcTemplate jt;

//  생성자 주입
//  ProductDAOImpl(JdbcTemplate jt){
//      this.jt =jt;
//    }
  //등록
//  @Override
//  public Integer save(Product product) {
//    StringBuffer sql = new StringBuffer();
//    sql.append("insert into product values(product_product_id_seq.nextval,'?',?,?)");
//
//    class PreparedStatementCreatorImpl implements PreparedStatementCreator{
//
//      @Override
//      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//        PreparedStatement pstmt = con.prepareStatement(sql.toString(),new String[]{"product_id"});
//        pstmt.setString(1,product.getPname());    //상품명
//        pstmt.setInt(2,product.getQuatity());     //수량
//        pstmt.setInt(3,product.getPrice());       //가격
//        return pstmt;

//  Integer product_id = Integer.valueOf(keyHolder.getKeys().get("product_id").toString());
//    return product_id;

//      }
//    }

  //  @Override
//  public Integer save(Product product) {
//    StringBuffer sql = new StringBuffer();
//    sql.append("insert into product values(product_product_id_seq.nextval,'?',?,?)");
//
//    class PreparedStatementCreatorImpl implements PreparedStatementCreator{
//
//      @Override
//      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//        PreparedStatement pstmt = con.prepareStatement(sql.toString(),new String[]{"product_id"});
//        pstmt.setString(1,product.getPname());    //상품명
//        pstmt.setInt(2,product.getQuatity());     //수량
//        pstmt.setInt(3,product.getPrice());       //가격
//        return pstmt;
//      }
//    }

    @Override
    public Integer save(Product product) {
      StringBuffer sql = new StringBuffer();
      sql.append("insert into product values(product_product_id_seq.nextval,'?',?,?)");

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jt.update(

        con->{
        PreparedStatement pstmt = con.prepareStatement(sql.toString(),new String[]{"product_id"});
        pstmt.setString(1,product.getPname());    //상품명
        pstmt.setInt(2,product.getQuatity());     //수량
        pstmt.setInt(3,product.getPrice());       //가격
        return pstmt;
      }
    , keyHolder);

    Integer product_id = Integer.valueOf(keyHolder.getKeys().get("product_id").toString());
    return product_id;
  }
}
