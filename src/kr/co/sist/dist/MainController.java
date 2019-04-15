package kr.co.sist.dist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.controller.Controller;
import kr.co.sist.controller.DeptController;
import kr.co.sist.controller.EmpController;

/**
 * ������ : ��� ��û�� �ް�, ��û�� ó���� Controller�� Map���� ã�Ƽ� ������ �Ѵ�.
 * 			  View�� �̵�
 * @author owner
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Controller> distMap;

	static { // ���� : �����ڰ�, ȣ������ �ʰ� �ڹ��ڵ带 �ڵ����� �����ؾ� �� �� 
		// instance���� - ��ü�� ������ ������ �ڵ� ȣ��(�����ں��� ���� ����)
		// static ���� - JVM�� ����ǰ� ���� Ŭ������ �����Ǹ� �ڵ����� �ѹ� ȣ��(�켱���� ���� ���� ����)
		distMap = new HashMap<String, Controller>();
		distMap.put("D001",new DeptController()); // �μ� ��ȸ ����
		distMap.put("E001",new EmpController()); // �����ȸ ����
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // GET ����� ��û�� �־ doPost�� ó��
	} // doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd == null || "".equals(cmd)) { // cmd�� ���� ��, �Ǵ� cmd�� ���� ���� ��
			 cmd ="D001";
		} // end if
		
		Controller controller = distMap.get(cmd);
		if( controller == null ) { // cmd�� �ܺο��� ���Ƿ� �������� �� ó��
			controller = distMap.get("D001"); // �ܺο��� ���Ƿ� �����ϸ� ������ �����Ѵ�.
		} // end if
		// �� �Ķ����ó��, ��������, ����ó�� ����� scope ��ü �����ϴ� ��.
		controller.execute(request, response); // �Ķ����ó��
		// �̵��� ������ URL �ޱ�
		String url = controller.moveURL();
		// �̵���� �ޱ�
		boolean forwardFlag = controller.isForward();
		// ������ �̵�
		pageMove(request, response, url, forwardFlag);
		
		
	} // doPost
	
	public void pageMove(HttpServletRequest request, HttpServletResponse response, 
			String moveURL, boolean isForward) throws ServletException, IOException {
		
		if(isForward) { //forward �̵�
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		} else { // redirect �̵� 
			response.sendRedirect(moveURL);
		} // end else
		
	} // pageMove
	
} // class
