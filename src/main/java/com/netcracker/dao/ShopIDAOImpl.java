package com.netcracker.dao;

import com.netcracker.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDao")
@Transactional
public class ShopIDAOImpl extends BasicDAO implements IDAO<Shop> {

    @Override
    public void add(Shop entity) {
        persist(entity);
    }

    @Override
    public List<Shop> findAll() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        return criteria.list();
    }

    @Override
    public Shop findById(int id) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("id", id));
        return (Shop) criteria.uniqueResult();
    }

    @Override
    public void deleteById(int id) {
        Query query = getSession().createQuery("delete from Shop where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateById(int id, Shop entity) {
        Query query = getSession().createQuery("update Shop set shop_name= :shopname, area=:area, comissions=:comissions where id=:id");
        query.setString("shopname", entity.getShopName());
        query.setString("area", entity.getArea());
        query.setInteger("comissions", entity.getComissions());
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int getRowCount() {
        return ((Long) getSession().createQuery("select count(*) from Shop").uniqueResult()).intValue();
    }
}
