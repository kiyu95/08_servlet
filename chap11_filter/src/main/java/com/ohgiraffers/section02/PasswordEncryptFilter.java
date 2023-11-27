package com.ohgiraffers.section02;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ServletRequest는 사용할 수 없으므로 HttpServletRequest 로 형변환
        /*
        * ServletRequestWrapper 클래스와 ServletResponseWrapper 클래스는 필터가 요청을
        * 변경한 결과 또는 응답을 변결할 결과를 저장할 래퍼 클래스를 나타내며,
        * 개발자는 이 두 클래스를 알맞게 상속하여 요청/응답 정보를 변경하면 된다.
        * */
        RequestWrapper wrapper = new RequestWrapper(httpServletRequest);

        chain.doFilter(wrapper, response);
    }
}
