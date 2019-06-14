package com.snsoft.services;

import com.snsoft.models.Voucher;

import java.util.List;

public interface VoucherService {
    List<Voucher> findVoucher(String bCode, Integer year, Integer month);

    void approveVoucher(String hId);
}
