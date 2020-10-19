package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantOnboarding extends JpaRepository<Merchant, Integer> {
    List<Merchant> findByMerchantId(String merchId);
}
