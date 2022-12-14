package com.kh.myapp3.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/thyme")
public class ThymeLeafController {

  @GetMapping("/text")
  public String text(Model model){
    model.addAttribute("hello","<b>반갑습니다.</b>");
    model.addAttribute("uhello","<b>반갑습니다.</b>");

    Person p1 = new Person("홍길남",40);
    Person p2 = new Person("홍길북",50);

    model.addAttribute("p1",p2);
    model.addAttribute("p1",p2);

    List<Person> personList = new ArrayList<>();
    personList.add(p1); personList.add(p2);
    model.addAttribute("personList", personList);

    Map<String,Person> personMap = new LinkedHashMap<>();
    personMap.put("1",p1);personMap.put("2",p2);
    model.addAttribute("personMap",personMap);

    Set<Person> personSet = new HashSet<>();
    personSet.add(p1);personSet.add(p2);
    model.addAttribute("personSet", personSet);


    return "thyme/text";
  }

@Data
@AllArgsConstructor
  static class Person{
    private String name;
    private int age;
  }
}
