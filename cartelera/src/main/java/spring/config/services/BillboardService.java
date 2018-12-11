package spring.config.services;

import model.Billboard;
import model.DAO.BillboardDAO;
import model.repositories.BillboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.BillboardMarshaller;

@Component("billboardService")
public class BillboardService {

    @Autowired
    private BillboardDAO billboardRepository;

    public void save(Billboard billboard){
        this.billboardRepository.save(billboard);
    }
}
