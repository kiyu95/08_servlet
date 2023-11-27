package com.ohgiraffers.section02;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {

        String value = "";
        if ("password".equals(name)){ // 매개변수로 받은것이 password 인지 확인하고, password가 맞다면 인코딩 해준다.
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
        } else {
            value = super.getParameter(name);
        }
        return value;
    }
}
