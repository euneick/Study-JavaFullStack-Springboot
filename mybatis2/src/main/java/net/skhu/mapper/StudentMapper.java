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
}