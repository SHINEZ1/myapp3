package com.kh.myapp3;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

  //등록양식
  @GetMapping
  public String saveForm(){

    return "product/saveForm";    //상품등록 view
  }


  //등록처리
  @PostMapping()
  public String saver(){

    return "redirect:/product/1";   //상품상세 view

  }

  //상품개별조회
  @GetMapping("/{pid}")
  public String findByProductId(@PathVariable("pid") String pid){
    //db에서 상품조회

    return "product/detailForm";    //상품 상제 view
  }

  //수정양식
  @GetMapping("/{pid}/edit")      //위에랑 식별이 안돼서 edit 붙여줌
  public String updateForm(){

    return "product/updateForm";      //상품 수정 view
  }


  //수정처리.
  @PostMapping("/{pid}/edit")
  public String update(){

    return "redirect:/product/1";     //상품 상세 view
  }

}
