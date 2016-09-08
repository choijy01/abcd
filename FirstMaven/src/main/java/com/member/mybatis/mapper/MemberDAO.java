package com.member.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.member.mybatis.vo.MemberVO;

public interface MemberDAO {
	//��ü����
	List<Object> getMemberList(String id);
	
	//��ü����
	List<Object> getMemberList(String id, HashMap<Object,Object> hm);
	//�߰�
	void insert(String id, MemberVO user);
	//�󼼺���
	MemberVO findById(String id, String value); //value - where�� ���� id��
	//����
	void update(String id, MemberVO user);
	//����
	void delete(String id ,String value);
}
