package com.kh.myapp3;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    return "product/all";   //전체목록 view

  }
}
