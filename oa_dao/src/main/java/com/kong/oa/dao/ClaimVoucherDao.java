package com.kong.oa.dao;

import com.kong.oa.entity.ClaimVoucher;

import java.util.List;

public interface ClaimVoucherDao {

    void insert(ClaimVoucher claimVoucher);

    void update(ClaimVoucher claimVoucher);

    void delete(int id);

    ClaimVoucher select(int id);

    List<ClaimVoucher> selectByCreateSn(String csn);

    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
