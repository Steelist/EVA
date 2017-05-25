
package fi.tamk.tiko;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
    
    @Modifying
    @Query("Update ShoppingItem t SET t.price=:price WHERE t.id=:id")
    @Transactional
    public void updateTitle(@Param("id") Long id, @Param("price") Double price);
    
    
    @Modifying
    @Query("Update ShoppingItem t SET t.quantity=:quantity WHERE t.id=:id")
    @Transactional
    public void updateCount(@Param("id") Long id, @Param("quantity") int quantity);
}