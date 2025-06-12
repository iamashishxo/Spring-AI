package com.spring.ai;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class SportsService {

	
	
	private final ChatModel chatModel;


	public SportsService(ChatModel chatModel) {
		super();
		this.chatModel = chatModel;
	}


     // convert result into list using ListOutputConverter
//	public List<String> findPopularPlayers(@RequestParam String sports)
//	   {
//		
//		
//		ListOutputConverter converter = new ListOutputConverter(new DefaultConversionService());
//		   
//		   String mesage = """
//		   		List of 5 most popular personalities in{sports}
//		   		{format}
//		   		""";
//		   PromptTemplate promptTemplate = new PromptTemplate(mesage);
//		   
//		   Prompt prompt = promptTemplate.create(Map.of("sports",sports , "format",converter.getFormat() ));
//		  
//		  //return  response.getResult().getOutput().getText();
//		   
//		   
//		   return converter.convert(chatModel.call(prompt).getResult().getOutput().getText());
//		  //return chatModel.call(prompt).getResult().getOutput().getText();
//	   }
	
	public Player findPopularPlayers(@RequestParam String sportsPerson)
	   {
		
		
		BeanOutputConverter<Player> converter = new BeanOutputConverter<>(Player.class);
		   
		   String mesage = """
		   		Generate the list of Career achievement  for the sportperson {sportsPerson}.\s
		   		Include the player as the key and achievement as the value for it  
		   		{format}
		   		""";
		   PromptTemplate promptTemplate = new PromptTemplate(mesage);
		   
		   Prompt prompt = promptTemplate.create(Map.of("sportsPerson",sportsPerson , "format",converter.getFormat() ));
		  
		  //return  response.getResult().getOutput().getText();
		   
		   
		   return converter.convert(chatModel.call(prompt).getResult().getOutput().getText());
		  //return chatModel.call(prompt).getResult().getOutput().getText();
	   }
}
