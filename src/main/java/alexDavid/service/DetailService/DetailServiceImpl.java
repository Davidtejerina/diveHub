package alexDavid.service.DetailService;

import alexDavid.models.Detail;
import alexDavid.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;

    @Override
    public List<Detail> findByUser(String email) {
        return detailRepository.findByOrder_User_Email(email);
    }

    @Override
    public Detail addDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public void deleteByUser(String email) {
        this.findByUser(email);
        detailRepository.deleteByOrder_User_Email(email);
    }
}