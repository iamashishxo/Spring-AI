// put inside com.spring.ai; package to work with this 


//package com.spring.ai;
//
//import org.springframework.ai.image.ImagePrompt;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
//import org.springframework.ai.chat.model.ChatModel;
//import org.springframework.ai.chat.prompt.PromptTemplate;
//import org.springframework.ai.image.ImageModel;
//import org.springframework.ai.image.ImageOptions;
//import org.springframework.ai.image.ImageOptionsBuilder;
//
//@Service
//public class CodeDiagramGenerator {
//
//
//    private final ChatModel chatModel;
//    private final ImageModel imageModel;
//
//	public CodeDiagramGenerator(ChatModel chatModel, ImageModel imageModel) {
//		super();
//		this.chatModel = chatModel;
//		this.imageModel = imageModel;
//	}
//
//    public Map<String, String> generateCodeDiagram(String code) {
//        // Step 1: Generate PlantUML
//        String descPrompt = """
//        Convert this code into a visual diagram description:
//        {code}
//        
//        Output should be in PlantUML syntax with technical accuracy.
//        Include these elements:
//        - Components as rectangles
//        - Relationships as arrows
//        - Notes where needed
//        - Proper namespace grouping
//        """;
//        
//        String plantUml = chatModel.call(new PromptTemplate(descPrompt)
//                             .create(Map.of("code", code)))
//                             .getResult().getOutput().getText();
//
//        // Step 2: Generate diagram image
//        ImageOptions options = ImageOptionsBuilder.builder()
//                .model("dall-e-3")
//               // .withQuality("hd")
//                //.withStyle("natural")
//                .build();
//
//        ImagePrompt imagePrompt = new ImagePrompt(
//            "Generate a technical architecture diagram from this PlantUML:\n" + plantUml,
//            options
//        );
//
//        String imageUrl = imageModel.call(imagePrompt)
//                             .getResult().getOutput().getUrl();
//
//        return Map.of(
//            "plantUml", plantUml,
//            "imageUrl", imageUrl
//        );
//    }
//
//
//
//
//}


