package study.servlet.web.frontcontroller.v5;

import study.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //어댑터가 해당 컨트롤러를 사용할 수 있는지 판단하는 메소드
    boolean supports(Object handler);

    //실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환해야 한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
