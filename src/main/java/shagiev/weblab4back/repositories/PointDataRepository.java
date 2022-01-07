package shagiev.weblab4back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shagiev.weblab4back.beans.PointBean;

import java.util.List;

@Repository
public interface PointDataRepository extends JpaRepository<PointBean, Long> {

    List<PointBean> findAllByUsername(String username);

}
