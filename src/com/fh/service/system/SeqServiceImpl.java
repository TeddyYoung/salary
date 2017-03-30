package com.fh.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.dao.system.SeqDao;
import com.fh.entity.system.Seq;

@Service
public class SeqServiceImpl implements SeqService {

	@Autowired
	private SeqDao seqDao;
	
	public String getSeqNo(String seqKey) {
		Seq seq = this.seqDao.get(seqKey);
		String seqNo = String.valueOf(seq.getSeqNo());
		int length = seqNo.length();
		for (int i = 0; i < seq.getSeqCount() - length; i++) {
			seqNo = "0" + seqNo;
		}
		String endString =  seq.getSeqKeyEnd();
		if(endString == null){
			endString = "";
		}
		String resultStr = seq.getSeqKeyBegin() + seqNo + endString;
		seq.setSeqNo(seq.getSeqNo() + 1);
		this.seqDao.update(seq);
		return resultStr;
	}

}
