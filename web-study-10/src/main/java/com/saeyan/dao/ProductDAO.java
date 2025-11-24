package com.saeyan.dao;

// JDBC 관련 클래스 import
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;
import util.DBManager;

public class ProductDAO {

    // 🔹 싱글톤 패턴: DAO 객체를 애플리케이션 전체에서 하나만 쓰도록 하기 위한 static 인스턴스Z
    private static ProductDAO instance = new ProductDAO();
    
    // 🔹 생성자를 private으로 막아서 외부에서 new ProductDAO() 못 하게 함
    private ProductDAO() {}
    
    // 🔹 외부에서는 이 메서드를 통해서만 ProductDAO 인스턴스를 가져올 수 있음
    public static ProductDAO getInstance() {
        return instance;
    }
    
    
    // =========================
    // 1. 전체 상품 목록 조회 메서드
    // =========================
    // product 테이블의 전체 데이터를 code 내림차순으로 가져와서 List<ProductVO>로 반환
    public List<ProductVO> selectAllProuducts() {
        
        Connection con = null;        // DB 연결 객체
        PreparedStatement pstmt = null; // SQL 실행을 위한 PreparedStatement
        ResultSet rs = null;          // SELECT 결과를 담는 ResultSet
        
        // code 기준으로 내림차순 정렬해서 전체 조회
        String sql =  "select * from product order by code desc";
        
        // 결과를 담을 리스트
        List<ProductVO> list = new ArrayList<ProductVO>();
        
        // 반복문 안에서 사용할 VO 객체
        ProductVO vo = null;
        
        try {
            // 1. DB 연결
            con = DBManager.getConnection();
            
            // 2. SQL 구문을 전송할 PreparedStatement 생성
            pstmt = con.prepareStatement(sql);
            
            // 3. (현재 쿼리는 ? 파라미터가 없어서 맵핑할 값이 없음)
            
            // 4. SQL 실행 → SELECT이므로 executeQuery() 사용
            rs = pstmt.executeQuery();
            
            // 5. 가져온 데이터를 한 행(row)씩 읽어서 VO에 담고, 리스트에 추가
            /*
             * product 테이블 구조 예시
             * create table product(
             *     code int  auto_increment primary key,
             *     name varchar(100),
             *     price int,
             *     pictureurl varchar(50),
             *     description varchar(1000)    
             * );
             */
            while(rs.next()) { // 다음 행이 있으면 true
                vo = new ProductVO();
                
                // ResultSet에서 컬럼 값 꺼내서 VO의 필드에 채워 넣기
                vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setPrice(rs.getInt("price"));
                vo.setPictureUrl(rs.getString("pictureurl"));
                vo.setDescription(rs.getString("description"));
                
                // 완성된 VO를 리스트에 추가
                list.add(vo);
            }
        
        } catch(Exception e) {
            // 예외 발생 시 콘솔에 스택 트레이스 출력
            e.printStackTrace();
        } finally {
            // 사용한 자원 정리 (연결, statement, resultset 닫기)
            DBManager.close(con, pstmt, rs);
        }
        
        // 최종적으로 상품 목록 리스트 반환
        return list;
    } // end selectAllProuducts

    
    // =========================
    // 2. 상품 추가(INSERT) 메서드
    // =========================
    // ProductVO에 담긴 정보를 product 테이블에 한 행으로 저장
    public void insertProduct(ProductVO vo) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        // name, price, pictureurl, description 컬럼에 값 삽입
        String sql = "insert into product(name, price, pictureurl, description ) "
                + " values(?, ?, ?, ? )";
        
        try {
            // 1. DB 연결
            con = DBManager.getConnection();
            
            // 2. SQL 전송 준비
            pstmt = con.prepareStatement(sql);
            
            // 3. ? 에 실제 값 맵핑 (1번 ?부터 순서대로)
            pstmt.setString(1, vo.getName());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setString(3, vo.getPictureUrl());
            pstmt.setString(4, vo.getDescription());
            
            // 4. SQL 실행 (INSERT/UPDATE/DELETE 이므로 executeUpdate 사용)
            pstmt.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // 사용한 자원 정리 (ResultSet은 없음)
            DBManager.close(con, pstmt);
        }
        
    } // end insertProduct

    
    // =========================
    // 3. 상품 코드로 한 개 조회 메서드
    // =========================
    // code(primary key)로 product 테이블에서 한 행을 조회해서 ProductVO로 반환
    public ProductVO selectProductByCode(String code) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        // code가 ? 인 행 하나만 조회
        String sql = "select * from product where code = ?";
        
        // 결과를 담을 VO 객체 (조회 결과가 없으면 필드가 비어 있는 상태로 리턴됨)
        ProductVO vo = new ProductVO();
        
        try {
            // 1. DB 연결
            con = DBManager.getConnection();
            
            // 2. SQL 전송 준비
            pstmt = con.prepareStatement(sql);
            
            // 3. ? 에 값 맵핑 (파라미터 code는 String이므로 int로 변환)
            pstmt.setInt(1, Integer.parseInt(code));
            
            // 4. SQL 실행 (SELECT 이므로 executeQuery)
            rs = pstmt.executeQuery();
            
            /*
             * 추천 방식(컬럼명 사용) - 주석처리 되어 있음
             *
             * if(rs.next()) {
             *     vo.setCode(rs.getInt("code") );
             *     vo.setName(rs.getString("name"));
             *     vo.setPrice(rs.getInt("price"));
             *     vo.setPictureUrl(rs.getString("pictureurl"));
             *     vo.setDescription(rs.getString("description"));
             * }
             */

            // 아래는 컬럼 인덱스로 값 꺼내는 비추천 방식 (현재 사용 중)
            // 인덱스는 select * 했을 때 컬럼 순서에 의존하기 때문에, 테이블 구조 변경 시 취약함
            if(rs.next()) {  // 결과가 한 행이라도 있으면 true
                vo.setCode(rs.getInt(1) );
                vo.setName(rs.getString(2));
                vo.setPrice(rs.getInt(3));
                vo.setPictureUrl(rs.getString(4));
                vo.setDescription(rs.getString(5));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // ⚠ 여기서는 rs도 닫아주는 게 더 안전함 (현재 DBManager.close(con, pstmt)만 호출 중)
            // DBManager.close(con, pstmt, rs); 가 더 좋은 형태
            DBManager.close(con, pstmt, rs);
        }
        
        // 조회된 상품 정보가 담긴 VO 반환 (없으면 필드가 비어 있음)
        return vo;
    } // end selectProductByCode

	
		
	//end updateProduct
    public void updateProduct(ProductVO vo) {
	  Connection con = null;
      PreparedStatement pstmt = null;
      
      // name, price, pictureurl, description 컬럼에 값 삽입
      String sql = "update product set name=?,price=?,pictureurl=?," + "description=? where code = ?";
              
      
      try {
          // 1. DB 연결
          con = DBManager.getConnection();
          
          // 2. SQL 전송 준비
          pstmt = con.prepareStatement(sql);
          
          // 3. ? 에 실제 값 맵핑 (1번 ?부터 순서대로)
          pstmt.setString(1, vo.getName());
          pstmt.setInt(2, vo.getPrice());
          pstmt.setString(3, vo.getPictureUrl());
          pstmt.setString(4, vo.getDescription());
          pstmt.setInt(5, vo.getCode());
          
          // 4. SQL 실행 (INSERT/UPDATE/DELETE 이므로 executeUpdate 사용)
          pstmt.executeUpdate();
          
      } catch(Exception e) {
          e.printStackTrace();
      } finally {
          // 사용한 자원 정리 (ResultSet은 없음)
          DBManager.close(con, pstmt);
      }
}

	public void deleteProduct(int code) {
		 Connection con = null;
	     PreparedStatement pstmt = null;
	     
	     // name, price, pictureurl, description 컬럼에 값 삽입
	     String sql = "delete from product where code = ?";
	             
	     
	     try {
	         // 1. DB 연결
	         con = DBManager.getConnection();
	         
	         // 2. SQL 전송 준비
	         pstmt = con.prepareStatement(sql);
	         
	         // 3. ? 에 실제 값 맵핑 (1번 ?부터 순서대로)
	         pstmt.setInt(1, code);
	         
	         // 4. SQL 실행 (INSERT/UPDATE/DELETE 이므로 executeUpdate 사용)
	         pstmt.executeUpdate();
	         
	     } catch(Exception e) {
	         e.printStackTrace();
	     } finally {
	         // 사용한 자원 정리 (ResultSet은 없음)
	         DBManager.close(con, pstmt);
	}//end deleteProduct
	
     }
}


