package com.ftc.freemall.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.foundation.dao.DefaultDAO;
import com.ftc.freemall.service.AgentService;
import com.ftc.freemall.vo.AgentVO;

@Service("agentService") 
public class AgentServiceImpl implements AgentService {
	private static final Logger logger = Logger.getLogger(AgentServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<AgentVO> getAgentList(AgentVO agent) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentList(AgentVO) - start"); //$NON-NLS-1$
		}
		List<AgentVO> agentList = null;
			try {
			     dao.startTransaction();
			     agentList = (List<AgentVO>)dao.toList("agent.getAgentList", agent);
				 
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
			
		if (logger.isDebugEnabled()) {
			logger.debug("getAgentList(AgentVO) - end"); //$NON-NLS-1$
		}
		return agentList;
	}

}
