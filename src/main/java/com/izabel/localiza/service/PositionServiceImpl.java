package com.izabel.localiza.service;

import com.izabel.localiza.domain.Position;
import com.izabel.localiza.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public Position create(Position position) {
        return this.positionRepository.save(position);
    }
}
