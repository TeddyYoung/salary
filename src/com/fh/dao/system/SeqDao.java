package com.fh.dao.system;

import com.fh.entity.system.Seq;

public interface SeqDao {
	
	public int update(Seq seq);
	
	public Seq get(String seqKey);
	
}