package br.com.nemeia.pc.webscraper.repository;

import br.com.nemeia.pc.webscraper.model.Gpu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GpuRepository extends MongoRepository<Gpu, String> {

}
