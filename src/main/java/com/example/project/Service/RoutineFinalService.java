package com.example.project.Service;

import com.example.project.domain.RoutineFinal;
import com.example.project.repository.RoutineFinalRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineFinalService {

    private final EntityManager em;

    public List<RoutineFinal> findAllRoutines() {
        return em.createQuery("select  r from RoutineFinal  r", RoutineFinal.class)
                 .getResultList();
    }

}
