package repository.entity;

import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import javax.validation.constraints.Size;


public class CustomerUpload {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @Size(min = 2, max = 50, message = "loi cmnr")
        private String firstName;

    @Size(min = 2, max = 50, message = "loi cmnr")
        private String lastName;
        private MultipartFile img;
        @ManyToOne
        private TypeCustomer type;

        public CustomerUpload() {
        }

    public CustomerUpload(Long id, String firstName, String lastName, MultipartFile img, TypeCustomer type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public TypeCustomer getType() {
        return type;
    }

    public void setType(TypeCustomer type) {
        this.type = type;
    }
}
