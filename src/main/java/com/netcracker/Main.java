package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.service.interfaces.IBooksService;
import com.netcracker.service.interfaces.ICustomerService;
import com.netcracker.service.interfaces.IPurchaseService;
import com.netcracker.service.interfaces.IShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfig.class);

        ICustomerService customerService = (ICustomerService) context.getBean("customerService");
        IShopService shopService = (IShopService) context.getBean("shopService");
        IBooksService bookService = (IBooksService) context.getBean("booksService");
        IPurchaseService purchaseService = (IPurchaseService) context.getBean("purchaseService");

        //Различные названия и стоимость книг
        bookService.showUniqueBooks();

        //Различные районы
        customerService.showAreas();

        //Месяцы покупок
        purchaseService.showMonths();

        //Фамилии и скидки жителей нижегородского района
        customerService.showNAreaCustomers();

        //Названия магазинов сормовского и советского районов
        shopService.showShopNames();

        //Список книг со словом Windows и книг дороже 20000
        bookService.showWindowsAndExpensiveBooks();

        //Покупатель и название магазина
        purchaseService.showCustomerAndShop();

        //Полная информация о покупке
        purchaseService.showFullInfo();

        //Номер заказа, фамилия покупателя и дата для покупок, в которых было продано книг на сумму не меньшую чем 60000 руб
        purchaseService.moreThen60000();

        //Покупки, сделанные покупателем в своем районе не ранее марта месяца. Вывести фамилию покупателя, район, дату. Произвести сортировку
        purchaseService.purchaseWinterHomeArea();

        // Магазины, расположенные в любом районе, кроме Автозаводского, где покупали книги те, у кого скидка от 10 до 15 %
        purchaseService.exceptAutoWithDiscount();

        //Данные по покупке книг (название, район складирования, количество), приобретенных в районе складирования и содержащихся в запасе более 10 штук
        purchaseService.booksHomeStorage();

    }

}
