package com.izabel.localiza.repository;

import com.izabel.localiza.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> getPositionByPlateAndPositionDate(String plate, Date positionDate);
}
