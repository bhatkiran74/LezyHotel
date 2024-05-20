package com.kiran.LezyHotel.controller;

import com.kiran.LezyHotel.Response.RoomResponse;
import com.kiran.LezyHotel.model.Room;
import com.kiran.LezyHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * RoomController.java
 * Author: Kiransing bhat
 * Description: This class implements RoomController.
 **/

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add/new-room")
    ResponseEntity<RoomResponse> addRoom(@RequestParam("photo") MultipartFile photo,
                                         @RequestParam("roomType") String roomType,
                                         @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addRoom(photo, roomType, roomPrice);
        RoomResponse roomResponse = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return new ResponseEntity<>(roomResponse, HttpStatus.CREATED);
    }
}
