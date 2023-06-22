package Dishank.Project01.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String address;
    private String departmentName;
    private String PositionName;
}
