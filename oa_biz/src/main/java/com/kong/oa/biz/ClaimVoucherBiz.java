package com.kong.oa.biz;

import com.kong.oa.entity.ClaimVoucher;
import com.kong.oa.entity.ClaimVoucherItem;
import com.kong.oa.entity.DealRecord;

import java.util.List;

/**
 * @Author: kongxy
 * @Date: 2019/9/24 8:35
 */
public interface ClaimVoucherBiz {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);

    List<ClaimVoucherItem> getItems(int cvid);

    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);

    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    void submit(int id);

    void deal(DealRecord dealRecord);
}
