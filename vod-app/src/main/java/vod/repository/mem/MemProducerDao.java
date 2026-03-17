package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.ProducerDao;
import vod.model.Producer;

import java.util.List;

@Repository
public class MemProducerDao implements ProducerDao {
    @Override
    public List<Producer> findAll() {
        return SampleData.producers;
    }

    @Override
    public Producer findById(int id) {
        return SampleData.producers.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Producer add(Producer d) {
        int max = SampleData.producers.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.producers.add(d);
        return d;
    }
}
