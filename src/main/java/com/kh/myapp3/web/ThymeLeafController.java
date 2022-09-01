package com.kh.myapp3.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/thyme")
public class ThymeLeafController {

  @GetMapping("/text")
  public String text(Model model){
    model.addAttribute("hello","<b>반갑습니다.</b>");
    model.addAttribute("uhello","<b>반갑습니다.</b>");

    Person p1 = new Person("홍길남",40);
    Person p2 = new Person("홍길북",40);

    model.addAttribute("p1",p2);
    model.addAttribute("p1",p2);

    List<Person> persons = new ArrayList<>();
    persons.add(p1);
    persons.add(p2);

    model.addAttribute("persons", persons);

    return "thyme/text";
  }

@Data
@AllArgsConstructor
  static class Person{
    private String name;
    private int age;
  }
}
