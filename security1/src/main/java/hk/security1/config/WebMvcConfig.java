package hk.security1.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
mustach? "logic less" 템플릿 엔진으로 뷰와 로직을 명확하게 분리한다.
이 코드를 왜 쓰는가?
Mustache를 사용하기 위함이다! Mustache는 서버 사이드에서 데이터를 채워 사용자에게
보여줄 페이지를 동적으로 생성한다.
=> 데이터 표현과 로직을 분리하며, 유지 보수성과 확장성을 높이는 데 도움을 준다.
*/


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

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

/*
class path란?
java환경에서 클래스 파일들이나 애플리케이션 실행에 필요한 리소스를 찾기 ㅟ해 JVM이 검색하는 디렉토리의 목록을 의미한다.
 src/main/resources 디렉토리의 내용이 빌드 시에 클래스패스에 포함되므로, JVM이 런타임에 이 디렉토리의 리소스들을 찾을 수 있게 되고,
 그렇기 때문에 절대 경로로 하드코딩하는 대신 classpath: 접두사를 사용하여 이 리소스들을 참조합니다.
 */