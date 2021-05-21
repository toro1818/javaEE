package bjtu.edu.ebookshoprestful.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@ApiModel(value = "用户对象")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "username",unique = true)
    @ApiModelProperty(value = "用户名")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"u_id","r_id"})},
            joinColumns={@JoinColumn(name="u_id" ,referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="r_id" ,referencedColumnName = "id")}
    )
    private List<Role> roles=new ArrayList<>();
}
