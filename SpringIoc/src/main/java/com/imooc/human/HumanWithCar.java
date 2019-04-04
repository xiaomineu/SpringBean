package com.imooc.human;

import com.imooc.car.Car;

public abstract class HumanWithCar implements Human {
    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    public abstract void goHome();
}
