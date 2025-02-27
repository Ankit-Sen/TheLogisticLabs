package com.logistics.logisticsLab.repository.fuelCalculation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logistics.logisticsLab.model.fuelCalculation.RiderInfo;


@Repository
public interface RiderInfoRepository extends JpaRepository<RiderInfo, Long> {
    RiderInfo findById(String id);
//    @Modifying
//    @Query("update RiderInfo u set u.balance = :balance where u.id = :id")
//    void updateBalance(@Param(value = "id") String id, @Param(value = "balance") double price);
//@Modifying
//void updateBalanceById(String id, double balance);
//@Modifying
//void updateTrip_NumById(String id,long tripNum);
//    @Modifying
//    @Query("update RiderInfo u set u.tripNum = :tripNum where u.id = :id")
//    void updateTripNum(@Param(value = "id") String id, @Param(value = "tripNum") long tripNum);
//    @Query("update RiderInfo u set u.lastAddress = :lastAddress where u.id = :id")
//    void updatelastAddress(@Param(value = "id") String id, @Param(value = "lastAddress") String tripNum);

}
