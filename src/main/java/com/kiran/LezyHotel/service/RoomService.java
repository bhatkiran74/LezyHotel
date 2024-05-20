package com.kiran.LezyHotel.service;


import com.kiran.LezyHotel.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
/**
 * RoomService.java
 * Author: Kiransing bhat
 * Description: This class implements RoomService.
 **/
public interface RoomService {
    Room addRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException;
}
