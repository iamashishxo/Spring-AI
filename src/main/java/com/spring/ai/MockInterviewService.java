package com.spring.ai;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class MockInterviewService {

    private final ChatModel chatModel;
    


    public MockInterviewService(ChatModel chatModel) {
		super();
		this.chatModel = chatModel;
	}



	public String conductInterview(String role, String experience) {
        String template = """
        Act as a {role} technical interviewer for a {experience} candidate.
        Follow this pattern:
        1. Start with 2 warm-up questions
        2. Ask 3 technical questions increasing in difficulty
        3. Present 1 system design/problem-solving scenario
        4. Finish with 1 behavioral question
        
        After each question, wait for candidate response before proceeding.
        Format questions clearly with difficulty indicators.
        """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
            "role", role,
            "experience", experience
        );
        
        return chatModel.call(promptTemplate.create(params))
               .getResult().getOutput().getText();
    }
}