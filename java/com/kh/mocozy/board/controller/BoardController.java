package com.kh.mocozy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.mocozy.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
}
