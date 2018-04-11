package ones.quzhigang.order.dao;

import ones.quzhigang.order.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
