package com.maybank.emaiApp.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.maybank.emaiApp.Models.DemoSelfieModel;

public interface IDemoSelfieRepository extends CrudRepository<DemoSelfieModel,UUID> {
	Optional<DemoSelfieModel> findByNikId(UUID nikId);
}
