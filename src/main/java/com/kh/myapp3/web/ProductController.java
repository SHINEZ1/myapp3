package com.kh.myapp3.web;


import com.kh.myapp3.domain.Product;
import com.kh.myapp3.domain.svc.ProductSVC;
import com.kh.myapp3.web.form.SaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


  private final ProductSVC productSVC;

  //등록양식
  @GetMapping("/add")
  public String saveForm(){

    return "product/addForm";    //상품등록 view
  }


  //등록처리
  @PostMapping("/add")
  public String saver(SaveForm saveForm){
    log.info("saveForm:{}",saveForm);
    Product product = new Product();
    product.setPname(saveForm.getPname());
    product.setQuantity(saveForm.getQuantity());
    product.setPrice(saveForm.getPrice());

    Product savedProduct = productSVC.save(product);



    return "redirect:/products/1"+savedProduct.getProductId();   //상품상세 view

  }

  //상품개별조회
  @GetMapping("/{pid}")
  public String findByProductId(
      @PathVariable("pid") String pid,
      Model model
  ){
    //db에서 상품조회


    Product product=new Product();
    model.addAttribute("product",product);

    return "product/itemForm";    //상품 상제 view
  }

  //수정양식
  @GetMapping("/{pid}/edit")      //위에랑 식별이 안돼서 edit 붙여줌
  public String updateForm(){

    return "product/editForm";      //상품 수정 view
  }


  //수정처리.
  @PostMapping("/{pid}/edit")
  public String update(){

    return "redirect:/products/1";     //상품 상세 view
  }


  //삭제처리(화면필요 x)
  @GetMapping("/{pid}/del")
  public String delete(){

    return "redirect:/products";    //전체 목록 view
  }

  //목록화면
  @GetMapping
  public String list(){

    return "product/all";     //전체목록 view
  }


}
