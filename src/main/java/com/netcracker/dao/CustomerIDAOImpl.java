package com.netcracker.dao;

import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDao")
@Transactional
public class CustomerIDAOImpl extends BasicDAO implements IDAO<Customer> {
    @Override
    public void add(Customer entity) {
        persist(entity);
    }

    @Override
    public List<Customer> findAll() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer findById(int id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", id));
        return (Customer) criteria.uniqueResult();
    }

    @Override
    public void deleteById(int id) {
        Query query = getSession().createQuery("delete from Customer where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateById(int id, Customer entity) {
        Query query = getSession().createQuery("update Customer set last_name= :lastname, area=:area, discount=:discount where id=:id");
        query.setString("lastname", entity.getLastName());
        query.setString("area", entity.getArea());
        query.setInteger("discount", entity.getDiscount());
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int getRowCount() {
        return ((Long) getSession().createQuery("select count(*) from Customer").uniqueResult()).intValue();
    }
}
