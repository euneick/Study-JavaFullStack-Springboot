package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
			""")
	public List<Student> selectSearchedStudent(String name);

	@Select("""
			SELECT
				*
			FROM student s
			WHERE id=#{id}
			""")
	public Student selectStudentById(int id);

	@Select("""
			UPDATE student SET
			studentNo=#{studentNo}, name=#{name}, departmentId=#{departmentId},
			phone=#{phone}, sex=#{sex}, email=#{email}
			WHERE id=#{id}
			""")
	public void updateStudent(Student student);
}
