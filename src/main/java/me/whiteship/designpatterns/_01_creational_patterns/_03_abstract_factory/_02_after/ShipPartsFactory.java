package me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory._02_after;


// 추상 팩토리
public interface ShipPartsFactory {
    // 각각 인터페이스를 만들어준다.
    Anchor createAnchor();

    Wheel createWheel();

}
