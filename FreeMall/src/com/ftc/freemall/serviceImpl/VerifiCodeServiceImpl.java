package com.ftc.freemall.serviceImpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ftc.foundation.dao.DefaultDAO;
import com.ftc.freemall.service.VerifiCodeService;
import com.ftc.freemall.vo.VerifiCodeVO;

@Service("verifiCodeService") 
public class VerifiCodeServiceImpl implements VerifiCodeService {
private static final Logger logger = Logger.getLogger(VerifiCodeServiceImpl.class);
	
	@Resource
	private DefaultDAO dao;
	public DefaultDAO getDao() {
		return dao;
	}
	
	public void setDao(DefaultDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void insertVerifiCode(VerifiCodeVO verifiCodeVO) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("insertVerifiCode(VerifiCodeVO) - start"); //$NON-NLS-1$
		}
			try {
			     dao.startTransaction();
				 
				 dao.doInsertResult("vcode.doInsertCode", verifiCodeVO);
			} catch (Exception e) {
				dao.endTransaction();
				e.printStackTrace();
			}finally{
				dao.commitTransation();
			}
		if (logger.isDebugEnabled()) {
			logger.debug("insertVerifiCode(VerifiCodeVO) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public VerifiCodeVO checkVerifiCode(VerifiCodeVO verifiCodeVO) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("checkVerifiCode(VerifiCodeVO) - start"); //$NON-NLS-1$
		}
		
		VerifiCodeVO result=(VerifiCodeVO)dao.toView("vcode.checkexist", verifiCodeVO);
		
		if (logger.isDebugEnabled()) {
			logger.debug("checkVerifiCode(VerifiCodeVO) - end"); //$NON-NLS-1$
		}
		return result;
	}

}
