package com.snsoft.services;

import com.snsoft.models.ApprovalPendingGroup;
import com.snsoft.models.ApprovalPendingItem;

import java.util.List;

public interface ApproveService {
    List<ApprovalPendingGroup> getPendingGroups(String userId);

    List<ApprovalPendingItem> getPendingItems(String code);

    void approve(String id, String userName, String expl);
}
