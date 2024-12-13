package net.skhu.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
 * jakarta.validation 어노테이션
 * 		@NotEmpty 				값 입력 되었는지 확인, int형에는 사용 불가
 * 		@NotNull 				값이 null이거나 비어있는 경우 확인
 * 		@Positive 				정수 변수에 저장된 값이 양수인지 확인
 * 		@PositiveOrZero 		정수의 값 확인 시 0 까지 포함하여 확인
 * 		@NotBlank				공백만 입력되었는지 확인
 * 		@Size(min=2, max=20) 	문자열의 최소 및 최대 크기 확인
 * 		@Patter(regexp="") 		정규표현식 확인
 * 		@Email 					이메일 형식 확인
 * 		@Min(1)					입력 된 값의 최소값 확인
 *		@Max(10) 				입력 된 값의 최대값 확인
 */
@Data
public class StudentEdit {

	int id;

	@NotEmpty(message = "학번을 입력하세요.")
	@NotBlank
	@Size(min = 8, max = 12)
	private String studentNo;

	@NotEmpty(message = "이름을 입력하세요.")
	@NotBlank
	@Size(min = 2, max = 20)
	private String name;

	@Min(1)
	@Positive
	private int departmentId;


	@NotEmpty(message = "성별을 선택하세요.")
	@NotBlank
	@Pattern(regexp = "남자|여자")
	private String gender;

	private boolean absense;

	@Min(1)
	@Max(4)
	private int year;
}
