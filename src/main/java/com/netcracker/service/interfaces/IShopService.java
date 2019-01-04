package com.netcracker.service.interfaces;

import com.netcracker.model.Shop;

import java.util.List;

public interface IShopService {

    void add(Shop entity);

    List<Shop> findAll();

    Shop findById(int id);

    void deleteById(int id);

    void updateById(int id, Shop entity);

    int getRowCount();

    void showShopNames();
}
