package com.lion.cv.DataFiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BlogTable")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    String name;

    @NotNull
    String message;

    @NotNull
    String title;


    @NotNull
    @Transient
    MultipartFile file;

    @Lob
    @NotNull
    @Type(type="org.hibernate.type.BinaryType")
    byte[] byteFile;


    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    LocalDateTime time;

}
