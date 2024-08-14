package com.jovisco.springsecurity.oauth2social.controllers;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecureController {

  @GetMapping("/secure")
  public String securePage(Authentication authentication) {

    if (authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
      log.debug("****** unpwdtoken: {}", usernamePasswordAuthenticationToken.toString());
    } else if (authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken) {
      log.debug("****** oauth2oken: {}", oAuth2AuthenticationToken.toString());

    }
    return "secure.html";
  }
}
