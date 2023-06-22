package Dishank.Project01.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @SequenceGenerator(
            name = "Dept_sequence",
            sequenceName = "Dept_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Dept_sequence"
    )
    private Long id;

    @Column(name = "dept_name")
    private String DepartmentName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee>employeeList;
}
