package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.FxSaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author groot
 * @date 2019-10-31
 */
public interface FxSaleOrderRepository extends JpaRepository<FxSaleOrder, Long>, JpaSpecificationExecutor {
    @Query(value = "SELECT MAX(t.fx_sale_number) FROM fx_sale_order t WHERE t.fx_sale_number LIKE ?1", nativeQuery = true)
    String getMaxSalesOrderNo(String salesOrderNo);


    /**
     * 修改状态
     *
     * @param id SaleOrder id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update fx_sale_order set erp_sale_number=?2 where id=?1 ", nativeQuery = true)
    void updateErp(Long id,String erpSaleNumber);

    /**
     * 修改状态
     *
     * @param id SaleOrder id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update fx_sale_order set status=?2,update_date=now() where id=?1 ", nativeQuery = true)
    void sign(Long id,String status);
}