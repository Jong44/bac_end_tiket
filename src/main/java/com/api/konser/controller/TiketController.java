package com.api.konser.controller;

import com.api.konser.Response;
import com.api.konser.entity.TIket;
import com.api.konser.service.TiketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tiket")
public class TiketController {
    @Autowired
    TiketService service;

    @GetMapping
    public Response index(){
        return new Response(
                service.findAll(),
                service.findAll().isEmpty() ? "Data kosong" : "Data Berhasil Ditampilkan",
                HttpStatus.OK
        );

    }

    @PostMapping
    public Response store(@Valid @RequestBody TIket param){
        return new Response(service.save(param),"Data berhasil disimpan", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idTiket}")
    public Response show(@PathVariable int idTiket){
        TIket data = service.findById(idTiket);
        return new Response(
                data,
                data != null ? "Data ditemukan" : "Data tidak ditemukan",
                HttpStatus.OK
        );
    }

    @PutMapping(value = "/{idTiket}")
    public Response update(@RequestBody TIket param, @PathVariable int idTiket){
        TIket data = service.update(param, idTiket);
        return new Response(
                data,
                data != null  ? "Data berhasil diubah" : "Data gagal diubah",
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{idTiket}")
    public Response delete(@PathVariable int idTiket){
        if (service.delete(idTiket)){
            return new Response(
                    "Data berhasil dihapus",
                    HttpStatus.OK
            );
        }
        else {
            return new Response(
                    "Data gagal dihapus",
                    HttpStatus.OK
            );
        }
    }

    @GetMapping(value = "/findByNamaTiket")
    public  Response showByName(@RequestParam(value = "namaTiket") String namaTiket){
        if (service.findByName(namaTiket).isEmpty()){
            return new Response(
                    service.findByName(namaTiket),
                    "Data tidak ditemukan",
                    HttpStatus.OK
            );
        }
        else {
            return new Response(
                    service.findByName(namaTiket),
                    "Data berhasil ditemukan",
                    HttpStatus.OK
            );
        }
    }




}
