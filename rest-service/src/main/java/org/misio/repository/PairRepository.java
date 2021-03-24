package org.misio.repository;

import org.misio.model.StringIntegerPair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PairRepository extends JpaRepository<StringIntegerPair, String> {
}
