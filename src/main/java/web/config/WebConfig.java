package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//Данный код представляет собой конфигурацию Spring MVC приложения, использующего Thymeleaf
// в качестве шаблонизатора для генерации HTML-страниц.


@Configuration //конфигурационным классом Spring, который содержит определения бинов.
@EnableWebMvc  //Включает поддержку Spring MVC в приложении.
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean //Создает и настраивает SpringResourceTemplateResolver, который отвечает за
    // разрешение шаблонов Thymeleaf.
    /*Этот метод является важной частью конфигурации приложения на Spring с использованием Thymeleaf
     в качестве движка шаблонов. Он позволяет настроить, где находятся шаблоны, как они называются и
      какова их кодировка, что является критически важным для правильного отображения данных в
       веб-приложении.*/

    public SpringResourceTemplateResolver templateResolver() { //resolver = решатель разрешитель
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);//Метод setApplicationContext
        // устанавливает контекст приложения, который будет использоваться для разрешения ресурсов.
        // Это позволяет templateResolver получать доступ к ресурсам, определенным в контексте Spring.
        templateResolver.setPrefix("/WEB-INF/pages/"); // Указывает, где находятся HTML-шаблоны.
        templateResolver.setSuffix(".html"); //Указывает, что файлы шаблонов имеют расширение .html
        templateResolver.setCharacterEncoding("UTF-8"); //Устанавливает кодировку для шаблонов.
        return templateResolver; //возвращаемый объект templateResolver представляет собой
        // настроенный механизм для разрешения и обработки шаблонов Thymeleaf
    }
//Этот метод является частью конфигурации Spring и используется для интеграции Thymeleaf
// в ваше веб-приложение. template =шаблон ; engine = двигатель
    //Метод templateEngine()  связывает движок шаблонов с разрешателем шаблонов
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver()); //В этом вызове устанавливается
        // шаблонный разрешатель, который будет использоваться для поиска и загрузки шаблонов.
        templateEngine.setEnableSpringELCompiler(true); //Этот вызов включает компилятор
        // Spring Expression Language (SpEL). Включение компилятора может улучшить производительность,
        // так как выражения SpEL будут компилироваться в байт-код
        return templateEngine; //возвращая объект templateEngine, вы делаете его доступным
        // для других компонентов вашего приложения через механизм управления зависимостями Spring.
    }

/*ViewResolverRegistry — это класс, который предоставляет методы для регистрации
различных разрешителей представлений (view resolvers) в Spring MVC. Разрешители представлений
 отвечают за определение того, как обрабатывать и отображать представления
  (например, HTML-страницы) в ответ на запросы.*/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver(); //Здесь создается
        // новый экземпляр ThymeleafViewResolver, который будет использоваться для обработки
        // представлений, возвращаемых из контроллеров.

        resolver.setTemplateEngine(templateEngine());
        /*В этом вызове устанавливается движок шаблонов, который будет использоваться
        ThymeleafViewResolver. Метод templateEngine() должен возвращать настроенный экземпляр
        SpringTemplateEngine, который мы обсуждали ранее. Это связывает разрешитель представлений
         с конкретным движком шаблонов.*/

        registry.viewResolver(resolver);
        /*Этот вызов регистрирует созданный ThymeleafViewResolver в ViewResolverRegistry.
        Это означает, что Spring будет использовать этот разрешитель для обработки представлений,
        когда контроллер возвращает имя представления (например, "example").*/

        resolver.setCharacterEncoding("UTF-8");//Этот вызов устанавливает кодировку
        // символов для разрешителя представлений

        resolver.setContentType("text/html; charset=UTF-8");
        /*Этот вызов устанавливает тип контента, который будет использоваться для ответов,
         генерируемых разрешителем представлений. Установка типа контента
          на "text/html; charset=UTF-8" указывает, что возвращаемые данные будут в формате HTML
           и использовать кодировку UTF-8.*/
    }
}