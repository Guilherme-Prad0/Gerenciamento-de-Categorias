package com.rdg.GerenciamentoCategorias.service;

import com.rdg.GerenciamentoCategorias.models.CategoriasModel;
import com.rdg.GerenciamentoCategorias.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    public CategoriasModel save(CategoriasModel categoriasModel) {
        return categoriasRepository.save(categoriasModel);
    }

    public List<CategoriasModel> findAll(){
        return categoriasRepository.findAll();
    }

    public void delete(Long id) {
        categoriasRepository.deleteById(id);
    }

    public CategoriasModel update(Long id, CategoriasModel categoriasModel) {
        Optional<CategoriasModel> categoriaOpt = categoriasRepository.findById(id);

        if(categoriaOpt.isPresent()){
            CategoriasModel categoriaAtual = categoriaOpt.get();

            categoriaAtual.setDescricao(categoriasModel.getDescricao());
            categoriaAtual.setNome(categoriasModel.getNome());

            return categoriasRepository.save(categoriaAtual);
        }
        return null;
    }
    public CategoriasModel findById(Long id) {
        return categoriasRepository.findById(id).orElse(null);
    }

}
