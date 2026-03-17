package vod.repository;

import vod.model.Producer;

import java.util.List;

public interface ProducerDao {

    List<Producer> findAll();

    Producer findById(int id);

    Producer add(Producer d);


}
