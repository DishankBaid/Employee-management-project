package Dishank.Project01.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee_Details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @Column(name = "first_name")
    @NotBlank(message = "First Name is required!")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name is required!")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Invalid Email format!")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @Column(name = "contact_number")
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Contact number should be in ###-###-#### format")
    private String contactNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentID",referencedColumnName = "id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "PositionId",referencedColumnName = "id")
    private Position position;
}
