package com.netcracker.dao;

import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("purchaseDao")
@Transactional
public class PurchaseDAPImpl extends BasicDAO implements IDAO<Purchase> {
    @Override
    public void add(Purchase entity) {
        persist(entity);
    }

    @Override
    public List<Purchase> findAll() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list();
    }

    @Override
    public Purchase findById(int id) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id", id));
        return (Purchase) criteria.uniqueResult();
    }

    @Override
    public void deleteById(int id) {
        Query query = getSession().createQuery("delete from Purchase where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateById(int id, Purchase entity) {
        Query query = getSession().createQuery("update Purchase set date= :date, seller=:seller, customer=:customer,book=:book,amount=:amount,cost=:cost where id=:id");
        query.setDate("date", entity.getDate());
        query.setInteger("seller", entity.getSeller());
        query.setInteger("customer", entity.getCustomer());
        query.setInteger("book", entity.getBook());
        query.setInteger("amount", entity.getAmount());
        query.setInteger("cost", entity.getCost());
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int getRowCount() {
        return ((Long) getSession().createQuery("select count(*) from Purchase").uniqueResult()).intValue();

    }
}
