package com.tufuteca.uploadImage.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Column(name = "image_data", columnDefinition = "bytea")
    private byte[] imageData;
}
