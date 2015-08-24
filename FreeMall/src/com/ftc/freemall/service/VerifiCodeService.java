package com.ftc.freemall.service;

import com.ftc.freemall.vo.VerifiCodeVO;

public interface VerifiCodeService {
	public void insertVerifiCode (VerifiCodeVO verifiCodeVO) throws Exception;
	public VerifiCodeVO checkVerifiCode (VerifiCodeVO verifiCodeVO) throws Exception;
}
