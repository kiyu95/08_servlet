package com.ohgiraffers.section02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListenerTest() {
        System.out.println("context가 로드될 때 인스턴스를 생성함");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // session이 생성될 때 동작한다
        System.out.println("create session");
        System.out.println("생성된 session id : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // session이 소멸되는 시점이 실행
        System.out.println("session destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // session의 attribute가 add될때 동작한다.
        System.out.println("session attribute added");
        System.out.println("session에서 추가된 attribute : " + event.getName() + " , " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // session의 attribute가 제거될때 동작한다.
        System.out.println("session Attribute removed");
        System.out.println("session에서 제거된 attribute : " + event.getName() + " , " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // session의 attribute가 변경될때 동작한다.
        System.out.println("session Attribute replaced");
        System.out.println("session 수정된 attribute : " + event.getName() + " , " + event.getValue());
    }
}
