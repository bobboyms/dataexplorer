package br.com.next.dataexplorer.service;

import br.com.next.dataexplorer.modeldto.ModelDto;
import br.com.next.dataexplorer.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final MainRepository mainRepository;

    @Autowired
    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void saveModel(ModelDto modelDto) {
        mainRepository.save(modelDto);
    }

    public List<ModelDto> findAll() {
        return mainRepository.findAll();
    }

    public ModelDto find(Long id) {
        return mainRepository.find(id);
    }

    public boolean delete(Long id) {
        return mainRepository.delete(id);
    }

}
