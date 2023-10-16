package hk.security1.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8"); //내가 너한테 던질 파일은 html파일이야
        resolver.setPrefix("classpath:/templates/");  //classpath는 프로젝트
        resolver.setSuffix(".html");

        registry.viewResolver(resolver); //registry로 viewResolver등록
    }
}
