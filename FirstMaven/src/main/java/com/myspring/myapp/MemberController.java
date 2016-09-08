package com.myspring.myapp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.mybatis.mapper.MemberService;
import com.member.mybatis.vo.MemberVO;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;

	// 전체보기
	@RequestMapping("member_list")
	public ModelAndView getList(String field, String word) {
		word=word==null?"":word.trim();
		
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		ModelAndView mv = new ModelAndView();
		
		List<Object> userlist = memberService.getMemberList(hm);
		mv.addObject("userlist", userlist);
		mv.setViewName("list");
		return mv;
	}
	
	//회원가입 폼
	@RequestMapping("member_insert")
	public ModelAndView insert(){
		return new ModelAndView("insert");
	}

	//회원가입
	@RequestMapping(value="member_insert", method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute MemberVO vo){
		memberService.insert(vo);
		return new ModelAndView("redirect:member_list");
	}
	
	//상세보기
	@RequestMapping("member_detail")
	public ModelAndView findbyId(String id){
		ModelAndView mv = new ModelAndView();
		MemberVO vo = (MemberVO)memberService.findById(id);
		mv.addObject("user", vo);
		mv.setViewName("detail");
		return mv;
	}
	
	//삭제
	@RequestMapping("member_delete")
	public ModelAndView delete(String id){
		memberService.delete(id);
		return new ModelAndView("redirect:member_list");
	}
	
	//수정
	@RequestMapping("member_update")
	public ModelAndView update(String id){
		//memberService.update(vo);
		return new ModelAndView("redirect:member_detail");
	}
	
}
