package ma.zs.easystock.zynerator.service;

import ma.zs.easystock.zynerator.bean.BusinessObject;
import ma.zs.easystock.zynerator.criteria.BaseCriteria;

import java.util.List;

public interface IService<D extends BusinessObject, Criteria extends BaseCriteria> {
    D save(D model);
    List<D> findAll();
    List<D> findAllOptimized();
    D update(D model);
    D findById(Long id);
    int deleteById(Long id);
}
