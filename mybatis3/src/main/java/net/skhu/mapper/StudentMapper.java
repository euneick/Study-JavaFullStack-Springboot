package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

	@Select("""
			SELECT
				s.*, d.name AS departmentName
			FROM student s
			JOIN department d
			ON s.departmentId = d.id
			""")
	public List<Student> selectStudents();


	@Select("""
			SELECT
				s.*, d.name AS departmentName
			FROM student s
			JOIN department d
			ON s.departmentId = d.id
			WHERE s.name LIKE #{name}
			ORDER BY s.id
			""")
	public List<Student> selectSearchedStudent(String name);


	@Select("""
			SELECT
				*
			FROM student s
			WHERE id=#{id}
			""")
	public Student selectStudentById(int id);


	@Update("""
			UPDATE student SET
			studentNo=#{studentNo}, name=#{name}, departmentId=#{departmentId},
			phone=#{phone}, sex=#{sex}, email=#{email}
			WHERE id=#{id}
			""")
	public void updateStudent(Student student);


	@Insert("""
			INSERT INTO student(studentNo, name, departmentId, phone, sex, email)
			VALUES(#{studentNo}, #{name}, #{departmentId}, #{phone}, #{sex}, #{email})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	// 새로운 행을 추가 할 때 자동으로 생성하는 key 값을 사용, 자동으로 생성된 id 값을 Student 객체의 id 필드에 저장
	public void insertStudent(Student stduent);


	@Delete("""
			DELETE FROM student
			WHERE id=#{id}
			""")
	public void deleteStudentById(int id);
}
