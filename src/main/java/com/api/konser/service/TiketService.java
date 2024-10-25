package com.api.konser.service;


import com.api.konser.entity.TIket;
import com.api.konser.repository.TiketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiketService {

    @Autowired
    TiketRepository repository;

    public List<TIket> findAll(){
        return repository.findAll();
    }

    public long count(){
        return repository.count();
    }

    public TIket save(TIket param){
        return repository.save(param);
    }

    public TIket findById(Integer idTiket){
        return repository.findById(idTiket).orElse(null);
    }

    public TIket update(TIket tIket, Integer idTiket){
        TIket referenceData = repository.findById(idTiket).orElse(null);

        if (referenceData != null){
            referenceData.setNamaTiket(tIket.getNamaTiket() != null ? tIket.getNamaTiket() : referenceData.getNamaTiket());
            referenceData.setDeskripsi(tIket.getDeskripsi() != null ? tIket.getDeskripsi() : referenceData.getDeskripsi());
            referenceData.setTanggalKonser(tIket.getTanggalKonser() != null ? tIket.getTanggalKonser() : referenceData.getTanggalKonser());
            referenceData.setImage(tIket.getImage() != null ? tIket.getImage() : referenceData.getImage());
            referenceData.setLokasi(tIket.getLokasi() != null ? tIket.getLokasi() : referenceData.getImage());

            return repository.save(referenceData);
        }

        return null;
    }

    public boolean delete(int idTiket){
        TIket referenceData = repository.findById(idTiket).orElse(null);

        if (referenceData != null){
            repository.delete(referenceData);
            return true;
        }

        return false;
    }

    public List<TIket> findByName(String param){
        return repository.findByNamaTiket(param);
    }


}
