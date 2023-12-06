package ma.zs.easystock.domain.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.domain.model.stock.Stock;
import ma.zs.easystock.infra.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.zynerator.service.IService;



import ma.zs.easystock.ws.dto.stock.StockDto;
import org.springframework.http.HttpEntity;


public interface StockAdminService extends  IService<Stock,StockCriteria>  {

    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitBarCode(String barCode);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);


    HttpEntity<byte[]> createPdf(StockDto dto) throws Exception;

}
