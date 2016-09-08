package com.member.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.member.config.MybatisManager;
import com.member.mybatis.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	SqlSession sqlMap;
	
	public MemberDAOImpl(){
		SqlSessionFactory sqlMapper = MybatisManager.getMapper();
		sqlMap = sqlMapper.openSession();
	}

	@Override
	public List<Object> getMemberList(String id) {
		// TODO Auto-generated method stub
		List<Object> userlist = (List<Object>)sqlMap.selectList(id);
		
		return userlist;
	}
	
	@Override
	public List<Object> getMemberList(String id, HashMap<Object, Object> hm) {
		// TODO Auto-generated method stub
		return (List<Object>)sqlMap.selectList(id,hm);
	}

	@Override
	public void insert(String id, MemberVO user) {
		// TODO Auto-generated method stub
		sqlMap.insert(id,user);
		sqlMap.commit();
	}

	@Override
	public MemberVO findById(String id, String ids) {//viewdata,ȫ�浿
		// TODO Auto-generated method stub
		MemberVO vo = sqlMap.selectOne(id,ids);//viewdata,ȫ�浿
		return vo;
	}

	@Override
	public void update(String id, MemberVO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id, String value) {
		// TODO Auto-generated method stub
		sqlMap.delete(id,value);
		sqlMap.commit();
	}

	
}
