package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Model2DAO;
import kr.co.sist.vo.DeptVO;

/**
 *	Business Logic�� ó���ϴ� Ŭ����
 * @author owner
 */
public class DeptService {

	public List<DeptVO> searchAllDept(){
		
		List<DeptVO> list = null;
		
		Model2DAO m_dao = Model2DAO.getInstance();
		try {
			list = m_dao.selectDeptList();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		
		return list;
	} // searchAllDept
	
} // class