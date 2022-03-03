package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
 @GetMapping("/")
 public String index() {
 //return "index";
 return "login";
 }
 @GetMapping("/login")
 public String login() {
 //return "login";
 return "login";
 }

 @GetMapping("/loginerror")
 public String loginerror() {
 //return "loginerror";
 return "login";
 }
 
 @GetMapping("/error")
 public String error() {
 //return "loginerror";
 return "login";
 }
}

