package com.bajicdusko.data.di;

import dagger.Module;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module(includes = {ApiModule.class, RepositoryModule.class})
public class DataModule {
}
