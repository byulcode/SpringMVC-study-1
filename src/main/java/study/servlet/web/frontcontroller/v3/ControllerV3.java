package study.servlet.web.frontcontroller.v3;

import study.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    public ModelView process(Map<String, String> paramMap);
}
