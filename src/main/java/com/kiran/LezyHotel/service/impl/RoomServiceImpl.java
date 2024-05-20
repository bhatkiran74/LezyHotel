package com.kiran.LezyHotel.service.impl;

import com.kiran.LezyHotel.model.Room;
import com.kiran.LezyHotel.repository.RoomRepository;
import com.kiran.LezyHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * RoomServiceImpl.java
 * Author: Kiransing bhat
 * Description: This class implements RoomServiceImpl.
 **/
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException {

        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        if (!photo.isEmpty()){
            byte[] photoByte = photo.getBytes();
            Blob photoBlob = new SerialBlob(photoByte);
            room.setPhoto(photoBlob);
        }

        return roomRepository.save(room);
    }
}
