package kr.co.hyewon.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.hyewon.bean.UserBean;

public interface UserMapper {

	//아이디 중복검사
	@Select("select user_name from user_table where user_id = #{user_id}")
	String checkUserIdExist(String user_id);  
	// 사용자가 jsp화면에서 입력한 값이 ()안에 프러퍼티를 통해서 mapper까지 전달된다
	// 이렇게 전달된 값이 #{}안에 들어가서 sql문이 실행된다.
	
	
	//회원가입 - 정보저장
	@Insert("insert into user_table (user_idx, user_id, user_name, user_pw) " +
			"values (user_seq.nextval, #{user_id}, #{user_name}, #{user_pw})" )
	void addUserInfo(UserBean joinUserBean);

	//로그인처리
	@Select("select user_idx, user_name " + 
			"from user_table " + 
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	//정보수정 화면에 사용자 id, name 가져와서 출력하기
	@Select("select user_id, user_name " + 
			"from user_table " +
			"where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(int user_idx);
	
	//정보수정-업데이트
	@Update("update user_table " +
			"set user_pw=#{user_pw} " +
			"where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
	
	
}
