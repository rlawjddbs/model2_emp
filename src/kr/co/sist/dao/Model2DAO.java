package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.EmpVO;

public class Model2DAO {
	private static Model2DAO jes_dao;
	
	private Model2DAO() {
	} // JsonEmpSearchDAO
	
	public static Model2DAO getInstance() {
		if( jes_dao == null ) {
			jes_dao = new Model2DAO();
		} // end if
		return jes_dao;
	} // getInstance
	
	private Connection getConn() throws SQLException{
		Connection con = null;
		
		try {
			// 1. JNDI 사용객체 생성
			Context ctx = new InitialContext();
			// 2. DBCP에 저장된 DataSource 얻기
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/model2_dbcp");
			// 3. Connection 얻기
			con = ds.getConnection();
		} catch (NamingException ne) {
			ne.printStackTrace();
		} // end catch
		
		return con;
	} // getConn
	
	public List<DeptVO> selectDeptList() throws SQLException {
	      List<DeptVO> list = new ArrayList<DeptVO>();
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         // 1. JNDI 사용 객체 얻기
	         // 2. DataSource를 DBCP에서 꺼내온다.
	         // 3. Connection 얻기
	         con = getConn();
	         // 4. 쿼리문 수행 객체 얻기
	         String selectEmp = "select deptno, dname, loc from dept";
	         pstmt = con.prepareStatement(selectEmp);
	         // 5. 쿼리문 수행 후 결과 얻기
	         rs = pstmt.executeQuery();
	         DeptVO dv = null;
	         while (rs.next()) {
	            dv = new DeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
	            list.add(dv);
	         } // end while
	      } finally {
	         // 6. 연결 끊기
	         if (rs != null) {rs.close();} // end rs
	         if (rs != null) {pstmt.close();   } // end rs
	         if (pstmt != null) {con.close();} // end rs
	      } // end finally
	      
	      return list;
	      
	   }// selectEmpList
	
	
	public List<EmpVO> selectEmpList(int deptno) throws SQLException {
	      List<EmpVO> list = new ArrayList<EmpVO>();
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         // 1. JNDI 사용 객체 얻기
	         // 2. DataSource를 DBCP에서 꺼내온다.
	         // 3. Connection 얻기
	         con = getConn();
	         // 4. 쿼리문 수행 객체 얻기
	         String selectEmp = "select empno, sal, ename, job, hiredate from emp where deptno=?";
	         pstmt = con.prepareStatement(selectEmp);
	         // 5. 쿼리문 수행 후 결과 얻기
	         pstmt.setInt(1, deptno);
	         rs = pstmt.executeQuery();
	         EmpVO ev = null;
	         while (rs.next()) {
	        	ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),rs.getString("hiredate"));
	            list.add(ev);
	         } // end while
	      } finally {
	         // 6. 연결 끊기
	         if (rs != null) {rs.close();} // end rs
	         if (rs != null) {pstmt.close();   } // end rs
	         if (pstmt != null) {con.close();} // end rs
	      } // end finally
	      
	      return list;
	      
	   }// selectEmpList
} // class
