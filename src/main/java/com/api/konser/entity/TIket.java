package com.api.konser.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tiket")
@Getter
@Setter
public class TIket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiket")
    private int idTiket;

    @Column(name = "nama_tiket")
    @NotEmpty
    private  String namaTiket;

    @Column(name = "deskripsi", length = 512)
    @NotEmpty
    private String deskripsi;

    @Column(name = "tanggal_konser")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyy")
    @NotNull
    private Date tanggalKonser;

    @Column(name = "lokasi")
    @NotEmpty
    private String lokasi;

    @Column(name = "image")
    @NotEmpty
    private String image;


}
