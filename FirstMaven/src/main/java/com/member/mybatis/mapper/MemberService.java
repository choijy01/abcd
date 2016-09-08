package com.member.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.member.mybatis.vo.MemberVO;

@Service("memberService")
public class MemberService {
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	//전체보기
	public List<Object> getMemberList(){
		return memberDAO.getMemberList("listData");
	}
	
	//전체보기
	public List<Object> getMemberList(HashMap<Object,Object> hm){
		return memberDAO.getMemberList("listData", hm);
	}
		

	//추가
	public void insert(MemberVO vo){
		memberDAO.insert("insertData", vo);
	}
	
	//상세보기
	public MemberVO findById(String ids){
		return memberDAO.findById("viewData", ids);
	}
	
	//삭제
	public void delete(String id){
		memberDAO.delete("deleteData", id);
	}
	
	//수정
	public void update(MemberVO vo){
		memberDAO.update("updateData", vo);
	}
}
