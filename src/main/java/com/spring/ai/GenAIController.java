package com.spring.ai;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;



@RestController
public class GenAIController {
	
	
	 private final ChatService chatService;
	 private final ImageService imageService;
	 private final RecepieService recipeService;
	 private final CodeReviewService codeReviewService;
	 private final SportsService sportService;
	 
	 private final MockInterviewService interviewService;





	public GenAIController(ChatService chatService, ImageService imageService, RecepieService recipeService,
			CodeReviewService codeReviewService, SportsService sportService, MockInterviewService interviewService) {
		super();
		this.chatService = chatService;
		this.imageService = imageService;
		this.recipeService = recipeService;
		this.codeReviewService = codeReviewService;
		this.sportService = sportService;
		this.interviewService = interviewService;
	}

	@GetMapping("ask-ai")
	public String getResponse(@RequestParam String prompt)
	{
		return chatService.getResponse(prompt);
	}

	@GetMapping("ask-ai-options")
	public String getResponseOptions(@RequestParam String prompt)
	{
		return chatService.getResponseOptions(prompt);
	}

//	@GetMapping("generate-images")
//	public void generateImages(@RequestParam String prompt, HttpServletResponse response) throws IOException
//	{
//			ImageResponse imgResponse = imageService.generateImage(prompt);
//					
//			String url =imgResponse.getResult().getOutput().getUrl();
//	 
//			response.sendRedirect(url);
//	}
	
	@GetMapping("generate-images")
	public List<String> generateImages(@RequestParam String prompt, HttpServletResponse response)
	{
			ImageResponse imgResponse = imageService.generateImage(prompt);
					
			//use stream to get more than one image
			
			List<String> imageUrls = imgResponse.getResults().stream().map(result->result.getOutput().getUrl()).collect(Collectors.toList());
			return imageUrls;
	}
	
	
	@GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                      @RequestParam(defaultValue = "any") String cuisine,
                                      @RequestParam(defaultValue = "") String dietaryRestriction) {
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
    }
	

	    
	@GetMapping("/review")
	    public String codeReview(@RequestParam String code, 
	                            @RequestParam String language) {
	        return codeReviewService.performCodeReview(code, language);
	    }

	   //(input code = SELECT * FROM users WHERE username = 'admin' AND password = '1234'; ,language = sql )
	     // input 2- def calculate_average(numbers):
	    			//sum = 0
	   				// for num in numbers:
	    	    	//    sum += num
	    	    	//return sum / len(numbers)     // pthon
	   
	   
	   @GetMapping("/MockInterview")
	    public String startInterview(@RequestParam String role,
	                                 @RequestParam String experienceLevel) {
	        return interviewService.conductInterview(role, experienceLevel);
	    }
	   
//	   @GetMapping("/sports")
//	   public List<String> aboutSports(@RequestParam String sports)
//	   {		  
//		  return  sportService.findPopularPlayers(sports);
//	   }
	  
	   @GetMapping("/sports")
	   public Player aboutSports(@RequestParam String sportsPerson)
	   {		  
		  return  sportService.findPopularPlayers(sportsPerson);
	   }
}
