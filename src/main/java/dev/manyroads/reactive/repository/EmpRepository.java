package dev.manyroads.reactive.repository;

import dev.manyroads.reactive.model.EmpRecord;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EmpRepository extends R2dbcRepository<EmpRecord, Integer> {
}
