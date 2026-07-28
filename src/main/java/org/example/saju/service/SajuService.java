package org.example.saju.service;

import org.example.saju.dto.SajuRequestDTO;
import org.example.saju.dto.SajuResultDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class SajuService {
    private final ChatClient chatClient;

    public SajuService(ChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel)
                .defaultSystem("너는 사주 전문가야. 200자 이내로, 물어보는 주제에 대해서 가능한 긍정적인 내용을 담아서 답변해줘.")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("openai/gpt-oss-120b")
                        .maxTokens(1024)
                        .temperature(0.3))
                .build();
    }

    public SajuResultDTO invoke(SajuRequestDTO dto) {
        return chatClient.prompt().user(dto.question())
                .call()
                .responseEntity(SajuResultDTO.class)
                .entity();
    }
}