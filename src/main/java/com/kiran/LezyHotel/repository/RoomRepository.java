package com.kiran.LezyHotel.repository;

import com.kiran.LezyHotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoomRepository.java
 * Author: Kiransing bhat
 * Description: This class implements RoomRepository Repository.
 **/
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
