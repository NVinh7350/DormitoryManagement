package com.example.dormitorymanagement.entity;

import com.example.dormitorymanagement.util.BirthdayContraint;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @NotNull(message = "Không được để trống!")
//    @Pattern(regexp = "[0-9]+", message = "Số CMND/CCCD không được chứa kí tự")
    @Length(min = 12, max = 12, message = "Vui lòng nhập lại số CCCD")
    @Id
    @Column(columnDefinition = "varchar(12)")
    private String studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomId", nullable = false, referencedColumnName = "roomId")

    private Room room;

    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$", message = "Vui lòng nhập lại tên")
    @Column(columnDefinition = "nvarchar(50)")
    private String studentName;

    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "(0+(3|5|7|8|9))+([0-9]{8})+", message = "Vui lòng nhập lại số điện thoại")
    @Column(columnDefinition = "varchar(10)")
    private String phone;

    @NotBlank(message = "Không được để trống!")
    @Email(regexp = "\\S+@\\S+\\.\\S+", message = "Vui lòng nhập lại email")
    @Column(columnDefinition = "varchar(254)")
    private String email;

    @NotNull(message = "Không được để trống!")
    @Past(message = "Ngày sinh không hợp lệ")
    @BirthdayContraint(minAge = 18, maxAge = 30)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotBlank(message = "Không được để trống!")
    @Column(columnDefinition = "varchar(6)")
    private String gender;

    @NotBlank(message = "Không được để trống!")
    @Column(columnDefinition = "nvarchar(100)")
    private String address;

//    @NotBlank(message = "Không được để trống!")
    @Column(columnDefinition = "varchar(10)")
    private String studentState;

    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$", message = "Vui lòng nhập lại tên")
    @Column(columnDefinition = "nvarchar(50)")
    private String relativeName;

    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "(0+(3|5|7|8|9))+([0-9]{8})+", message = "Vui lòng nhập lại số điện thoại")
    @Column(columnDefinition = "varchar(10)")
    private String relativePhone;

    @NotBlank(message = "Không được để trống!")
    @Column(columnDefinition = "nvarchar(100)")
    private String relativeAddress;

    @OneToOne
    @JoinColumn(name = "studentId", nullable = true, referencedColumnName = "userName")
    private Account account;
}
