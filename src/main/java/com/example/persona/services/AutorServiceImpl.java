package com.example.persona.services;

import com.example.persona.entities.Autor;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.AutorRepository;
import com.example.persona.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {   //porque solo cree los metodos para el pageable
        return null;
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try{

            Page<Autor> autor = autorRepository.searchNativo(filtro, pageable);
            return autor;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
