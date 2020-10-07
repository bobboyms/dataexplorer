package br.com.next.dataexplorer.repository;

import br.com.next.dataexplorer.modeldto.ModelDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MainRepository {

    private static List<ModelDto> modelDtos = new ArrayList<>();

    public void save(ModelDto modelDto) {
        modelDtos.add(modelDto);
    }

    public List<ModelDto> findAll() {
        return modelDtos;
    }

    public ModelDto find(Long id) {

        final List<ModelDto> model = modelDtos.stream()
                .filter((modelDto -> modelDto.getId().equals(id)))
                .collect(Collectors.toList());

        if (model.size() > 0) {
            return model.get(0);
        }

        return null;
    }

    public boolean delete(Long id) {

        Optional<ModelDto> result = Optional.ofNullable(find(id));

        if (result.isPresent()) {

            modelDtos = modelDtos.stream()
                    .filter((modelDto -> !modelDto.getId().equals(id)))
                    .collect(Collectors.toList());

            return true;
        }

        return false;

    }

}
