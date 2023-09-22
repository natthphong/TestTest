package com.auth2.azuread;

import com.auth2.azuread.test.Iam2MsUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/session")
public class TestSessionController {

    private String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";

    @GetMapping
    public void home(HttpSession session){
        var homeCount = session.getAttribute(HOME_VIEW_COUNT)==null?0:(Integer)session.getAttribute(HOME_VIEW_COUNT);
        session.setAttribute(HOME_VIEW_COUNT,++homeCount);
    }

    @GetMapping("/count")
    public Object count(HttpSession session){
        return Map.of("status","ok","HOME_VIEW_COUNT",session.getAttribute(HOME_VIEW_COUNT));
    }

    @GetMapping("/xml")
    public Object xml(HttpSession session){
        return Iam2MsUser.builder().mobileNo(String.valueOf((Integer) session.getAttribute(HOME_VIEW_COUNT))).build();
    }


}
