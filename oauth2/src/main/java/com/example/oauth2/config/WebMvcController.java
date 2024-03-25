package com.example.oauth2.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcController implements WebMvcConfigurer {
    @Override
    // 이름 그대로 ViewResolver를 구성하기 위해 사용된다.
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // Mustache 템플릿 엔진을 사용하여 HTML파일을 렌더링 하기 위한 설정을 한다.
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");
        // MIME 타입이 text/html - 웹 서버는 클라이언트에게 전송하는 데이터의 형식을 알려준다.
        resolver.setContentType("text/html; charset=UTF-8"); //내가 너한테 던질 파일은 html파일이야
        //Mustache 템플릿 파일들은 'resources/templates/디렉토리에서 찾고
        resolver.setPrefix("classpath:/templates/");  //classpath는 java의 classpath로써 jvm이 프로그램을 실행할 때 참조하는 경로이다
        //.html 확장자를 가진 파일로 처리한다.
        resolver.setSuffix(".html");

        registry.viewResolver(resolver); //registry로 viewResolver등록
    }
}
