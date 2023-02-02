package study.servlet.web.frontcontroller.v5.adapter;

import study.servlet.web.frontcontroller.ModelView;
import study.servlet.web.frontcontroller.v4.ControllerV4;
import study.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//v3 컨트롤러를 사용하도록 하는 어댑터
public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    //v4 컨트롤러 사용한다고 확정 받기
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    //v4 컨트롤러 사용
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    //paramMap 생성해 파라미터 전부 가져오기
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
