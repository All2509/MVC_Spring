package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//AbstractAnnotationConfigDispatcherServletInitializer — это базовый класс,
// который упрощает настройку DispatcherServlet и конфигурации Spring.
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;//В данном случае метод возвращает null, что означает, что нет
        // дополнительных классов конфигурации для корневого контекста.
    }

//Этот метод указывает классы конфигурации, которые будут использоваться для настройки
// контекста DispatcherServlet
    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class //пояснение ниже
        };
    }
    /*В данном случае возвращается массив с одним элементом — классом WebConfig. Этот класс,
     скорее всего, содержит настройки, такие как ViewResolver, настройки компонентов Spring MVC
     и другие конфигурации, специфичные для веб-приложения.*/


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //Назначение: Этот метод указывает, какие URL-адреса будут обрабатываться DispatcherServlet.
    // Он определяет, на какие запросы будет реагировать данный сервлет.
//В данном случае возвращается массив с одним элементом — строкой "/", что означает, что все
// запросы к приложению будут обрабатываться этим DispatcherServlet. Это стандартная настройка
// для большинства приложений, так как она позволяет обрабатывать все входящие запросы.
}