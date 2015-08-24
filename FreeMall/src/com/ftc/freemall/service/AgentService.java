package com.ftc.freemall.service;

import java.util.List;

import com.ftc.freemall.vo.AgentVO;

public interface AgentService {
	public List<AgentVO> getAgentList(AgentVO agent) throws Exception;
}
