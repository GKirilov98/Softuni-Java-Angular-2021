package softuni.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.angular.data.entities.InsProduct;

import java.util.List;

/**
 * Project: backend
 * Created by: GKirilov
 * On: 8/4/2021
 */
@Repository
public interface InsProductRepository extends JpaRepository<InsProduct, Long> {
    List<InsProduct> findAllByInsCompanyId(Long companyId);
    List<InsProduct> findAllByInsTypeId(Long insTypeId);
}
