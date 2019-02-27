package com.vivek.wo.mvp.basemvp;

public interface BasePresenter<T extends BaseView> {

    void takeView(T view);

    void dropView();
}
