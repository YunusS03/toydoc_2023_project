package be.thomasmore.toydoc.interceptor;

import be.thomasmore.toydoc.model.AppUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();

                if (principal instanceof UserDetails) {
                    String loginName = ((UserDetails) principal).getUsername();

                    if (principal != null){
                        modelAndView.addObject("loginName", loginName);
                    }
                    if (principal instanceof AppUser) {
                        String firstName = ((AppUser) principal).getFirstName();
                        modelAndView.addObject("firstName", firstName);
                    }
                }
            }
        }
    }
}