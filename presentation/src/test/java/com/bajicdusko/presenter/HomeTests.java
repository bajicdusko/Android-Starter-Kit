package com.bajicdusko.presenter;

import com.bajicdusko.data.repository.CacheRepository;
import com.bajicdusko.presenter.impl.HomePresenterImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class HomeTests {

    @Test
    public void shouldShowLogin() {

        CacheRepository cacheRepository = Mockito.mock(CacheRepository.class);
        Mockito.when(cacheRepository.isLoggedIn()).thenReturn(false);

        HomePresenter.View homeView = Mockito.mock(HomePresenter.View.class);

        HomePresenter homePresenter = new HomePresenterImpl(cacheRepository);
        homePresenter.setView(homeView);
        homePresenter.init();

        Mockito.verify(homeView).showLogin();
    }

    @Test
    public void shouldShowHome() {

        CacheRepository cacheRepository = Mockito.mock(CacheRepository.class);
        Mockito.when(cacheRepository.isLoggedIn()).thenReturn(true);

        HomePresenter.View homeView = Mockito.mock(HomePresenter.View.class);

        HomePresenter homePresenter = new HomePresenterImpl(cacheRepository);
        homePresenter.setView(homeView);
        homePresenter.init();

        Mockito.verify(homeView).showHome();
    }
}
