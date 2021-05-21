package bjtu.edu.ebookshoprestful.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"u_id","r_id"})},
            joinColumns={@JoinColumn(name="u_id" ,referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="r_id" ,referencedColumnName = "id")}
    )
    private List<Role> roles=new ArrayList<>();
}
