package com.snsoft.services.impl;

import com.snsoft.dao.mappers.custom.ApproveMapper;
import com.snsoft.models.ApprovalPendingGroup;
import com.snsoft.models.ApprovalPendingItem;
import com.snsoft.services.ApproveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApproveServiceImpl implements ApproveService {
    @Resource
    private ApproveMapper approveMapper;

    @Override
    public List<ApprovalPendingGroup> getPendingGroups(String userId) {
        return approveMapper.selectPendingApproveGroup(userId);
    }

    @Override
    public List<ApprovalPendingItem> getPendingItems(String code) {
        return approveMapper.selectPendingApprvoeItem(code);
    }

    @Override
    public void approve(String id, String userName, String expl) {
        approveMapper.updateApprvoeReuslt("storeslist." + id, userName, expl);
    }
}
