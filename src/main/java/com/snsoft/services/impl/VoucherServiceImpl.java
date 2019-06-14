package com.snsoft.services.impl;

import com.snsoft.dao.mappers.custom.VoucherMapper;
import com.snsoft.models.Voucher;
import com.snsoft.services.VoucherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Resource
    private VoucherMapper voucherMapper;

    @Override
    public List<Voucher> findVoucher(String bCode, Integer year, Integer month) {
        return voucherMapper.selectVouchers(bCode, year, month);
    }

    @Override
    public void approveVoucher(String hId) {
        voucherMapper.updateVoucher(hId);
    }
}
