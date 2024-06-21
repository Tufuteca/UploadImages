package com.tufuteca.uploadImage.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import java.time.LocalDateTime;


@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImage")
    private Long id;

    @Column(name = "date_image_added")
    private LocalDateTime dateImageAdded;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image_data", columnDefinition = "bytea")
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
