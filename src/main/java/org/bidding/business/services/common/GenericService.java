package org.bidding.business.services.common;

import java.io.Serializable;
import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericService<T extends Serializable> implements IOperations<T> {

    @Override
    public T findOne(final int id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public T create(final T entity) {
        return getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final int entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract IOperations<T> getDao();

}
