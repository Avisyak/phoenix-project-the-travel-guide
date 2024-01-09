package com.phoenix.Phoenixprojectwork.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user_table", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name"}, name = "uk_user_userName")})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_table_generator")
    @SequenceGenerator(name = "user_table_generator", sequenceName = "user_table_sequence", initialValue = 1, allocationSize = 1)
    private Integer id;


    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Column(name = "user_password", nullable = false, length = 100)
    private String password;

    @Column(name = "user_email", nullable = false, length = 100)
    private String email;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_mapping",
            foreignKey = @ForeignKey(name = "fk_users_id"),
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseForeignKey = @ForeignKey(name = "fk_users_roles_role_id"),
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map((role) ->
                new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
