package com.article.service;



import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService {
	
	@Autowired
	RabbitTemplate template;
	
	public String testMethod(){
		
		template.convertAndSend("testQueue", "This is test new");
		return "success";
	}
	public String testmethod()
	{
		Message message = template.receive("testQueue");
		message.getBody();
		return message.getBody().toString();
	}
	public String testJWT()
	{
		return "test";
	}
	
	/*public String testMethod(){
		
		Article article = new Article();
		article.setName("One Indian Girl");
		article.setAuthor("Chethan Bhagath");
		article.setPrice(new BigDecimal(450));
		article.setGst(new BigDecimal(10));
		articleRepository.save(article);
		return "Success";
	}*/

}
