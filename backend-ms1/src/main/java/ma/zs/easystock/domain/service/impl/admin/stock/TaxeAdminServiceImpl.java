package ma.zs.easystock.domain.service.impl.admin.stock;


import ma.zs.easystock.domain.model.stock.Taxe;
import ma.zs.easystock.infra.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.domain.dao.stock.TaxeDao;
import ma.zs.easystock.infra.dao.specification.core.stock.TaxeSpecification;
import ma.zs.easystock.domain.service.facade.admin.stock.TaxeAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.helper.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.stock.TaxeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TaxeAdminServiceImpl extends AbstractServiceImpl<Taxe, TaxeCriteria, TaxeDao> implements TaxeAdminService {







    public List<Taxe> findAllOptimized() {
        return dao.findAllOptimized();
    }




    public void configure() {
        super.configure(Taxe.class);
    }


    public TaxeAdminServiceImpl(TaxeDao dao) {
        super(dao);
    }

}
