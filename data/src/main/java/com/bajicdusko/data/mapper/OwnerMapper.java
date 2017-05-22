package com.bajicdusko.data.mapper;

import com.bajicdusko.androidstarterkit.model.Owner;
import com.bajicdusko.data.api.model.stackoverflow.OwnerData;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 22.05.17.
 */

public class OwnerMapper implements DataMapper<Owner, OwnerData> {

    @Override
    public Owner transform(OwnerData ownerData) {
        return Owner.newBuilder()
                .withAvatar(ownerData.getAvatar())
                .withDisplayName(ownerData.getDisplayName())
                .withProfileUrl(ownerData.getProfileUrl())
                .withReputation(ownerData.getReputation())
                .withUserId(ownerData.getUserId())
                .build();
    }

    @Override
    public OwnerData transform(Owner owner) {
        return OwnerData.newBuilder()
                .withAvatar(owner.getAvatar())
                .withDisplayName(owner.getDisplayName())
                .withProfileUrl(owner.getProfileUrl())
                .withReputation(owner.getReputation())
                .withUserId(owner.getUserId())
                .build();
    }
}
