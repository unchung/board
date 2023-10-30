package com.example.common.Controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthHandler implements HandlerInterceptor {
    /*
     * 1. HandlerInterceptor를 상속받습니다.
     *
     * preHandle()-컨트롤러 진입전에 실행
     * postHandle()-컨트롤러 수행 후에 실행
     * afterCompletion()-화면으로 가기 직전에 수행
     *
     * 2. 인터셉터클래스를 bean으로 등록
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("인터셉터실행");
        //현재세션을 얻음
        HttpSession session=request.getSession();
        String user_id=(String)((HttpSession) session).getAttribute("user_id");

        if(user_id==null) {//로그인이 안됨
            response.sendRedirect(request.getContextPath()+"/user/login"); //로그인페이지로 리다이렉션. 절대경로로 적는다.
            return false;//컨트롤러를 실행하지 않음
        }

        return true; //컨트롤러가 그대로 실행
    }
}
