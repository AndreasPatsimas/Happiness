package org.patsimas.happy.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
    public static final Role ADMIN = new Role(1l, "Administrator");
    public static final Role EMPLOYEE  = new Role(2l, "Employee");
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private  Long roleId;
    
    
    @Column(name="role_name")
    private  String name;
    
    public Role() {
		
	}
    

	public Role(Long roleId, String name) {
		
		this.roleId = roleId;
		this.name = name;
	}


    public Long getRoleId() {
        return roleId;
    }

    
    public String getName() {
        return name;
    }

    

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", name=" + name + '}';
    }
    
    public static final Role getRoleFor(Long rid) throws Exception {

    	if (rid == EMPLOYEE.getRoleId()) {
            return EMPLOYEE;
        }
        else if (rid == ADMIN.getRoleId()) {
            return ADMIN;
        }
        else {
            throw new Exception("Invalid role id: " + rid);
        }
    }
}
