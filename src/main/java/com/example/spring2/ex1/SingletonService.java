package com.example.spring2.ex1;


public class SingletonService {

    //jvm이 뜨는 시점에 초기화 하면서 new로 한 번 생성해서 가지고 있음
    private static final SingletonService instance=new SingletonService();

    //static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance(){
        return  instance;
    }

    //외부 클래스에서 임의로 만드는것 방지
    private SingletonService(){};

    public void logic(){
        System.out.println("싱글턴 객체 로직 호출!");
    }

}
