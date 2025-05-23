package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller //аннотация, которая указывает, что класс является контроллером в Spring MVC.
public class HelloController {
	//GET-запросы являются основным способом получения данных с сервера в веб-приложениях
	@GetMapping( "/") //Эта аннотация указывает, что метод printWelcome будет обрабатывать
	// GET-запросы по корневому URL ("/"). Корневой URL это домашняя страница сайта основная
	public String printWelcome(ModelMap model) { //Метод, который будет вызван при получении GET-запроса
		// на корень приложения. Он принимает объект ModelMap, который используется для передачи данных из
		// контроллера в представление.
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages); //Список сообщений добавляется в модель под
		// именем "messages". Это позволяет передать данные в представление.
		return "index";//Метод возвращает строку "index", что указывает на то, что нужно отобразить
		// представление с именем "index". Это будет соответствовать файлу index.html в папке шаблонов.
	}
}
/*Взаимодействие между контроллером и шаблоном(index.html)!!!!!!!!!!!!!!!!
Когда пользователь отправляет GET-запрос на корень приложения ("/"), контроллер HelloController
обрабатывает этот запрос, создает список сообщений и добавляет его в модель.
 Затем он возвращает имя представления "index", которое соответствует HTML-шаблону.
 Thymeleaf обрабатывает шаблон, заменяя переменные на соответствующие значения из модели,
 и генерирует финальный HTML-код, который отправляется пользователю в ответ на запрос.
Таким образом, пользователь видит на странице три сообщения, которые были определены в контроллере.*/


/*Как это работает:
Запрос от пользователя: Пользователь отправляет запрос на сервер (например, открывает веб-страницу).
Обработка на сервере: Сервер обрабатывает этот запрос, выполняет необходимую бизнес-логику
(например, получает данные из базы данных) и подготавливает модель данных.

Генерация HTML: Шаблонизатор (в данном случае Thymeleaf) берет шаблон и подставляет в него
 данные из модели, создавая финальный HTML-код.

Отправка HTML-кода: Сервер отправляет сгенерированный HTML-код обратно пользователю в ответ на его запрос.

Отображение в браузере: Браузер получает этот HTML-код и интерпретирует его, отображая содержимое на экране.
 Например, если финальный HTML-код содержит три строки сообщений, браузер отобразит их как список или абзацы,
 в зависимости от разметки.
 Таким образом, пользователь видит не сам HTML-код, а его визуальное представление.
 Браузер обрабатывает HTML и отображает его в удобочитаемом формате, который может включать текст,
  изображения, ссылки и другие элементы интерфейса.*/