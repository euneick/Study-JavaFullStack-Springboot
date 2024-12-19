package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Sugang;

@Mapper
public interface SugangMapper {

	@ResultMap("sugang")
	@Select("""
			SELECT
				g.*,
				s.studentNo, s.name,
				l.title, l.year, l.semester
			FROM sugang g
			JOIN student s ON g.studentId = s.id
			JOIN lecture l ON g.lectureId = l.id
			ORDER BY s.studentNo
			""")
	public List<Sugang> selectSugangs();
}
