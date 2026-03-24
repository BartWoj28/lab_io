package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
