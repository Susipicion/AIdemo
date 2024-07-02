package com.example.aidemo.Controller;


import jakarta.annotation.Resource;
import org.junit.Test;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class AiController {
    @Resource
    private OllamaChatClient chatClient;

    @GetMapping("test")
    public String contextLoads(String message) {
        System.out.println("问:"+message);
        String call = chatClient.call(message);
        System.out.println("答:"+call);
        return call;
    }
}
