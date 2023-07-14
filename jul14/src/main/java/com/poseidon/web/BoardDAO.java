package com.poseidon.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlsession;

	public List<BoardDTO> boardList() {
		return sqlsession.selectList("board.boardList");//네임스페이스.id
	}
	
	

}
