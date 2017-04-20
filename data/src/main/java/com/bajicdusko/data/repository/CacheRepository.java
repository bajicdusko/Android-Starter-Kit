package com.bajicdusko.data.repository;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 27/02/17.
 */

public interface CacheRepository {

    void setUsername(String username);

    void setPassword(String password);

    String getUsername();

    String getPassword();

    boolean isSidebarShown();

    void clear();
}