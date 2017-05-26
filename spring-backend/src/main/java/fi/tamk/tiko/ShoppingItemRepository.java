package fi.tamk.tiko;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Makes the database interface for the shoppingitems.
 * 
 * @author Eerik Timonen
 * @author Vilho Stenman
 * @author Aleksi Hella
 * @version 1.0
 * @since 1.0
 */
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

    /**
     * Updates the quantity of the items.
     * 
     * @param id item id
     * @param quantity item quantity
     */
    @Modifying
    @Query("Update ShoppingItem t SET t.quantity=:quantity WHERE t.id=:id")
    @Transactional
    public void updateCount(@Param("id") Long id, @Param("quantity") int quantity);
}
