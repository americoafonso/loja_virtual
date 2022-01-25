package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AcessoRepository;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;
}
