package net.skhu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentEdit {

	private int id;

	@NotEmpty(message = "학번을 입력하세요.")
	@NotBlank
	@Size(min = 8, max = 12)
	private String studentNo;

	@NotEmpty(message = "이름을 입력하세요.")
	@NotBlank
	@Size(min = 2, max = 20)
	private String name;

	@Min(value = 1, message = "학과를 선택하세요.")
	@Positive
	private int departmentId;

	@NotEmpty(message = "휴대폰 번호를 입력하세요.")
	@NotBlank
	@Pattern(regexp = "010-[0-9]{3,4}-[0-9]{4}")
	private String phone;


	@NotEmpty(message = "성별을 선택하세요.")
	@NotBlank
	@Pattern(regexp = "남|여")
	private String sex;

	@NotEmpty(message = "이메일을 선택하세요.")
	@Email
	private String email;
}
