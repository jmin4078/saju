package org.example.saju.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.saju.dto.SajuRequestDTO;
import org.example.saju.dto.SajuResultDTO;
import org.example.saju.service.SajuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class SajuController {
    private final SajuService sajuService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String saju(@ModelAttribute SajuRequestDTO dto, HttpSession session) {
        SajuResultDTO result = sajuService.invoke(dto);
        session.setAttribute("question", dto.question());
        session.setAttribute("saju", result.saju());
        return "redirect:/";
    }
}