package Dishank.Project01.Services;

import Dishank.Project01.Entity.Position;
import Dishank.Project01.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    public PositionRepository positionRepository;

    public void saveEmpPosition(Position position) {
        positionRepository.save(position);
    }
}
