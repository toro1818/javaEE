package bjtu.edu.ebookshoprestful.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "rolename",unique = true)
    private String rolename;

    @ManyToMany(mappedBy = "roles")
    private List<UserInfo> users=new ArrayList<>();


}
