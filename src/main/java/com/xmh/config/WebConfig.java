package com.xmh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.xmh.interceptor.AdminToUser;
import com.xmh.interceptor.LoginInterceptor;
import com.xmh.interceptor.UserToAdmin;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	//自定义的拦截器
    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
    
    @Bean
    public AdminToUser getAdminToUser() {
        return new AdminToUser();
    }
    
    @Bean
    public UserToAdmin getUserToAdmin() {
        return new UserToAdmin();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration r1 = registry.addInterceptor(getLoginInterceptor());
        r1.excludePathPatterns("/userlogin.jsp");
        r1.excludePathPatterns("/userRegister0");
        r1.excludePathPatterns("/tomain");
        r1.excludePathPatterns("/toadmain");
        r1.excludePathPatterns("/addUser");
        r1.excludePathPatterns("/static/**");
        r1.excludePathPatterns("/img/**");
        r1.excludePathPatterns("/chinasofti/**");
        r1.excludePathPatterns("/UserLoginController");
        r1.excludePathPatterns("/AdminLoginController");
        r1.addPathPatterns("/**");
        
        InterceptorRegistration r2 = registry.addInterceptor(getAdminToUser());
        r2.addPathPatterns("/meal");
        r2.addPathPatterns("/cart");
        r2.addPathPatterns("/myOrders");
        r2.addPathPatterns("editUser");
        
        InterceptorRegistration r3 = registry.addInterceptor(getUserToAdmin());
        r3.addPathPatterns("/mealseriesManage");
        r3.addPathPatterns("/mealManage");
        r3.addPathPatterns("/ordersManage");
        r3.addPathPatterns("/usersManage");
        r3.addPathPatterns("/adminManage");
    }
}
