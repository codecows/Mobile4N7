package com.snsoft.dao.mappers.custom;

import com.snsoft.models.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoucherMapper {

    List<Voucher> selectVouchers(@Param("bCode") String bCode, @Param("year") int year, @Param("month") int month);

    void updateVoucher(@Param("id") String hId);
}
