package kr.co.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.DeptService;
import kr.co.sist.vo.DeptVO;

/**
 * 모든 부서정보를 조회하는 일. (요청 하나당 클래스 하나가 처리한다.)
 * @author owner
 */
public class DeptController implements Controller{

	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService ds = new DeptService();
		List<DeptVO> deptList = ds.searchAllDept();
		// 처리된 데이터를 jsp에서 보여주기 위해 scope 객체에 설정
		request.setAttribute("deptList", deptList);
		url = "dept/dept.jsp";
		forwardFlag=true;
	} // execute

	@Override
	public String moveURL() {
		return url;
	} // moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	} // isForward
	
} // class
