package ma.zs.easystock.zynerator.dao;

import ma.zs.easystock.zynerator.domain.AuditDomainObject;

import java.util.List;

public interface IDao<D extends AuditDomainObject> {

    D save(D model);

    List<D> findAll();

    D findById(Long id);

    int deleteById(Long id);

    List<D> findAllOptimized();

    D update(D model);
}
