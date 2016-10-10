package it.openstyle;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.core.convert.converter.Converter;


@SpringBootApplication
public class SkirApplication// extends WebMvcConfigurerAdapter implements ApplicationContextAware 
{

	//private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(SkirApplication.class, args);
	}
	
	@Bean
	public MessageRepository messageRepository() {
		return new InMemoryMessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}
	
	/*
	@Bean
	  public ViewResolver viewResolver() {
	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	    resolver.setTemplateEngine(templateEngine());
	    resolver.setCharacterEncoding("UTF-8");
	    return resolver;
	  }

	  @Bean
	  public TemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setEnableSpringELCompiler(true);
	    engine.setTemplateResolver(templateResolver());
	    return engine;
	  }

	  private ITemplateResolver templateResolver() 
	  {
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setApplicationContext(applicationContext);
	    resolver.setPrefix("/WEB-INF/templates/");
	    resolver.setTemplateMode(TemplateMode.HTML);
	    return resolver;
	  }


	

	  public void setApplicationContext(ApplicationContext applicationContext) {
	    this.applicationContext = applicationContext;
	  }*/
}
