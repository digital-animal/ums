package com.zahid.university;

import com.zahid.courses.Course;
import com.zahid.departments.Department;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "university")
//@Data
@NoArgsConstructor
public class University {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "university_name", nullable = true)
    private String universityName;

    @Getter
    @Setter
    @Column(name = "university_location", nullable = true)
    private String universityLocation;

    @Getter
    @Setter
    @OneToMany(mappedBy = "university")
    private Set<Department> courses = new HashSet<>();

    public University(String universityName, String universityLocation) {
        this.universityName = universityName;
        this.universityLocation = universityLocation;
    }

}
