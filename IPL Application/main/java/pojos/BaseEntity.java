package pojos;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

public BaseEntity() {
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Override
public String toString() {
	return "BaseEntity [id=" + id + "]";
}


}
