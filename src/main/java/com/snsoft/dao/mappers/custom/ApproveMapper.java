package com.snsoft.dao.mappers.custom;

import com.snsoft.models.ApprovalPendingItem;
import com.snsoft.models.ApprovalPendingGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApproveMapper {
    List<ApprovalPendingGroup> selectPendingApproveGroup(@Param("userId") String userId);

    List<ApprovalPendingItem> selectPendingApprvoeItem(@Param("code") String code);

    void updateApprvoeReuslt(@Param("id") String id, @Param("userName") String userName, @Param("expl") String expl);
}
