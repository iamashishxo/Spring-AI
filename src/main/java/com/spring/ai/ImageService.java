package com.spring.ai;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;



@Service
public class ImageService {
	
	
	private OpenAiImageModel imagemodel;

	public ImageService(OpenAiImageModel imagemodel) {
		super();
		this.imagemodel = imagemodel;
	}
	

	
	public ImageResponse generateImage(String prompt)
	{
//		ImageResponse imageResponse = imagemodel.call(new ImagePrompt(prompt));
//		return imageResponse;
		
		ImageResponse imageResponse = imagemodel.call(new ImagePrompt(prompt ,OpenAiImageOptions.builder()
				//.model("")
		        .quality("hd")
		        .N(1)
		        .height(1024)
		        .width(1024).build()));
		return imageResponse;
		
		
		

		
		
	}
}
	
//	public ImageResponse generateImage(String prompt,
//            //String quality,
//            int n,
//            int width,
//            int height){
////ImageResponse imageResponse = openAiImageModel.call(
////new ImagePrompt(prompt));
//
////ImageResponse imageResponse = openAiImageModel.call(
////new ImagePrompt(prompt,
////OpenAiImageOptions.builder()
////     .withModel("dall-e-2")
////     .withQuality("hd")
////     .withN(3)
////     .withHeight(1024)
////     .withWidth(1024).build())
////);
//
//
//ImageResponse imageResponse = imagemodel.call(
//new ImagePrompt(prompt,
//OpenAiImageOptions.builder()
//     .withModel("gpt-image-1")
//     //.withQuality(quality)
//     .withN(n)
//     .withHeight(height)
//     .withWidth(width).build())
//);
//
//return imageResponse;
//}
//}
