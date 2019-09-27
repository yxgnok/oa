package com.kong.oa.dto;

import com.kong.oa.entity.ClaimVoucher;
import com.kong.oa.entity.ClaimVoucherItem;

import java.util.List;

/**
 * @Author: kongxy
 * @Date: 2019/9/24 10:10
 */
public class ClaimVoucherInfo {
    private ClaimVoucher claimVoucher;
    private List<ClaimVoucherItem> items;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
