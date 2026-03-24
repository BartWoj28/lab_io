package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producer;
import vod.repository.ProducerDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataProducerDao implements ProducerDao {

    private final ProducerRepository producerRepository;

    @Override
    public List<Producer>  findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Producer findById(int id) {
        return producerRepository.findById(id).orElse(null);
    }

    @Override
    public Producer add(Producer p) {
    return producerRepository.save(p);
    }
}
