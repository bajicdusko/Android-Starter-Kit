package com.bajicdusko.androidstarterkit.repository;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27/02/17.
 */

public interface CacheRepository {

    void setUsername(String username);

    void setPassword(String password);

    String getUsername();

    String getPassword();

    boolean isSidebarShown();

    boolean isLoggedIn();

    void clear();
}
