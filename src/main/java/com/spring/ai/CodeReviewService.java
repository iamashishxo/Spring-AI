package com.spring.ai;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class CodeReviewService {

    private final ChatModel chatModel;

    public CodeReviewService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String performCodeReview(String code, String language) {
        String template = """
        Analyze this {language} code for:
        - Security vulnerabilities
        - Performance optimizations
        - Code smells
        - Best practice violations
        - Alternative implementations
        
        Code:
        {code}
        
        Provide output in Markdown with severity ratings (🔴 High | 🟠 Medium | 🟢 Low) 
        and concrete examples for fixes.
        """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
            "language", language,
            "code", code
        );
        
        return chatModel.call(promptTemplate.create(params))
               .getResult().getOutput().getText();
    }
}
