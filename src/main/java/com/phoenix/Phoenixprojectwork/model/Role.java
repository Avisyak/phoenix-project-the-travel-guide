package com.phoenix.Phoenixprojectwork.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"role_name"}, name = "uk_role_roleName")})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_table_generator")
    @SequenceGenerator(name = "role_table_generator", sequenceName = "role_table_sequence",
            initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(name = "role_name", nullable = false, length = 50)
    private String name;

    @Column(name = "is_active")
    private boolean isActive = true;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<User> users;
}
