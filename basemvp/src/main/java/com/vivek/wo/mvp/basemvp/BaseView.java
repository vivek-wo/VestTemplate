package com.vivek.wo.mvp.basemvp;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);
}
