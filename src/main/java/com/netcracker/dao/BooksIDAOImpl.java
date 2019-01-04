package com.netcracker.dao;

import com.netcracker.model.Books;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("booksDao")
@Transactional
public class BooksIDAOImpl extends BasicDAO implements IDAO<Books> {
    @Override
    public void add(Books entity) {
        persist(entity);
    }

    @Override
    public List<Books> findAll() {
        Criteria criteria = getSession().createCriteria(Books.class);
        return criteria.list();
    }

    @Override
    public Books findById(int id) {
        Criteria criteria = getSession().createCriteria(Books.class);
        criteria.add(Restrictions.eq("id", id));
        return (Books) criteria.uniqueResult();
    }

    @Override
    public void deleteById(int id) {
        Query query = getSession().createQuery("delete from Books where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateById(int id, Books entity) {
        Query query = getSession().createQuery("update Books set name= :name, cost=:cost, storage=:storage,amount=:amount where id=:id");
        query.setString("name", entity.getName());
        query.setInteger("cost", entity.getCost());
        query.setString("storage", entity.getStorage());
        query.setInteger("amount", entity.getAmount());
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int getRowCount() {
        return ((Long) getSession().createQuery("select count(*) from Books").uniqueResult()).intValue();

    }
}
