package com.imooc.human;

import com.imooc.car.Car;

public class LiSi extends HumanWithCar {
    public LiSi(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.stop();
    }
}
